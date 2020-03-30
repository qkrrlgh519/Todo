package com.kiho.todo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kiho.todo.dao.TodoDao;
import com.kiho.todo.dto.TodoDto;

@WebServlet("/todoType")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		
		if("TODO".equals(type)) {
			type = "DOING";
		}
		else if("DOING".equals(type)) {
			type = "DONE";
		}
		
		TodoDto todoDto = new TodoDto();
		todoDto.setId(id);
		todoDto.setType(type);
		
		TodoDao todoDao = new TodoDao();
		int updateCount = todoDao.updateTodo(todoDto);
		
		if(updateCount > 0) {
			out.print("SUCCESS");
		}
	}

}
