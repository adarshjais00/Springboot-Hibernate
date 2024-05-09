package in.adarshjais.hibernate.springboothibernate.Repository;

import in.adarshjais.hibernate.springboothibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

    @Query("select e from Employee e where e.firstName=:n")
    public List<Employee> getEmployeeByName(@Param("n") String name);
}
