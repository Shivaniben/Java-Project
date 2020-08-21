/* CST8110W20
 * 
 * NAME: SHIVANIBEN DOSHI
 *
 * STUDENT NUMBER: 040972996
 * 
 * ASSIGNMENT 2
 * 
 * DATE CREATED: 2020/04/06
 *
 */

public class Employee {// class employee starts
	
    //private variable declared 
	private String name;
	private int number;
	private double salary;
	
	
	public Employee() {      //default constructor- chained
		this("unknown",-1,0.0);
	}
	
	
	public Employee(String name, int number, double salary) {    //parameterized constructor
		this.name = name;
		this.number = number;
		setSalary(salary) ;  
	
	}

	private void setName(String name) {   //private setter for name
		 this.name= name ;
	}
	
	private void setNumber(int number) {  //private setter for number
		this.number = number ;
	}
	
	public void setSalary(double salary) { //private setter for salary
		if (salary<0) {
			this.salary = 52000;
		}
		else {
			this.salary = salary;
		}
	
}
	
	
	
	public String getName() {   //getter for name
		return name;
		
	}
	
	public int getNumber() {    //getter for name
		return number;
	}
	
	public double getSalary() { //getter for name
		return salary;
	}
	
	public double calculateWeeklyPay() {  //calculateWeeklyPay method created
		
		
		 double SECOND_LOWER_LIMIT=48535, THIRD_LOWER_LIMIT=97069, FORTH_LOWER_LIMIT = 150473, FIFTH_LOWER_LIMIT = 214368;
		 double FIRST_BLOCK = 48535*0.15, SECOND_BLOCK = 48534*0.205,THIRD_BLOCK = 53404*0.26, FORTH_BLOCK = 63895*0.29;
		 double tax=0.00;
		 
		 if (salary<= SECOND_LOWER_LIMIT) { 
			 tax = (salary*0.15);
		 }
		 else if (salary<=THIRD_LOWER_LIMIT ) {
			 tax = ((salary-SECOND_LOWER_LIMIT)*0.205)+FIRST_BLOCK;
		 }
		 else if(salary <= FORTH_LOWER_LIMIT) {
			 tax = ((salary-THIRD_LOWER_LIMIT)*0.26)+SECOND_BLOCK+FIRST_BLOCK;
		 }
		 else if(salary<= FIFTH_LOWER_LIMIT ) {
			 tax =((salary-FORTH_LOWER_LIMIT)*0.29)+THIRD_BLOCK+SECOND_BLOCK+FIRST_BLOCK; 
		 }
		 else  {
			  tax =((salary-FIFTH_LOWER_LIMIT)*0.33)+FORTH_BLOCK+THIRD_BLOCK+SECOND_BLOCK+FIRST_BLOCK; 

		 }
		double weeklyPay = ((salary-tax)/52);
		
		
		return weeklyPay;
		
		
		
	}

	@Override
	public String toString() {  //toString method generated 
		String.format("%.2f", salary);
		return String.format("Name: %s\nNumber: %d\nSalary: $%.2f\n", this.name, this.number, this.salary);  
	}
	
	
	
}//END class Employee
