import java.util.Scanner;

public class Command {
    private String name;

    public Command() {

    }
    String help() {
        String helptext = "";
        helptext = helptext + "/go -  lets your character go in a specified direction\n";
        helptext = helptext + "help - Shows the commandlist\n";
        helptext = helptext + "/look - to look in a specified direction\n";
        helptext = helptext + "/map - will print the gamemap on the console\n";
        helptext = helptext + "/quit - will shutdown the game properly\n";
        helptext = helptext + "/save - saves your current gamestatus\n";
        helptext = helptext + "/talk - talk to given person\n";
        helptext = helptext + "/use - use given item\n";
        return helptext;
    }

//Unfinnished Commands
    void go() {}
    void talk() {}
    void use() {}
    void look() {}
    void map() {}
    void inv() {}
    void save() {
        System.out.println("Your game will be saved now.");
    }
    void quit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you really want to leave the game? (yes/no): ");
        if (sc.nextLine().equals("yes")) System.out.println("quit game.");
        sc.close();
        System.exit(0);
    }


    //Setter Methods
    public void setName(String name) {this.name = name;}
    //Getter Methods
    public String getName() {return this.name;}
}

