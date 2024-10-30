package contactmanager.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactmanager.model.Contact;
import contactmanager.service.ContactService;
import contactmanager.service.impl.ContactServiceImpl;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactService contactService = new ContactServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listContacts(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteContact(request, response);
                break;
            default:
                listContacts(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addContact(request, response);
                break;
            case "edit":
                updateContact(request, response);
                break;
            default:
                listContacts(request, response);
                break;
        }
    }

    private void listContacts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contact> contacts = contactService.getAllContacts();
        request.setAttribute("contacts", contacts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/contacts.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/add_contact.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactService.getContactById(id);
        request.setAttribute("contact", contact);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/edit_contact.jsp");
        dispatcher.forward(request, response);
    }

    private void addContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhone(phone);
        contact.setEmail(email);

        contactService.addContact(contact);

        response.sendRedirect("ContactServlet?action=list");
    }

    private void updateContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Contact contact = contactService.getContactById(id);
        contact.setName(name);
        contact.setPhone(phone);
        contact.setEmail(email);

        contactService.updateContact(contact);

        response.sendRedirect("ContactServlet?action=list");
    }

    private void deleteContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        contactService.deleteContact(id);
        response.sendRedirect("ContactServlet?action=list");
    }
}
