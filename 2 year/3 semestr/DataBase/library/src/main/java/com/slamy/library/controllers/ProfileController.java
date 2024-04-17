package com.slamy.library.controllers;

import com.slamy.library.models.Book;
import com.slamy.library.models.Email;
import com.slamy.library.models.User;
import com.slamy.library.repositories.BookRepository;
import com.slamy.library.repositories.EmailRepository;
import com.slamy.library.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/profile")
public class ProfileController {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final BookRepository bookRepository;


    public ProfileController(UserRepository userRepository, EmailRepository emailRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/user_info")
    public User getInfoAboutUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Email email = this.emailRepository.findByName(authentication.getName());

        return this.userRepository.findByEmail(email);
    }

    @DeleteMapping("/delete")
    public String deleteProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            Email email = this.emailRepository.findByName(authentication.getName());
            User user = this.userRepository.findByEmail(email);

            this.userRepository.delete(user);
            this.emailRepository.delete(email);

            return "Removed is success!";
        } catch (Exception e) {
            return "Delete books first";
        }
    }

    @PostMapping("/like_book/{id}")
    public Book likeBook(@PathVariable("id") Long id) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            Email email = this.emailRepository.findByName(authentication.getName());
            User user = this.userRepository.findByEmail(email);
            Book book = this.bookRepository.findAllById(id);


            if (!user.getBooks().contains(book)) {
                user.getBooks().add(book);
                this.userRepository.save(user);
            }

            return book;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/my_like_books")
    public List<Book> myLikeBooks() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            Email email = this.emailRepository.findByName(authentication.getName());
            User user = this.userRepository.findByEmail(email);

            return this.bookRepository.findByUsersContains(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("/unlike_book/{id}")
    public String unlikeBook(@PathVariable("id") Long id) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            Email email = this.emailRepository.findByName(authentication.getName());
            User user = this.userRepository.findByEmail(email);
            Book book = this.bookRepository.findById(id).orElseThrow();

            book.getUsers().remove(user);
            user.getBooks().remove(book);

            this.bookRepository.save(book);
            this.userRepository.save(user);

            return "Successfully left the event.";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}