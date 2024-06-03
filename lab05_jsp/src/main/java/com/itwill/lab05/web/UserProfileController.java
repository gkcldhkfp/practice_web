package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "userProfileController", urlPatterns = {"/user/profile"} )
public class UserProfileController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserProfileController.class);
	private final UserService userService = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		
		HttpSession session = req.getSession();
		
		String userid = (String) session.getAttribute("signedInUser");
		
		User result = userService.userProfile(userid);
		log.debug("result {} ", result);
		req.setAttribute("userInfo", result);
		
		req.getRequestDispatcher("/WEB-INF/views/user/profile.jsp").forward(req, resp);
		
		
	}

}
