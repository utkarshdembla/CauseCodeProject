package Controller;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StoreDaoImp;
import Model.Store;

@WebServlet("/AllStores")
public class AllStores extends HttpServlet {

	private static final long serialVersionUID = 1L;
	StoreDaoImp storeDaoImp = new StoreDaoImp();

	public void processAllStores(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		ResultSet rs;
		
		if(req.getParameter("Find")!=null)
		{
		String str = storeDaoImp.findStore(req.getParameter("zipcode"), req.getParameter("range"));
		 rs=executeFetchQuery(str);
		ArrayList<Store> list=getQueryStores(rs);
		req.setAttribute("list", list);
		req.getRequestDispatcher("success.jsp").forward(req, res);
		}
		else if(req.getParameter("Search")!=null)
		{
			String str=storeDaoImp.getStore(req.getParameter("storeid"));
			rs=executeFetchQuery(str);
			ArrayList<Store> list=getQueryStores(rs);
			req.setAttribute("list", list);
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}
		else if(req.getParameter("SearchAll")!=null)
		{
			String str = storeDaoImp.getAllStores();
			rs=executeFetchQuery(str);
			ArrayList<Store> list=getQueryStores(rs);
			req.setAttribute("list", list);
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processAllStores(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processAllStores(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet executeFetchQuery(String sql) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/stores";

		String user = "root";

		String password = "root";

		ResultSet rs = null;
		try {

			 Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url, user, password);
			rs = conn.createStatement().executeQuery(sql);
			//conn.close();

		} catch (Exception exp) {
			System.err.println("Getting");
		}

		return rs;

	}
	
	
	public ArrayList<Store> getQueryStores(ResultSet rs)
	{	
		ArrayList<Store> list=new ArrayList<Store>();
		
		try {
			while(rs.next())
			{
				Store store=new Store();
				store.setStoreId(rs.getString("StoreId"));
				store.setStoreName(rs.getString("StoreName"));
				store.setZipCode(rs.getString("ZipCode"));
				store.setDistance(rs.getInt("Distance"));
				
				list.add(store);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}