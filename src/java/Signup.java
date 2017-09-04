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
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Shivakumart2181
 */
@ManagedBean
@RequestScoped
public class Signup implements Serializable{
       private static String Loginid;        
       private static String password;
       private String Name;
       private String gender;
       private String Interestgender;
       private int age;
     
       //private String city;
       private String interest1;
       private String interest2;
       private String interest3;
       private String lastlogin;
       //private int views; 
       private String Zipcode;
       private static String dob;
       private String eyecolor;
       private String haircolor;
       private String bodytype;
       private String height;
       private String relationshipstatus;
       private String headline;
       private String aboutmatch;
       private String security_ques;
       private String security_ans;
       private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
       
       

    public String getSecurity_ques() {
        return security_ques;
    }

    public void setSecurity_ques(String security_ques) {
        this.security_ques = security_ques;
    }

    public String getSecurity_ans() {
        return security_ans;
    }

    public void setSecurity_ans(String security_ans) {
        this.security_ans = security_ans;
    }

       
    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public String getBodytype() {
        return bodytype;
    }

    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRelationshipstatus() {
        return relationshipstatus;
    }

    public void setRelationshipstatus(String relationshipstatus) {
        this.relationshipstatus = relationshipstatus;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getAboutmatch() {
        return aboutmatch;
    }

    public void setAboutmatch(String aboutmatch) {
        this.aboutmatch = aboutmatch;
    }

      
public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getLoginid() {
        return Loginid;
    }

    public void setLoginid(String Loginid) {
        this.Loginid = Loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterestgender() {
        return Interestgender;
    }

    public void setInterestgender(String Interestgender) {
        this.Interestgender = Interestgender;
    }  

//    public String getCity() {
//        return city;
//    }

//    public void setCity(String city) {
//        this.city = city;
//    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public void setInterest2(String interest2) {
        this.interest2 = interest2;
    }

    public String getInterest3() {
        return interest3;
    }

    public void setInterest3(String interest3) {
        this.interest3 = interest3;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

//    public int getViews() {
//        return views;
//    }

//    public void setViews(int views) {
//        this.views = views;
//    }
      
      
    public String cSignup() {        
      try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ("Internal Error, Please try again later");
        }
    
       
        //add to the database
        final String dbUrl ="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
        Connection conn=null;
        Statement stat = null;
        ResultSet rs=null;
        //boolean newAcc = false;
        try{
        conn = DriverManager.getConnection(dbUrl,"kanchipatik0763","1507919");
        stat =conn.createStatement();
        rs =stat.executeQuery("Select * from userprofile where loginid='"+Loginid+"'");            
        if(rs.next())
            {   
              return("login id already exists ! get a new one");
            }
          else
           {
                  
             int r = stat.executeUpdate("Insert into userprofile values('"+gender+"','"+Interestgender+"','"+age+"','" +Zipcode+"','"+Loginid+"','"+password+"','"+dob+"','"+eyecolor+"','"+haircolor+"','"+interest1+"','"+interest2+"','"+interest3+"','"+bodytype+"','"+height+"','"+relationshipstatus+"','"+headline+"','"+aboutmatch+"','"+Name+"','"+security_ques+"','"+security_ans+"','"+city+"','"+lastlogin+"')");
             return("registration successful");
                  
           }
    
        }         
           
        catch (SQLException e)
        {
            //return an error message
            e.printStackTrace();
            return ("Internal Error. Please Try Again Later");
        }
        finally
        {
            try
            { 
                rs.close();
                stat.close();
                conn.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return("internal error");
            }
        }
       
    }
    
    
}
