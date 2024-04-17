package controller;

import model.EmployeeData.User;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(value = "/furama")
public class FuramaServlet extends HttpServlet {
    private IEmployeeService furamaService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        };
        switch (action){
            case "add":
                break;
            case "FormLogin":
                showFormLogin(req,resp);
                break;
            case "homePage":
                showHomePage(req,resp);
                 break;
            default:
                showList(req,resp);
        }
    }

    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/HomePage.jsp");

        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormLogin(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/FormLogin.jsp");
        req.setAttribute("userList",furamaService.selectAllUser());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Login.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "checkUser":
                if(checkUser(req,resp)){
                    String userName = req.getParameter("userName");
                    String passWord = req.getParameter("passWord");
                    resp.sendRedirect("/furama?action=homePage&userName="+userName+"&passWord=" + passWord);
                     break;
                }
                else {
                    String mess = "mật khẩu bị trùng";
                    resp.sendRedirect("view/FormLogin.jsp");
                    break;
                }

        }
    }

    private boolean checkUser(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        List<User> userList = furamaService.selectAllUser();

        // Sắp xếp danh sách người dùng theo tên người dùng (đảm bảo danh sách đã được sắp xếp trước)
        Collections.sort(userList, Comparator.comparing(User::getUserName));

        // Tìm kiếm nhị phân trong danh sách đã sắp xếp
        int index = binarySearch(userList, passWord);

        // Nếu tìm thấy tên người dùng trong danh sách
        if (index != -1) {
            User user = userList.get(index);
            // Kiểm tra mật khẩu của người dùng
            if (user.getPassWord().equals(passWord)) {
                // Mật khẩu chính xác, trả về true để xác nhận đăng nhập thành công
                return true;
            }
        }
        // Không tìm thấy hoặc mật khẩu không chính xác, trả về false để xác nhận đăng nhập thất bại
        return false;
    }

    // Hàm tìm kiếm nhị phân cho List<User>
    private int binarySearch(List<User> userList, String passWord) {
        int left = 0;
        int right = userList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midUsername = userList.get(mid).getPassWord();
            int compareResult = midUsername.compareTo(passWord);

            if (compareResult == 0) {
                return mid; // Tìm thấy tên người dùng, trả về chỉ mục
            } else if (compareResult < 0) {
                left = mid + 1; // Nếu tên người dùng ở giữa nhỏ hơn tên cần tìm, loại bỏ nửa phía trước
            } else {
                right = mid - 1; // Nếu tên người dùng ở giữa lớn hơn tên cần tìm, loại bỏ nửa phía sau
            }
        }

        return -1; // Không tìm thấy
    }

}
