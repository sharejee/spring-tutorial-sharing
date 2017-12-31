package com.memorynotfound.dao;

import com.memorynotfound.model.Employee;

import java.util.List;

/**
 * Created by : Ron Rith
 * Create Date: 12/31/2017.
 */
public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getById(int id);
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
