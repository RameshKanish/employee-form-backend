package Employee.Registration.demo.service;

import Employee.Registration.demo.DTO.EmployeeRequestDto;
import Employee.Registration.demo.DTO.EmployeeResponseDto;
import Employee.Registration.demo.model.Department;
import Employee.Registration.demo.model.Employee;
import Employee.Registration.demo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import Employee.Registration.demo.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;


import static Employee.Registration.demo.constants.AppConstants.EMPLOYEE_CREATED_SUCCESS;
import static Employee.Registration.demo.constants.AppConstants.WELCOME_EMAIL_BODY;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Autowired
    private EmailService emailService;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public ResponseEntity<EmployeeResponseDto> createEmployee(EmployeeRequestDto employeeRequestDto) {

        Employee employee = new Employee();
        Department department = new Department();

        department.setId(employeeRequestDto.getDepartmentId());

        employee.setEmail(employeeRequestDto.getEmail());
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setPhoneNumber(employeeRequestDto.getPhoneNumber());
        employee.setDepartment(department);
        employee.setDeleted(false);

        Employee emp = employeeRepo.save(employee);

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setId(emp.getId());
//        if(emp != null){
//            CompletableFuture.runAsync(() ->
//                    emailService.sendEmail(
//                            emp.getEmail(),
//                            EMPLOYEE_CREATED_SUCCESS,
//                            WELCOME_EMAIL_BODY
//                    )
//            );
//        }
        return ResponseEntity.ok(employeeResponseDto);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAllByIsDeletedFalse();
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if(!emp.isEmpty()){
            Employee employee = emp.get();
            employee.setDeleted(true);
            employeeRepo.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDepartment(Long deptId, Long empId) {
        Optional<Employee> employee = employeeRepo.findById(empId);
        Optional<Department> department = departmentRepo.findById(deptId);

        if(employee.isPresent() && department.isPresent()){
            Employee emp = employee.get();
            Department department1 = department.get();
            department1.setId(deptId);

            emp.setDepartment(department1);
            employeeRepo.save(emp);

            return true;
        }
        return false;
    }
}