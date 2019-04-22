import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

      List<Integer> results = new ArrayList<>();

      Map<Integer,Integer> num_to_count = new HashMap<>();
      Map<Integer,Integer> occurences_to_count = new HashMap<>();

      occurences_to_count.put(0, 0);

      for(List<Integer> l : queries) {
        int op = l.get(0);
        int num = l.get(1);

        if(op == 1) {
          if(num_to_count.containsKey(num)) {
            int count = num_to_count.get(num);
            count++;
            // --------------------------------
            if(occurences_to_count.containsKey(count)) {
              int c = occurences_to_count.get(count);
              c++;
              occurences_to_count.put(count, c);
              c = occurences_to_count.get(count - 1);
              if(c > 0) {
                c--;
                occurences_to_count.put(count - 1, c);
              }
            } else {
              occurences_to_count.put(count,1);
            }
            // --------------------------------


            num_to_count.put(num, count);
          } else {
            num_to_count.put(num, 1);

            int count = 1;
            // --------------------------------
            if(occurences_to_count.containsKey(count)) {
              int c = occurences_to_count.get(count);
              c++;
              occurences_to_count.put(count, c);
              c = occurences_to_count.get(count - 1);
              if(c > 0) {
                c--;
                occurences_to_count.put(count - 1, c);
              }
            } else {
              occurences_to_count.put(count,1);
            }
            // --------------------------------
          }
        } else if(op == 2) {
          if(num_to_count.containsKey(num) && num_to_count.get(num) > 0) {
            int count = num_to_count.get(num);

            // --------------------------------
            if(occurences_to_count.containsKey(count)) {
              int c = occurences_to_count.get(count);
              if(c > 0) {
                c--;
              }
              occurences_to_count.put(count, c);
              c = occurences_to_count.get(count - 1);
              if(c > 0) {
                c--;
                occurences_to_count.put(count - 1, c);
              }
            }
            // --------------------------------

            count--;
            num_to_count.put(num, count);
          }
        } else {
          // boolean found = false;
          // for(int n : unique_keys) {
          //   if(num_to_count.get(n) == num) {
          //     found = true;
          //     System.out.println(1);
          //     results.add(1);
          //     break;
          //   }
          // }
          // if(found == false) {
          //   System.out.println(0);
          //   results.add(0);
          // }

          if(occurences_to_count.containsKey(num) && occurences_to_count.get(num) > 0) {
            System.out.println(1);
            results.add(1);
          } else {
            System.out.println(0);
            results.add(0);
          }

        }
      }

      return results;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        // for (int i = 0; i < ans.size(); i++) {
        //     bufferedWriter.write(String.valueOf(ans.get(i)));
        //
        //     if (i != ans.size() - 1) {
        //         bufferedWriter.write("\n");
        //     }
        // }
        //
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
