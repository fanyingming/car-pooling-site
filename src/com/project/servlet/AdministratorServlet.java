package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.javabean.Administrator;
import com.project.service.AdministratorService;

/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet("/AdministratorServlet")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//public use info.
		
		String type = request.getParameter("type");
		
		AdministratorService service = new AdministratorService();
		HttpSession session = request.getSession();
		try {
			if (type.equals("login")) {
				String user_name = request.getParameter("user_name");
				String user_pass = request.getParameter("user_pass");
				Administrator a = new Administrator();
				a.setAdministrator_name(user_name);
				a.setAdministrator_pass(user_pass);
				if (service.isExist(a)) {
					a.setAdministrator_id(service.getAdministratorIdByAdministratorName(user_name));
					session.setAttribute("administrator", a);
					request.getRequestDispatcher("manage.jsp").forward(request,
							response);
				   } else {
					request.setAttribute("result", "用户名或密码不存在");
					request.getRequestDispatcher("admin_log.jsp").forward(request,
							response);
				   }
				
			}
			else if (type.equals("exit")) {
				session.invalidate();
				request.getRequestDispatcher("admin_log.jsp").forward(request,
						response);
			} 
			else {
					response.sendRedirect("admin_log.jsp");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
