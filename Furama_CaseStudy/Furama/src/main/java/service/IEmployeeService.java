package service;

import model.EmployeeData.*;
import model.EmployeeData.dto.EmployeeAdd;
import model.EmployeeData.dto.EmployeeInnerJoin;
import model.EmployeeData.dto.EmployeeInsert;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeInnerJoin> selectAllEmployee();
    public List<Position> selectAllPosition();
    public List<Education> selectAllEducation();
    public List<Division> selectAllDivision();
    public int findIdlast();
    public boolean updateEmployee(EmployeeInsert employeeInsert);
    public List<User> selectAllUser();
    public boolean addNewEmployee(EmployeeAdd employeeAdd);
    public boolean addNewUser(User user);
    public boolean deleteEmployee(int id);
}
