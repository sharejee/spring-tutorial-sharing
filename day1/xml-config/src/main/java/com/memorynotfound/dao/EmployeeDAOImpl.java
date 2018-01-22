package com.memorynotfound.dao;

import com.memorynotfound.model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by : Ron Rith
 * Create Date: 12/31/2017.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    public JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        String sqlSelect = "Select *from employee";

        List<Employee> employees = jdbcTemplate.query(sqlSelect, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Employee> employeeList = new ArrayList<Employee>();

                while (resultSet.next()){
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setAge(resultSet.getInt("age"));
                    employee.setDepartment(resultSet.getString(3));

                    employeeList.add(employee);
                }
                return employeeList;
            }
        });
        return employees;
    }

    @Override
    public Employee getById(int id) {
        String sql = "select *from Employee where id=?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]
                { id }, new RowMapper<Employee>()
        {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Employee employee = new Employee();
                employee.setId(rs.getInt("ID"));
                employee.setDepartment(rs.getString(1));
                employee.setAge(rs.getInt("AGE"));
                employee.setName(rs.getString("NAME"));
                return employee;
            }
        });
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        String sql = "insert into Employee values(?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
                {employee.getId(), employee.getName(),employee.getAge(), employee.getDepartment()});
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update Employee set age =?, dept=?,name=? where id=?";
        jdbcTemplate.update(sql, new Object[]
                { employee.getAge(), employee.getDepartment(), employee.getName(), employee.getId() });
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql, new Object[]
                { id });
    }
}
