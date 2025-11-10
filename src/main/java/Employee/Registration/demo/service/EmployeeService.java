package Employee.Registration.demo.service;


import Employee.Registration.demo.DTO.EmployeeRequestDto;
import Employee.Registration.demo.DTO.EmployeeResponseDto;
import Employee.Registration.demo.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    public ResponseEntity<EmployeeResponseDto> createEmployee(EmployeeRequestDto employeeRequestDto);
    public List<Employee> getAllEmployee();
    public boolean deleteEmployee(Long id);
    public boolean updateDepartment(Long deptId, Long empId);
}