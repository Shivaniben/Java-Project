/*Course Name  : CST8284
  Student Name : Shivaniben Doshi
  Class name   : RegControl.java
  Date         : 12/07/2020
*/
/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 12, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt2.landRegistry;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;







public class RegControl {
	private ArrayList<Registrant> registrants = new ArrayList<Registrant>() ;   
	private ArrayList<Property> properties = new ArrayList<Property>();     
	
	
	
    /* This code provided by Dave Houtman [2019] personal communication */
	 //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
	private ArrayList<Registrant> getRegistrants() {	
    	return this.registrants;
    	}   
    /* This code provided by Dave Houtman [2019] personal communication */
	 //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
    private ArrayList<Property> getProperties() {
    	return this.properties; 
    	}
	
    /* This code provided by Dave Houtman [2019] personal communication */
   public Registrant addNewRegistrant(Registrant reg) {
	   getRegistrants().add(reg);
	   return reg ;
   }
   
   /* This code provided by Dave Houtman [2019] personal communication */
    public Registrant findRegistrant(int regNum) {
    	
    	for(Registrant reg : listOfRegistrants()) {
    		 
    		if(reg.getRegNum()==regNum){
    			return reg;
    	}
    	}
    
    	return null;
    }
   
    /* This code provided by Dave Houtman [2019] personal communication */
    //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
    public ArrayList<Registrant> listOfRegistrants() {
    	 return getRegistrants();
    }
    
    //ArrayList methods ara provided by David Houtman in Module 6 
    public Registrant deleteRegistrant(int regNum) {
    	if(findRegistrant(regNum)!= null)
        getRegistrants().remove(findRegistrant(regNum));
    	
    	
    	return findRegistrant(regNum);
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    
    public Property addNewProperty(Property prop) {  
    	Property overlapProperty = propertyOverlaps(prop);
    	if (overlapProperty == null) {
    		
    		getProperties().add( prop);
        	
    	}
    	else
    		prop = overlapProperty;
    	return prop;

    }
    
    //ArrayList methods ara provided by David Houtman in Module 6 
   public boolean deleteProperty(ArrayList<Property> properties) {
	  if ((properties.isEmpty())){
		  return false;
	  }
	  else {
			for(Property prop : properties) {
			listOfAllProperties().remove(prop);
			}}
	  return true;
	  
    }
    
   /* This code provided by Dave Houtman [2019] personal communication */
    public Property changePropertyRegistrant(Property oldRegNumProp, int newRegNum) {
    	return (new Property(oldRegNumProp, newRegNum));
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
    //ArrayList methods ara provided by David Houtman in Module 6 
    
    public ArrayList<Property> listOfProperties(int regNum) {
    	ArrayList<Property> listProps = new ArrayList<Property>();
    	
    	for (Property prop: listOfAllProperties()) {
    		if (prop.getRegNum() == regNum) 
    	  listProps.add(prop) ;}
    	return listProps;
    }
    	
    /* This code provided by Dave Houtman [2019] personal communication */
    //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
    
    public ArrayList<Property> listOfAllProperties() {
    	return getProperties();
    	
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    //ArrayList methods ara provided by David Houtman in Module 6 
    private Property propertyOverlaps(Property prop) {
    	
    	if (getProperties().size()> 0) {
	    	for (int ctr = 0; ctr < getProperties().size(); ctr++) {
	    		Property existingProp = getProperties().get(ctr);
	    		if (existingProp.overlaps(prop)) return existingProp;
	    	}
    	}
    	return null;
    }
    
    
    /* This code provided by Dave Houtman [2019] personal communication */
    // Hybrid Activity 7 IO
    public <T> boolean saveToFile(ArrayList<T> source, String fileName) {
		
		  File file = new File(fileName); 
		  if(file.exists()) {
			 file.delete(); 
			  }
		  
		  try {
		  
		  FileOutputStream fout = new FileOutputStream(fileName); 
		  ObjectOutputStream oos = new ObjectOutputStream(fout);
		  
		  oos.writeObject(source); 
		  oos.close();
		  
		  return true; 
		  } 
		  catch (IOException ex) { 
			  ex.printStackTrace();
			  return false;
			  } 
		  
		  }
		 
    //URL: //https://www.java-forums.org/new-java/26670-save-load-arraylist.html
     /*
	  * Thread: Save/Load ArrayList. (n.d.). Retrieved July 12, 2020, from
	  * https://www.java-forums.org/new-java/26670-save-load-arraylist.html
	  */    
    public <T> ArrayList<T> loadFromFile(String fileName){
	
	  try {
          FileInputStream fin = new FileInputStream(fileName);
          ObjectInputStream ois = new ObjectInputStream(fin);
         ArrayList<T> list = ( ArrayList<T>) ois.readObject();
           
          
        ois.close();
        
        return list; 
	  }
     
	  catch (IOException e) { 
          return null ;
      }
	  catch (ClassNotFoundException e) {
	
		return null;
	
}
  }
}


