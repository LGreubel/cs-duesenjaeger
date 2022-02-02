import com.google.gson.Gson;
import java.io.*;

public class Functions {
    public static void commandExecution(Command cmd) {
        switch (cmd.getName().toLowerCase()) {
            case "/help" -> System.out.println(cmd.help());
            case "/go" -> cmd.go();
            case "/use" -> cmd.use();
            case "/look" -> cmd.look();
            case "/inv" -> cmd.inv();
            case "/save" -> cmd.save();
            case "/quit" -> cmd.quit();
            default -> {
            }
        }
    }
    public static boolean commandCheck(String cmd) {
        switch (cmd) {
            case "/help":
            case "/quit":
            case "/save":
            case "/go":
            case "/use":
            case "/look":
            case "/map":
            case "/inv":
                return true;
            default: if(cmd.startsWith("/"))
                System.err.println("Error: Command is invalid!");
            else System.out.println(cmd); //to hide non-commands remove me.
        }
        return false;
    }
    public static int locationToID(String location) {
        int RETURN = 0;
        switch (location) {
            case "story introduction" -> {}
            case "plains" -> RETURN = 1;
            case "forest" -> RETURN = 2;
            case "barn" -> RETURN = 3;
            case "Castle" -> RETURN = 4;
            case "Tent" -> RETURN = 5;
            case "Mountains" -> RETURN = 6;
            case "Cave" -> RETURN = 7;
            default -> System.err.println("Error: No area.");
        }
        return RETURN;
    }
    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object).trim();
    }
    public static Savegame fromJson(String jsonString) {
        Gson gson = new Gson();
    return gson.fromJson(jsonString, Savegame.class);
    }
    public static void jsonWrite(String jsonString, String jsonPath) {
        if(!jsonPath.endsWith(".json")) jsonPath = jsonPath + ".json";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(jsonPath));
            bw.write(jsonString);
            bw.close();
        } catch (Exception e) {
            System.err.println("Error: File could not be written: " + e);
        }
    }
    public static String jsonRead(String jsonPath) {
        if(!jsonPath.endsWith(".json")) jsonPath = jsonPath + ".json";
        StringBuilder jsonString = new StringBuilder();
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(jsonPath));
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Error: File could not be read: " + e);
        }
        return jsonString.toString();
    }
}
