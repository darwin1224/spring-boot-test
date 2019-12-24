package com.darwin.javatest.services;

import java.util.List;
import java.util.Optional;

import com.darwin.javatest.models.Article;

import org.springframework.stereotype.Service;

@Service
public interface ArticleServiceContract {
  public List<Article> getAllArticle();
  public Optional<Article> getArticleById(long id);
  public Article insertArticle(Article params);
  public Article updateArticle(long id, Article params);
  public void deleteArticle(long id);
}