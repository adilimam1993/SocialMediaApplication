package beans;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessImage
 */
@WebServlet("/ProcessImage")
public class ProcessImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       
		  String saveFile=new String();
		  String contentType=request.getContentType();
		  String imageName=new String();
		  
		     if(contentType!=null && contentType.indexOf("multipart/form-data")>=0)
		     {
		    	     	 
		    	 
		    	 DataInputStream in=new DataInputStream(request.getInputStream());
		    	 
		    	 int formDataLength=request.getContentLength();
		    	 
		    	 byte dataBytes[]=new byte[formDataLength];
		    	 
		    	 int bytesRead=0;
		    	 int total=0;
		    	 
		    	 while(total<formDataLength)
		    	 {
		    		 bytesRead = in.read(dataBytes,total,formDataLength);
		    		 
		    		 total+=bytesRead;
		    	 }
		     
		     String file=new String(dataBytes);
		     
		     saveFile=file.substring(file.indexOf("filename=\"")+10);
		     saveFile=saveFile.substring(0, saveFile.indexOf("\n"));
		     saveFile=saveFile.substring(saveFile.lastIndexOf("\\")+1, saveFile.indexOf("\""));
		     
		     int lastIndex=contentType.lastIndexOf("=");
		     
		     String boundary=contentType.substring(lastIndex+1, contentType.length());
		     int pos;
		     
		     pos=file.indexOf("filename=\"");
		     pos=file.indexOf("\n", pos)+1;
		     pos=file.indexOf("\n", pos)+1;
		     pos=file.indexOf("\n", pos)+1;
		     
		     int boundaryLocation= file.indexOf(boundary,pos)-4;
		     
		     int startPos=file.substring(0,pos).getBytes().length;
		     int endPos=file.substring(0,boundaryLocation).getBytes().length;
		     
		     imageName=saveFile;
		     
		     saveFile="C:/Users/Adil Imam/Desktop/SocialMediaApplication/WebContent/"+saveFile;
		     
		     File ff=new File(saveFile);
		      
		      try
		      {
		    	  FileOutputStream fileout=new FileOutputStream(ff);
		    	  fileout.write(dataBytes, startPos, endPos-startPos);
		    	  fileout.flush();
		    	  fileout.close();
		      }
		     catch(Exception e){}
		     }
           
		   
		     
		      Users user=new Users();
		      
		      user.setImage(imageName);
		      
		      String email=(String) request.getSession().getAttribute("email");
		 
		      user.setEmail(email);
		      
		      user.saveProfileImg();
		      
		      System.out.println(saveFile);
		      
		      request.getSession().setAttribute("image",imageName);
		      
		     try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		      
		     // System.out.println(saveFile);
		      
		      request.getRequestDispatcher("TestFile.jsp").forward(request,response);
		      
		
	}
	
	

}
