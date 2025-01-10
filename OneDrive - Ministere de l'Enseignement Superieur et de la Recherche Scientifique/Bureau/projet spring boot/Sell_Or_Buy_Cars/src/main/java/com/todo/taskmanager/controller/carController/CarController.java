package com.todo.taskmanager.controller.carController;

import com.todo.taskmanager.Entity.car.Car;
import com.todo.taskmanager.controller.carController.DTO.CarRequest;
import com.todo.taskmanager.controller.carController.DTO.CarResponse;
import com.todo.taskmanager.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    @Autowired
    private  CarService carService;

    @PostMapping("/addcar/{vendorId}")
    public ResponseEntity<CarResponse> addCar(@RequestBody CarRequest request, @PathVariable Long vendorId) {
        return ResponseEntity.ok(carService.addCar(request, vendorId));
    }

    @GetMapping("/allcars")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CarResponse> updateCar(@PathVariable Long id, @RequestBody CarRequest request) {
        return ResponseEntity.ok(carService.updateCar(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        boolean isDeleted = carService.deleteUserById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Car deleted successfully.");
        } else
            {
                return ResponseEntity.status(404).body("Car not found.");
            }
    }

}
