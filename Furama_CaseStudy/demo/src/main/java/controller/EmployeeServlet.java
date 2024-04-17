package controller;

import model.EmployeeData.Employee;
import service.IEmployeeService;
import service.impl.FuramaService;

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
    private final IEmployeeService employeeService = new FuramaService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("actionE");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "add":
                break;
            default:
                showList(req,resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/PageEmployee.jsp");
        List<Employee>  employeeList = employeeService.selectAllEmployee();
        req.setAttribute("employeeList",employeeList);
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
        super.doPost(req, resp);
    }
}
