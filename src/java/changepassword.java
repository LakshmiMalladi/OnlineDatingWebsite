/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.io.Serializable;

/**
 *
 * @author KanchipatiK0763
 */
@ManagedBean
@RequestScoped
public class changepassword implements Serializable{

    /**
     * Creates a new instance of changepassword
     */
    private String oldpswd;
    private String newpswd1;
    private String newpswd2;
    private String message;

    public String getNewpswd1() {
        return newpswd1;
    }

    public void setNewpswd1(String newpswd1) {
        this.newpswd1 = newpswd1;
    }

    public String getNewpswd2() {
        return newpswd2;
    }

    public void setNewpswd2(String newpswd2) {
        this.newpswd2 = newpswd2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOldpswd() {
        return oldpswd;
    }

    public void setOldpswd(String oldpswd) {
        this.oldpswd = oldpswd;
    }

    
    
    public void changepassword()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
        
        try
        {
            conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
            stat=conn.createStatement();
            
            rs=stat.executeQuery("select password from userprofile where loginid='"+Login.id+"'");
            if(rs.next())
            {
                if(oldpswd.equals(rs.getString(1)))
                {
                    if(newpswd1.equals(newpswd2))
                    {
                      int a=stat.executeUpdate("update userprofile set password='"+newpswd2+"' where loginid='"+Login.id+"'");
                      message="updated succesfully";
                    }
                    else
                    {
                      message="your new password doesn't match";
                    }
                }
                else
                {
                    message="your old password doesn't match";
                }
            }
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
    }
    
}
