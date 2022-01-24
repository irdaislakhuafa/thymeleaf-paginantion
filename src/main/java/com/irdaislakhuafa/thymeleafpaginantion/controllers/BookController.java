package com.irdaislakhuafa.thymeleafpaginantion.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.irdaislakhuafa.thymeleafpaginantion.models.BookEntity;
import com.irdaislakhuafa.thymeleafpaginantion.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/thymeleaf/pagination")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String index(
            Model model,
            @RequestParam("requestPage") Optional<Integer> requestPage,
            @RequestParam("requestSize") Optional<Integer> requestSize) {

        model.addAttribute("title", "Spring Boot Thymeleaf | Pagination");
        model.addAttribute("contentTitle", "Book Table");
        try {
            // get books pageable
            Page<BookEntity> bookPages = bookService.findAll(
                    PageRequest.of(
                            requestPage.orElse(0),
                            requestSize.orElse(10),
                            Sort.by("name").ascending()));

            List<Integer> bookPageNumbers = IntStream.rangeClosed(
                    1, bookPages.getTotalPages())
                    // convert to Stream<Integer>
                    .boxed()
                    // convert to list
                    .collect(Collectors.toList());

            model.addAttribute("bookPage", bookPages);
            model.addAttribute("bookPageNumbers", bookPageNumbers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}
