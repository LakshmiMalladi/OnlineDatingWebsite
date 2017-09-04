/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author krish
 */
@ManagedBean
@SessionScoped
public class wink implements Serializable {

    /**
     * Creates a new instance of wink
     */
    private String message="";
    ArrayList<String>rwids=new ArrayList<String>();
    ArrayList<String>swids=new ArrayList<String>();

    public ArrayList<String> getRwids() {
        return rwids;
    }

    public void setRwids(ArrayList<String> rwids) {
        this.rwids = rwids;
    }

    public ArrayList<String> getSwids() {
        return swids;
    }

    public void setSwids(ArrayList<String> swids) {
        this.swids = swids;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public String rwink()
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
             
            rs=stat.executeQuery("select loginid from interestw where userid='"+Login.id+"'");
            while(rs.next())
            {
              rwids.add(rs.getString("loginid"));
            }
            message="rwink";
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
    public String swink()
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
             
            rs=stat.executeQuery("select userid from interestw where loginid='"+Login.id+"'");
            while(rs.next())
            {
              swids.add(rs.getString("userid"));
            }
            message="swink";
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
