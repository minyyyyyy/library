package com.mini.springlv2library.controller;

import com.mini.springlv2library.dto.BookRequestDto;
import com.mini.springlv2library.dto.BookResponseDto;
import com.mini.springlv2library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> registerBook(@RequestBody BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookService.registerBook(bookRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
