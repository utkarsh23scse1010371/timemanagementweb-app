<%@ page import="java.sql.*" %>
<% 
    Connection conn = com.time.utils.DatabaseUtil.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM tasks");
%>
<table>
    <tr><th>Task Name</th><th>Description</th><th>Created At</th></tr>
    <% while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("task_name") %></td>
            <td><%= rs.getString("description") %></td>
            <td><%= rs.getTimestamp("created_at") %></td>
        </tr>
    <% } %>
</table>
