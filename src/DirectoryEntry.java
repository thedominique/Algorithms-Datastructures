
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }
    @Override
    public boolean equals(Object o) {
    	if(o instanceof DirectoryEntry) {
    		if(((DirectoryEntry) o).name.equals(this.name)) {
        		return true;
        	} 
    	}
    	
    return false;
    }
    
}