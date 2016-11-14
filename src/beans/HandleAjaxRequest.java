package beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleAjaxRequest
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/HandleAjaxRequest" })
public class HandleAjaxRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleAjaxRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   Users user=new Users();

			response.setContentType("text/plain");
			
			
			String str1="Valid Email Address";
			String str2="Email Already Exists";
			
			String email=request.getParameter("email");
			
			user.setEmail(email);

			if(user.checkEmail())
			{
				response.getWriter().write(str1);
					
			}
			else
			{
				response.getWriter().write(str2);
						
			}
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		
	}

}
