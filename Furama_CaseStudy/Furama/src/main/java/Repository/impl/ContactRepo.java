package Repository.impl;

import Repository.IContactRepo;
import com.mysql.cj.jdbc.CallableStatement;
import model.ContactData.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.conf.PropertyKey.logger;

public class ContactRepo implements IContactRepo {
    private String SELECT_ALL_CONTACT = "\tselect hd.MaHopDong,hd.NgaylamHopDong,hd.NgayKetThuc,hd.TienDatCoc,nv.hoTen,kh.HoTen,dv.TenDichVu from furama.HopDong as hd\n" +
            "\tinner join furama.NhanVien as nv on nv.MaNhanVien = hd.MaNhanvien\n" +
            "\tinner join furama.KhachHang as kh on kh.MaKhachHang = hd.MaKhachHang\n" +
            "\tinner join furama.DichVu as dv on dv.MaDichVu = hd.MaDichVu;\n";
    private String PROCEDURE_DELETE_CONTACT = "{CALL DELETE_BY_CONTACTID(?)}";
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement statement = null;
    @Override
    public List<Contact> selectAllContact() {
        List<Contact> contactList = new ArrayList<>();
        connection = repo.BaseRepository.getConnectDB();
        try {
            statement = connection.prepareStatement(SELECT_ALL_CONTACT);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("MaHopDong");
                String ngayLamHopDong = resultSet.getString("NgayLamHopDong");
                String ngayKetThuc = resultSet.getString("NgayKetThuc");
                int tienDatCoc = (resultSet.getInt("TienDatCoc"));
                String tenNhanVien = resultSet.getString("hoTen");
                String tenKhachHang = resultSet.getString("HoTen");
                String tenDichVu = resultSet.getString("TenDichVu");

                contactList.add(new Contact(id,ngayLamHopDong,ngayKetThuc,tienDatCoc,tenNhanVien,tenKhachHang,tenDichVu));
            }
            return contactList;
        } catch (SQLException e) {
            return null;
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }if (statement != null) {
                    statement.close();
                }if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException sqlException){
                return null;
            }
        }
    }

    @Override
    public boolean deleteContact(int id) {
        connection = repo.BaseRepository.getConnectDB();
        java.sql.CallableStatement callableStatement = null;
        try {
//            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall(PROCEDURE_DELETE_CONTACT);
            callableStatement.setInt(1,id);
            int check = callableStatement.executeUpdate();
//            connection.commit();
            return check == 1;
        } catch (SQLException e) {
            System.out.println("Lỗi xóa dữ liệu: "+e.getMessage());
//            if (connection!= null){
//                try {
////                    connection.rollback();
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (callableStatement != null){
                    callableStatement.close();
                }if (resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException sqlException){
            }
        }
        return false;
    }

    @Override
    public void addContactTransaction(Contact contact, List<Integer> permissions) {
        connection = repo.BaseRepository.getConnectDB();
        try {
            connection.setAutoCommit(false);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
