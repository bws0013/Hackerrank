import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static Map<Integer,Integer> position_to_occurances = new HashMap<>();

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

      List<Integer> results = new ArrayList<>();

      Map<Integer,Integer> num_to_count = new HashMap<>();

      // occurences_to_count.put(0, 0);
      position_to_occurances.put(0, 1);

      for(List<Integer> l : queries) {
        int op = l.get(0);
        int num = l.get(1);

        if(op == 1) {
          if(num_to_count.containsKey(num)) {
            int count = num_to_count.get(num);

            change_position_map(count,true);
            count++;

            num_to_count.put(num, count);
          } else {
            num_to_count.put(num, 1);

            int count = 0;
            change_position_map(count,true);
          }
        } else if(op == 2) {
          if(num_to_count.containsKey(num) && num_to_count.get(num) > 0) {
            int count = num_to_count.get(num);

            change_position_map(count,false);

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

          if(position_to_occurances.containsKey(num) && position_to_occurances.get(num) > 0) {
            // System.out.println(1);
            results.add(1);
          } else {
            // System.out.println(0);
            results.add(0);
          }

        }
      }

      return results;

    }

    // Given the pre-incremented position add to the map
    public static void change_position_map(int n, boolean add) {
      if(add == true) {
        if(position_to_occurances.containsKey(n)) {
          int occurances = position_to_occurances.get(n);
          if(occurances > 0) {
            position_to_occurances.put(n, occurances - 1);
          }

          if(position_to_occurances.containsKey(n + 1)) {
              occurances = position_to_occurances.get(n + 1);
              occurances++;
              position_to_occurances.put(n + 1, occurances);
          } else {
            position_to_occurances.put(n + 1, 1);
          }

        } else {
          position_to_occurances.put(n, 1);
        }

      } else {

        if(position_to_occurances.containsKey(n)) {
          int occurances = position_to_occurances.get(n);
          if(occurances > 0) {
            occurances--;
            position_to_occurances.put(n, occurances);
            if(position_to_occurances.containsKey(n - 1)) { // This feels questionable
              occurances = position_to_occurances.get(n - 1);
              occurances++;
              position_to_occurances.put(n - 1, occurances);
            }
          }
        }

      }
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
