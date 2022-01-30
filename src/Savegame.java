import com.google.gson.*;
import java.io.*;
import java.util.Scanner;

public class Savegame {
    private int playerHealth;
    private int playerHealthMAX;
    private String[] playerInventory;
    private int playerLevel;
    private String playerName;
    private int[] playerPosition;

    public Savegame() {
        System.out.println("Empty savegame created.\n It is not sutied for actually playing the game!");
    }
    //Story playerCurrentParagraph
    public Savegame(int playerHealth, int playerHealthMAX,
                    String[] playerInventory, int playerLevel, String playerName, int[] playerPosition) {
        //
        //Define default startvalues in main or in the savegameCreate method!
        //
        //setPlayerCurrentParagraph(playerCurrentParagraph);
        setPlayerHealth(playerHealth);
        setPlayerHealthMAX(playerHealthMAX);
        setPlayerInventory(playerInventory);
        setPlayerName(playerName);
        setPlayerPosition(playerPosition);
    }
    //setter methods
    public void setPlayerHealth(int playerHealth) {this.playerHealth = playerHealth;}
    public void setPlayerHealthMAX(int playerHealthMAX) {this.playerHealthMAX = playerHealthMAX;}
    public void setPlayerInventory(String[] playerInventory) {this.playerInventory = playerInventory;}
    public void setPlayerLevel(int playerLevel) {this.playerLevel = playerLevel;}
    public void setPlayerName(String playerName) {this.playerName = playerName;}
    public void setPlayerPosition(int[] playerPosition) {this.playerPosition = playerPosition;}
    //getter methods
    public int getPlayerHealth() {return this.playerHealth;}
    public int getPlayerHealthMAX() {return this.playerHealthMAX;}
    public String[] getPlayerInventory() {return this.playerInventory;}
    public String getPlayerName() {return this.playerName;}
}