<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Calculator</title>
</head>
<body>
<h1><%= "Simple Calculator" %>
</h1>
<p>Calculate</p>
<form action="${pageContext.request.contextPath}/calculate" method="post">
    <span>First operand:</span>
    <input type="text" name="firstOperand" value="0">
    <br>
    <span>Operator</span>
    <select name="operator">
        <option value="addition">Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiplication">Multiplication</option>
        <option value="division">Division</option>
    </select>
    <br>
    <span>Second operand:</span>
    <input type="text" name="secondOperand" value="0">
    <br>
    <input type="submit" name="submit" value="calculate">
</form>
</body>
</html>