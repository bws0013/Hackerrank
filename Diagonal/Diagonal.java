import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/diagonal-difference

public class Diagonal {

   	public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in); 

      	int size = sc.nextInt();

      	int[][] arr = new int[size][size];

      	for(int i = 0; i < size; i++) {
      		for(int j = 0; j < size; j++) {
      			arr[i][j] = sc.nextInt();
      		}
      	}

      	int dia1 = 0;
      	int dia2 = 0;

      	for(int i = 0; i < size; i++) {
      		dia1 += arr[i][i];
      		dia2 += arr[i][size - 1 - i];
      	}

      	System.out.println(Math.abs(dia1 - dia2)); 
   	}

}