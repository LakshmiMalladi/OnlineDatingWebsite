/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.sql.*;

/**
 *
 * @author krish
 */
@ManagedBean
@RequestScoped
public class forget_password {

    /**
     * Creates a new instance of forget_password
     */
    private static String id;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String retrieve_question() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return("internal error");
        }
        
        final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
        
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        
        try
        {
            conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
            stat=conn.createStatement();
            
            rs=stat.executeQuery("select security_question from userprofile where loginid='"+id+"'");
            if(rs.next())
            {
                return("your security question: "+" "+rs.getString(1));
                
            }
            else
            {
                return("login id doesnot exists");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return("Internal error ! plz try again later");
        }
    }
    
    public String retrieve_answer()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return("internal error");
        }
        
        final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
        
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        
        try
        {
            conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
            stat=conn.createStatement();
            
            rs=stat.executeQuery("select security_answer,password from userprofile where loginid='"+id+"'");
            if(rs.next())
            {
                if(answer.equals(rs.getString(1)))
                {
                    return("your password is: "+rs.getString(2));
                }
                else
                {
                    return("your answer doesnot match. sorry");
                }
            }
            else
            {
                return("no records");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return("internal error ! plz try again later");
        }
    }
}
