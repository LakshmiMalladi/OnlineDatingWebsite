/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author krish
 */
@ManagedBean
@RequestScoped
public class pview implements Serializable

{

    /**
     * Creates a new instance of pview
     */
    private String message="";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    ArrayList<String>rvids=new ArrayList<String>();
    ArrayList<String>svids=new ArrayList<String>();

    public ArrayList<String> getRvids() {
        return rvids;
    }

    public void setRvids(ArrayList<String> rvids) {
        this.rvids = rvids;
    }

    public ArrayList<String> getSvids() {
        return svids;
    }

    public void setSvids(ArrayList<String> svids) {
        this.svids = svids;
    }
    
    public String receivedview()
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
             
            rs=stat.executeQuery("select loginid from interestsv where userid='"+Login.id+"'");
            while(rs.next())
            {
              rvids.add(rs.getString("loginid"));
            }
//            if(rvids.size()==0)
//            {
//                message="no one had viewed your profile";
//            }
//            else
//            {
               message="rview";
            //}
            //message="rview";

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
    
    public String sentview()
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
             
            rs=stat.executeQuery("select userid from interestsv where Loginid='"+Login.id+"'");
            while(rs.next())
            {
              svids.add(rs.getString("userid"));
            }
//            if(svids.size()==0)
//            {
//                message="you have not viewed any profiles";
//            }
//            else
//            {
               message="sview";
            //}
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
    
//    public ArrayList<String> getlist1()
//    {
//        return rvids;
//    }
//    
//    public ArrayList<String> getList2()
//    {
//        return svids;
//    }
}
