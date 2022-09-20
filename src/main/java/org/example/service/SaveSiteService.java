package org.example.service;

import org.example.entity.Page;
import org.example.pageRepository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ForkJoinPool;


@Service
public class SaveSiteService implements SaveSiteServiceInterface {

    @Autowired
    PageRepository pageRepository;


    @Override
    public void saveSiteMap(String url) {
        SiteScanner siteScanner = new SiteScanner(url);
        Set<Page> siteMap;
        siteMap = new ForkJoinPool(8).invoke(siteScanner);
        for (Page page : siteMap) {
            pageRepository.findByPathContainsAndContentContains(page.getPath(), page.getContent())
                    .ifPresentOrElse(p -> {
                                p.setPath(page.getPath());
                                p.setContent(p.getContent());
                            }
                            , () -> pageRepository.save(page)
                    );
        }
    }


}


