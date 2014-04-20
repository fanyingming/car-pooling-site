package com.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.javabean.User;
import com.project.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		String user_name = request.getParameter("user_name");
		String user_pass = request.getParameter("user_pass");
		String type = request.getParameter("type");
		
		UserService service = new UserService();
		HttpSession session = request.getSession();
		try {
			if (type.equals("login")) {
				String validate=request.getParameter("validate");
				String rand=(String)session.getAttribute("rand");
			//	System.out.println("user_name=" + user_name);
			//	System.out.println("user_pass=" + user_pass);
				User u = new User();
				u.setUser_name(user_name);
				u.setUser_pass(user_pass);
				if (service.isExist(u)) {
					u.setUser_id(service.getUserIdByUserName(user_name));
					session.setAttribute("user", u);
					request.getRequestDispatcher("main.jsp").forward(request,
							response);
				   } else {
					request.setAttribute("result", "用户名或密码不存在");
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				   }
				
			}//Administrator add user.
			else if (type.equals("add")) {
				String user_phone = request.getParameter("user_phone");
				User u = new User();
				u.setUser_name(user_name);
				u.setUser_pass(user_pass);
				u.setUser_phone(user_phone);
				service.addUser(u);
				response.sendRedirect("UserServlet?type=list");
			} else if (type.equals("regist")) {
			//	String yan=request.getParameter("yan");
			//	String rand=(String)session.getAttribute("rand");
				String user_phone = request.getParameter("user_phone");
				 
				User u = new User();
				u.setUser_name(user_name);
				u.setUser_pass(user_pass);
				u.setUser_phone(user_phone);
				service.addUser(u);
				//Add user info into db complete, then we set user session. 
				int user_id = service.getUserIdByUserName(user_name);
				u.setUser_id(user_id);
		//		System.out.println("user_id=" + user_id);
				session.setAttribute("user", u);
				response.sendRedirect("index.jsp");
			} 
			else if (type.equals("list")) {
				List<User> list = new ArrayList<User>();
				list = service.listAllUsers();
				request.setAttribute("list", list);
				request.getRequestDispatcher("BackAdmin/user_list.jsp")
						.forward(request, response);
			} 
	/*		else if (type.equals("modify")) {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				User user = service.getUserByUserId(user_id);
				request.setAttribute("user", user);
				request.getRequestDispatcher("BackAdmin/user_modify.jsp")
						.forward(request, response);
			} else if (type.equals("delete")) {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				service.deleteUserByUid(user_id);
				response.sendRedirect("UserServlet?type=list");
			} else if (type.equals("modified")) {
				String user_mail = request.getParameter("user_mail");
				User user = new User();
				user.setUser_name(user_name);
				user.setUser_pass(user_pass);
				user.setUser_id(Integer.parseInt(request
						.getParameter("user_id")));
				user.setUser_mail(user_mail);
				service.modifyUser(user);
				response.sendRedirect("UserServlet?type=list");
			}else if(type.equals("user_modify")){//�û��Լ��޸ĸ�����Ϣ.
				String user_mail = request.getParameter("user_mail");
				User user = new User();
				user.setUser_name(user_name);
				user.setUser_pass(user_pass);
				user.setUser_id(Integer.parseInt(request
						.getParameter("user_id")));
				user.setUser_mail(user_mail);
				service.modifyUser(user);
				response.sendRedirect("UserServlet?type=personalInfo");
			} else if (type.equals("exit")) {

				session.invalidate();
				request.getRequestDispatcher("main.jsp").forward(request,
						response);
			} else if (type.equals("personalInfo")) {// �����������ʾ��Ա������Ϣ��
				SessionChecker sessionChecker = new SessionChecker(request);
				if (sessionChecker.checkUser()) {
					request.getRequestDispatcher("personalInfo.jsp").forward(
							request, response);
				} 
				*/
				else {
					response.sendRedirect("login.jsp");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("BackAdmin/error.jsp");
		}
	}

}
