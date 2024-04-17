package com.slamy.library.controllers;

import com.slamy.library.models.Book;
import com.slamy.library.models.User;
import com.slamy.library.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookRepository.findAllBy();
    }

    @GetMapping("/book_by_id/{id}")
    public Book getBookById(@PathVariable("id") Long id) throws Exception {
        try {
            return this.bookRepository.findAllById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

   @GetMapping("/author_book/{id}")
   public User getAuthorsBook(@PathVariable("id") Long id) throws Exception {
       try {
           Book book = this.bookRepository.findAllById(id);
           return book.getAuthor();
       } catch (Exception e) {
           throw new Exception(e.getMessage());
       }
   }
}
