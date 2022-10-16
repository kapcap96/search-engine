package org.example.service;
import org.example.entity.Page;
import org.example.pageRepository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

/**
 * SaveSiteService парсер html страницы и сохранение её параметров в БД.
 */
@Service
public class SaveSiteService implements SaveSiteServiceInterface {

    @Autowired
    PageRepository pageRepository;

    /**
     * Запускает параллельный парсинг html страниц и сохраняет параметры (Page) в БД.
     * @param url url адрес страницы
     */
    @Override
    public void saveSiteMap(String url) {
        SiteScanner siteScanner = new SiteScanner(url);
        Set<Page> siteMap;
        siteMap = new ForkJoinPool(8).invoke(siteScanner);
        pageRepository.saveAll(siteMap);
    }
}


