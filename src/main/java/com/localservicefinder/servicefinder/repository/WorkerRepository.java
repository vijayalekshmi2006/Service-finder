package com.localservicefinder.servicefinder.repository;

import com.localservicefinder.servicefinder.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository
        extends JpaRepository<Worker, Long> {

    Worker findByEmail(String email);

    Worker findByEmailAndPassword(
            String email,
            String password
    );

    List<Worker> findByDistrictAndAreaAndSkill(
            String district,
            String area,
            String skill
    );
    List<Worker> findBySkill(String skill);
}