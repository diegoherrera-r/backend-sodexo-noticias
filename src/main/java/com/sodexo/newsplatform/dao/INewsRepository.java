package com.sodexo.newsplatform.dao;

import com.sodexo.newsplatform.entities.News;
import org.springframework.data.repository.CrudRepository;

public interface INewsRepository extends CrudRepository<News, Long> {

}
