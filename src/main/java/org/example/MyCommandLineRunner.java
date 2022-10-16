package org.example;
import org.example.service.SaveSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private SaveSiteService saveSiteService;

    private static final String  url = "http://www.playback.ru/";

    @Override
    public void run(String... args) throws Exception {

        saveSiteService.saveSiteMap(url);
    }
}