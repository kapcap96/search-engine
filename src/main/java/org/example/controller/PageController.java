package org.example.controller;
import org.example.entity.Page;
import org.example.pageRepository.PageRepository;
import org.example.service.SaveSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PageController {

    private static final String url = "http://www.playback.ru/";

    @Autowired
    private SaveSiteService saveSiteService;

    @Autowired
    private PageRepository pageRepository;

    @GetMapping("/pages")
    public List<Page> getAllPage() {
        Iterable<Page> pageIterable = pageRepository.findAll();
        ArrayList<Page> pages = new ArrayList<>();
        for (Page page : pageIterable) {
            pages.add(page);
        }
        return pages;
    }

    @GetMapping("/")
    public List<Page> getAllP() {
        //  saveSiteServiceInterface.saveSiteMap(url);
        saveSiteService.saveSiteMap(url);
        Iterable<Page> pageIterable = pageRepository.findAll();
        ArrayList<Page> pages = new ArrayList<>();
        for (Page page : pageIterable) {
            pages.add(page);
        }
        return pages;
    }
}
