package com.todo.taskmanager.service;

import com.todo.taskmanager.Entity.advertisement.AdStatus;
import com.todo.taskmanager.Entity.advertisement.Advertisement;
import com.todo.taskmanager.controller.advertisementController.DTO.ADVRequest;
import com.todo.taskmanager.controller.advertisementController.DTO.ADVResponse;
import com.todo.taskmanager.controller.carController.DTO.CarResponse;
import com.todo.taskmanager.repository.AdvertisementRepository;
import com.todo.taskmanager.repository.CarRepository;
import com.todo.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private  AdvertisementRepository advertisementRepository;
    @Autowired
    private  CarRepository carRepository;
    @Autowired
    private  UserRepository userRepository;

    public ADVResponse createAdvertisement(ADVRequest request) {
        try {
            var car = carRepository.findById(request.getCarId())
                    .orElseThrow(() -> new RuntimeException("Car not found"));
            var user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            var advertisement = new Advertisement();
            advertisement.setCar(car);
            advertisement.setUser(user);
            advertisement.setStatus(AdStatus.ACTIVE);
            advertisement.setDatePosted(LocalDateTime.now());

            advertisementRepository.save(advertisement);

            return ADVResponse.builder()
                    .advertisement(advertisement)
                    .message("Advertisement created successfully")
                    .build();
        }catch (RuntimeException ex){
            return ADVResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }

    }

    public List<Advertisement> getAllAdvertisement() {
        return advertisementRepository.findAll();
    }

    public ADVResponse getAdvertisementById(Long id) {
      try {
          var advertisement = advertisementRepository.findById(id)
                  .orElseThrow(()->new RuntimeException("Advertisement not found"));
          return ADVResponse.builder()
                  .advertisement(advertisement)
                  .message("Advertisement found")
                  .build();
      }catch (RuntimeException ex){
          return ADVResponse.builder()
                  .message("Advertisement not found")
                  .build();
      }
    }

    public ADVResponse updateAdvertisement(Long id) {
        try {
            var existingAdvertisement = advertisementRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Advertisement not found!"));

            if (existingAdvertisement.getStatus() == AdStatus.ACTIVE){
                existingAdvertisement.setStatus(AdStatus.INACTIVE);
            } else if (existingAdvertisement.getStatus()== AdStatus.INACTIVE) {
                existingAdvertisement.setStatus(AdStatus.ACTIVE);
            }

            advertisementRepository.save(existingAdvertisement);

            return  ADVResponse.builder()
                    .advertisement(existingAdvertisement)
                    .message("advertisement updated successfully")
                    .build();
        }catch (RuntimeException ex)
        {
            return  ADVResponse.builder()
                    .message(ex.getMessage())
                    .build();
        }
    }

    public boolean deleteAdvertisementById(Long id) {
        var advertisement = advertisementRepository.findById(id);
        if (advertisement.isPresent()){
            advertisementRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
