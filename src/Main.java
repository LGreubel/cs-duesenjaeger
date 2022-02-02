import com.google.gson.Gson;
import java.io.File;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Command cmd = new Command();
    public static Gson gson = new Gson();
    public static Savegame save = new Savegame();
    public static Story story = gson.fromJson(Functions.jsonRead("story.json"), Story.class);
    public static String savegameDir = "savegames\\";

    public static int ghorkan = 0;
    public static boolean rareSword = false;
    public static boolean blacksmith = false;
    public static boolean blackhelmet = false;
    public static boolean jeweledSteel = false;
    public static boolean sticksandhilt = false;
    public static boolean enteredTent = false;

    public static void main(String[] args) {
        if(titleScreen().equals("create")) save = savegameCreate();
        else save = savegameLoad();

        storyIntroduction();
        System.out.println("Congratulations. You have made it. nice...");
        sc.nextLine();
        sc.close();
        cmd.quit();
    }

    public static void storyIntroduction() {
        System.out.println("""
                Ghorkan the self proclaimed "Master of the Forest" claimed it for his own.
                Due to his accursed presence, the once full blooming forest is now bleak and lifeless.
                You an adventurer take matters to your own hands to strike him down!""");
        System.out.println("Press Any key to continue!!!");
        sc.nextLine();
        textPlains();
    }
    public static void textPlains() {
        System.out.println("Current location: plains.\n");
        System.out.println("""
                As you are standing on a great plain you can only see the blue sky with clouds.
                After looking around, you recognize a dark cave in the north.
                In the west you can see a peaky castle behind some mountains.
                A misty and dead forest stretches across the southern horizon\s
                and there is a barn made out of brittle wood in the east.""");

        System.out.println("""
                You can go\s
                --> "north" into the mountains.
                --> "south" into the forest".
                --> "east" into the barn.
                --> "west" into the castle.""");

        String userInput;

        while (true) {
            userInput = sc.nextLine();

            if(userInput.equalsIgnoreCase("north")) {
                System.out.println("[moves to location 'mountains'] ...you wander north.");
                textMountains();
                break;
            }
            else if(userInput.equalsIgnoreCase("south")) {
                System.out.println("[moves to location 'forest'] ...you wander south.");
                textForest();
                break;
            }
            else if(userInput.equalsIgnoreCase("east")) {
                System.out.println("[moves to location 'barn'] ...you wander east.");
                textBarn();
                break;
            }
            else if(userInput.equalsIgnoreCase("west")) {
                System.out.println("[moves to location 'castle'] ...you wander west.");
                textCastle();
                break;
            }
        }
    }
    public static void textMountains() {
        System.out.println("Current location: mountains.\n");
        System.out.println("""
                You look around...
                On the way to the cave some stormy clouds rise along the sky and rain begins to pour down.
                The rising storm made it hard to find the entrance of the dark cave.
                The inside of the cave is so dark, that as you stretch your arm inside you lose sight of it.""");

        System.out.println("""
                You can go\s
                --> to the "cave". You'll explore the cave.
                --> "south" into the plains.\s
                """);

        String userInput;

        while (true) {
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("cave")) {
                System.out.println("To Enter the cave you pick up a torche and some flint.");
                System.out.println("""
                        [moves location to 'cave(inside)'] ...As you enter the moisty cave, you take a torch to light up a shallow path.
                         As you traverse further into the cave bones are spread around the ground and it kinda creeps you out.
                         You walk deeper in the cave and discover a dim light at the end of a passage.
                         As the air thins breathing is getting harder for you...\"""");
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
        System.out.println("Current location: cave.\n");

        System.out.println("""
                You look around...
                You see a small fireplace that reveals a man from head to toe clad in black.
                !Dain, the dark knight, is here""");

        System.out.println("""
                You can\s
                --> "go" outside.
                --> "attack" Dain the Black Knight.
                --> "talk" to Dain the Black Knight.""");

        String userInput;

        while (true) {
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("go")) {
                System.out.println("Go outside [moves location to 'cave'] ...you leave the cave and return outside.");
                textMountains();
                break;
            } else if(userInput.equalsIgnoreCase("attack")) {
                System.out.println("""
                        Use 'sword' on Dain/Black Knight [puts 'black helmet' in inventory]
                        ...After a hard and long fight you achieve to best the black knight. You gain some minor injuries but nothing drastic.
                         With blood all splattered around you, you take the helmet of the black knight as proof for the nobleman.
                         You take the black helmet and place it in your bag.""");
                System.out.println("You may leave the cave now.");
                blackhelmet = true;
                sc.nextLine();
                textMountains();
                break;
            } else if(userInput.equalsIgnoreCase("talk")) {
                System.out.println("""
                        Talk to Dain/Black Knight\\n... As you open your mouth, he cuts you short and mutters.
                        You little chap... it was a fault to come here.
                         Your fate will be the same as the ones who got here before.""");
                sc.nextLine();
                System.exit(0);
            }
        }
    }
    public static void textBarn() {
        System.out.println("Current location: Barn.\n");

        System.out.println("""
                You look around...
                Walking towards the brittle barn you recognize a bearded man with a dog nearby.
                The man does not seem pretty chatty.
                 Nevertheless, he hands you a bag with sticks and a hilt.
                !Typhon, a shepherd, is here.\"""");

        System.out.println("""
                You can\s
                --> go "west".\s
                --> "talk" to Typhon
                --> "take" 'sticks and hilt'""");

        String userInput;

        while (true) {
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("west")) {
                System.out.println("[moves to location 'plains']\n ... you wander away from the barn towards the open plains.");
                textPlains();
                break;
            } else if (userInput.equalsIgnoreCase("take") & !sticksandhilt) {
                System.out.println("... You take a bag with sticks and a hilt from Typhon.\n" +
                        " After you take them, he nods at you, like saying you'll need them.\"");
                sticksandhilt = true;
                textBarn();
                break;
            } else if (userInput.equalsIgnoreCase("talk")) {
                System.out.println("Talk to Typhon\n ... he recognizes you, but does not seem to want to converse, odd fellow.\"");
                sc.nextLine();
                textBarn();
                break;
            }
        }
    }
    public static void textForest() {
        System.out.println("Current location: forest.\n");
        System.out.println("""
                You look around...
                As you wander further into the dark and gloomy forest the trees begin to look even worse, like they've gotten there life sucked out of them and the mist seems to thicken.
                 You wander until you can make out a single person standing in the midst of it all. The air seems to get heavier.
                !Ghorkan, the Master of Forest, is here.""");

        System.out.println("""
                You can
                --> go "north" into the plains.
                --> "attack" Ghorkan with your sword.
                --> "talk" to Ghorkan.""");

        String userInput;

        while (true) {
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("north")) {
                System.out.println("[moves to location 'plains'] ...you wander away from this accursed forest.");
                textPlains();
                break;
            } else if(userInput.equalsIgnoreCase("attack") & !rareSword) {
                System.out.println("... your measly sword is useless against the evil Ghorkan and you are cursed by a ban.\n");
                blacksmith = true;
                textForest();
                break;
            } else if(userInput.equalsIgnoreCase("attack") & rareSword) {
                System.out.println("""
                        Use 'rare sword' Ghorkan
                         You enter the foreboding forest...
                        Your heartbeat is getting faster and faster as you start thinking of the last time you've been here.
                        It is getting dark, the trees, stones and creatures within the forest cast wide shadows.
                        And then you recognize the same sparkle in the darkness. Ghorkan, he is there.
                        You take a deep breath, take your new sword to hand and walk towards him.
                         "You again", he murmures, "was last time not enough for you?
                        This time you won't get out of here alive."
                         With a great thrust into Ghorkan's heart you achieved to kill the Master of Forest.
                         Concurrently, the ban of Ghorkan that was layed upon you is now gone and the forest is once again full of life and the peaceful animals seem to return.""");
                sc.nextLine();
                break;
            } else if(userInput.equalsIgnoreCase("talk") & ghorkan != 5) {
                System.out.println("... you try to reason with Ghorkan, he seems a bit irritated but ignores you.\n"); ghorkan++;
                sc.nextLine();
                textForest();
                break;

            } else if (userInput.equalsIgnoreCase("talk") & ghorkan == 5) { //WIP
                System.out.println("""
                        "you're getting on my nerves now, get ready to die."!
                         You can feel your arms getting heavy, legs unsteady, moms spaghetti. (You faint)
                        As you awaken you're surrounded by thick castle walls.
                         Talk to Ghorkan [after annoying him -> kills you/quits game]
                         ... "you again, you're eager to die aren't you? This time I won't use the wrong spell again!"He chants the words "Expelliarmus" and you die.
                        *YOU ARE DEAD*\"""");
                break;
            }
        }
    }
    public static void textCastle() {
        System.out.println("Current location: castle.\n");

        System.out.println("""
                You look around...
                You reach the castle after a long way across the mountains.
                It is surrounded by a crowdy town full of houses and a market with shops.
                The citizens there are selling food and other stuff.
                You can hear a ringing anvil from a blacksmith in a tent near the market.
                A man in posh expensive looking clothing is sitting near the tent, looking anxious.
                """);

                System.out.println("""
                        You can\s
                        -->go "tent" go into the tent
                        -->go "east" go into the plains\s
                        -->"talk" to Noblemen\s
                        -->"use" black helmet""");

        String userInput;

        while (true) {
            userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("east")) {
                System.out.println("[moves to location 'plains'] ... you traverse through the mountains back to the plains.\n");
                textPlains();
                break;
            } else if (userInput.equalsIgnoreCase("tent")) {
                System.out.println("[moves location to 'tent']\n ... you enter the tent.\n");
                textTent();
                break;
            } else if (userInput.equalsIgnoreCase("talk") & enteredTent & !jeweledSteel) {
                System.out.println("""
                        You approach the noblemen\s
                        ... "have you already avengend my family? If not don't bother me.
                         He must be in a cave by northern mountains.\"""");
                sc.nextLine();
                textCastle();
                break;
            } else if (userInput.equalsIgnoreCase("talk") & (jeweledSteel || rareSword)) { // after finishing noblemens quest -> getting jeweled steel
                System.out.println("You approach the noblemen \n" +
                        " \"I wish you luck.\"");
                sc.nextLine();
                textCastle();
                break;
                // needs blackhelmet == true/1 && makes jeweled steel == true/1
            } else if (userInput.equalsIgnoreCase("talk") & !jeweledSteel) {
                System.out.println("You approach the noblemen \n" +
                        "... as you approach him he musters you up. After finishing he seems to leave without leaving you a chance to talk to him.");
                sc.nextLine();
                textCastle();
                break;
                // after talking to blacksmith about ghorkan -> have used sword on ghorkan in forest, talked to blacksmith, left tent)
            } else if (userInput.equalsIgnoreCase("use") & !jeweledSteel & blackhelmet) {
                System.out.println("""
                        "You really killed Dain?! You have my respect. I've hired many others before to get my revenge.
                         He bested them all, so no one ever came back to me...
                         Here is the promised jewel steel, do not waste it
                         I wish you luck."
                         You take the jeweled steel.\"""");
                jeweledSteel = true; blackhelmet = false;
                sc.nextLine();
                textCastle();
                break;
            }
        }
    }
    public static void textTent() {
        System.out.println("Current location: tent(castle).\n");

        System.out.println("""
                You look around...
                As you enter the tent, you can see the roaring flames and lots of crafted goods.
                It reeks of coal, metal and sweat, it is incredibly hot inside.
                In the midst of it all is brawny, long bearded dwarf.
                !The blacksmith is here, swinging his hammer.""");

        System.out.println("""
                You can
                --> "go" back into the castle.
                --> "forge" the rare sword with sticks `n` hilt and jeweled steel.
                --> "talk" to the blacksmith.""");

        String userInput;

        while (true) {
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("go")) {
                System.out.print("[moves to location 'castle'] ");
                if(blacksmith & (!blackhelmet || !jeweledSteel || !rareSword)) {
                    System.out.println("""
                            ... as you leave the tent.
                             !A noblemen is walking by.
                             "I heard that you fought against Ghorkan.
                             Everyone who loses is cursed by a ban... only if you defeat him you will be free of his ban.
                             Only a sword made by the rare jewel steel is able to kill him.
                             Luckily I have a bag of it.
                             To get the jewel steel, you have to do me a favour.
                             For this issue you will need some torches and flint. I will wait for you in the castle."
                             >Task: "Kill Dain the black knight in the cave in the north,
                             he has murdered the whole family of the nobleman a long time ago.",""");
                    blacksmith = false; enteredTent = true;
                } else {
                    System.out.println("...you leave the tent.");
                }
                sc.nextLine();
                textCastle();
                break;
            } else if(userInput.equalsIgnoreCase("forge") & sticksandhilt & jeweledSteel) {
                System.out.println("""
                        ...To craft the incredible sword out of the rare material,
                         you give some sticks, the hilt and the jeweled steel to the blacksmith.
                         After he examines the materials he nods and says:
                         "Crafting this sword will take a while, the steel needs a certain temperature."
                         After some hours, the blacksmith finished crafting the sword.
                         He comes out of tent and hands it to you.""");

                sticksandhilt = false; jeweledSteel = false; rareSword = true;
                sc.nextLine();
                textCastle();
                break;
            } else if(userInput.equalsIgnoreCase("talk") & !rareSword & !blacksmith) {
                System.out.println("... you try to talk to the blacksmith, but he seems to be to focused in his craft.");
                textTent();
                break;
            } else if(userInput.equalsIgnoreCase("talk") & !rareSword & blacksmith) {
                System.out.println("""
                        ... you tell the blacksmith of the occurrences in the forest.
                         He talks to you.
                         "Haha, fighting against the Master of Forest with this puny equipment is suicide.
                         I can craft you a strong sword... but only with some good raw materials.
                         Bring them to me if you have them."
                        >Task: Bring the blacksmith 'Sticks And Hilt','Jeweled Steel'""");
                sc.nextLine();
                textTent();
                break;
            } else if(userInput.equalsIgnoreCase("talk") & rareSword & !blacksmith) {
                System.out.println("... \"You now have the best sword I've ever made. Put it to good use and slay this \"master\"\".");
                sc.nextLine();
                textTent();
                break;
            }
        }
    }

    public static String titleScreen() {
        File file = new File(savegameDir);
        String userInput;
        System.out.println("""

                ---------------------------------------------------             \\  \\             |""\s
                |                __|__                            |              .  \\            |   :\s
                |         --o--o--(_)--o--o--                     |              `   \\           |    \s
                |            cs-duesenjaeger                      |               \\   \\          |    ;               +.
                |                                                 |                .   \\         |                   *._`-.
                |    --- Projektlead                              |                `    \\        |     :          .-*'  `. `.
                |      --- Lucas G.                               |                _\\    \\.__..--**--...L_   _.-*'      .'`*'
                |                                                 |               /  `*-._\\   -.       .-*"*+._       .'
                |    --- Development management                   |              :        ``*-._*.     \\      _J.   .'          \s
                |      --- Marvin R.                              |          .-*'`*-.       ;     `.    \\    /   `.'            \s
                |                                                 |      .-*'  _.-*'.     .-'       `-.  `-.:   _.'`-.          \s
                |    --- Development                              |   +*' _.-*'      `..-'             `*-. `**'      `-.       \s
                |      --- Maximilian K. x Kevin S. x Laurin L.   |    `*'          .-'      ._            `*-._         `.     \s
                |                                                 |              .-'         `.`-.____..+-**""'         .*"`.   \s
                ---------------------------------------------------         ._.-'          _.-*'':$$$;._$              /     `. \s
                                                                         .-'  `.      _.-*' `*-.__T$P   `"**--..__    :        `.
                                                                  .'..-'       \\_.-*'                            `"**--..___.-*'
                """);
        if(!Savegame.savegameExists(file)) {
            System.out.println("""
                    Hello and Welcome.                               `. `.    _.-*'                                            \s
                    Thank you for checking out our textadventure.      `. `:*'
                                                                          `. `.
                                                                             `*""".indent(1));
                        return "create";
        } else {
            System.out.println("""
                    Welcome back.                                     `. `.    _.-*'                                            \s
                    Do you want to load up a save or start a new one?   `. `:*'
                                                                          `. `.
                                                                             `*""".indent(1));
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
            assert files != null;
            save.setSavegamePath(savegameDir + files[0].getName());
        }//Savegame loading
        String jsonString = Functions.jsonRead(save.getSavegamePath());
        System.out.println("You have selected the savegame: " + save.getSavegamePath().substring(10));
        System.out.println("Have fun while playing");
        return Functions.fromJson(jsonString);
    }
}
