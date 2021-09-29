package com.example.demo01.contro;

import com.example.demo01.model.Car;
import com.example.demo01.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarContro {
    @Autowired
    private ICarService carService;

    @GetMapping
    public ResponseEntity<Iterable<Car>> findAllCarr() {
        List<Car> customers = (List<Car>) carService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable Long id) {
        Optional<Car> carOptional = carService.findById(id);
        if (!carOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car customer) {
        carService.save(customer);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCustomer(@PathVariable Long id, @RequestBody Car car) {
        Optional<Car> carOptional = carService.findById(id);
        if (!carOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        car.setId(carOptional.get().getId());
        carService.save(car);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) {
        Optional<Car> carOptional = carService.findById(id);
        if (!carOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        carService.remove(id);
        return new ResponseEntity<>(carOptional.get(), HttpStatus.NO_CONTENT);
    }
}
