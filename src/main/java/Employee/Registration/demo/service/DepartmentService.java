package Employee.Registration.demo.service;

import Employee.Registration.demo.model.Department;

import java.util.List;

public interface DepartmentService {
    public Department createDepartment(String name);
    public List<Department> getAllDepartments();
}
