package com.time.servlet;

import com.time.dao.TaskDAO;
import com.time.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    private TaskDAO taskDAO = new TaskDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        try {
            List<Task> tasks = taskDAO.getTasks(userId);
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("pages/tasks.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String taskName = request.getParameter("taskName");
        String dueDate = request.getParameter("dueDate");

        Task task = new Task(0, userId, taskName, dueDate);
        try {
            taskDAO.addTask(task);
            response.sendRedirect("tasks?userId=" + userId);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
