import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new TreeMap<>();
        int total = 0;
        String name;
        while ((name = br.readLine()) != null) {
            map.put(name, map.getOrDefault(name, 0) + 1);
            total++;
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            result.append(entry.getKey())
                    .append(" ")
                    .append(String.format("%.4f", (double) entry.getValue() / (double) total * 100.0))
                    .append("\n");
        }

        bw.write(result.toString());


        br.close();
        bw.close();
    }
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        int total = 0;
        String name;
        while ((name = br.readLine()) != null) {
            map.put(name, map.getOrDefault(name, 0) + 1);
            total++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double treeRatio = (double)entry.getValue() / (double)total * 100;
            System.out.println(entry + " " + String.format("%,.4f", treeRatio));
        }
    }*/
}