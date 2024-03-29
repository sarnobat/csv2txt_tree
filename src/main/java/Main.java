import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import org.json.JSONObject;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Main {
    public String getGreeting() {
        return "Hello world.";
    }

    /**
     * Read csv in Write indented text
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        Multimap<String, String> map = HashMultimap.create();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = br.readLine()) != null) {
                // log message
                // System.err.println("[DEBUG] current line is: " + line);

                String[] pair = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                // System.out.println("Main.main() " + pair);
                map.put(pair[0].replace("\"", ""), pair[1].replace("\"", ""));

                // program output
//                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("enclosing_type.enclosing_method()" + map);

        JSONObject out = new JSONObject();
        for (String key : map.keys()) {
            Collection<String> values = map.get(key);
            // System.err.println("Main.main() " + values);
            out.put(key, values);
        }
        System.out.println(out.toString(2));

    }
}
