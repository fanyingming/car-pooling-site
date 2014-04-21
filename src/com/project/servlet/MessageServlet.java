package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.javabean.Message;
import com.project.service.MessageService;

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
					
					String message_content = request.getParameter("message_content");
					Integer gasoline_fee = Integer.parseInt(request.getParameter("gasoline_fee"));
					Integer road_fee = Integer.parseInt(request.getParameter("road_fee"));
					Integer total_passangers = Integer.parseInt(request.getParameter("total_passangers"));
					Integer distance = Integer.parseInt(request.getParameter("distance"));
					User user=(User)session.getAttribute("user");
					if(user == null){
						response.sendRedirect("error.jsp");
					}
					Carpooling c = new Carpooling();
					c.setCar_type(car_type);
					c.setDestiny(destiny);
					c.setDistance(distance);
					c.setGasoline_fee(gasoline_fee);
					c.setIntro(intro);
					c.setRoad_fee(road_fee);
					c.setSource(source);
					c.setTotal_passangers(total_passangers);
					c.setUser_id(user.getUser_id());
					c.setDate(date);
					service.addCarpooling(c);
					response.sendRedirect("index.jsp");
			}else if (type.equals("list")) {
				response.sendRedirect("index.jsp");
			}else if (type.equals("delete")) {
				int carpooling_id = Integer.parseInt(request.getParameter("carpooling_id"));
				service.deleteCarpoolingByCarpoolingId(carpooling_id);
				response.sendRedirect("index.jsp");
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
