import com.google.gson.Gson;

import java.io.Console;
import java.io.File;
import java.util.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Gson gson = new Gson();
    public static Savegame save = new Savegame();
    public static Story story = gson.fromJson(Functions.jsonRead("story.json"), Story.class);
    public static String savegameDir = "savegames\\";

    public static void main(String[] args) {
        Command cmd = new Command();
        if(titleScreen().equals("create")) save = savegameCreate();
        else save = savegameLoad();
        System.out.println("");
        storyIntroduction();
        System.out.println("Congratulations. You have made it. nice...");
        System.out.println("");
        sc.close();
    }
    public static void storyIntroduction() {
        while (true) {
            System.out.println("Ghorkan the self proclaimed \"Master of the Forest\" claimed it for his own.\n" +
                    "Due to his accursed presence, the once full blooming forest is now bleak and lifeless.\n" +
                    "You an adventurer take matters to your own hands to strike him down!");
            System.out.println("Press Any key to continue!!!");
            sc.nextLine();
            break;
        }
        textPlains();
    }
    public static void textPlains() {
        System.out.println("Current location: plains.");
        System.out.println("");
        System.out.println("As you are standing on a great plain you can only see the blue sky with clouds.\n" +
                "After looking around, you recognize a dark cave in the north.\n" +
                "In the west you can see a peaky castle behind some mountains.\n" +
                "A misty and dead forest stretches across the southern horizon \n" +
                "and there is a barn made out of brittle wood in the east.");

        System.out.println("You can go \n" +
                "--> \"north\" into the mountains.\n" +
                "--> \"south\" into the forest\".\n" +
                "--> \"east\" into the barn.\n" +
                "--> \"west\" into the castle.");

        String userInput;

        while (true) {
            userInput = "";
            userInput = sc.nextLine();

            if(userInput.equalsIgnoreCase("north")) {
                System.out.println("[moves to location 'mountains'] ...you wander north.");
                textMountains();
                break;
            }
            else if(userInput.equalsIgnoreCase("south")) {
                System.out.println("[moves to location 'forest'] ...you wander south.");

                break;
            }
            else if(userInput.equalsIgnoreCase("east")) {
                System.out.println("[moves to location 'barn'] ...you wander east.");

                break;
            }
            else if(userInput.equalsIgnoreCase("west")) {
                System.out.println("[moves to location 'castle'] ...you wander west.");

                break;
            }
        }
    }
    public static void textMountains() {
        System.out.println("Current location: mountains.");
        System.out.println("");
        System.out.println("You look around...\n" +
                "On the way to the cave some stormy clouds rise along the sky and rain begins to pour down.\n" +
                "The rising storm made it hard to find the entrance of the dark cave.\n" +
                "The inside of the cave is so dark, that as you stretch your arm inside you lose sight of it.");

        System.out.println("You can go \n" +
                "--> to the\"cave\". You'll explore the cave.\n" +
                "--> \"south\" into the plains. \n");

        String userInput;

        while (true) {
            userInput = "";
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("cave")) {
                System.out.println("To Enter the cave you pick up a torche and some flint.");
                System.out.println("[moves location to 'cave(inside)'] ...As you enter the moisty cave, you take a torch to light up a shallow path.\n " +
                        "As you traverse further into the cave bones are spread around the ground and it kinda creeps you out.\n " +
                        "You walk deeper in the cave and discover a dim light at the end of a passage.\n " +
                        "As the air thins breathing is getting harder for you...\"");
                textCave();
                break;
            } else if(userInput.equalsIgnoreCase("south")) {
                System.out.println("[moves location to 'plains'] ...you leave the cave behind and wander towards the plains.");
                textPlains();
                break;
            }
        }
    }
    public static void textCave() {
        System.out.println("Current location: cave.");
        System.out.println("");

        System.out.println("You look around...\n" +
                "You see a small fireplace that reveals a man from head to toe clad in black.\n" +
                "!Dain, the dark knight, is here");

        System.out.println("You can \n" +
                "--> \"go\" outside.\n" +
                "--> \"attack\" Dain the Black Knight." +
                "--> \"talk\" to Dain the Black Knight.");

        String userInput;

        while (true) {
            userInput = "";
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("go")) {
                System.out.println("Go outside [moves location to 'cave'] ...you leave the cave and return outside.");
                textMountains();
                break;
            } else if(userInput.equalsIgnoreCase("attack")) {
                System.out.println("Use 'sword' on Dain/Black Knight [puts 'black helmet' in inventory]\n" +
                        "...After a hard and long fight you achieve to best the black knight. You gain some minor injuries but nothing drastic.\n " +
                        "With blood all splattered around you, you take the helmet of the black knight as proof for the nobleman.\n " +
                        "You take the black helmet and place it in your bag.");
                System.out.println("You may leave the cave now.");
                sc.nextLine();
                textMountains();
                break;
            } else if(userInput.equalsIgnoreCase("talk")) {
                System.out.println("Talk to Dain/Black Knight\\n" +
                        "... As you open your mouth, he cuts you short and mutters.\n" +
                        "You little chap... it was a fault to come here.\n " +
                        "Your fate will be the same as the ones who got here before.");
                sc.nextLine();
                System.exit(0);
            }
        }
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
        save.setLastSection(0);
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
