package controller;

import model.EmployeeData.User;
import model.EmployeeData.dto.EmployeeAdd;
import model.EmployeeData.dto.EmployeeInnerJoin;
import model.EmployeeData.dto.EmployeeInsert;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService furamaService = new EmployeeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "save":
                save(req,resp);
                break;
            case "update":
                update(req,resp);
                break;
            case "addNewUser":
                addNewUser(req,resp);
                break;
            case "deleteEmployee":
                delete(req,resp);
                break;

            default:

        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("idDelete"));
        boolean flag = furamaService.deleteEmployee(id);
        String messDelete = "Xóa không thành công";
        if (flag) {
            messDelete = "Xóa thành công";
        }
        try {
            resp.sendRedirect("/employee?mess="+messDelete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addNewUser(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        furamaService.addNewUser(new User(userName,passWord));
        try {
            resp.sendRedirect("/employee?action=showFormAddEmployee&userName="+userName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String idCard = req.getParameter("idCard");
        double Salary = Double.parseDouble(req.getParameter("salary"));
        String numberPhone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int positionId = Integer.parseInt(req.getParameter("positionId"));
        int divisionid = Integer.parseInt(req.getParameter("divisionId"));
        int education = Integer.parseInt(req.getParameter("educationId"));
        EmployeeInsert employeeInsert = new EmployeeInsert(id,name,birthday,idCard,Salary,numberPhone,email,address,positionId,divisionid,education);
        Boolean isSucces = furamaService.updateEmployee(employeeInsert);
        String messUpdate = "update not succes";
        if (isSucces){
            messUpdate = "update succes";
        }
        try {
            resp.sendRedirect("/employee?mess"+messUpdate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formUpdate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/employee/EmployeeUpdate.jsp");
        int idUpdate = Integer.parseInt(req.getParameter("idUpdate"));
        req.setAttribute("idUpdate",idUpdate);
        req.setAttribute("positionList",furamaService.selectAllPosition());
        req.setAttribute("educationList",furamaService.selectAllEducation());
        req.setAttribute("divisionList",furamaService.selectAllDivision());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String idCard = req.getParameter("idCard");
        double Salary = Double.parseDouble(req.getParameter("salary"));
        String numberPhone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int positionId = Integer.parseInt(req.getParameter("position"));
        int divisionid = Integer.parseInt(req.getParameter("division"));
        int education = Integer.parseInt(req.getParameter("education"));
        String userName = req.getParameter("userName");
        furamaService.addNewEmployee(new EmployeeAdd(id,name,birthday,idCard,Salary,numberPhone,email,address,positionId,divisionid,education,userName));
        try {
            resp.sendRedirect("/employee");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    int id, String employeeName, String birthday, String iDCard, double salary, String numberPhone, String email, String address, int positionId, int idEDegree, int idDivision
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "showFormAddEmployee":
                showFormAddEmployee(req,resp);
                break;
            case "showFormUpdate":
                formUpdate(req,resp);
                break;
            case "showFormAddUser":
                formAddNewUser(req,resp);
                break;
            case "Login":
                showFormLogin(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void showFormLogin(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Login.jsp");
        req.setAttribute("userList",furamaService.selectAllUser());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formAddNewUser(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/employee/addNewUser.jsp");
        req.setAttribute("userList",furamaService.selectAllUser());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormAddEmployee(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/employee/addNewEmployee.jsp");
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        req.setAttribute("idMax",furamaService.findIdlast());
        req.setAttribute("divisionList",furamaService.selectAllDivision());
        req.setAttribute("positionList",furamaService.selectAllPosition());
        req.setAttribute("educationList",furamaService.selectAllEducation());
        req.setAttribute("userName",userName);
        req.setAttribute("passWord",passWord);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/employee/EmployeePage.jsp");
        List<EmployeeInnerJoin> employeeList = furamaService.selectAllEmployee();
        req.setAttribute("employeeList",furamaService.selectAllEmployee());
        req.setAttribute("educationList",furamaService.selectAllEducation());
        req.setAttribute("divisionList",furamaService.selectAllDivision());
        req.setAttribute("positionList",furamaService.selectAllPosition());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
