// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class BiomassSMSextends HttpServlet {
 
   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "....";
   }

	/**
	* Post the SMS request to the database
	*/
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		try{
		   // JDBC driver name and database URL
		  static final String JDBC_DRIVER = "org.postgresql.Driver";  
		  static final String DB_URL="jdbc:postgresql://host/biomass";

		  //  Database credentials
		  static final String USER = "root";
		  static final String PASS = "password";
		  String message = "", msisdn = "";
		  message = request.getParameter("message");
		  msisdn = request.getParameter("msisdn");
  
		  // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		 conn.createStatement().executeQuery(
				"INSERT INTO SMS (msisdn, message) VALUES (" + msisdn + ",\'" + message + "\');"
		 );
         
		 conn.close();
		 response.getWriter().println("ok");
		 response.getWriter().flush();		 
		} catch (SQLException sql){}
   }

   public void destroy() {
      // destroy any permanent stuff.
   }
}