package vn.hiuz.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.hiuz.models.UserModel;
import vn.hiuz.services.IUserService;
import vn.hiuz.services.impl.UserServiceImpl;
import vn.hiuz.utils.Constant;

@WebServlet(urlPatterns = {"/login"})
public class LoginControllers extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// Lấy toàn bộ hàm trong service
	IUserService service = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
		 resp.setCharacterEncoding("UTF-8");
		 req.setCharacterEncoding("UTF-8");
		 
		 //  Lấy tham số tu view
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
		 String remember = req.getParameter("remember");
		 
		 //kiểm tra tham số
		 boolean isRememberMe = false;
		 if("on".equals(remember)){
		 isRememberMe = true;
		 }
		 String alertMsg="";
		 if(username.isEmpty() || password.isEmpty()){
			 alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			  req.setAttribute("alert", alertMsg);
			  req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			  return;
			  }
		 	// Xử lý bài toán login
			  
			  UserModel user = service.login(username, password);
			 if(user!=null){
				  HttpSession session = req.getSession(true);
				  session.setAttribute("account", user);
				  if(isRememberMe){
				  saveRemeberMe(resp, username);
			  }
			  resp.sendRedirect(req.getContextPath()+"/home");
			  }else{
			  alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			  req.setAttribute("alert", alertMsg);
			  req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			  }
	}
	private void saveRemeberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER,
				username);
				 cookie.setMaxAge(30*60);
				 resp.addCookie(cookie);
		
	}
}
