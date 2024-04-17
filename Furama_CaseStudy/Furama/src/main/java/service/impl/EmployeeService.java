package service.impl;

import Repository.IEmployeeRepo;
import Repository.impl.EmployeeRepo;
import model.EmployeeData.*;
import model.EmployeeData.dto.EmployeeAdd;
import model.EmployeeData.dto.EmployeeInnerJoin;
import model.EmployeeData.dto.EmployeeInsert;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepo furamaRepo = new EmployeeRepo();
    @Override
    public List<EmployeeInnerJoin> selectAllEmployee() {
        return furamaRepo.selectAllEmployee();
    }

    @Override
    public List<Position> selectAllPosition() {
        return furamaRepo.selectAllPosition();
    }

    @Override
    public List<Education> selectAllEducation() {
        return furamaRepo.selectAllEducation();
    }

    @Override
    public List<Division> selectAllDivision() {
        return furamaRepo.selectAllDivision();
    }

    @Override
    public int findIdlast() {
        return furamaRepo.findIdMax();
    }

    @Override
    public boolean updateEmployee(EmployeeInsert employeeInsert) {
        return furamaRepo.updateEmployee(employeeInsert);
    }

    @Override
    public List<User> selectAllUser() {
        return furamaRepo.selectAllUser();
    }

    @Override
    public boolean addNewEmployee(EmployeeAdd employeeInsert) {
        return furamaRepo.addNewEmployee(employeeInsert);
    }

    @Override
    public boolean addNewUser(User user) {
        return furamaRepo.addNewUser(user);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return furamaRepo.deleteNhanVien(id);
    }
}
