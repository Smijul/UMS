package ums;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/Save")

public class SaveServlet extends HttpServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		System.out.println("hai");
		
		
//		System.out.println("Id is "+id);
//		System.out.println("name is "+name);
//		System.out.println("Email  is "+email);
//		System.out.println("phone number  is "+phone);
//		System.out.println("password is "+id);
		
		try {
			System.out.println("hAI");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("hai");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","root");
			System.out.println("hai");
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?)");
			System.out.println("hai");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, password);
			int row=ps.executeUpdate();
			System.out.println(row+ " row inserted");
			ps.close();
			con.close();			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, res);
		
	}

}
