package com.tp.carsseller.Repositories;

import com.tp.carsseller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
