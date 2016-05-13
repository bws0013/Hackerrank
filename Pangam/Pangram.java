import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pangram {

   	public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in); 

      	String text = (sc.nextLine()).toLowerCase();
      	text = text.replaceAll("\\s","");

      	int letters[] = new int[26];
      	
      	for(int i = 0; i < text.length(); i++) {
      		int num = (int) text.charAt(i);
      		letters[num - 97] = 1;
      	}

      	int count = 0;
      	for(int i = 0; i < 26; i++) {
      		count += letters[i];
      	}

      	if(count == 26) {
      		System.out.println("pangram");
      	} else {
      		System.out.println("not pangram");
      	}
      
   	}

}