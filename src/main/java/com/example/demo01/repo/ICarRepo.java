package com.example.demo01.repo;

import com.example.demo01.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepo extends CrudRepository<Car,Long> {
}
