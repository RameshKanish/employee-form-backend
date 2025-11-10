package Employee.Registration.demo.service;


import Employee.Registration.demo.model.Department;
import Employee.Registration.demo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department createDepartment(String name){
        Department department = new Department();
        department.setName(name);
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}