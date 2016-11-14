package beans;
import java.sql.*;


public class Users {

	private String email;
	private String password;
	private String fname;
	private String lname;
	private String occupation;
	private String gender;
	private String image;
	
    private Connection con;
	private Statement stat;
	private ResultSet result;
	
	 String url="jdbc:mysql://localhost:3306/customers?autoReconnect=true&useSSL=false";
	 String user="root";
	 String pass="rafa2012";

	



		

public Users()
{
	
}

	public Users(String fname, String lname,String email, String occupation, String gender, String password
			) {
		super();
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.occupation = occupation;
	    this.gender=gender;
	} 

	
	
	public String getImage() {
		
		getConnection();
		
		try 
		{
			
			
		    stat=con.createStatement();
	
            String sql="select imgpath from username where email='"+this.email+"'";		    
		    
          
   result=stat.executeQuery(sql);
      
   result.next();
   
        image=result.getString("imgpath");
   
    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	public String getEmail(){
		
		
		
		return email;
	}



	public void setEmail(String username) {
		this.email = username;
	}



	public String getFname() {
		
		
		getConnection();
		
		try 
		{
			
			
		    stat=con.createStatement();
	
            String sql="select fname from username where email='"+this.email+"'";		    
		    
          
   result=stat.executeQuery(sql);
      
   result.next();
   
        fname=result.getString("fname");
   
    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		
		
		
		
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		
		
		
		 try {
		       Class.forName("com.mysql.jdbc.Driver");
	         } 
	     catch (ClassNotFoundException e1) {
		 	e1.printStackTrace();
	        }
		
		
		try 
		{
			
			
			con=DriverManager.getConnection(url, user, pass);
		    stat=con.createStatement();
	
           String sql="select lname from username where email='"+this.email+"'";		    
		    
         
  result=stat.executeQuery(sql);
     
  result.next();
  
       lname=result.getString("lname");
  
   
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		
		
		
		
		return lname;
		
			}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkEmail()
	{
		getConnection();
		
		
		try 
		{		
		    stat=con.createStatement();
		    
		    result=stat.executeQuery("select *from username where email='"+email+"'");   
		    
		    if(result.next())
		    {
		    	return false;
		    }
		  
		    
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public boolean testUsername()
	{
	

	 getConnection();
 	 
		try 
		{		
		    stat=con.createStatement();
		    
		    result=stat.executeQuery("select *from username where email='"+email+"' and password= '"+password+"'");   
		    
		    if(result.next())
		    {
		    	return true;
		    }
		  
		    
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	    		
	}
	
	
	public boolean createUser()
	{
		
		 getConnection();
		 		
		
		try 
		{
			
			
		    stat=con.createStatement();
	
String sql="insert into username values('"+fname+"','"+lname+"','"+email+"','"+occupation+"','"+gender+"','"+password+"','')";		    
		    
           stat.executeUpdate(sql);
		   return true;
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		return false;
		}
		
	}
	
	
	
	public void getConnection()
	{
		

		 try {
		       Class.forName("com.mysql.jdbc.Driver");
		       System.out.println("Driver found");
	         } 
	     catch (ClassNotFoundException e1) {
		 	e1.printStackTrace();
	        }
		
		
		try 
		{
			
			
			con=DriverManager.getConnection(url, user, pass);
	
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
}
		
	

	 public boolean saveProfileImg()
	 {
		 getConnection();
			try 
			{
				
				
		    stat=con.createStatement();
	
            String sql="update username set imgpath='"+this.image+"' where email='"+this.email+"'";		    
		    
           stat.executeUpdate(sql);
		   return true;
		    
			}
			catch(Exception e)
			{
				System.out.println(e);
			return false;
			}
		 
		
	 }
	
	
}
