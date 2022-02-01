import com.google.gson.Gson;
import java.io.File;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static String savegameDir = "savegames\\";
    public static void main(String[] args) {
        Gson gson = new Gson();
        Story story = gson.fromJson(Functions.jsonRead("story.json"), Story.class);

        //Story.Storycontent p1 = new Story.Storycontent("this", "lalala", "lelele",
        //        "dein Mutter", "dein Vater", "das Kind", "eine Mülldeponie", 666);

        Savegame save = new Savegame();
        Command cmd = new Command();
        if(titleScreen().equals("create")) save = savegameCreate();
        else save = savegameLoad();
        System.out.println("");

        System.out.println(story.getStoryContents(0).getContent());


        //Here the game beginns
        String userinput;
        boolean hasWon = false;
        //Gameloop-START
        while (!hasWon) {
            userinput = "";
            userinput = sc.nextLine();
            if(Functions.commandCheck(userinput)) {
                cmd.setName(userinput);
                Functions.commandExecution(cmd);

            }
        } //Gameloop-END
        System.out.println("Congratulations. You have made it. nice...");
        System.out.println("");
        sc.close();
    }
    public static String titleScreen() {
        File file = new File(savegameDir);
        String userInput;
        System.out.println("\n---------------------------------------------------             \\  \\             |\"\" \n" +
                "|                __|__                            |              .  \\            |   : \n" +
                "|         --o--o--(_)--o--o--                     |              `   \\           |     \n" +
                "|            cs-duesenjaeger                      |               \\   \\          |    ;               +.\n" +
                "|                                                 |                .   \\         |                   *._`-.\n" +
                "|    --- Projektlead                              |                `    \\        |     :          .-*'  `. `.\n" +
                "|      --- Lucas G.                               |                _\\    \\.__..--**--...L_   _.-*'      .'`*'\n" +
                "|                                                 |               /  `*-._\\   -.       .-*\"*+._       .'\n" +
                "|    --- Development management                   |              :        ``*-._*.     \\      _J.   .'           \n" +
                "|      --- Marvin R.                              |          .-*'`*-.       ;     `.    \\    /   `.'             \n" +
                "|                                                 |      .-*'  _.-*'.     .-'       `-.  `-.:   _.'`-.           \n" +
                "|    --- Development                              |   +*' _.-*'      `..-'             `*-. `**'      `-.        \n" +
                "|      --- Maximilian K. x Kevin S. x Laurin L.   |    `*'          .-'      ._            `*-._         `.      \n" +
                "|                                                 |              .-'         `.`-.____..+-**\"\"'         .*\"`.    \n" +
                "---------------------------------------------------         ._.-'          _.-*'':$$$;._$              /     `.  \n" +
                "                                                         .-'  `.      _.-*' `*-.__T$P   `\"**--..__    :        `.\n" +
                "                                                  .'..-'       \\_.-*'                            `\"**--..___.-*'\n");
        if(!Savegame.savegameExists(file)) {
            System.out.println(" Hello and Welcome.                               `. `.    _.-*'                                             \n" +
                    " Thank you for checking out our textadventure.      `. `:*'\n" +
                    "                                                       `. `.\n" +
                    "                                                          `*");
                        return "create";
        } else {
            System.out.println(" Welcome back.                                     `. `.    _.-*'                                             \n" +
                    " Do you want to load up a save or start a new one?   `. `:*'\n" +
                    "                                                       `. `.\n" +
                    "                                                          `*");
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
        save.setPlayerInventory(new String[]{"Sword", "", "", "", "", "", "", "", ""});
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

        if(Savegame.savegameShowLoad(file)) {//Multiple savegames
            System.out.println("List of your savegames.");
            Savegame.savegameList(file);
            System.out.print("Select your savegame by name: ");
            String userInput = sc.nextLine();
            if(userInput.endsWith(".json")) save.setSavegamePath(savegameDir + userInput);
            else save.setSavegamePath(savegameDir + userInput + ".json");

        } else {//Single savegame
            File[] files = file.listFiles();
            save.setSavegamePath(savegameDir + files[0].getName());
        }//Savegame loading
        String jsonString = Functions.jsonRead(save.getSavegamePath());
        System.out.println("You have selected the savegame: " + save.getSavegamePath().substring(10));
        System.out.println("Have fun while playing");
        return (Savegame) Functions.fromJson(jsonString);
    }
}