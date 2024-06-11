package in.adarshjais.hibernate.springboothibernate.service;

import in.adarshjais.hibernate.springboothibernate.Repository.EmployeeRepository;
import in.adarshjais.hibernate.springboothibernate.entity.Employee;
import in.adarshjais.hibernate.springboothibernate.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee) ;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
       Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()){
            return emp.get();
        }
        else{
            throw new ResourceNotFound("EMPLOYEE NOT FOUND");
        }

    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee emp = employeeRepository.findById(id).get();
        emp.setEmail(employee.getEmail());
        return employeeRepository.save(emp);
    }

}
