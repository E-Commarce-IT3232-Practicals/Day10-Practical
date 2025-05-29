package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    public List<Department> getDepts() {
        return repo.findAll();
    }

    public Department getDept(int id) {
        return repo.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("Department Not Found"));
    }

    public String addDept(Department department) {
        if (repo.findById(department.getId()).isPresent()) {
            throw new DuplicateKeyException("The Department ID already exists");
        }
        repo.save(department);
        return "New department added";
    }

    public String updateDept(int id, Department department) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Department not found for update");
        }
        department.setId(id); // Ensure the ID is set correctly
        repo.save(department);
        return "The department updated";
    }

    public String deleteDept(int id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Department not found for deletion");
        }
        repo.deleteById(id);
        return "The department deleted";
    }
}
