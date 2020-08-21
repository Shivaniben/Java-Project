/*Course Name  : CST8284
  Student Name : Shivaniben Doshi
  Class name   : Property.java
  Date         : 12/07/2020
*/
/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 12, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt2.landRegistry;

import java.io.Serializable;

public class Property implements Serializable {
	
	private static final double TAX_RATE_PER_M2 = 12.50;
	private static final int DEFAULT_REGNUM = 999;
	
	private int xLeft, yTop;
	private int xLength, yWidth;
	private int regNum = DEFAULT_REGNUM;
	private int area = getArea();
	private double taxes = getTaxes();
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public Property() {
		this (0, 0, 0, 0);}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public Property(int xLength, int yWidth, int xLeft, int yTop) {
		this (xLength, yWidth, xLeft, yTop, DEFAULT_REGNUM);
	}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public Property(Property prop, int regNum) {
		this (prop.getXLength(), prop.getYWidth(), prop.getXLeft(), prop.getYTop(), regNum);
	}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public Property(int xLength, int yWidth, int xLeft, int yTop, int regNum) {
		setXLength(xLength); setYWidth(yWidth); setXLeft(xLeft); setYTop(yTop); setRegNum(regNum);
	}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public int getXLeft() { 
		return xLeft;
		}
	/* This code provided by Dave Houtman [2019] personal communication */
	public void setXLeft(int left) { 
		this.xLeft = left; 
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public int getXRight(){
		return getXLeft() + getXLength();
		}

	/* This code provided by Dave Houtman [2019] personal communication */
	public int getYTop() { 
		return yTop; 
		}
	/* This code provided by Dave Houtman [2019] personal communication */
	public void setYTop(int top) {
		this.yTop = top;
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public int getYBottom() { 
		return getYTop() + getYWidth(); }

	/* This code provided by Dave Houtman [2019] personal communication */
	public int getYWidth() {
		return yWidth; 
	}
	/* This code provided by Dave Houtman [2019] personal communication */
	public void setYWidth(int yWidth) { 
		this.yWidth = yWidth; 
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public int getXLength() {
		return xLength;
		}
	/* This code provided by Dave Houtman [2019] personal communication */
	public void setXLength(int xLength) {
		this.xLength = xLength; 
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public int getRegNum() {
		return regNum;
		}
	/* This code provided by Dave Houtman [2019] personal communication */
	private void setRegNum(int regNum) {
		this.regNum = regNum; 
		}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public int getArea() {
		return (getXLength() * getYWidth());
		}
	/* This code provided by Dave Houtman [2019] personal communication */
	public double getTaxes() {
		return getArea() * TAX_RATE_PER_M2;
		}

	/* This code provided by Dave Houtman [2019] personal communication */
	@Override
	public String toString() {
		return "Coordinates: " + getXLeft() + ", " + getYTop() + "\n" +
			   "Length: " + getXLength() + " m  Width: " + getYWidth() + " m\n" +
			   "Registrant #: " + getRegNum() + "\n" +
			   "Area: " + getArea() + " m2\nProperty Taxes : $" + getTaxes();
	}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Property)) return false;
		Property prop = (Property)obj;
		return 
			prop.getYTop()==this.getYTop() &&
			prop.getXLeft()==this.getXLeft() &&
			hasSameSides(prop);
	}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public boolean hasSameSides(Property prop) {
		return prop.getXLength()==this.getXLength() && prop.getYWidth()==this.getYWidth();
	}
	
	/* This code provided by Dave Houtman [2019] personal communication */
	public boolean overlaps(Property prop) {
		return  prop.getXRight() > this.getXLeft() && prop.getXLeft() < this.getXRight() &&
				prop.getYTop() < this.getYBottom() && prop.getYBottom() > this.getYTop();
	}
	
}
