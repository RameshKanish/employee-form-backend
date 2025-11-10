package Employee.Registration.demo.controller;


import Employee.Registration.demo.DTO.EmployeeRequestDto;
import Employee.Registration.demo.DTO.EmployeeResponseDto;
import Employee.Registration.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Employee.Registration.demo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.createEmployee(employeeRequestDto);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("{id}")
    public boolean deletedEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping()
    public boolean changeDepartment( @RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.updateDepartment(employeeRequestDto.getDepartmentId() , employeeRequestDto.getEmpId());
    }
}