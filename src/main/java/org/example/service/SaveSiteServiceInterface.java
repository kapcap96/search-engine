package org.example.service;

/**
 * Интерфейс SaveSiteServiceInterface парсер html страницы и сохранение её параметров в БД.
 */
public interface SaveSiteServiceInterface {

    /**
     * Запускает парсин  html и сохраняет параметры (Page) в БД.
     * @param url url адрес страницы
     */
    public void saveSiteMap (String url);
}
