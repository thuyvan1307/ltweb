<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>Servlet Multipart</div>
<form method="post" action="/btltweb5/multiPartServlet"
	enctype="multipart/form-data">
	Choose a file: <input type="file" name="multiPartServlet" /> <input
		type="submit" value="Upload" />
</form>