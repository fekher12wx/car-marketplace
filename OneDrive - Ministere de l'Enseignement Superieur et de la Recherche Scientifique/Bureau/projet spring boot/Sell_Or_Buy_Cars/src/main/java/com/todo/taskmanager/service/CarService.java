package com.todo.taskmanager.service;

import com.todo.taskmanager.Entity.car.Car;
import com.todo.taskmanager.Entity.user.Role;
import com.todo.taskmanager.Entity.user.User;
import com.todo.taskmanager.controller.AuthController.DTO.UserResponse;
import com.todo.taskmanager.controller.carController.DTO.CarRequest;
import com.todo.taskmanager.controller.carController.DTO.CarResponse;
import com.todo.taskmanager.repository.CarRepository;
import com.todo.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  CarRepository carRepository;

    public CarResponse addCar(CarRequest request, Long vendorId) {
        var vendor = userRepository.findById(vendorId);
        if (vendor.isEmpty() || !vendor.get().getRole().equals(Role.VENDEUR)) {
            return CarResponse.builder()
                    .message("Only Vendeur users can add cars")
                    .build();
        }

        var car = new Car();
        car.setMake(request.getMake());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setPrice(request.getPrice());
        car.setDescription(request.getDescription());
        car.setVendor(vendor.get());

        carRepository.save(car);

        return CarResponse.builder()
                .car(car)
                .message("Car added successfully")
                .build();
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public CarResponse getCarById(Long id) {
        try {
            var car = carRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Car not found!"));

            return CarResponse.builder()
                    .car(car)
                    .message("Car found")
                    .build();
        }catch (RuntimeException ex){
            return  CarResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }
    }

    public CarResponse updateCar(Long id, CarRequest request) {

        try {
            var existingCar = carRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Car not found!"));

            existingCar.setMake(request.getMake());
            existingCar.setDescription(request.getDescription());
            existingCar.setYear(request.getYear());
            existingCar.setPrice(request.getPrice());
            existingCar.setModel(request.getModel());

            carRepository.save(existingCar);

            return  CarResponse.builder()
                    .car(existingCar)
                    .message("Car updated successfully")
                    .build();
        }catch (RuntimeException ex)
        {
            return  CarResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }
    }


    public boolean deleteUserById(Long id) {
        var car = carRepository.findById(id);
        if (car.isPresent()) {
            carRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
