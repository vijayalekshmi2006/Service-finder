package com.localservicefinder.servicefinder.controller;

import com.localservicefinder.servicefinder.entity.Worker;
import com.localservicefinder.servicefinder.repository.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/workers")
@CrossOrigin("*")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @PostMapping("/register")
    public Worker registerWorker(
            @RequestBody Worker worker) {

        return workerRepository.save(worker);

    }

    @PostMapping("/login")
    public Worker loginWorker(
            @RequestBody Worker worker) {

        return workerRepository.findByEmailAndPassword(
                worker.getEmail(),
                worker.getPassword()
        );

    }
    @GetMapping("/skill/{skill}")
public List<Worker> getWorkersBySkill(
        @PathVariable String skill){

    return workerRepository.findBySkill(skill);
}
    @GetMapping("/search")
public List<Worker> searchWorkers(
        @RequestParam String district,
        @RequestParam String area,
        @RequestParam String skill) {

    return workerRepository.findByDistrictAndAreaAndSkill(
                    district,
                    area,
                    skill
            );
}
@GetMapping("/{id}")
public Worker getWorker(
        @PathVariable Long id){

    return workerRepository.findById(id)
            .orElse(null);
}
@GetMapping("/all")
public List<Worker> getAllWorkers(){

    return workerRepository.findAll();

}
@DeleteMapping("/{id}")
public String deleteWorker(
        @PathVariable Long id){

    workerRepository.deleteById(id);

    return "Worker Deleted";

}
}