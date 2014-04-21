package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.javabean.Message;
import com.project.javabean.User;
import com.project.service.MessageService;
import com.project.service.UserService;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
		
		MessageService service = new MessageService();
		HttpSession session = request.getSession();
		
		try {
				if (type.equals("add")) {
					
					Integer carpooling_id = Integer.parseInt(request.getParameter("carpooling_id"));
					String message_content = request.getParameter("message_content");
					User user=(User)session.getAttribute("user");
					Integer user_id;
					if(user == null){
						response.sendRedirect("error.jsp");
					}
					user_id = user.getUser_id();
					Message m = new Message();
					m.setMessage_content(message_content);
					m.setCarpooling_id(carpooling_id);
					m.setUser_id(user_id);
					service.addMessage(m);
					request.setAttribute("result", "留言成功。");
					request.getRequestDispatcher("succ.jsp")
							.forward(request, response);
			}else if (type.equals("list")) {
			//	response.sendRedirect("index.jsp");
			}else if (type.equals("delete")) {
				int message_id = Integer.parseInt(request.getParameter("message_id"));
				service.deleteMessageByMessageId(message_id);
				response.sendRedirect("messageManage.jsp");
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
