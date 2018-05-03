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

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet_getString")
public class Servlet_getString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_getString() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  ArrayList<Food> food = new ArrayList<Food>();
	        Gson g = new Gson();
	    
	        Food f1 = new Food(1,"111145678","1111","/cinema_1.jpg");
	        Food f2 = new Food(2,"2222","22222","/cinema_2.jpg");
	        Food f3 = new Food(3,"3333","33333","/food_1.jpg");
	        Food f4 = new Food(4,"44444","4444","/food_2.jpg");
	        Food f5 = new Food(5,"55555","5555","/hotel_1.jpg");
	        
	        food.add(f1);
	        food.add(f2);
	        food.add(f3);
	        food.add(f4);
	        food.add(f5);
	        
	        boolean  isNextPage = false;
	        Map<String,Object> map = new HashMap<String,Object>();
	        
	        map.put("foodList", food);
	        map.put("isNextPage", isNextPage);
	        
	        response.setContentType("text/html;charset=utf-8");
	        
	        PrintWriter  out = response.getWriter();
	        //out.print(g.toJson(map));
	        out.print("teee");
	        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
