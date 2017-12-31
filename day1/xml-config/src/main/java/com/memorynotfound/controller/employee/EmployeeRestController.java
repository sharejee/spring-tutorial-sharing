package com.memorynotfound.controller.employee;

import com.memorynotfound.dao.EmployeeDAO;
import com.memorynotfound.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by : Ron Rith
 * Create Date: 12/31/2017.
 */
@RestController
public class EmployeeRestController {
    @Autowired
    public EmployeeDAO employeeDAO;

    @RequestMapping("/rest/employees")
    private List<Employee> getEmployee(){
        return (List<Employee>) employeeDAO.getAllEmployees();
    }
}
