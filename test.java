
import java.io.*;
import java.util.*;

public class test {
  // If you need extra classes, you can define them privately here within class Solution

  static boolean shareAncestor(String[] idPair, String[][] dataset) {
    return false;
  }

  // DO NOT MODIFY MAIN()
  public static void main(String[] args) {
    String[] arg0 = new String[]{};
    List<String[]> arg1 = new ArrayList<String[]>();

    String line;
    boolean first_arg = true;
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      while ((line = br.readLine()) != null) {
        if (line.equals("")) {
          continue;
        }

        if(first_arg) {
          arg0 = line.split(" ");
          first_arg = false;
        } else {
          arg1.add(line.split(" "));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    String[][] friendships = arg1.toArray(new String[arg1.size()][]);
    System.out.println(Arrays.deepToString(friendships));

    /*
     * .deepToString
    if(shareAncestor(arg0, friendships)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
    
    */
  }
}
