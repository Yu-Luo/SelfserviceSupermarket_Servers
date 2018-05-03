package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.User;
import DAO.UserDAO;

/**
 * Servlet implementation class Register_Servlet
 */
@WebServlet("/Register_Servlet")
public class Register_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("ISO8859-1");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String account = request.getParameter(User.ACCOUNT);
        String passWord = request.getParameter(User.PASSWORD);
        String userName = request.getParameter(User.USERNAME);
        
        String userName1 = new String(userName.getBytes("ISO8859-1"), "UTF-8");
        UserDAO userDAO = new UserDAO();
        if(userDAO.register(account, passWord, userName1)){
        	out.println("true");
        }
        else{
        	out.println("Wrong");
        }
        out.flush();
        out.close();
	}

}
