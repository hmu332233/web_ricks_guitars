package controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

@SuppressWarnings("serial")
public class AppInitController implements WebApplicationInitializer
{

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("AppInitServlet 준비…");
		try
		{
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(sc.getInitParameter("url"), sc.getInitParameter("username"),
					sc.getInitParameter("password"));

			sc.setAttribute("conn", conn);
		} catch (Throwable e)
		{
			throw new ServletException(e);
		}		
	}
}
