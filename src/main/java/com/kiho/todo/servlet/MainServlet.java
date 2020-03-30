package com.kiho.todo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kiho.todo.dao.TodoDao;
import com.kiho.todo.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDao todoDao = new TodoDao();
		List<TodoDto> selectList = todoDao.getTodos();
		
		List<TodoDto> todoList = new ArrayList<>();
		List<TodoDto> doingList = new ArrayList<>();
		List<TodoDto> doneList = new ArrayList<>();
		
		for(TodoDto todoDto : selectList) {
			String type = todoDto.getType();
			if(type.equals("TODO")) {
				todoList.add(todoDto);
			}
			else if(type.equals("DOING")) {
				doingList.add(todoDto);
			}
			else {
				doneList.add(todoDto);
			}
		}
		
		request.setAttribute("todoList", todoList);
		request.setAttribute("doingList", doingList);
		request.setAttribute("doneList", doneList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
		requestDispatcher.forward(request, response);
	}
}
