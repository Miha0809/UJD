package com.slamy.library.repositories;

import com.slamy.library.models.Book;
import com.slamy.library.models.Email;
import com.slamy.library.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(Email email);
    List<User> findAllBy();
    List<User> findByBooksContains(Book book);

}

