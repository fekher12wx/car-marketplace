package com.todo.taskmanager.controller.advertisementController;

import com.todo.taskmanager.Entity.advertisement.Advertisement;
import com.todo.taskmanager.Entity.car.Car;
import com.todo.taskmanager.controller.advertisementController.DTO.ADVRequest;
import com.todo.taskmanager.controller.advertisementController.DTO.ADVResponse;
import com.todo.taskmanager.controller.carController.DTO.CarRequest;
import com.todo.taskmanager.controller.carController.DTO.CarResponse;
import com.todo.taskmanager.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ad")
public class AdvertisementController {
    @Autowired
    private  AdvertisementService  service;

    @PostMapping("/createADV")
    public ResponseEntity<ADVResponse> CreateADV(@RequestBody ADVRequest request) {
        return ResponseEntity.ok(service.createAdvertisement(request));
    }

    @GetMapping("/allADV")
    public ResponseEntity<List<Advertisement>> getAllADV() {
        return ResponseEntity.ok(service.getAllAdvertisement());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ADVResponse> getADVById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAdvertisementById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ADVResponse> updateADV(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateAdvertisement(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteADV(@PathVariable Long id) {
        boolean isDeleted = service.deleteAdvertisementById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Advertisement deleted successfully.");
        } else
        {
            return ResponseEntity.status(404).body("Advertisement not found.");
        }
    }
}
