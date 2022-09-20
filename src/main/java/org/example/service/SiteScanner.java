package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Page;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

@RequiredArgsConstructor
@Service
public class SiteScanner extends RecursiveTask<Set<Page>> {

    private final List<SiteScanner> siteScannerList = new CopyOnWriteArrayList<>();

    private  String url;


    private static final CopyOnWriteArraySet<String> DOWNLOADED_URLS = new CopyOnWriteArraySet<>();

    private static final CopyOnWriteArraySet<Page> ARRAY_PAGES = new CopyOnWriteArraySet<>();

    private static final String CSS_QUERY = "a[href]";

    private static final String ATTRIBUTE_KEY = "href";

    public SiteScanner(String url) {
        this.url = url.trim();
    }

    @Override
    protected Set<Page> compute() {

        try {
            Thread.sleep(150);

            var document = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            Connection.Response response = document.connection().response();

            for (Element element : document.select(CSS_QUERY)) {
                String attributeUrl = element.absUrl(ATTRIBUTE_KEY);
                if (!attributeUrl.isEmpty() && attributeUrl.startsWith(url) && !DOWNLOADED_URLS.contains(attributeUrl) && !attributeUrl.contains("#")) {
                    DOWNLOADED_URLS.add(attributeUrl);

                    Page page = new Page();
                    page.setPath(new URI(attributeUrl).getPath());
                    page.setCode(response.statusCode());
                    page.setContent(document.html());
                    ARRAY_PAGES.add(page);

                    SiteScanner siteScanner = new SiteScanner(attributeUrl);
                    siteScanner.fork();
                    siteScannerList.add(siteScanner);

                    System.out.println((ARRAY_PAGES.size() - 1) + " -> " + attributeUrl);
                }
            }
        } catch (InterruptedException | IOException | URISyntaxException e) {
            Thread.currentThread().interrupt();
        }

        siteScannerList.sort(Comparator.comparing((SiteScanner o) -> o.url));
        for (SiteScanner siteScanner : siteScannerList) {
            siteScanner.join();
        }
        return ARRAY_PAGES;
    }
}
