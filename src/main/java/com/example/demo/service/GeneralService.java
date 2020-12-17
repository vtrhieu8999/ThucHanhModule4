package com.example.demo.service;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();

    T save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);
}
