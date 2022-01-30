
import com.google.gson.Gson;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
            Testen der Storyimplementierung.
            Die Story wird in Paragraphen unterteit,
            welche einen Text enthalten.
            zum "Verlassen" des Paragraphen muss der
            User eine bedingung erfüllen.

            Implementierung: In eine Json datei sind sämtliche Paragraphen als
            Objekte in einer Liste gespeichert. Diese Json datei soll mit der
            Funktion Functions.readJson() in eine String variable geschrieben werden.
            Dieser String wird mit googles Gson Klasse nun final eine Liste mit Objekten
            erzeugen. Somit ist die Story nun in einer List.of oder einem Array.

            Ja das wäre der plan. mit den Read/Write funktionen wären auch die
            Savegames umsetzbar.
         */

        //Diese sind daten zu testzwecken.
        Gson gson = new Gson();
        String jsonString = "";
        Paragraph p1 = new Paragraph("1","1",false,0);
        Paragraph p2 = new Paragraph("2","2",false,1);
        Paragraph p3 = new Paragraph("3","3",false,2);

        //Json schreiben
        List paragraphs = List.of(p1, p2, p3);
        jsonString = gson.toJson(paragraphs);
        //Functions.jsonWrite(jsonString,"src\\story");
        System.out.println(jsonString);

        System.out.println("");
        System.out.println("");
        System.out.println("");

        //json Lesen (hier klappt noch nix so richtig. Sadge
        jsonString = Functions.jsonRead("src\\story");
        System.out.println("return: " + jsonString);

        for (int i = 0; i < 1; i++) {
            //paragraphs[i] = gson.fromJson(jsonString, Paragraph.class);
            //System.out.println(paragraphs[i]);
        }


        Scanner sc = new Scanner(System.in);
        Command cmd = new Command();
        //Savegame sav = savegameCreate();
        String userinput;
/*
        //Gameloop-START
        while (true) {
            //Text von der Story
            userinput = sc.nextLine();
            if(commandCheck(userinput)) {
                cmd.setName(userinput);
                commandExecution(cmd);
            }
        } //Gameloop-END
*/
    }

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



    public static Savegame savegameCreate() {
        System.out.print("Your about to Create a new savegame. \n" +
                "Please Enter a name to save it under: ");
        Scanner sc = new Scanner(System.in);
        String savegamePath = "savegames/" + sc.nextLine();

        System.out.println("\nNow enter your nickname: ");

        //Default values!!!
        //Story playerCurrentParagraph ...
        int playerHealth = 10;
        int playerHealthMAX = 10;
        String[] playerInventory = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int playerLevel = 0;
        String playerName = sc.nextLine();
        int[] playerPosition = {1,1};

        sc.close();
        Savegame savegame = new Savegame(playerHealth,playerHealthMAX,
                playerInventory,playerLevel,playerName,playerPosition);
        //Functions.toJson("", savegamePath);
        return savegame;
    }
    public static void savegameLoad(String savegameName) {
        String savegamePath = "savegames/" + savegameName + ".json";
        String savegame = Functions.jsonRead(savegamePath);
        //String in Objekte schreiben bitte!
    }
}