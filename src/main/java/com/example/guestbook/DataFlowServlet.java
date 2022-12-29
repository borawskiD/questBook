package com.example.guestbook;

import java.io.*;
import java.util.Comparator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/saveThoughts")
public class DataFlowServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        NoteDAO noteDAO = new NoteDAO();
        List<Note> noteList = noteDAO.findAll();
        noteList.sort(Comparator.comparing(Note::getTime).reversed());
        request.setAttribute("notes", noteList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}