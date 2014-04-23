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

import com.project.javabean.Carpooling;
import com.project.javabean.User;
import com.project.service.CarpoolingService;
import com.project.service.UserService;

/**
 * Servlet implementation class CarpoolingServlet
 */
@WebServlet("/CarpoolingServlet")
public class CarpoolingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarpoolingServlet() {
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
		
		CarpoolingService service = new CarpoolingService();
		UserService userService = new UserService();
		HttpSession session = request.getSession();
		
		try {
				if (type.equals("add")) {
					String date = request.getParameter("date");
					String source = request.getParameter("source");
					String destiny = request.getParameter("destiny");
					String car_type = request.getParameter("car_type");
					String intro = request.getParameter("intro");
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
				response.sendRedirect("manage.jsp");
			}else if (type.equals("detail")) {
				Carpooling c = new Carpooling();
				int carpooling_id = Integer.parseInt(request.getParameter("carpooling_id"));
				c = service.getCarpoolingByCarpoolingId(carpooling_id);
				
				request.setAttribute("carpooling", c);
				request.getRequestDispatcher("details.jsp")
						.forward(request, response);
			}else if (type.equals("join")) {
				User user=(User)session.getAttribute("user");
				if(user == null){
					request.setAttribute("result", "请登录");
					request.getRequestDispatcher("log.jsp").forward(request,
							response);
					return;
				}
				
				int carpooling_id = Integer.parseInt(request.getParameter("carpooling_id"));
				Carpooling c = service.getCarpoolingByCarpoolingId(carpooling_id);
				//订车人数不能大于总人数
				if(c.getJoined_passangers() >= c.getTotal_passangers()){
					request.setAttribute("result", "此车人数已满，请尝试其他车~~");
					request.getRequestDispatcher("error.jsp")
							.forward(request, response);
					return;
				}
				//TODO: 同一个人不能多次订车。
				
				//TODO: 自己不能第二次加入自己的订车单。
				
				service.addPassanger(carpooling_id);
				//Get host info.
				Carpooling car = service.getCarpoolingByCarpoolingId(carpooling_id);
				int host_id = car.getUser_id();
				User host = userService.getUserByUserId(host_id);
				String host_info = "车主电话:"+host.getUser_phone();
				request.setAttribute("result", "拼车成功，请尽快联系车主."+host_info);
				request.getRequestDispatcher("succ.jsp")
						.forward(request, response);
			}else if (type.equals("search")) {
				String date = request.getParameter("date");
				String source = request.getParameter("source");
				String destiny = request.getParameter("destiny");
				
			//	List<Carpooling> search_carpoolings = service.getSecrchCarpoolingBySource(date, begin, offset)
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}