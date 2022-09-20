package org.example;

import org.example.entity.Page;
import org.example.service.SaveSiteService;
import org.example.service.SiteScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
public class Main {
    private static String url;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);



//        SiteScanner siteScanner = new SiteScanner(url);
//        Set<Page> siteMap1;
//        Date start = new Date();
//        System.out.println(new Date());
//        siteMap1 = new ForkJoinPool(100).invoke(siteScanner);
//        System.out.println(siteMap1.size());
////        var resultList = siteMap1.stream().map(Main::mapToUri).toList();
////        System.out.println(resultList);
//        System.out.println(new Date().getTime() - start.getTime());



    }
}