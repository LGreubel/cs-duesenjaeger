import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Functions {
    static StringBuilder sb = new StringBuilder();
    //
    //
    //

    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static boolean jsonWrite(String jsonString, String jsonPath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(jsonPath + ".json"));
            bw.write(jsonString);
            bw.close();
        } catch (Exception e) {
            System.err.println("Error: File could not be written: " + e);
            return false;
        }
        return true;
    }
    public static String jsonRead(String jsonPath) {
        String jsonString = "";
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(jsonPath + ".json"));
            while ((line = br.readLine()) != null) {
                jsonString = jsonString + line;
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Error: File could not be read: " + e);
        }
        return jsonString;
    }
}
