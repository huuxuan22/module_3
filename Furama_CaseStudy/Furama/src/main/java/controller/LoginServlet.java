package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/CookieLogin")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName =req.getParameter("username");
        String passWord = req.getParameter("passWord");
        if (isValidLogin(userName,passWord)){
            Cookie userCookieUN = new Cookie("userName",userName);
            Cookie userCookiePW = new Cookie("passWord",passWord);
            resp.addCookie(userCookieUN);
            resp.addCookie(userCookiePW);
            resp.sendRedirect("HomePage.jsp");
         }else {
            resp.sendRedirect("FormLogin.jsp");
        }
    }

    private boolean isValidLogin(String username, String password) {
        // Thực hiện kiểm tra thông tin đăng nhập ở đây (ví dụ: kiểm tra tài khoản trong cơ sở dữ liệu)
        // Trong ví dụ này, giả sử đăng nhập thành công nếu username và password không rỗng
        return !username.isEmpty() && !password.isEmpty();
    }
}
