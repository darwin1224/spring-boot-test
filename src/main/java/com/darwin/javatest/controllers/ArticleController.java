package com.darwin.javatest.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.darwin.javatest.exceptions.BadRequestException;
import com.darwin.javatest.exceptions.NotFoundException;
import com.darwin.javatest.models.Article;
import com.darwin.javatest.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController extends BaseController<Article> {
  @Autowired
  private ArticleService article;

  @GetMapping
  public List<Article> index() {
    try {
      List<Article> data = this.article.getAllArticle();
      if (data == null)
        throw new NotFoundException("Data not found");
      return data;
    } catch (Exception e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public Optional<Article> show(@PathVariable(value = "id") long id) {
    try {
      Optional<Article> data = this.article.getArticleById(id);
      if (data == null)
        throw new NotFoundException("Data not found");
      return data;
    } catch (Exception e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Article store(@Valid @RequestBody Article body) {
    try {
      return this.article.insertArticle(body);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public Article update(@PathVariable(value = "id") long id, @Valid @RequestBody Article body) {
    try {
      if (this.article.getArticleById(id) == null)
        throw new NotFoundException("Data not found");
      return this.article.updateArticle(id, body);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public Optional<Article> destroy(@PathVariable(value = "id") long id) {
    try {
      Optional<Article> data = this.article.getArticleById(id);
      if (data == null)
        throw new NotFoundException("Data not found");
      this.article.deleteArticle(id);
      return data;
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }
}