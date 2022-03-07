package com.example.guestbook;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GuestBookController", value = "")
public class GuestBookController extends HttpServlet {
    private final GuestBookDao guestBookDao = new GuestBookDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GuestBookEntry> allEntries = guestBookDao.allEntries();
        request.setAttribute("entries", allEntries);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick");
        String content = request.getParameter("content");
        guestBookDao.saveNewEntry(new GuestBookEntry(nick, content));
    }
}
