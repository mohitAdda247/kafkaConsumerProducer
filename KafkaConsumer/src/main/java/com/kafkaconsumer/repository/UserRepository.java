package com.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafkaconsumer.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
