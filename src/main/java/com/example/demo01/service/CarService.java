package com.example.demo01.service;

import com.example.demo01.model.Car;
import com.example.demo01.repo.ICarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CarService implements ICarService{
@Autowired
private ICarRepo carRepo;

    @Override
    public Iterable findAll() {
        return carRepo.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return carRepo.findById(id);
    }

    @Override
    public void save(Car car) {
        carRepo.save(car);
    }


    @Override
    public void remove(Long id) {
            carRepo.deleteById(id);
    }
}
