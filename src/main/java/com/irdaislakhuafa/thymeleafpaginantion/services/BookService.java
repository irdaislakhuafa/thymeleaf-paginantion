package com.irdaislakhuafa.thymeleafpaginantion.services;

import java.util.List;
import java.util.Optional;

import com.irdaislakhuafa.thymeleafpaginantion.models.BookEntity;
import com.irdaislakhuafa.thymeleafpaginantion.models.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BasicService<BookEntity> {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity save(BookEntity entity) {
        return bookRepository.save(entity);
    }

    @Override
    public Optional<BookEntity> findById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void removeById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookEntity> findByNameContains(String name) {
        return bookRepository.findByNameContains(name);
    }

    @Override
    public BookEntity findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Page<BookEntity> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
