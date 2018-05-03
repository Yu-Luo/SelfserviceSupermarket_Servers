package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Class.Supermarket;
import DAO.SupermarketDAO;

/**
 * Servlet implementation class GetSupermarketbyCity_Servlet
 */
@WebServlet("/GetSupermarketbyCity_Servlet")
public class GetSupermarketbyCity_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSupermarketbyCity_Servlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String city = request.getParameter("city");
        System.out.println(city);
        SupermarketDAO supermarketDAO = new SupermarketDAO();
        ArrayList<Supermarket> Supermarkets = supermarketDAO.GetSupermarketbyCity(city);
        Gson g = new Gson();
        
        //boolean  isNextPage = false;
        Map<String,Object> map = new HashMap<String,Object>();
        
        map.put("Supermarkets", Supermarkets);
        //map.put("isNextPage", isNextPage);
        
        out.print(g.toJson(map));
        
        out.flush();
        out.close();
	}

}
