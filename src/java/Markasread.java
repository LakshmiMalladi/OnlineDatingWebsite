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
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Lenovo
 */
@ManagedBean
@RequestScoped
public class Markasread {

    private String senderid;
    private String time;
    private String status;
    private String receiverid;

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid;
    }
    
    /**
     * Creates a new instance of Markasread
     */
    public  String Read() {
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
       receiverid = Login.id;
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from message where Senderid='"+senderid+"'and Receiverid ='"+receiverid+"' and DateandTime ='"+time+"'");
           if(rs.next())
           {
               status= "Read";
               time = DateAndTime.DateTime();
               int r = stat.executeUpdate("Update message set status='"+status+"',DateandTime='"+time+"'");
               return ("Message marked as read!!");
           }
           else
           {
               return ("Message not available!!");
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
           return("Internal error");
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
    public  String Unread() {
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
       receiverid = Login.id;
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from message where Senderid='"+senderid+"'and Receiverid ='"+receiverid+"' and DateandTime ='"+time+"'");
           if(rs.next())
           {
               status= "Sent";
               time = DateAndTime.DateTime();
               int r = stat.executeUpdate("Update message set status='"+status+"',DateandTime='"+time+"'");
               return ("Message marked as Unread!!");
           }
           else
           {
               return ("Message not available!!");
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
           return("Internal error");
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
