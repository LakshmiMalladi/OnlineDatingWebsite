

import java.sql.*;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KriLak
 */

public class Profile{
    
    private static String Loginid;        
       //private static String password;
       private String Name;
       private String gender;
       private String Interestgender;
       private int age;            
       private String city;
       private String interest1;
       private String interest2;
       private String interest3;
       private String lastlogin;
       private int views; 
       private String Zipcode;
       private static String dob;
       private String eyecolor;
       private String haircolor;
       private String bodytype;
       private String height;
       private String relationshipstatus;
       private String headline;
       private String aboutmatch;
       String profile;
       
       public Profile(String n,String g,String ig,int a, String c, String i1,String i2,String i3,String lastl,
             String z, String d, String ec,String hc, String bt, String ht, String rs, String h,String am)
     {
         Name = n;
         gender = g;
         Interestgender = ig;
         age = a;
         city = c;
         interest1 = i1;
         interest2 = i2;
         interest3 = i3;
         lastlogin=lastl;
         Zipcode = z;
         dob = d;
         eyecolor = ec;
         haircolor = hc;
         bodytype = bt;
         height = ht;
         relationshipstatus = rs;
         headline = h;
         aboutmatch = am;
     }

    public static String getLoginid() {
        return Loginid;
    }

    public static void setLoginid(String Loginid) {
        Profile.Loginid = Loginid;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public static String getDob() {
        return dob;
    }

    public static void setDob(String dob) {
        Profile.dob = dob;
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
    
    public String getProfile(String profile)
    {
        return profile;
    }
    
    public String signOut()
    {
        FacesContext.getCurrentInstance().
                getExternalContext().invalidateSession();
        return "index.xhtml";

        
    }
}      
