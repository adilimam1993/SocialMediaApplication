package beans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleData
 */
@WebServlet("/HandleData")
public class HandleData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
	 
	}

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String username=request.getParameter("username");
	     String password=request.getParameter("key");
	 
	     PrintWriter out=response.getWriter();
	     
	      Users user=new Users();
	      user.setEmail(username);
	      user.setPassword(password);
	  
	      System.out.println("User image = "+user.getImage());
	      
	      request.getSession().setAttribute("email", user.getEmail());   		   
	      request.getSession().setAttribute("fname", user.getFname());     
	      request.getSession().setAttribute("lname", user.getLname());    
	      request.getSession().setAttribute("image", user.getImage());    
	      
	   
	      
	   if(user.testUsername())
	   request.getRequestDispatcher("LoginSuccessful.jsp").forward(request, response);
	     
	   else
	   {
		   out.println("Not a registered User");
	   }
	 
	
	
	}
}
