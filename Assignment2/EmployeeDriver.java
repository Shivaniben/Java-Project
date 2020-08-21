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

import java.util.Scanner;     //import Scanner class

public class EmployeeDriver { // EmployeeDriver class starts

 
     public static void main(String[] args) {  // main method starts


        final int MAX_NUMBER_EMPLOYEE = 5;    //final variable declared

        Scanner input = new Scanner(System.in); 

        int currentNumberEmployees = 0;      // variable decalred

 

        Employee[] e1 = new Employee[MAX_NUMBER_EMPLOYEE]; //array for employee class

 
                    //arrays of employees are created            
        
                    e1[0] = new Employee("Thanh Do", 123, 185000.0);

                    e1[1] = new Employee("Jacklyn Jones", 174, 145000.0);

                    e1[2] = new Employee("Rita Chan", 185, 72000.0);

                    e1[3] = new Employee("Vikash Singh", 198, 300000.0);
                    

                    currentNumberEmployees = 4; 


                    int choice = 0;   

                    while (choice != 4) {   //while -sentinel control loop starts

                             System.out.println("\nMake Selection\n1.Add Employees\n2.Display Employees\n3.Display Payroll\n4.Quit");

                             System.out.print("\nEnter your choice: ");

                                  choice = input.nextInt();
                                  

                                         if (choice == 1) {//choice == 1 starts
                                        	 
                                        	 

                                             if (currentNumberEmployees < MAX_NUMBER_EMPLOYEE) {  // if Selection structure starts

                                                  input.nextLine();

                                                  System.out.print("\nEnter Name: ");

                                                  String name = input.nextLine();

                                                  System.out.print("Enter Number: ");

                                                  int number = input.nextInt();

                                                  System.out.print("Enter Salary: $");

                                                  double salary = input.nextDouble();

                                              e1[currentNumberEmployees] = new Employee(name, number, salary); //array to store value of  new employee

                                                 currentNumberEmployees++;

                                              }

                                              else {

                                                    System.out.println("You have reached the maximum limit of employee. ");//Press 4 to quit.");

                                                    }

                                           }//END selection statement choice == 1

                             

                                           if (choice==2) {   //choice == 2 starts
                                        	   
                                        	   

                                               for (int j=0; j<currentNumberEmployees; j++) {  //

                                                     System.out.println(e1[j]);

                                                }

                                           }//END selection statement choice == 2

 

                                           if(choice ==3) {   //choice == 3 starts

 

                                               double sum =0;

                                               System.out.println("\nName of Employees and Weekly Payroll");

                                               for (int j=0; j<currentNumberEmployees; j++) {

                                                    System.out.printf("\nName: "+ e1[j].getName()+"\nPayroll: $%.2f\n", e1[j].calculateWeeklyPay());   //invoking getters

                                                    sum = sum + e1[j].calculateWeeklyPay();  // invoking calculateWeeklyPay method

                                                          }

                                                    System.out.printf("\nTotal average payroll: %.2f\n", sum);

                                           }//END selection statement choice == 3

 

                                           if (choice == 4 ) {     //choice == 4 starts
                                        	   

                                                          System.out.print("Bye");

                                           }//END selection statement choice == 4

 

                             }//END while sentinel loop

 

              }//END main method

}//END class employeeDriver

 

 

 


































/*
 * import java.util.Scanner;
 * 
 * public class EmployeeDriver {
 * 
 * public static void main(String[] args) {
 * 
 * final int MAX_NUMBER_EMPLOYEE = 5; int j = 0,i=0; Scanner input = new
 * Scanner(System.in);
 * 
 * Employee[] e1 = new Employee[MAX_NUMBER_EMPLOYEE]; e1 [0]= new
 * Employee("Than do", 123,0.00); e1 [1]= new Employee("Jacklyn Jones",
 * 174,0.00); e1 [2]= new Employee("Rita Chan", 185,0.00); e1 [3]= new
 * Employee("Vikas Singh", 198,0.00);
 * 
 * 
 * e1[0].setSalary(185000.00); e1[1].setSalary(145000.00);
 * e1[2].setSalary(72000.00); e1[3].setSalary(300000.00);
 * 
 * int choice = 0;
 * 
 * while (choice != 4) {
 * 
 * System.out.
 * println("\nMake Selection\n1.Add Employees\n2.Display Employees\n3.Display Payroll\n4.Quit"
 * ); System.out.print("\nEnter your choice: "); choice = input.nextInt();
 * 
 * 
 * 
 * if (choice == 1) {
 * 
 * 
 * if (e1[4]== null) {
 * 
 * input.nextLine(); System.out.print("\nEnter Name: " ); String name =
 * input.nextLine();
 * 
 * System.out.print("Enter Number: "); int number = input.nextInt();
 * 
 * System.out.print("Enter Salary: $"); double salary = input.nextDouble();
 * 
 * e1[4]=new Employee(name, number,salary);
 * 
 * }
 * 
 * else {
 * 
 * System.out.
 * println("You have reached the maximum limit of employee. Press 4 to quit.");
 * 
 * }
 * 
 * }
 * 
 * if (choice==2) {
 * 
 * if(e1[4]==null) { i=0; for (j=0; j<e1.length-1; j++) {
 * System.out.println(e1[i]); i++; }
 * 
 * }
 * 
 * else { i=0; for (j=0; j<e1.length; j++) {
 * 
 * System.out.println(e1[i]);
 * 
 * i++; }
 * 
 * 
 * }
 * 
 * }
 * 
 * if(choice ==3) {
 * 
 * double sum =0; System.out.println("\nName of Employees and Weekly Payroll");
 * 
 * if(e1[4]==null) {
 * 
 * i=0; for (j=0; j<e1.length-1; j++) {
 * 
 * System.out.printf("\nName: "+ e1[i].getName()+"\nPayroll: $%.2f\n",
 * e1[i].calculateWeeklyPay()); sum = sum + e1[i].calculateWeeklyPay(); i++; } }
 * else {
 * 
 * i=0; for (j=0; j<e1.length; j++) { System.out.printf("\nName: "+
 * e1[i].getName()+"\nPayroll: $%.2f\n", e1[i].calculateWeeklyPay()); sum = sum
 * + e1[i].calculateWeeklyPay(); i++; } }
 * System.out.printf("\nTotal average payroll: %.2f\n", sum); }
 * 
 * 
 * if (choice == 4 ) { System.out.print("Bye");
 * 
 * }
 * 
 * 
 * 
 * } }
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			