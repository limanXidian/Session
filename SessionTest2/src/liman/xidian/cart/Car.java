package liman.xidian.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import liman.xidian.dbUtil.Book;

/**
 * Servlet implementation class Car
 */
@WebServlet("/Car")
public class Car extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Car() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession();
		List<Book> list = (List<Book>) sess.getAttribute("list");
		if(list == null) {
			out.print("您还什么都没买呢！");
			return;
		}else {
			out.print("您购物车有以下商品：" + "<br/>");
			int charge = 0;
			for(Book book : list) {
				out.print(book.getName()+"<br/>");
				charge += book.getPrice();
			}
			out.print("总金额："+ charge);
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
