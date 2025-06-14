package com.example.homify_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.homify_app.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {}
