import com.google.gson.Gson;
import java.io.*;

public class Functions {
    public static void commandExecution(Command cmd) {
        switch (cmd.getName().toLowerCase()) {
            case "/help": System.out.println(cmd.help()); break;
            case "/go": cmd.go(); break;
            case "/use": cmd.use(); break;
            case "/look": cmd.look(); break;
            case "/map": cmd.map(); break;
            case "/inv": cmd.inv(); break;
            case "/save": cmd.save(); break;
            case "/quit":   cmd.quit(); break;
            default: break;
        }
    }
    public static boolean commandCheck(String cmd) {
        switch (cmd) {
            case "/help":   return true;
            case "/go":     return true;
            case "/use":    return true;
            case "/look":   return true;
            case "/map":    return true;
            case "/inv":    return true;
            case "/save":   return true;
            case "/quit":   return true;
            default: if(cmd.startsWith("/"))
                System.err.println("Error: Command is invalid!");
            else System.out.println(cmd); //to hide non-commands remove me.
        }
        return false;
    }
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