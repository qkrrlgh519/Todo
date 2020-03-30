package com.kiho.todo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kiho.todo.dao.TodoDao;
import com.kiho.todo.dto.TodoDto;

@WebServlet("/todoAdd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		
		TodoDao todoDao = new TodoDao();
		TodoDto todoDto = new TodoDto(title, name, sequence);
		
		todoDao.addTodo(todoDto);
				
		response.sendRedirect("main");
	}

}
