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
public class Sendfriendrequest {
    private String name;
    private String Loginid;
    private String friendid;
    private String status;
    private String time;

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginid() {
        return Loginid;
    }

    public void setLoginid(String Loginid) {
        this.Loginid = Loginid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
    public String sendrequest(String n) {
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
       ResultSet rs =null,rs1=null,rs2=null;
       Connection conn=null;
       Statement stat=null;
       Loginid = Login.id;
       
       try
       {
           
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           String fid= "";
           rs2 = stat.executeQuery("Select * from userprofile where name='"+n+"'");
           if(rs2.next())
           {
               fid=rs2.getString("Loginid");
           }
           rs = stat.executeQuery("Select * from friendlist where friendid ='"+fid+"' and userid ='"+Loginid+"'");
          
           if(rs.next())
           {
               return("isyourfriend");
               
           }
            rs1=stat.executeQuery("Select * from friendrequest where friendid ='"+fid+"' and userid ='"+Loginid+"'");
           if(rs1.next())
           {
               String status=rs1.getString("status");
               if(status.equals("pending"))
               {
                   return("reqpending");
               }
               else if(status.equals("approved"))
               {
                   return("reqapproved");
               }
               
           }
           else
           {
               friendid = fid;
               status= "pending";
               time = DateAndTime.DateTime();
               int r = stat.executeUpdate("Insert into friendrequest values ('"+Loginid+"','"+friendid+"','"+status+"','"+time+"')");              
               return ("requestconfirmed");
                   
           }
           return ("requestnotsent");
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
