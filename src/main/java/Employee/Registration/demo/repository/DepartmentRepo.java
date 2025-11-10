package Employee.Registration.demo.repository;

import Employee.Registration.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department , Long> {}