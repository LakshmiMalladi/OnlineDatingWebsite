/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author KanchipatiK0763
 */
@ManagedBean
@RequestScoped
public class likep implements Serializable
{

    /**
     * Creates a new instance of likep
     */
    private String id;
     String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void likep(String name1)
    {
        Search s= new Search();
        
        for(Profile i:s.getList())
        {
            if(i.getName().equals(name1))
            {
                //this.id=i.getId();
                this.id=i.getName();
            }
        }
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
            
            rs=stat.executeQuery("select * from interestsl where userid='"+this.id+"' and loginid='"+Login.id+"'");
            
            if(rs.next())
            {
                int a=stat.executeUpdate("update interestsl set likes=likes+1 where userid='"+this.id+"'");
                message="Done";
            }
            else
            {
                int a=stat.executeUpdate("insert into interestsl values('"+this.id+"','"+Login.id+"','"+1+"')");
                message="Done";
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
            }
        }
    }
}
