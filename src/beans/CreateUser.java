package beans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Users user=new Users();
		
		
		String str1="Valid Email Address";
		String str2="Invalid Email Address";
		
		System.out.println(request.getParameter("useremail"));
		
		
		response.setContentType("text/plain");
		
		response.getWriter().write(str1);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String key=request.getParameter("key1");
		String field=request.getParameter("field");
		String gender=request.getParameter("gender");
		
		
		Users user=new Users(fname,lname,email,field,gender,key);
		
		if(user.createUser())
		{
		   PrintWriter out=response.getWriter();
		    
		   
		   request.getRequestDispatcher("SuccessfulNewUser.jsp").forward(request, response);
		   
		}
		
			
	}

}
