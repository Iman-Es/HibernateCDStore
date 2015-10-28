package com.jwt.hibernate.controller;
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.bean.User;
import com.jwt.hibernate.dao.UserDAO;
 
public class LoginControllerServlet extends HttpServlet {
     
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserDetails(email);
            if (password.equals(user.getPassword1())) {
            	//password correct
            	System.out.println("login success");
            	
            	HttpSession session = request.getSession();
            	
            	session.setAttribute("sessionId", email);
            	
            	System.out.println("Test get session:" + session.getAttribute("sessionId"));
            } else {
            	//password wrong
            	System.out.println("wrong password");
            }
            
            
//            
//            String nextJSP;
//            if (success){
//            	nextJSP = "/success.jsp";
//            }
//            else {
//            	nextJSP = "/failed.jsp";
//            }
////            
//            HttpSession session = request.getSession();
//            session.setAttribute("userName", userName);
//            
            //response.sendRedirect("/HibernateWebApp/success.jsp");
//            
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//            dispatcher.forward(request,response);
            
            
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
    }
}