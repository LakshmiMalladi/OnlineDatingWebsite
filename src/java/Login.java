/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.webkit.WebPage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.text.*;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author krish
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable{

    /**
     * Creates a new instance of Login
     */
    public static String id;
    private String pswd;
    public Profile theCurrentAccount;
    private String lastlogin;

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }
    
    public Profile getTheCurrentAccount() {
        return theCurrentAccount;
    }

    public void setTheCurrentAccount(Profile theCurrentAccount) {
        this.theCurrentAccount = theCurrentAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
    
    
    public String cLogin()
    {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           e.printStackTrace();
           return("Internal error ...try again later");
       }
       
       final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null;
       String message="";
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           updatelogin();
           
           rs=stat.executeQuery("select * from userprofile where loginid='"+id+"'");
           
           if(rs.next())
           {
               if(pswd.equals(rs.getString("password")))
               {
                   
                  id=rs.getString("loginid");
//                  message="interests";
                   String password = rs.getString("password");
                  
//               if(pswd.equals(password))
//               {
                  theCurrentAccount = new Profile(rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("interestedgender"),
                        rs.getInt("age"),
                        rs.getString("city"),
                        rs.getString("interest01"),
                        rs.getString("interest02"),
                        rs.getString("interest03"),
                          rs.getString("lastlogin"),
                        rs.getString("zipcode"),
                        rs.getString("dob"),
                        rs.getString("eyecolor"),
                        rs.getString("haircolor"),
                        rs.getString("bodytype"),
                        rs.getString("height"),
                        rs.getString("relationshipstatus"),
                        rs.getString("headline"),
                        rs.getString("aboutmatch")); 
                  message = "MainPage";
               }
               else
               {
                   message="loginnotok";
               }
           }
           else
           {
               message="loginnotok";
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
           return ("Internal error");
       }
       finally
       {
           try
           {
               conn.close();
               stat.close();
               rs.close();
           }
           catch(Exception e)
           {
               e.printStackTrace();
               return ("internal error");
           }
       }
       return message;
    }
    
    public void updatelogin()
    {
           final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null;
       String message="";
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           lastlogin = DateAndTime.DateTime();
           
           rs=stat.executeQuery("select * from userprofile where loginid='"+id+"'");
             if(rs.next())
           {
               if(pswd.equals(rs.getString("password")))
               {
                    int r = stat.executeUpdate("Update userprofile set lastlogin ='"+lastlogin+"' where loginid='"+id+"'");
               }
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       finally
       {
           try
           {
               rs.close();
               stat.close();
               conn.close();
           }
           catch(SQLException e)
           {
               e.printStackTrace();
           }
       }
    }
    
}
