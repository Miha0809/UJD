package com.slamy.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.slamy.library.models.Email;

import java.util.List;

public interface EmailRepository extends CrudRepository<Email, Long> {
    boolean existsByName(String name);
    Email findByName(String name);
    List<Email> findAllBy();
}
