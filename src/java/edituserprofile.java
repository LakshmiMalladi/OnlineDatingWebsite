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
 * @author krish
 */
@ManagedBean
@RequestScoped
public class edituserprofile implements Serializable
{
     private  String gender;
     private String interestedgender;
       private int age;
       private String zipcode;
       private String dob;
       private String eyecolor;
       private String haircolor;
       private String interest01;
       private String interest02;
       private String interest03;
       private String bodytype;
       private String height;
       private String relationshipstatus;
       private String headline;
       private String aboutmatch;
       private String name;
       private String SecurityQuest;
       private String Securityans;
       private String City;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterestedgender() {
        return interestedgender;
    }

    public void setInterestedgender(String interestedgender) {
        this.interestedgender = interestedgender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public String getInterest01() {
        return interest01;
    }

    public void setInterest01(String interest01) {
        this.interest01 = interest01;
    }

    public String getInterest02() {
        return interest02;
    }

    public void setInterest02(String interest02) {
        this.interest02 = interest02;
    }

    public String getInterest03() {
        return interest03;
    }

    public void setInterest03(String interest03) {
        this.interest03 = interest03;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityQuest() {
        return SecurityQuest;
    }

    public void setSecurityQuest(String SecurityQuest) {
        this.SecurityQuest = SecurityQuest;
    }

    public String getSecurityans() {
        return Securityans;
    }

    public void setSecurityans(String Securityans) {
        this.Securityans = Securityans;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

       
//    public String getCity() {
//        return City;
//    }
//
//    public void setCity(String City) {
//        this.City = City;
//    }
//       
//    public String getSecurityQuest() {
//        return SecurityQuest;
//    }
//
//    public void setSecurityQuest(String SecurityQuest) {
//        this.SecurityQuest = SecurityQuest;
//    }
//
//    public String getSecurityans() {
//        return Securityans;
//    }
//
//    public void setSecurityans(String Securityans) {
//        this.Securityans = Securityans;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getInterestedgender() {
//        return interestedgender;
//    }
//
//    public void setInterestedgender(String interestedgender) {
//        this.interestedgender = interestedgender;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public String getEyecolor() {
//        return eyecolor;
//    }
//
//    public void setEyecolor(String eyecolor) {
//        this.eyecolor = eyecolor;
//    }
//
//    public String getHaircolor() {
//        return haircolor;
//    }
//
//    public void setHaircolor(String haircolor) {
//        this.haircolor = haircolor;
//    }
//
//    public String getInterest01() {
//        return interest01;
//    }
//
//    public void setInterest01(String interest01) {
//        this.interest01 = interest01;
//    }
//
//    public String getInterest02() {
//        return interest02;
//    }
//
//    public void setInterest02(String interest02) {
//        this.interest02 = interest02;
//    }
//
//    public String getInterest03() {
//        return interest03;
//    }
//
//    public void setInterest03(String interest03) {
//        this.interest03 = interest03;
//    }
//
//    public String getBodytype() {
//        return bodytype;
//    }
//
//    public void setBodytype(String bodytype) {
//        this.bodytype = bodytype;
//    }
//
//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    public String getRelationshipstatus() {
//        return relationshipstatus;
//    }
//
//    public void setRelationshipstatus(String relationshipstatus) {
//        this.relationshipstatus = relationshipstatus;
//    }
//
//    public String getHeadline() {
//        return headline;
//    }
//
//    public void setHeadline(String headline) {
//        this.headline = headline;
//    }
//
//    public String getAboutmatch() {
//        return aboutmatch;
//    }
//
//    public void setAboutmatch(String aboutmatch) {
//        this.aboutmatch = aboutmatch;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
       

    /**
     * Creates a new instance of edituserprofile
     */
    
    public void getuserprofile()
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
       final String DatabseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       
       try
       {
           conn=DriverManager.getConnection(DatabseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
           
           rs=stat.executeQuery("select * from userprofile where loginid='"+Login.id+"'");
           if(rs.next())
           {
               gender=rs.getString(1);
               interestedgender=rs.getString(2);
               age=Integer.parseInt(rs.getString(3));
               zipcode=rs.getString(4);
               dob=rs.getString(7);
               eyecolor=rs.getString(8);
               haircolor=rs.getString(9);
               interest01=rs.getString(10);
               interest02=rs.getString(11);
               interest03=rs.getString(12);
               bodytype=rs.getString(13);
               height=rs.getString(14);
               relationshipstatus=rs.getString(15);
               headline=rs.getString(16);
               aboutmatch=rs.getString(17);
               name=rs.getString(18);
               SecurityQuest=rs.getString(19);
               Securityans=rs.getString(20);
               City=rs.getString(21);
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
    }
    
    public void edituserprofile()
    {
        String message="";
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
       final String DatabseUrl="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
       
       try
       {
           conn=DriverManager.getConnection(DatabseUrl,"kanchipatik0763","1507919");
           stat=conn.createStatement();
//           if(gender==null)
//           {
//               System.out.println("error");
//           }
           int a=stat.executeUpdate("update userprofile set gender='"+gender+"',interestedgender='"+interestedgender+"',age='"+age+"', zipcode='"+zipcode+"',dob='"+dob+"',eyecolor='"+eyecolor+"',haircolor='"+haircolor+"',interest01='"+interest01+"',interest02='"+interest02+"',interest03='"+interest03+"',bodytype='"+bodytype+"',height='"+height+"',relationshipstatus='"+relationshipstatus+"',headline='"+headline+"',aboutmatch='"+aboutmatch+"',name='"+name+"',security_question='"+SecurityQuest+"',security_answer='"+Securityans+"',city='"+City+"' where loginid='"+Login.id+"'");
           message="Updated succesfully";
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
                      rs.close();
                      stat.close();
                  }
                  catch(Exception e)
                  {
                      e.printStackTrace();
                  }
               }
    }
}
