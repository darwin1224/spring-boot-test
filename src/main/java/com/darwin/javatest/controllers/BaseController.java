package com.darwin.javatest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public abstract class BaseController<T> {
  public abstract List<T> index();
  public abstract Optional<T> show(long id);
  public abstract T store(T body);
  public abstract T update(long id, T body);
  public abstract Optional<T> destroy(long id);
}