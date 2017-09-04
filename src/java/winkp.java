/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author krish
 */
@ManagedBean
@RequestScoped
public class winkp implements Serializable {

    /**
     * Creates a new instance of winkp
     */
    private String id;
    private String message;
    boolean winked = true;
    int count=0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isWinked() {
        return winked;
    }

    public void setWinked(boolean winked) {
        this.winked = true;
    }

    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void cwink(String name1)
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
        Statement stat1=null;
        ResultSet rs=null;
        ResultSet rs1=null;
        
        final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
        
        try
        {
            conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
            stat=conn.createStatement();
            
            rs=stat.executeQuery("select * from interestw where userid='"+this.id+"' and loginid='"+Login.id+"'");
            
            FacesContext context = FacesContext.getCurrentInstance();
            
            
            if(rs.next())
            {
                int a=stat.executeUpdate("update interestw set winks=winks+1 where userid='"+this.id+"'");
                message="Done";
                stat1 = conn.createStatement();
                rs1 = stat1.executeQuery("select * from interestw where loginid='"+Login.id+"' and userid = '" +this.id+ "'");
                if(rs1.next())
                {
                    count = rs1.getInt("winks");
                    context.addMessage(null, new FacesMessage(rs1.getString("loginid") +"have winked."));
                }
            }
            else
            {
                int a=stat.executeUpdate("insert into interestw values('"+this.id+"','"+Login.id+"','"+1+"')");
                message="Done";
                stat1 = conn.createStatement();
                rs1 = stat1.executeQuery("select * from interestw where loginid='"+Login.id+"' and userid = '" +this.id+ "'");
                if(rs1.next())
                {
                    count = rs1.getInt("winks");
                    context.addMessage(null, new FacesMessage(rs1.getString("loginid") +"have winked."));
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
            }
        } 
    }
    
}
