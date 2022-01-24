package com.irdaislakhuafa.thymeleafpaginantion.models.repositories;

import java.util.List;

import com.irdaislakhuafa.thymeleafpaginantion.models.BookEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
    public List<BookEntity> findByNameContains(String name);

    public BookEntity findByName(String name);

    public Page<BookEntity> findAll(Pageable pageable);
}
