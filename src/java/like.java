/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author krish
 */
@ManagedBean
@SessionScoped
public class like implements Serializable {

    /**
     * Creates a new instance of like
     */
    private String message="";
    ArrayList<String>rlids=new ArrayList<String>();
    ArrayList<String>slids=new ArrayList<String>();

    public ArrayList<String> getRlids() {
        return rlids;
    }

    public void setRlids(ArrayList<String> rlids) {
        this.rlids = rlids;
    }

    public ArrayList<String> getSlids() {
        return slids;
    }

    public void setSlids(ArrayList<String> slids) {
        this.slids = slids;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String rlikes()
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
        ResultSet rs=null;
        Statement stat=null;
        
        final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
        
        try
        {
            conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
            stat=conn.createStatement();
             
            rs=stat.executeQuery("select loginid from interestsl where userid='"+Login.id+"'");
            while(rs.next())
            {
              rlids.add(rs.getString("loginid"));
            }
            message="rlike";
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
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
       return message;
    }
    public String slikes()
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
        ResultSet rs=null;
        Statement stat=null;
        
        final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
        
        try
        {
            conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
            stat=conn.createStatement();
             
            rs=stat.executeQuery("select userid from interestsl where loginid='"+Login.id+"'");
            while(rs.next())
            {
              slids.add(rs.getString("userid"));
            }
            message="slike";
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
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
       return message;
    }
    
    
}
