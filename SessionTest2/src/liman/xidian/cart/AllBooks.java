package liman.xidian.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liman.xidian.dbUtil.Book;
import liman.xidian.dbUtil.Store;

/**
 * Servlet implementation class AllBooks
 */
@WebServlet("/AllBooks")
public class AllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		request.getSession();
		out.print("本网站有以下书籍：<br/>");
		//ArrayList<Book> al = null;
		Set<Map.Entry<String, Book>> set = null;
		try {
			set = Store.getBooks().entrySet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Map.Entry<String, Book> books: set) {
			Book book = books.getValue();
			String url = request.getContextPath() + "/BuyServlet?num=" + book.getNum();
			url = response.encodeRedirectURL(url);
			out.print(book.getName() + "售价" + book.getPrice() +
					"<a href='"+ url +"'>购买</a>"+ "<br/>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
