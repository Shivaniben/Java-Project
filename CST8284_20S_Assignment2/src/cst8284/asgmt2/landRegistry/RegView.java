/*Course Name  : CST8284
  Student Name : Shivaniben Doshi
  Class name   : RegView.java
  Date         : 12/07/2020
*/
/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 11, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt2.landRegistry;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class RegView {
	
	private static Scanner scan = new Scanner(System.in);
	private static RegControl rc;
	
	public static final String PROPERTIES_FILE= "LandRegistry.prop";
	public static final String REGISTRANTS_FILE= "LandRegistry.reg";
	  
	    
	  private static final int
		ADD_NEW_REGISTRANT = 1, 
		FIND_REGISTRANT = 2,
		LIST_REGISTRANTS = 3, 
		DELETE_REGISTRANT=4,
		
		ADD_NEW_PROPERTY = 5, 
		DELETE_PROPERTY=6,
		CHANGE_PROPERTY_REGISTRANT = 7,
		LIST_PROPERTY_BY_REGNUM = 8,
		LIST_ALL_PROPERTIES = 9,
		
		LOAD_LAND_REGISTRY_FROM_BACKUP=10,
		SAVE_LAND_REGISTRY_TO_BACKUP=11,
		
		EXIT = 0;
	
	public RegView() {
		rc = new RegControl();
	}
	
	private RegControl getRegControl() {
	    	return rc;
	    }
	
	public static void launch() {
		int choice = 0;
		do {
		   choice = displayMenu();
		   executeMenuItem(choice);
		} while (choice != EXIT);		
	}
	
	private static int displayMenu() {
		System.out.println("Enter a selection from the following menu:");
		System.out.println(
				
			ADD_NEW_REGISTRANT +       		". Enter a new registrant\n" +
			FIND_REGISTRANT + 				". Find registrant by registration number\n" +
			LIST_REGISTRANTS +     			". Display list of registrants\n" +
			DELETE_REGISTRANT +             ". Delete Registrant\n" +
			
			ADD_NEW_PROPERTY +        		". Register a new property\n" +
			DELETE_PROPERTY +               ". Delete Property\n" +
			CHANGE_PROPERTY_REGISTRANT +	". Change a property's registrant\n" +
			LIST_PROPERTY_BY_REGNUM + 		". Display all properties with the same registration number\n" + 
			LIST_ALL_PROPERTIES  +     		". Display all registered properties\n" +
			
            LOAD_LAND_REGISTRY_FROM_BACKUP +". Load Land Registry from backup\n" +
            SAVE_LAND_REGISTRY_TO_BACKUP +  ". Save Land Registry to backup\n" +
			
			EXIT +                    		". Exit program\n"
		);
		
		int ch = scan.nextInt();
		scan.nextLine();      // 'eat' the next line in the buffer
		return ch;
	    }
	
	private static void executeMenuItem(int choice) {
		switch (choice) {
		
			case ADD_NEW_REGISTRANT:   			viewAddNewRegistrant();			 break;
			case FIND_REGISTRANT:	 			viewFindRegistrant();			 break;
			case LIST_REGISTRANTS:    			viewListOfRegistrants();		 break;
			case DELETE_REGISTRANT:             viewDeleteRegistrant();          break;                   
			case ADD_NEW_PROPERTY: 				viewAddNewProperty();			 break;
			case DELETE_PROPERTY:               viewDeleteProperty() ;           break;
			case CHANGE_PROPERTY_REGISTRANT:	viewChangePropertyRegistrant();  break;
			case LIST_PROPERTY_BY_REGNUM: 		viewListPropertyByRegNum();		 break;	
			case LIST_ALL_PROPERTIES:   		viewListAllProperties();		 break;  
			case LOAD_LAND_REGISTRY_FROM_BACKUP:viewLoadLandRegistryFromBackUp();break;
			case SAVE_LAND_REGISTRY_TO_BACKUP : viewSaveLandRegistryToBackUp();  break;
			case EXIT: 	System.out.println("Exiting Land Registry\n\n");		 break;
			default: System.out.println("Invalid choice: try again. (Select " + EXIT + " to exit.)\n");
		}
		System.out.println();  // add blank line after each output
	}
	/* This code provided by Dave Houtman [2019] personal communication */
    private static String getResponseTo(String s) {
    	System.out.print(s);
		return(scan.nextLine());
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    private static int requestRegNum() {
    	return (Integer.parseInt(getResponseTo("Enter registration number : ")));
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    private static Registrant makeNewRegistrantFromUserInput() {
    	String firstLast = getResponseTo("Enter registant's first and Last name: ");
    	return (new Registrant(firstLast));  	
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    private static Property makeNewPropertyFromUserInput() {
    	String topLeftCoords = getResponseTo("Enter top and left coordinates of property (as X, Y): ");
    	String lengthWidth = getResponseTo("Enter length and width of property (as length, width): ");
    	int xLeft = Integer.parseInt(topLeftCoords.split(",")[0].trim());
    	int yTop = Integer.parseInt(topLeftCoords.split(",")[1].trim());
    	int xLength = Integer.parseInt(lengthWidth.split(",")[0].trim());
    	int yWidth = Integer.parseInt(lengthWidth.split(",")[1].trim());
    	return (new Property(xLength, yWidth, xLeft, yTop));  	
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    public static void viewAddNewRegistrant() {
    
    	Registrant reg = makeNewRegistrantFromUserInput();	
    	
    	 rc.addNewRegistrant(reg);
        System.out.println("Registrant added: \n"+reg.toString());
        
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    
    public static void viewFindRegistrant() {
    	int regNum = requestRegNum();
    	
    	Registrant reg = rc.findRegistrant(regNum);
    	System.out.println(""+ ((reg==null)? // Registrant does not exist
    		"A registrant having the registration number\n" + 
    		reg.getRegNum() + " could not be found in the registrants list.\n"
    		:  // Registrant found
    		"The registrant associated with that registration number " + 
    		"is\n"+ reg.toString() + "\n"));
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
    //ArrayList methods ara provided by David Houtman in Module 6 
    
    public static void viewListOfRegistrants() {
    	ArrayList<Registrant> regs = rc.listOfRegistrants();
    	if (rc.listOfRegistrants().size() == 0) 
    		System.out.println("No Registrants are loaded yet");
    	else {
    		System.out.println("List of registrants:\n");
    		for (Registrant reg: regs)
    			System.out.print(reg.toString()+ "\n");	
    	}
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    public static void viewDeleteRegistrant() {
    	int regNum =requestRegNum();
    	
    	if (rc.listOfRegistrants() != null) {
    		String response = getResponseTo("You are about to delete a registrant number and all the its\n" + 
    				"associated properties; do you wish to continue? (Enter 'Y' proceed.)");
    		if(response=="y");{
    		rc.deleteRegistrant(regNum);
    		rc.deleteProperty(rc.listOfProperties(regNum));
    		System.out.println("Registrant and related properties deleted");
    	}}
    	else {
    		System.out.println("No Registrants are loaded yet");}
    	}
    
    	
    /* This code provided by Dave Houtman [2019] personal communication */
    //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
    //ArrayList methods ara provided by David Houtman in Module 6 
    
    public static void viewChangePropertyRegistrant() {
    	int oldRegNum = Integer.parseInt(getResponseTo("Enter original registrants number: "));
    	if (rc.findRegistrant(oldRegNum) == null)  // Registrant does not exist
     	   System.out.println("Invalid registrant number.  Can't complete request.");
     	else {
     		int newRegNum = Integer.parseInt(getResponseTo("Enter new registrants number: "));
        	if (rc.findRegistrant(newRegNum) == null)  // Registrant does not exist
          	   System.out.println("Invalid registrant number.  Can't complete request.");
        	else {
     		   ArrayList<Property> props = rc.listOfProperties(oldRegNum);
     		   for (Property prop: props)
     				  rc.changePropertyRegistrant(prop, newRegNum);
     		       System.out.println("Operation completed; the new registration number, " + newRegNum +
     			   ", has replaced the old registration number, " + oldRegNum + 
     			   ", in all affected properties.");
        	}
     	}
    }
        
    /* This code provided by Dave Houtman [2019] personal communication */
    //Replace and Modify Array and Array method to ArrayList and ArrayListMethod 
    //ArrayList methods ara provided by David Houtman in Module 6 
    public static void viewAddNewProperty() {
    	int regNum = requestRegNum();
    	if (rc.findRegistrant(regNum) == null)  // Registrant does not exist
    	   System.out.println("Invalid registrant number");
    	else {  // Registrant exists
           Property prop = makeNewPropertyFromUserInput();	
    	   prop = new Property(prop, regNum);   	
    	   Property returnProp = rc.addNewProperty(prop); 
    	   if (returnProp == null) // registrant array is full
    		   System.out.println("New property could not be registered; registrant's array is full.");
    	   else if (prop.equals(returnProp))  // Registrant has been registered
    		   System.out.println("New property has been registered as: \n" + prop.toString());
    	   else  // Property already exists at that location
    		   System.out.println("New property could not be registered; \n" +
    		   "There is already a property registered at: \n" + returnProp.toString());   	   
    	}
    }
    
    //ArrayList methods ara provided by David Houtman in Module 6 
    public static void viewDeleteProperty() {
    	
    	int regNum = Integer.parseInt(getResponseTo("Enter a registrant number of property to delete: "));
    	ArrayList<Property> prop = rc.listOfProperties(regNum);
    	if (!(prop.isEmpty())) {
    		System.out.println("Properties associated with that registration number are: \n");
    		for(Property props : prop)
    			System.out.println(props);
    		String response = getResponseTo("You are about to delete "+prop.size()+" properties; do you wish to continue?\n" + 
    				"(Enter ‘Y’ to proceed.)");
            if(response == "y"); {
            	
            rc.deleteProperty(prop);
    		
    		System.out.println("Properties removed!");}
    		
    		
    	}
    	else {
    	System.out.println("No property associated with that registration number");}
    	}
    
    /* This code provided by Dave Houtman [2019] personal communication */
     //Replace and Modify Array and Array method to ArrayList and ArrayListMethod   
    //ArrayList methods ara provided by David Houtman in Module 6 
    
    public static void viewListPropertyByRegNum() { 
    	 ArrayList<Property> props = rc.listOfProperties(requestRegNum());
    	if (props.size() == 0) 
    		System.out.println("Property Registry empty; no properties to display\n");
    	else
    		for (Property prop: props)
    			System.out.println(prop.toString() + "\n");	   
    }
    
    /* This code provided by Dave Houtman [2019] personal communication */
    //Replace and Modify Array and Array method to ArrayList and ArrayListMethod    
    //ArrayList methods ara provided by David Houtman in Module 6 
    
    public static void viewListAllProperties() {
    	ArrayList<Property> props = rc.listOfAllProperties();
    	if (props.size() == 0) 
    		System.out.println("Property Registry empty; No properties to display");
    	else
    		for (Property prop: props)
    			System.out.println(prop.toString());
    }
    
	  public static void viewLoadLandRegistryFromBackUp() { 
		  String response =  getResponseTo("You are about to overwrite existing records; do you wish to\n" +
	                "continue? (Enter 'Y' to proceed.)");
	        if (response =="y"); {
	         
	        	rc.loadFromFile(PROPERTIES_FILE).add(rc.listOfAllProperties());
	        	rc.loadFromFile(REGISTRANTS_FILE).add(rc.listOfRegistrants());
	        	
	            System.out.println("Land Registry has been loaded from backup file");
	        }
	 
	  }
	  public static void viewSaveLandRegistryToBackUp() {
		
		  
		  rc.saveToFile(rc.listOfAllProperties(), PROPERTIES_FILE);
		  rc.saveToFile(rc.listOfRegistrants(), REGISTRANTS_FILE);
		  System.out.println("Land Registry has been backed up to file.");

	  }
}


