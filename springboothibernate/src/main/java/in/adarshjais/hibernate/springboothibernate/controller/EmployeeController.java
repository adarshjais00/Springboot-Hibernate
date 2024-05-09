package in.adarshjais.hibernate.springboothibernate.controller;

import in.adarshjais.hibernate.springboothibernate.entity.Employee;
import in.adarshjais.hibernate.springboothibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.findAllEmployee(), HttpStatus.OK);

    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody  Employee employee){
       return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer empid){
        return new ResponseEntity<>(employeeService.getEmployeeById(empid),HttpStatus.OK);
    }

    @GetMapping("employee")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name){
        return new ResponseEntity<>(employeeService.getEmployeeByName(name),HttpStatus.FOUND);
    }

}
