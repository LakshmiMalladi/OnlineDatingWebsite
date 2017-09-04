/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Lenovo
 */
@ManagedBean
@SessionScoped
public class Messages implements Serializable{

   private String Senderid;
   private String Receiverid;
   private String message;
   private String senttime;
   private String status;
    private ArrayList<msgdetails> msginbox = new ArrayList<>();
    private ArrayList<msgdetails> msgoutbox = new ArrayList<>();

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
 
    public String sendMessages() {
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
       Senderid = Login.id;
       
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
               return ("Message Sent!!!");
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
    
    public void Inbox()
    {
        String userid = Login.id;
       
         try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           e.printStackTrace();           
       }
       
       final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null;
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from Message where Receiverid ='"+userid+"'");
           if(msginbox.size()==0)
           {
           while(rs.next())
           {
               String rid= rs.getString("Receiverid");
               String sid = rs.getString("Senderid");
               String msg = rs.getString("Message");
               String status1 = rs.getString("Status");
               String time = rs.getString("DateandTime");
               msginbox.add(new msgdetails(sid, rid, msg, status1, time));
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
               conn.close();
               stat.close();
               rs.close();
           }
           catch(Exception e)
           {
               e.printStackTrace();
               //return ("internal error");
           }
       }
    
    }
    public void Outbox()
    {
        String userid = Login.id;
       
         try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           e.printStackTrace();           
       }
       
       final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null;
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from Message where Senderid ='"+userid+"'");
           if(msgoutbox.size()==0)
           {
           while(rs.next())
           {
               String rid= rs.getString("Receiverid");
               String sid = rs.getString("Senderid");
               String msg = rs.getString("Message");
               String status1 = rs.getString("Status");
               String time = rs.getString("DateandTime");
               msgoutbox.add(new msgdetails(sid, rid, msg, status1, time));
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
               conn.close();
               stat.close();
               rs.close();
           }
           catch(Exception e)
           {
               e.printStackTrace();
               //return ("internal error");
           }
       }
    
    }
    public ArrayList<msgdetails> getInbox()
    {
        
        return msginbox;
    }
     public ArrayList<msgdetails> getOutbox()
    {
        
        return msgoutbox;
    }
    
}
