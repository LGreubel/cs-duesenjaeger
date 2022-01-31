import javax.security.sasl.SaslClient;
import java.io.File;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Title Screen
        Command cmd = new Command();
        Savegame save = new Savegame();
        if(titleScreen().equals("create")) save = savegameCreate(save);
        else save = savegameLoad(save);

        //String userinput;
/*
        //Gameloop-START
        while (true) {
            //Text von der Story
            userinput = sc.nextLine();
            if(commandCheck(userinput)) {
                cmd.setName(userinput);
                commandExecution(cmd);
            }
        } //Gameloop-END */
        sc.close();
    }

    public static String titleScreen() {
        File file = new File("savegames");
        String userInput;
        if(!Savegame.savegameExists(file)) {
            System.out.println("Hello and Welcome.\n Thank you for checking our textadventure.");
            return "create";
        } else {
            System.out.println("Welcome back. Do you want to load up a save or start a new one?");
            System.out.print("--> 'load' or 'create': ");
            userInput = sc.nextLine();

            if(userInput.equalsIgnoreCase("load")) userInput = "load";
            else if(userInput.equalsIgnoreCase("create")) userInput = "create";
            //else userInput = titleScreenFail();
        }
        return userInput;
    }
    public static String titleScreenFail() {
        String userInput;
        while (true) {
            System.out.println("No action made. maybe a typo.. please try again.\n" +
                    "Do you want to load up a save or start a new one");
            System.out.print("\n 'load' or 'create': ");
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("load")) return "load";
            else if(userInput.equalsIgnoreCase("create")) return "create";
        }
    }

    public static Savegame savegameCreate(Savegame save) {
        //Default starting-values!!!
        System.out.println("You are about to create a new savegame.");
        save.setPlayerHealth(10);
        save.setPlayerHealthMAX(10);
        save.setPlayerInventory(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        System.out.print("\nEnter your nickname: ");

        //Keine eingabe möglich.
        save.setPlayerName(sc.nextLine());
        //No line found throw wird direkt geworfen.

        save.setPlayerPosition(new int[]{1,1});
        System.out.print("\nGive your savegame a name: ");
        save.setSavegamePath("savegames/" + sc.nextLine());
        String json = Functions.toJson(save);
        Functions.jsonWrite(json, save.getSavegamePath());
        System.out.println("Your save was successfully created!\n" +
                "Have fun playing our game =)");
        return save;
    }
    public static Savegame savegameLoad(Savegame save) {
        return save;
    }
}