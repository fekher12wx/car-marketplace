package com.todo.taskmanager.repository;

import com.todo.taskmanager.Entity.advertisement.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
}
