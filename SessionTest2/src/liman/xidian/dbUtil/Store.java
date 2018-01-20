package liman.xidian.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Store {

	public static Map<String, Book> getBooks() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///mydb2", "root", "123");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
		
		Map<String,Book> map = new HashMap<String,Book>();
		//ArrayList<Book> books = new ArrayList<Book>();
		while(rs.next()) {
			//System.out.println(rs.getString("id"));
			Book book = new Book();
			book.setName(rs.getString("id"));
			book.setPrice(rs.getInt("price"));
			book.setNum(rs.getInt("num"));
//			books.add(book);
			map.put(rs.getInt("num")+"", book);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		return map;
		
	}
}
