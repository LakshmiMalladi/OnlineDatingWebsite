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
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author KriLak
 */
//@Named(value = "search")
//@Dependent
@ManagedBean
@SessionScoped
public class Search implements Serializable {

    /**
     * Creates a new instance of Search
     */
    
    private static String Loginid;        
       //private static String password;
    private String Name;
    private String gender;
    private String Interestgender;
    private int age;
    private String ageBegin;
    private String ageEnd; 
    private String city;
    private String interest;
    private String lastlogin;
    private int views; 
    private String Zipcode;
    private static String dob;
    private String eyecolor;
    private String haircolor;
    private String bodytype;
    private String height;
    private String relationshipstatus;
    boolean toRefineSearch;
    public String a="yes";
    public String b="No";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public boolean isToRefineSearch() {
        return toRefineSearch;
    }

    public void setToRefineSearch(boolean toRefineSearch) {
        this.toRefineSearch = toRefineSearch;
    }
    //ArrayList<String> a = new ArrayList<String>();
    protected static ArrayList<Profile> list = new ArrayList<Profile>();
    boolean b1 = false;
    boolean b2= false;

    public ArrayList<Profile> getList() {
        return list;
    }

    public void setList(ArrayList<Profile> list) {
        this.list = list;
    }
        
     public static String getLoginid() {
        return Loginid;
    }

    public static void setLoginid(String Loginid) {
       Search.Loginid = Loginid;
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

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
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
        Search.dob = dob;
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
    
 
    public String searchNew()
    {
      final String dbUrl ="jdbc:mysql://mis-sql.uhcl.edu/kanchipatik0763";
      Connection conn=null;
      
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
        
        Statement stat = null;
        ResultSet rs=null;
        //boolean newAcc = false;
        
        try{
        conn = DriverManager.getConnection(dbUrl,"kanchipatik0763","1507919");
        stat =conn.createStatement();
        int x = Integer.parseInt(ageBegin);
        int y = Integer.parseInt(ageEnd);
        if((gender != null||gender != "")&&(Interestgender!=null||Interestgender !=" ")&&
                (Zipcode!=null||Zipcode !=" ")&&(x>0)&&(y>0))
        {
            //only normal search
            String sql = "select * from userprofile where gender = '" +Interestgender+ "' and interestedgender = '" +gender+ "' and age >= "+x+" and age <= "+y+" "
                    + " and zipcode = '" +Zipcode+ "'";
            rs = stat.executeQuery("select * from userprofile where gender = '" +Interestgender+ "' and interestedgender = '" +gender+ "' and age >= '" +x+ "' and age <= '"+y+"'"
                    + " and zipcode = '" +Zipcode+ "'");
            
            if(list.size()==0)
            {
            while(rs.next())
            {
                b1=true;
               list.add(new Profile(rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("interestedgender"),
                        rs.getInt("age"),
                        rs.getString("city"),
                        rs.getString("interest01"),
                        rs.getString("interest02"),
                        rs.getString("interest03"),
                       rs.getString("lastlogin"),
                        rs.getString("zipcode"),
                        rs.getString("dob"),
                        rs.getString("eyecolor"),
                        rs.getString("haircolor"),
                        rs.getString("bodytype"),
                        rs.getString("height"),
                        rs.getString("relationshipstatus"),
                        rs.getString("headline"),
                        rs.getString("aboutmatch")
                        )); 
            }
            }
            if(b1 == true)
            {
                return("resultSearch");
            }
        }
            //rs = stat.executeQuery("");
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
        return null;
    }
    public String refinedSearch(String ref)
    {
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
        Connection conn1=null;
        Statement stat1 = null;
        toRefineSearch=true;
        ResultSet rs1=null;
        //boolean newAcc = false;
        
        try{
        conn1 = DriverManager.getConnection(dbUrl,"kanchipatik0763","1507919");
        stat1 =conn1.createStatement();
        int x = Integer.parseInt(ageBegin);
        int y = Integer.parseInt(ageEnd);
        if((gender != null||gender != "")&&(Interestgender!=null||Interestgender !=" ")&&(Zipcode!=null||Zipcode !=" ")&&
                    (eyecolor!=null||eyecolor !=" ")&&(haircolor!=null||haircolor !=" ")&&
                    (bodytype!=null||bodytype !=" ")&&(interest!=null||interest!=" ")&&
                    (relationshipstatus!=null||relationshipstatus!=" ")&&(height!=null||height!=" ")
                    &&(x>0 && y >0))
        {
                //only normal search
            String sql1 = "select * from userprofile where gender = '" +Interestgender+ "' and interestedgender = '" +gender+ "' and age >= " +x+ " and age <= " +y+ ""
                    + " and zipcode = '" +Zipcode+ "' and eyecolor = '"+eyecolor+"' and haircolor = '" +haircolor+ "'"
                            + "and (interest01 = '" +interest+ "' or interest02 = '" +interest+ "' or interest03 = '"+interest+"')"+
                                    " and bodytype = '"+bodytype+"' and height = '"+height+"' and relationshipstatus='"+relationshipstatus+"'";
            
            rs1 = stat1.executeQuery("select * from userprofile where gender = '" +Interestgender+ "' and interestedgender = '" +gender+ "' and age >= " +x+ " and age <= " +y+ ""
                    + " and zipcode = '" +Zipcode+ "' and eyecolor = '"+eyecolor+"' and haircolor = '" +haircolor+ "'"
                            + "and (interest01 = '" +interest+ "' or interest02 = '" +interest+ "' or interest03 = '"+interest+"')"
                                    + " and bodytype = '"+bodytype+"' and height = '"+height+"' and relationshipstatus='"+relationshipstatus+"'");
            if(list.size()==0)
            {
            while(rs1.next())
            {
                b2 = true;
                list.add(new Profile(rs1.getString("name"),
                        rs1.getString("gender"),
                        rs1.getString("interestedgender"),
                        rs1.getInt("age"),
                        rs1.getString("city"),
                        rs1.getString("interest01"),
                        rs1.getString("interest02"),
                        rs1.getString("interest03"),
                        rs1.getString("lastlogin"),
                        rs1.getString("zipcode"),
                        rs1.getString("dob"),
                        rs1.getString("eyecolor"),
                        rs1.getString("haircolor"),
                        rs1.getString("bodytype"),
                        rs1.getString("height"),
                        rs1.getString("relationshipstatus"),
                        rs1.getString("headline"),
                        rs1.getString("aboutmatch")
                        ));   
            }
            }
//            if(b2 == true)
//            {
//                if(bodytype == null)
//                {
//                    return("discover");
//                }
//                else
//                {
//                    return("resultSearch");
//                }
//            }
            }

            //rs = stat.executeQuery("");
        }         
           
        catch (SQLException e)
        {
            //return an error message
            e.printStackTrace();
            return ("Internal Error. Please Try Again Later");
        }
        finally
        {
            //if(b2 == true)
            //{
                if(bodytype == null)
                {
                    return("Discover");
                }
                
                if(b2==true || bodytype!=null)
                {
                    return("resultSearch");
                }
                if(list.size()==0)
                {
                    return("Discover");
                }
            //}
            try
            { 
                rs1.close();
                stat1.close();
                conn1.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return("internal error");
            }
        }
        return "";
    }
//    public ArrayList<String> getList()
//    {
//        return a;
//    }
}

