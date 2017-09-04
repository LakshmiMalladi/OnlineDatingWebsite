/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Shivakumart2181
 */
@ManagedBean
@SessionScoped
public class Reply {

    /**
     * Creates a new instance of Reply
     */
    
     private String Senderid;
   private String Receiverid;
   private String message;
   private String senttime;
   public String status;

    public String getSenderid() {
        return Senderid;
    }

    public void setSenderid(String Senderid) {
        this.Senderid = Senderid;
    }

    public String getReceiverid() {
        return Receiverid;
    }

    public void setReceiverid(String Receiverid) {
        this.Receiverid = Receiverid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenttime() {
        return senttime;
    }

    public void setSenttime(String senttime) {
        this.senttime = senttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    public String createReply() {
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
       Senderid= Login.id;
       
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from friendlist where userid = '"+Senderid+"' and friendid ='"+Receiverid+"'");
           if(rs.next())
           {
               senttime = DateAndTime.DateTime();
               status = "Sent";
               int r = stat.executeUpdate("Insert into message values ('"+Senderid+"','"+Receiverid+"','"+message+"','"+senttime+"','"+status+"')");
               return ("Replysent");
           }
           else
           {
               return("Unable to send message as the user is not your friend!!");
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
    }
 
    public String checkreplybutton()
    {
        return "Reply";
    }
    
}
