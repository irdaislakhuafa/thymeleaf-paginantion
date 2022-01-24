package com.irdaislakhuafa.thymeleafpaginantion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BasicService<T> {
    public T save(T entity);

    public Optional<T> findById(String id);

    public List<T> findAll();

    public void removeById(String id);

    public List<T> findByNameContains(String name);

    public T findByName(String name);

    public Page<T> findAll(Pageable pageable);
}
