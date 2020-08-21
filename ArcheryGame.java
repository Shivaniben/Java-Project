/*
*Project 		:CST8110W20 Lab 05
*
*Project Name 	:Archery Game 
*
*Name 			:Shivaniben Doshi 
*
*Student Number	:040972996
*
*Date 			:2020-03-20
*
*/


import java.security.SecureRandom;  		//import random class package

import java.util.Scanner;					//import Scanner class package


public class ArcheryGame {					//create class 
	
	
   final static int MAX_ROUND = 10;			//two final static variables declared
   final static int MAX_SCORE = 30;


   public static void main (String[] args) { //main method starts
	
	   //declaring variable 
	    int round = 1;
	    int experiance = 0;
	    int rd1;
	    int rd2;
	    char gameEnd = 'y';
	    int choice = 0;
	    int x =0;
	    int y =0;
	    
	 SecureRandom rd= new SecureRandom();  	//create object for Secure Random class
	
	Scanner input = new Scanner (System.in);//create object for Scanner class
	
	//Print statements
	System.out.println("*****CHALLANGE THE ARCHERY CHAMP*****"); 

	System.out.println("\nBeat the champ(computer) by scoring higher than the champ's score but not more than 30 points.\nIf you score more than 30 you will lose!");

	System.out.println("\nYou have to start game by shooting 2 arrows first. \n");
	
	
	while(round <= MAX_ROUND ) {	//While loop starts- loop 1
		
		while(gameEnd != 'n') {		//nested loop sentinel while control statement - loop 2
			
			//declaring variable
			int sum1 =0,sum2 =0;
		    int shot =0 ,shot1=0;
		    
		    //increment operator
			x++; y++;
			
			
	        System.out.println("\n*****Round"+ round++ + "*****"); 
	        System.out.println("\nChallanger has "+ experiance++ +" experiance\n");
	        
	            for(int a = 0; a<2;a++) { 		//for loop which is a nested loop = loop 3
	            	
	            	rd1 = x + rd.nextInt(11-x);
		          
		           
		           if(rd1 <6) { 				//conditional statement
		        	   rd1=0;
			         System.out.println("Shot"+ ++shot + "....Challanger misses board....no points!");
		           }
		           
		           else {
	                 System.out.println("Shot"+ ++shot +"....Challanger shots...." + rd1);
		           }
	                 sum1+=rd1;
	               }							//for loop ends = loop 3 
	
	                System.out.println("\nCHALLANGER'S SCORE...."+ sum1+"\n");
	
	           while(sum1<MAX_SCORE && sum1>sum2 ) {	//while loop with 2 conditions  - loop 4
	
		               System.out.println("\nMake Choice: \n1.Shoot another areow.\n2.Challange the champ.");
		            
		               System.out.print("\nChoice: ");
		            
		               choice = input.nextInt();  		//user input 
		       
		            if(choice == 1) {					//Conditioanal statemet / if starts
			        
		            	rd1 = y + rd.nextInt(11-y);
			            System.out.println("\nShot"+ ++shot +"....Challanger shots...."+rd1);
			        
			            sum1+=rd1;
			        
			            System.out.println("\nCHALLANGER'S SCORE...."+ sum1+"\n");
			
			            if (sum1>= MAX_SCORE) {			//Conditioanal statemet/if starts
			            	
				           System.out.println("YOU LOSE! "+ sum1+" is over the max.");
				           System.out.print("Do you want to play another round? Press 'y' to play or 'n' for no : ");
				
			             }								//if ends
		           }									//if ends
	
	
			       if(choice == 2) {					//Conditioanal statemet / if starts
					
				        while (sum2<=sum1) {			//while loop starts - loop 5
				        	
						rd2 = (6+rd.nextInt(5));
						
					    System.out.println("Shot"+ ++shot1+"....Champion shots...."+rd2);
					    
				     	sum2+=rd2;
				        }								//while loop ends- loop 5
				
					    System.out.println("\nCHAMPION'S SCORE...."+ sum2+"\n");
					    
				  if (sum2>= MAX_SCORE) {	//if starts
						System.out.println("YOU WON! Champion score "+sum2+" is over the max.");
						System.out.print("Do you want to play another round? Press 'y' to play or 'n' for no : ");
						
				  }							//if ends
					
					  
			
			      else if (sum2<sum1) {		//else if starts
				        System.out.println("YOU WON! "+sum1+" is greater than "+ sum2+"."); 
				        System.out.print("Do you want to play another round? Press 'y' to play or 'n' for no : " );
				  }							//else if ends
				  
			      else if(sum2>sum1) {		//else if starts
				        System.out.println("YOU LOSE! "+sum2+" is greater than "+ sum1+".");
				        System.out.print("Do you want to play another round? Press 'y' to play or 'n' for no : " );
				
			      }							//else if ends
			 
					
					
			      else if (sum2==sum1) { 	//else if starts 
				        System.out.println("Tie!!! "+ sum2 + " is equals to "+ sum1);
				        System.out.print("Do you want to play another round? Press 'y' to play or 'n' for no : ");
				
			      }							//else if ends
			      }							//Conditioanal statemet / if ends
	        }								//while loop ends - loop 4
			
		  if(round>MAX_ROUND) {		//if starts
			 System.out.print("\nYou have reached the maximum limit of Rounds! Press 'n' to quit : ");
		  }							//if ends
			
	     gameEnd = input.next().charAt(0);			// input in char
	     
         if(gameEnd == 'n') {		//if starts
    	     System.out.println("\n\nThanks for playing the game.\n\nYou end with Level "+ (experiance-1)+" experiance.");
    	
          }							//if ends
  
	     
       }		//end of nested sentinel while control loop - loop 2
      }			//end of while loop - loop 1
    }			//end of main method
  }		        //end of public class