package org.example.pageRepository;

import org.example.entity.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * PageRepository является базой для хранения данных
 * хранит обьекты следующих типов Page,
 */
@Repository
public interface PageRepository extends CrudRepository<Page, Integer> {
    Optional<Page> findByPathContainsAndContentContains(@NotNull String path, @NotNull String content);

}
