package org.example.Controller;

import org.example.PageRepository.PageRepository;
import org.example.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PageController {

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

}
