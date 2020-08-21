/*Course Name  : CST8284
  Student Name : Shivaniben Doshi
  Class name   : Registrant.java
  Date         : 12/07/2020
*/
/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 12, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt2.landRegistry;

import java.io.Serializable;

public class Registrant implements Serializable {
	
	private static final int REGNUM_START = 1000;
	private static int currentRegNum = REGNUM_START;
	private final int REGNUM = currentRegNum;
	
	private String firstName, lastName;
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public Registrant () {this("unknown unknown");}
	public Registrant (String firstLastName) {
	    incrToNextRegNum();
		setFirstName(firstLastName.split(" ")[0]); 
		setLastName(firstLastName.split(" ")[1]);
	}

	/* This code provided by Dave Houtman [2019] personal communication */
	public int getRegNum() {
		return REGNUM;
		}
	/* This code provided by Dave Houtman [2019] personal communication */
	private static void incrToNextRegNum() {
		currentRegNum++;
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public String getFirstName() {
		return firstName;
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public String getLastName() {
		return lastName;
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public void setLastName(String lastName) {
		this.lastName = lastName;
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public boolean equals(Object obj) { 
		if (!(obj instanceof Registrant)) return false;
		Registrant reg = (Registrant)obj;
		return ((reg.getFirstName().equals(this.getFirstName())) &&
		   (reg.getLastName().equals(this.getLastName())) &&
		   (reg.getRegNum()==(this.getRegNum())));
	}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public String toString() {
		return "Name: " + getFirstName() + " " + getLastName() + "\n" +
			   "Registration Number: #" + getRegNum();
	}
	
}
