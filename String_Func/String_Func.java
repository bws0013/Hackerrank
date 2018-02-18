import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class String_Func {

  static int maxValue(String t) {

    Map<String, Integer> substring_to_count = new HashMap<String, Integer>();

    String substring = "";
    for(int i = 0; i < t.length(); i++) {
      substring = "";
      for(int j = i; j < t.length(); j++) {
        substring += t.charAt(j) + "";
        if(substring_to_count.containsKey(substring)) {
          int temp = substring_to_count.get(substring);
          temp++;
          substring_to_count.put(substring, temp);
        } else {
          substring_to_count.put(substring, 1);
        }
      }
    }


    List<String> substrings = new ArrayList<String>(substring_to_count.keySet());
    int max = 0;
    for(String s : substrings) {
      if(s.length() * substring_to_count.get(s) > max) {
        max = s.length() * substring_to_count.get(s);
      }
    }

    return max;
  }

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String t = in.next();
      int result = maxValue(t);
      System.out.println(result);
      in.close();
  }

}
