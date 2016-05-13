import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlipBits {

   	public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in); 

      	int count = sc.nextInt();

            for(int i = 0; i < count; i++) {
                  int num = sc.nextInt();

                  String temp = Integer.toString(num, 2);

                  String ret = "";
                  for(int j = 0; j < temp.length(); j++) {
                        if(temp.charAt(j) == '1') {
                              ret += "0";
                        }
                        else {
                              ret += "1";
                        }
                  }

                  int foo = Integer.parseInt(temp, 10);

                  System.out.println(foo);
            }
      
   	}

}