package com.rodrigopeleias.bookstoremanager.controller;


import com.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.rodrigopeleias.bookstoremanager.entity.Book;
import com.rodrigopeleias.bookstoremanager.exception.BookNotFoundException;
import com.rodrigopeleias.bookstoremanager.repository.BookRepository;
import com.rodrigopeleias.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
       return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.finById(id);
    }
}
