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
//@Named(value = "navigation")
//@Dependent
@ManagedBean
@SessionScoped
public class navigation implements Serializable {
    
    boolean toRefineSearch = false;

   
    /**
     * Creates a new instance of navigation
     */
    
     public boolean isToRefineSearch() {
        return toRefineSearch;
    }

    public void setToRefineSearch(boolean toRefineSearch) {
        this.toRefineSearch = toRefineSearch;
    }
    
    public navigation() {
    }
    
    public String makeRefineSearch()
    {
        toRefineSearch = true;
        return "Discover"; 
    }
}
