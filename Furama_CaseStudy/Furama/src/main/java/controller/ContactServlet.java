package controller;

import service.IContactService;
import service.impl.ContactService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/contact")
public class ContactServlet extends HttpServlet {
    private IContactService contactService = new ContactService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Contact/ContactPage.jsp");
        req.setAttribute("ContactList",contactService.selectAllContact());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action  = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                deleteContact(req,resp);
                break;
        }
    }

    private void deleteContact(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("idDelete"));
        boolean check = contactService.deleteContact(id);
        String messdelete = "Xóa không thành công";
        if (check) {
            messdelete = "Xóa thành công";
        }
        try {
            resp.sendRedirect("/contact?messDelete="+messdelete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
