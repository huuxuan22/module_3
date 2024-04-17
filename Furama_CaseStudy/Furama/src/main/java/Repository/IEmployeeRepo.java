package Repository;

import model.EmployeeData.*;
import model.EmployeeData.dto.EmployeeAdd;
import model.EmployeeData.dto.EmployeeInnerJoin;
import model.EmployeeData.dto.EmployeeInsert;

import java.util.List;

public interface IEmployeeRepo {
    public List<EmployeeInnerJoin> selectAllEmployee();
    public List<Position> selectAllPosition();
    public List<Division> selectAllDivision();
    public List<Education> selectAllEducation();
    public int findIdMax();
    public boolean addNewEmployee(EmployeeAdd employeeInsert);
    public boolean updateEmployee(EmployeeInsert employeeInsert);
    public List<User> selectAllUser();
    public boolean addNewUser(User user);
    public boolean deleteNhanVien(int id);
}
