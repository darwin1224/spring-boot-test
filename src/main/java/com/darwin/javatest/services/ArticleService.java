package com.darwin.javatest.services;

import java.util.List;
import java.util.Optional;

import com.darwin.javatest.models.Article;
import com.darwin.javatest.repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements ArticleServiceContract {
  @Autowired
  private ArticleRepository article;

  public List<Article> getAllArticle() {
    return this.article.findAll();
  }

  public Optional<Article> getArticleById(long id) {
    return this.article.findById(id);
  }

  public Article insertArticle(Article params) {
    return this.article.save(params);
  }

  public Article updateArticle(long id, Article params) {
    Article article = this.article.findById(id).get();
    article.setTitle(params.getTitle());
    article.setBody(params.getBody());
    return this.article.save(article);
  }

  public void deleteArticle(long id) {
    this.article.deleteById(id);
  }
}