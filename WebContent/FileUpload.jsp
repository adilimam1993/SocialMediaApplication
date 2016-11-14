<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <h1> Upload Files</h1>
   
 <form action="" method="post" enctype="multipart/form-data" name="uploadForm">
 
 <%
     String saveFile=new String();
     String contentType=request.getContentType();
     
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
     
     saveFile="C:/Users/Adil Imam/Desktop/UploadImages/"+saveFile;
     
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
 
 
 %>
 
 
 <input type="file" name="file" width="100" />
 <br />
 <input type="submit" value="Upload File" />

</form>

</body>
</html>