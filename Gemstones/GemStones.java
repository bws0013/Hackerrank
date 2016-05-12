import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GemStones {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      
      int toScan = sc.nextInt();
      String str = "";
      for(int i = 0; i < toScan; i++) {
         String test = sc.next();
         test = removeDublicateLetters(test);
         str += test;
      }
      
      int[] toCount = countSimilar(str);
      
      int r = 0;
      for(int i = 0; i < 26; i++) {
         if(toCount[i] == toScan) {
            r++;
         }
      }
      
      //String toPrint = removeDublicateLetters(test);
      
      System.out.println(r);
      
   }
   
   public static int[] countSimilar(String ip) {
      int[] ipLetters = new int[26];
      
      for(int i = 0; i < ip.length(); i++) {
         int letterValue = ip.charAt(i) - 97;
         ipLetters[letterValue] += 1;
      }
   
      return ipLetters;
   }
   
   public static String removeDublicateLetters(String ip) {
      int[] ipLetters = new int[26];
      ip = ip.toLowerCase();
      // char val - 97
      for(int i = 0; i < ip.length(); i++) {
         int letterValue = ip.charAt(i) - 97;
         ipLetters[letterValue] = 1;
      }
      
      String ret = "";
      
      for(int i = 0; i < 26; i++) {
         if(ipLetters[i] > 0) {
            ret += ((char) (i + 97)) + "";
         }
      }
   
      return ret;
   }
     
}