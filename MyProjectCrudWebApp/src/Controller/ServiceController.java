package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StoreDaoImp;
import Model.Store;

/**
 * Servlet implementation class ServiceController
 */
@WebServlet("/ServiceController")
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String storeid = req.getParameter("storeid");
		String storename = req.getParameter("storename");
		String zipcode = req.getParameter("zipcode");
		String distance = req.getParameter("distance");
		
		String delete=req.getParameter("Delete");
		String add=req.getParameter("Add");
		String update=req.getParameter("Update");
		Store store;

		HttpSession session = req.getSession();
		session.setAttribute("storeid", storeid);
		session.setAttribute("storename", storename);
		session.setAttribute("zipcode", zipcode);
		session.setAttribute("distance", distance);

		session.setAttribute("delete",delete);
		session.setAttribute("add",add );
		session.setAttribute("update",update);
		
		StoreDaoImp storeDaoImp = new StoreDaoImp();
		String sql = null;

		if (add != null) {

			if (storeid != "" && storename != "" && zipcode != "" && distance != "") {
				store = new Store(storeid, storename, zipcode, Integer.parseInt(distance));
				sql = storeDaoImp.add(store);
				executeModifyQuery(sql);
				req.setAttribute("add", add);
				req.getRequestDispatcher("querysuccess.jsp").forward(req, res);
			} else {
				req.setAttribute("add", add);
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}

		} else if (update != null) {

			if (storeid != "" && storename != "" && zipcode != "" && distance != "") {
				store = new Store((storeid), storename, zipcode, Integer.parseInt(distance));
				sql = storeDaoImp.edit(storeid, store);
				executeModifyQuery(sql);
				req.setAttribute("update", update);
				req.getRequestDispatcher("querysuccess.jsp").forward(req, res);
			}

			else {
				req.setAttribute("update", update);
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
		} else if (delete != null) {
			if (storeid != "") {
				sql = storeDaoImp.delete(storeid);
				executeModifyQuery(sql);
				req.setAttribute("delete", delete);
				req.getRequestDispatcher("querysuccess.jsp").forward(req, res);
			} else {
				req.setAttribute("delete", delete);
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
		}

		else if (req.getParameter("Find") != null) {
			String range = req.getParameter("range");
			if (range != "" && zipcode != "") {
				session.setAttribute("range", range);
				req.getRequestDispatcher("AllStores").forward(req, res);
			} else {
				req.getRequestDispatcher("errorFind.jsp").forward(req, res);
			}
		} else if (req.getParameter("Search") != null) {
			req.getRequestDispatcher("AllStores").forward(req, res);
		} else if (req.getParameter("SearchAll") != null) {
			req.getRequestDispatcher("AllStores").forward(req, res);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	public void executeModifyQuery(String sql) {

		String url = "jdbc:mysql://localhost:3306/stores";

		String user = "root";

		String password = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url, user, password);

			Statement myStmt = conn.createStatement();
			myStmt.executeUpdate(sql);
		} catch (Exception exp) {
			System.err.println(exp.getMessage());
		}

	}

	public Connection getConnectionDB() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/stores";

		String user = "root";

		String password = "root";

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;

	}

}