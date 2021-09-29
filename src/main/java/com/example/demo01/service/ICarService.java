package com.example.demo01.service;

import java.util.Optional;

public interface ICarService <T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);}
