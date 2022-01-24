package com.irdaislakhuafa.thymeleafpaginantion.controllers;

import com.irdaislakhuafa.thymeleafpaginantion.models.BookEntity;
import com.irdaislakhuafa.thymeleafpaginantion.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thymeleaf/pagetest")
public class PageableResponseController {
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {

            Page<BookEntity> bookPage = bookService.findAll(PageRequest.of(0, 5));

            if (bookPage.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(bookPage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
