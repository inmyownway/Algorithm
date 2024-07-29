import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> words = new HashMap<>();

        int cnt = 0;

        String str = "";
        str = bf.readLine();
        while (true) {

            words.put(str, words.getOrDefault(str, 0) + 1);
            cnt++;
            str = bf.readLine();
            if (str == null || str.length() == 0) {
                break;
            }
        }

        List<String> list = new ArrayList<>(words.keySet());

        Collections.sort(list);

        // System.out.println("@");
        StringBuilder sb = new StringBuilder();
        for (String s : list) {

            double num = (double) (words.get(s) * 100.0) / cnt;
            System.out.print(s + " ");
            System.out.print(String.format("%.4f", num));
            System.out.println();

            //  sb.append(s+" "+String.format("%.4f"))

        }


    }

}