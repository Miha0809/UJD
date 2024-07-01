package com.slamy.library.controllers;

import com.slamy.library.models.Book;
import com.slamy.library.models.Email;
import com.slamy.library.models.Role;
import com.slamy.library.models.User;
import com.slamy.library.repositories.BookRepository;
import com.slamy.library.repositories.EmailRepository;
import com.slamy.library.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final BookRepository bookRepository;
    private final PasswordEncoder passwordEncoder;


    public AdminController(UserRepository userRepository, EmailRepository emailRepository, BookRepository bookRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.bookRepository = bookRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register_user")
    public User registerUser(@RequestBody User user) throws Exception {
        try {
            Email email = user.getEmail();

            if (email != null) {
                user.setRole(Role.ROLE_USER);
                emailRepository.save(email);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepository.save(user);

            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/add_book")
    public Book addBook(@RequestBody Book book) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            Email email = this.emailRepository.findByName(authentication.getName());
            User user = this.userRepository.findByEmail(email);

            user.getMyBooks().add(book);
            book.setAuthor(user);

            this.bookRepository.save(book);
            this.userRepository.save(user);

            return book;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/my_books")
    public List<Book> myBooks() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            Email email = this.emailRepository.findByName(authentication.getName());
            User user = this.userRepository.findByEmail(email);

            return this.bookRepository.findByAuthor(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/delete_book/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        try {
            Book book = this.bookRepository.findAllById(id);
            this.bookRepository.delete(book);

            return "Success!";
        } catch (Exception e) {
            return "Not success";
        }
    }

    @GetMapping("/book_users_likes/{id}")
    public List<User> eventParticipants(@PathVariable("id") Long id) throws Exception {
        try {
            Book book = this.bookRepository.findAllById(id);
            return this.userRepository.findByBooksContains(book);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
