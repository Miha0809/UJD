package com.slamy.library.controllers;

import com.slamy.library.models.Book;
import com.slamy.library.models.Email;
import com.slamy.library.models.User;
import com.slamy.library.repositories.BookRepository;
import com.slamy.library.repositories.EmailRepository;
import com.slamy.library.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/info")
public class InfoController {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final BookRepository bookRepository;

    public InfoController(UserRepository userRepository, EmailRepository emailRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userRepository.findAllBy();
    }

    @GetMapping("/emails")
    public List<Email> getEmails() {
        return this.emailRepository.findAllBy();
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookRepository.findAllBy();
    }
}
