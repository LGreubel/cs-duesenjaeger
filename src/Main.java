import java.io.File;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static String savegameDir = "savegames\\";
    public static void main(String[] args) {
        Savegame save = new Savegame();
        Command cmd = new Command();
        if(titleScreen().equals("create")) save = savegameCreate();
        else save = savegameLoad();

        //Here the game beginns
        String userinput;
        boolean hasWon = false;
        //Gameloop-START
        while (!hasWon) {
            userinput = sc.nextLine();
            if(Functions.commandCheck(userinput)) {
                cmd.setName(userinput);
                Functions.commandExecution(cmd);
            }
        } //Gameloop-END
        System.out.println("Congratiualtions. You have made it. nice...");
        System.out.println("");
        sc.close();
    }

    public static String titleScreen() {
        File file = new File(savegameDir);
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
            else userInput = titleScreenFail();
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

    public static Savegame savegameCreate() {
        Savegame save = new Savegame();
        //Default starting-values!!!
        System.out.println("You are about to create a new savegame.");
        save.setPlayerHealth(10);
        save.setPlayerHealthMAX(10);
        save.setPlayerInventory(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        save.setPlayerLevel(1);
        System.out.print("\nEnter your nickname: ");
        save.setPlayerName(sc.nextLine());
        save.setPlayerPosition(new int[]{1,1});
        System.out.print("\nGive your savegame a name: ");
        save.setSavegamePath(savegameDir + sc.nextLine());
        String json = Functions.toJson(save);
        Functions.jsonWrite(json, save.getSavegamePath());
        System.out.println("Your save was successfully created!\n" +
                "Have fun playing our game =)");
        return save;
    }
    public static Savegame savegameLoad() {
        File file = new File(savegameDir);
        Savegame save = new Savegame();
        Savegame.savegameList(file);
        System.out.print("Select your savegame by name (no .json): ");
        String userInput = sc.nextLine();
        if(userInput.endsWith(".json")) save.setSavegamePath(savegameDir + userInput);
        else save.setSavegamePath(savegameDir + userInput + ".json");
        String jsonString = Functions.jsonRead(save.getSavegamePath());
        save = Functions.fromJson(jsonString, save);
        System.out.println("You have selected the savegame: " + save.getSavegamePath().substring(10));
        System.out.println("Have fun while playing");
        return save;
    }
}