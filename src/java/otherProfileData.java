/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author KriLak
 */
//@Named(value = "otherProfileData")
@ManagedBean
@SessionScoped
public class otherProfileData implements Serializable{

    /**
     * Creates a new instance of otherProfileData
     */
    private String name;
    private String gender;
    private String Interestgender;
    private int age;
    private String ageBegin;
    private String ageEnd; 
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
    boolean b1 = false;

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAgeBegin() {
        return ageBegin;
    }

    public void setAgeBegin(String ageBegin) {
        this.ageBegin = ageBegin;
    }

    public String getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(String ageEnd) {
        this.ageEnd = ageEnd;
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
        otherProfileData.dob = dob;
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

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }
    
    
    public String otherProfileDataGet(String name1) {
         
        Search s = new Search();
        for(Profile i : s.getList())
        {
          if(i.getName().equals(name1))
          {
              this.name = name1;
              this.gender = i.getGender();
              this.Interestgender = i.getInterestgender();
              this.Zipcode = i.getZipcode();
              this.age = i.getAge();
              this.bodytype = i.getBodytype();
              this.eyecolor = i.getEyecolor();
              this.city = i.getCity();
              this.interest1 = i.getInterest1();
              this.interest2 = i.getInterest2();
              this.interest3 = i.getInterest3();
              this.relationshipstatus = i.getRelationshipstatus();
              this.lastlogin = i.getLastlogin();
              b1 = true;
          }
        }
        if(b1 == true)
        {
            return("getProfile");
        }
        else
        {
            return null;
        }
    }
    
}
