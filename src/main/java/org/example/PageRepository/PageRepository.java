package org.example.PageRepository;

import org.example.entity.Page;
import org.springframework.data.repository.CrudRepository;


public interface PageRepository extends CrudRepository <Page,Integer> {
}
