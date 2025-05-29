package lk.ac.vau.fas.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // Get all departments
    @GetMapping
    public ResponseEntity<List<Department>> getDepts() {
        return new ResponseEntity<>(service.getDepts(), HttpStatus.OK);
    }

    // Get a department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDept(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.getDept(id), HttpStatus.OK);
    }

    // Create a new department
    @PostMapping
    public ResponseEntity<String> addDept(@RequestBody Department department) {
        String result = service.addDept(department);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Update an existing department
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDept(@PathVariable("id") int id, @RequestBody Department department) {
        String result = service.updateDept(id, department);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Delete a department by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable("id") int id) {
        String result = service.deleteDept(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
