package Repository.impl;

import Repository.IEmployeeRepo;
import model.EmployeeData.*;
import model.EmployeeData.dto.EmployeeAdd;
import model.EmployeeData.dto.EmployeeInnerJoin;
import model.EmployeeData.dto.EmployeeInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    private final String SELECT_ALL = "select nv.*, td.TenTrinhDo,vt.TenViTri,bp.TenBoPhan from furama.NhanVien as nv\n" +
            "inner join furama.BoPhan as bp on bp.MaBoPhan = nv.MaBoPhan\n" +
            "inner join furama.ViTri as vt on vt.MaViTri = nv.MaViTri\n" +
            "inner join furama.TrinhDo as td on td.MaTrinhDo = nv.MaTrinhDo";

    private final String INSERT_INTO_EMPLOYEE = "insert into furama.NhanVien(MaNhanVien,HoTen,NgaySinh,CMND,Luong,SDT,Email,DiaChi,MaViTri,MaTrinhDo,MaBoPhan,UserName)\n" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?)";

    private  final  String DELETE_NHANVIEN= "delete from furama.NhanVien where MaNhanVien  = ?";
    private final String ADD_NEW_USER = "insert into furama.NguoiSuDung \n" +
            "values (?,?)";
    private final  String UPDATE_EMPLOYEE =  "update furama.NhanVien\n" +
            "set \n" +
            "\tHoTen = ?,\n" +
            "    NgaySinh = ?,\n" +
            "    CMND = ?,\n" +
            "    Luong = ?,\n" +
            "    SDT = ?,\n" +
            "    Email = ?,\n" +
            "    DiaChi = ?,\n" +
            "    MaTrinhDo = ?,\n" +
            "    MaViTri = ?,\n" +
            "    MaBoPhan = ?\n" +
            "    UserName = ?\n"+
            "    where MaNhanVien = ?";
    private final String FIND_ID_MAX = "select Max(MaNhanVien) as MaNhanVien from furama.NhanVien";
    private final String SELECT_ALL_POSITION = "select * from furama.vitri";
    private final String SELECT_ALL_DIVISION = "select * from furama.bophan;";
    private final String SELECT_ALL_EDUCATION = "select * from furama.trinhdo";
    private final String SELECT_ALL_USER = "select * from furama.nguoisudung";
    private Connection connection = null;
    PreparedStatement statement = null;
    private ResultSet resultSet = null;
    @Override
    public List<EmployeeInnerJoin> selectAllEmployee() {
         connection = repo.BaseRepository.getConnectDB();
        List<EmployeeInnerJoin> employeeList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("MaNhanVien");
                String hoTen = resultSet.getString("HoTen");
                String ngaySinh = resultSet.getString("NgaySinh");
                String CMND = resultSet.getString("CMND");
                int luong = resultSet.getInt("Luong");
                String SDT = resultSet.getString("SDT");
                String email = resultSet.getString("Email");
                String diaChi = resultSet.getString("diaChi");
                String tenTrinhDo = resultSet.getString("TenTrinhDo");
                String tenViTri =resultSet.getString("TenViTri");
                String tenBoPhan = resultSet.getString("MaBoPhan");
                String userName = resultSet.getString("userName");
                employeeList.add(new EmployeeInnerJoin(id,hoTen,ngaySinh,CMND,luong,SDT,email,diaChi,tenTrinhDo,tenViTri,tenBoPhan,userName));
            }
            return employeeList;
        } catch (SQLException e) {
            return null;
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Position> selectAllPosition() {
        List<Position> positionList = new ArrayList<>();
         connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(SELECT_ALL_POSITION);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("MaViTri");
                String name = resultSet.getString("TenViTri");
                positionList.add(new Position(id,name));
            }
            return positionList;
        } catch (SQLException e) {
            throw  new RuntimeException();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Division> selectAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = repo.BaseRepository.getConnectDB();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL_DIVISION);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("MaBoPhan");
                String name = resultSet.getString("TenBoPhan");
                divisionList.add(new Division(id,name));
            }
            return divisionList;
        } catch (SQLException e) {
            throw  new RuntimeException();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Education> selectAllEducation() {
        List<Education> educationList = new ArrayList<>();
        connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(SELECT_ALL_EDUCATION);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("MaTrinhDo");
                String name = resultSet.getString("TenTrinhDo");
                educationList.add(new Education(id,name));
            }
            return educationList;
        } catch (SQLException e) {
            throw  new RuntimeException();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public int findIdMax() {
        connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(FIND_ID_MAX);
            resultSet = statement.executeQuery();
            int id = 0;
            while (resultSet.next()){
                 id = resultSet.getInt("MaNhanVien");
            }
            return id+1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    int id, String employeeName, String birthday, String iDCard, double salary, String numberPhone, String email, String address, String idEducation, String idPosition, String idDivition?
    @Override
    public boolean addNewEmployee(EmployeeAdd employeeAdd) {
        connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(INSERT_INTO_EMPLOYEE);
            statement.setString(2,employeeAdd.getEmployeeName());
            statement.setString(3,employeeAdd.getBirthday());
            statement.setString(4,employeeAdd.getiDCard());
            statement.setDouble(5,employeeAdd.getSalary());
            statement.setString(6,employeeAdd.getNumberPhone());
            statement.setString(7,employeeAdd.getEmail());
            statement.setString(8,employeeAdd.getAddress());
            statement.setInt(9,employeeAdd.getIdPosition());
            statement.setInt(10,employeeAdd.getIdEducation());
            statement.setInt(11,employeeAdd.getIdDivition());
            statement.setString(12,employeeAdd.getUserName());
            statement.setInt(1,employeeAdd.getId());
            int effectRow = statement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            return false;
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

//    int id, String employeeName, String birthday, String iDCard, double salary, String numberPhone, String email, String address, int idEducation, int idPosition, int idDivition
    @Override
    public boolean updateEmployee(EmployeeInsert employeeInsert) {
        connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(UPDATE_EMPLOYEE);
            statement.setString(1,employeeInsert.getEmployeeName());
            statement.setString(2,employeeInsert.getBirthday());
            statement.setString(3,employeeInsert.getiDCard());
            statement.setDouble(4,employeeInsert.getSalary());
            statement.setString(5,employeeInsert.getNumberPhone());
            statement.setString(6,employeeInsert.getEmail());
            statement.setString(7,employeeInsert.getAddress());
            statement.setInt(8,employeeInsert.getIdEducation());
            statement.setInt(9,employeeInsert.getIdDivition());
            statement.setInt(10,employeeInsert.getIdPosition());
            statement.setInt(11,employeeInsert.getId());

            int effect = statement.executeUpdate();

            return effect == 1;
        } catch (SQLException e) {
            return false;
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    @Override
    public List<User> selectAllUser(){
        connection = repo.BaseRepository.getConnectDB();
        List<User> userList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_USER);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String userName = resultSet.getString("UserName");
                String matKhau = resultSet.getString("MatKhau");
                userList.add(new User(userName,matKhau));
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addNewUser(User user) {
        connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(ADD_NEW_USER);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getPassWord());

            int  effect = statement.executeUpdate();
            return  effect == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteNhanVien(int id) {
        connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(DELETE_NHANVIEN);
            statement.setString(1, String.valueOf(id));
            int effect = statement.executeUpdate();
            return effect == 1;
        } catch (SQLException e) {
            return false;
        }
    }
}
