package com.time.dao;

import com.time.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    public List<Task> getTasks(int userId) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM tasks WHERE user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            tasks.add(new Task(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getString("task_name"),
                resultSet.getString("due_date")
            ));
        }
        return tasks;
    }

    public void addTask(Task task) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO tasks (user_id, task_name, due_date) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, task.getUserId());
        preparedStatement.setString(2, task.getTaskName());
        preparedStatement.setString(3, task.getDueDate());
        preparedStatement.executeUpdate();
    }
}
