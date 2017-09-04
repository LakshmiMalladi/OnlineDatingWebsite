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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Shivakumart2181
 */
@ManagedBean
@SessionScoped
public class Delete implements Serializable {

    private String time;
    private String senderid;
    private String recieverid;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getRecieverid() {
        return recieverid;
    }

    public void setRecieverid(String recieverid) {
        this.recieverid = recieverid;
    }
    
    /**
     * Creates a new instance of Delete
     */
    public String todelete() {
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
      
       
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from message where senderid = '"+senderid+"' and DateandTime ='"+time+"' and receiverid ='"+recieverid+"'");
           if(rs.next())
           {
               
               int r = stat.executeUpdate("Delete from message where Senderid= '"+senderid+"' ");
               return ("message deleted!!");
           }
           else
           {
               return("message not deleted");
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
    
}
