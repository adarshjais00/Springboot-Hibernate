package in.adarshjais.hibernate.springboothibernate.service;

import in.adarshjais.hibernate.springboothibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee>  findAllEmployee();
    public Employee addEmployee(Employee employee);

    public Employee getEmployeeById(Integer id);
    public List<Employee>  getEmployeeByName(String name);

    public Employee updateEmployee(Integer id, Employee employee);

}
