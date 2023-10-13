<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-4">
        <h1>Task List</h1>
        <form class="mb-3" action="" method="Post">
            <div class="input-group">
                <input type="text" id="task" class="form-control"
                    placeholder="Enter a task" name="todosItem" required>
                <button type="submit" class="btn btn-primary">Add Task</button>
            </div>
        </form>
        <ul class="list-group">
            <%
                String item = request.getParameter("todosItem");
                List<String> itemlist = (List<String>) session.getAttribute("TodosList");
                if (itemlist == null) {
                    itemlist = new ArrayList<>();
                }
                if (item != null && item.trim().length() > 0) {
                    itemlist.add(item);
                    session.setAttribute("TodosList", itemlist);
                }
                
                for (String task : itemlist) {
            %>
            <li class="list-group-item"><%= task %></li>
            <%
                }
            %>
        </ul>
    </div>
</body>
</html>
