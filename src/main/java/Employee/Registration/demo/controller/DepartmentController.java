package Employee.Registration.demo.controller;


import Employee.Registration.demo.DTO.DepartmentReqDto;
import Employee.Registration.demo.model.Department;
import Employee.Registration.demo.repository.DepartmentRepo;
import Employee.Registration.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createDept")
    public Department createDepartment(@RequestBody DepartmentReqDto department) {
        System.out.println(department.getName());
        Department department1 = departmentService.createDepartment(department.getName());
        System.out.println(department.getName());
        return department1;
    }
    @GetMapping("")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }
}