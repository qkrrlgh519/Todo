package com.kiho.todo.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.kiho.todo.dto.TodoDto;

public class TodoDao {
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/tododb";
	private static String dbUser = "parkkiho";
	private static String dbPasswd = "kgu123";
	
	public int addTodo(TodoDto todoDto) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?);";
		
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, todoDto.getTitle());
			ps.setString(2, todoDto.getName());
			ps.setInt(3, todoDto.getSequence());
			
			insertCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}
	
	
	public List<TodoDto> getTodos(){
		List<TodoDto> list = new ArrayList<TodoDto>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT id, title, name, sequence, type, DATE_FORMAT(regdate, \"%Y.%m.%d\")"
				+ "as regdate FROM todo order by regdate";
		
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
				
			while(rs.next()) {
				Long id = rs.getLong("id");
				String title = rs.getString("title");
				String name = rs.getString("name");
				int sequence = rs.getInt("sequence");
				String type = rs.getString("type");
				String regDate = rs.getString("regdate");
				
				TodoDto todoDto = new TodoDto(id, name, regDate, sequence, title, type);
				list.add(todoDto);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return list;
	}
	
	
	public int updateTodo(TodoDto todoDto) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE TODO SET type = ? WHERE id = ?";
		
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, todoDto.getType());
			ps.setLong(2, todoDto.getId());
			
			updateCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return updateCount;
	}
}
