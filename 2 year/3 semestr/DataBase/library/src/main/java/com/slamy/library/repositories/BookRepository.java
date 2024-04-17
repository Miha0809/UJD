package com.slamy.library.repositories;

import com.slamy.library.models.Book;
import com.slamy.library.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllBy();
    Book findAllById(Long id);
    List<Book> findByAuthor(User author);
    List<Book> findByUsersContains(User user);
    Book findAllByName(String name);
//    User findAllByAuthor(Book book);
}
