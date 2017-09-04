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
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Shivakumart2181
 */
@ManagedBean
@RequestScoped
public class viewfriends {

    private String userid;
    private String friendid;
    private String status;
    private String time;
    private static boolean renderpendingsection;
      private  static boolean renderapprovesection ;
        private static boolean rendersentrequestsection;
          private static boolean renderfriendssection;  
         private String id ;
        private boolean approveresult;
        private boolean approveresult1;

    public boolean isApproveresult1() {
        return approveresult1;
    }

    public void setApproveresult1(boolean approveresult1) {
        this.approveresult1 = approveresult1;
    }
        

    public boolean isApproveresult() {
        return approveresult;
    }

    public void setApproveresult(boolean approveresult) {
        this.approveresult = approveresult;
    }
        
         
         

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

         
    public boolean isRenderapprovesection() {
        return renderapprovesection;
    }

    public void setRenderapprovesection(boolean renderapprovesection) {
        this.renderapprovesection = renderapprovesection;
    }

    public boolean isRendersentrequestsection() {
        return rendersentrequestsection;
    }

    public void setRendersentrequestsection(boolean rendersentrequestsection) {
        this.rendersentrequestsection = rendersentrequestsection;
    }

    public boolean isRenderfriendssection() {
        return renderfriendssection;
    }

    public void setRenderfriendssection(boolean renderfriendssection) {
        this.renderfriendssection = renderfriendssection;
    }
          
          
       
       
       

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
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

   

    public ArrayList<friendrequest> getPending() {
        return pending;
    }

    public void setPending(ArrayList<friendrequest> pending) {
        this.pending = pending;
    }

    public ArrayList<friendrequest> getSentrequest() {
        return sentrequest;
    }

    public void setSentrequest(ArrayList<friendrequest> sentrequest) {
        this.sentrequest = sentrequest;
    }

    public ArrayList<friends> getFriend_list() {
        return friend_list;
    }

    public void setFriend_list(ArrayList<friends> friend_list) {
        this.friend_list = friend_list;
    }

    public boolean isRenderpendingsection() {
        return renderpendingsection;
    }

    public void setRenderpendingsection(boolean renderpendingsection) {
        this.renderpendingsection = renderpendingsection;
    }
    
    
    ArrayList<friendrequest> pending =new ArrayList<>();
    ArrayList<friendrequest> sentrequest = new ArrayList<>();
    ArrayList<friends> friend_list = new ArrayList<>();
  
    /**
     * Creates a new instance of viewfriends
     */
    public viewfriends() {
    }
    
    public void changerenderedpending(String correct)
    {
        if(correct.equals("pending"))
        {
        if(renderpendingsection)
        renderpendingsection=false;
        else
            renderpendingsection=true;
        }
        else if (correct.equals("request"))
        {
             if(rendersentrequestsection)
        rendersentrequestsection=false;
        else
            rendersentrequestsection=true;
        }
        else
        {
             if(renderfriendssection)
        renderfriendssection=false;
        else
            renderfriendssection=true;
        }
    }
       public void changerenderedapprove()
    {
        if(renderapprovesection)
        renderapprovesection=false;
        else
            renderapprovesection=true;
    }
//          public void changerenderedsentrequest()
//    {
//        if(rendersentrequestsection)
//        rendersentrequestsection=false;
//        else
//            rendersentrequestsection=true;
//    }
//             public void changerenderedfriends()
//    {
//        if(renderfriendssection)
//        renderfriendssection=false;
//        else
//            renderfriendssection=true;
//    }
    
    public ArrayList<friendrequest> Pending()
    {
     
        String id = Login.id;
          try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           e.printStackTrace();
           
       }
       
       final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null;      
      
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from friendrequest where friendid = '"+id+"' and status ='pending'");
           if(pending.size()==0)
           {
           while(rs.next())
           {
               pending.add(new friendrequest(rs.getString("userid"), rs.getString("friendid"), rs.getString("status"), rs.getString("time")));
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
               rs.close();
               stat.close();
               conn.close();
           }
           catch(SQLException e)
           {
               e.printStackTrace();
           }
       }
       return pending;
    }
    public ArrayList<friendrequest> sentrequest()
    {
         String id = Login.id;
         try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           e.printStackTrace();
           
       }
       
       final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null;      
    
        
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from friendrequest where userid = '"+id+"' and status ='pending'");
           if(sentrequest.size()==0)
           {
           while(rs.next())
           {
               sentrequest.add(new friendrequest(rs.getString("userid"), rs.getString("friendid"), rs.getString("status"), rs.getString("time")));
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
               rs.close();
               stat.close();
               conn.close();
           }
           catch(SQLException e)
           {
               e.printStackTrace();
           }
       }
       return sentrequest;
    }
    public ArrayList<friends> viewfriendlist()
    {
         String id = Login.id;
         try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           e.printStackTrace();
           
       }
       
       final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null; 
      
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
          
           rs = stat.executeQuery("Select * from friendlist where userid = '"+id+"'");
           if(friend_list.size()==0)
           {
           while(rs.next())
           {
              friend_list.add(new friends(rs.getString("userid"),rs.getString("friendid")));
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
               rs.close();
               stat.close();
               conn.close();
           }
           catch(SQLException e)
           {
               e.printStackTrace();
           }
       }
       return friend_list;
    }
    public String approverequest()
    {
       String userid = Login.id;
         try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           e.printStackTrace();  
          
          return ("Internal Error!!");
       }
       
       final String DatabaseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       ResultSet rs=null;
       Connection conn=null;
       Statement stat=null;      
       
       try
       {
           conn=DriverManager.getConnection(DatabaseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           rs = stat.executeQuery("Select * from friendrequest where friendid = '"+userid+"' and userid = '"+id+"' and status='pending'");       
           
           if(rs.next())
           {
               
              int r = stat.executeUpdate("Update friendrequest set status = 'approved'  where userid = '"+id+"' and friendid = '"+userid+"'");
              int a = stat.executeUpdate("Insert into friendlist values('"+userid+"','"+id+"')");
               int b = stat.executeUpdate("Insert into friendlist values('"+id+"','"+userid+"')");
                return ("Request Approved!!");  
           }
           else
           {
               return ("Request not Approved!!");
           }
             
       }
       catch(SQLException e)
       {
           e.printStackTrace();      
          return ("Internal Error!!");
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
              return ("Internal Error!!");
           }
       }  
     
    }
}
