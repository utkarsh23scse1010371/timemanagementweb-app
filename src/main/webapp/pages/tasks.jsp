<!DOCTYPE html>
<html>
<head>
    <title>Your Tasks</title>
</head>
<body>
    <h1>Your Tasks</h1>
    <ul>
        <c:forEach items="${tasks}" var="task">
            <li>${task.taskName} - ${task.dueDate}</li>
        </c:forEach>
    </ul>
    <form action="tasks" method="post">
        <input type="hidden" name="userId" value="1">
        <input type="text" name="taskName" placeholder="Task Name">
        <input type="date" name="dueDate">
        <button type="submit">Add Task</button>
    </form>
</body>
</html>
