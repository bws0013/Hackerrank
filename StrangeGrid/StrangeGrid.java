import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/strange-grid

public class StrangeGrid {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 

      double a = sc.nextInt();
      double b = sc.nextInt();

      double ret = gridSolver(a, b);
      


      
      DecimalFormat dm = new DecimalFormat("#.#");
      System.out.println(dm.format(ret));   
      
   }

   public static double gridSolver(double a, double b) {
   		boolean bool = false; 
   		double temp = a - 1;

   		if(!(temp % 2 == 0)) {
   			bool = true;
   			temp--;	
   		}

   		temp = temp * 5;
   		//System.out.println(temp + "");
   		if(bool == true) {
   			temp++;	
   		}
   		//System.out.println(temp + "");
   		temp += (b - 1) * 2;

   		return temp;

   }


}