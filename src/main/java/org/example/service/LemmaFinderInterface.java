package org.example.service;
import java.util.Map;
import java.util.Set;

/**
 * Интерфейс LemmaFinderInterface находит уникальные леммы в тексте и считает их количество.
 */
public interface LemmaFinderInterface {

    /**
     * Метод разделяет текст на слова, находит все леммы и считает их количество.
     *
     * @param text текст из которого будут выбираться леммы
     * @return ключ является леммой, а значение количеством найденных лемм
     */
    public Map<String, Integer> collectLemmas(String text);

    /**
     * @param text текст из которого собираем все леммы
     * @return набор уникальных лемм найденных в тексте
     */
    public Set<String> getLemmaSet(String text);
}
