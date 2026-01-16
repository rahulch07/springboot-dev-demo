package com.example.cruddemo.rest;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService empl;
    private JsonMapper jsonMapper;
    public EmployeeController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.empl = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> lst = this.empl.findAll();
        return lst;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        Employee temp = this.empl.findById(id);
        if(temp == null){
            throw new RuntimeException("Employee not found with id: "+ id);
        }
        return temp;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        //just in case then pass id of the employee set it to 0...to avoid update of another employee with same id.
//        employee.setId(0);
        if (employee.getId() != null) {
            throw new RuntimeException("ID must not be provided when creating an employee");
        }
        Employee temp = this.empl.create(employee);
        if(temp == null){
            throw new RuntimeException("Unable to create new employee");
        }
        return temp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee temp = this.empl.update(employee);
        if(temp == null){
            throw new RuntimeException("Unable to update employee");
        }
        return temp;
    }

    @PatchMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchpayload){
        //find employee by id
        System.out.println("&&&&&in patch:"+ patchpayload);
        Employee temp = empl.findById(id);
        if(temp == null){
            throw new RuntimeException("Employee not found with id: "+ id);
        }
        if(patchpayload.containsKey("id")){
            throw new RuntimeException("Employee id is not allowed in request body: "+ id);
        }

        Employee patchedEmployee = jsonMapper.updateValue(temp, patchpayload);
        Employee newEmployee = this.empl.update(patchedEmployee);
        return newEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployees(@PathVariable int id){
        empl.delete(id);
    }
}
