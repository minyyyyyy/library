package com.mini.springlv2library.service;

import com.mini.springlv2library.dto.BookRequestDto;
import com.mini.springlv2library.dto.BookResponseDto;
import com.mini.springlv2library.dto.DtoConverter;
import com.mini.springlv2library.entity.Book;
import com.mini.springlv2library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DtoConverter dtoConverter;

    public BookResponseDto registerBook(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setLanguage(bookRequestDto.getLanguage());
        book.setPublisher(bookRequestDto.getPublisher());
        book.setRegistrationDate(LocalDate.now());
        Book savedBook = bookRepository.save(book);
        return dtoConverter.convertToBookResponseDto(savedBook);
    }

    public BookResponseDto getBook(Long id) {
        return bookRepository.findById(id)
                .map(dtoConverter::convertToBookResponseDto)
                .orElse(null);
    }

    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .sorted(Comparator.comparing(Book::getRegistrationDate))
                .map(dtoConverter::convertToBookResponseDto)
                .collect(Collectors.toList());
    }
}
