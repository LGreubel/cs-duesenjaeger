import java.io.*;

public class Savegame {
    private int playerHealth;
    private int playerHealthMAX;
    private String[] playerInventory;
    private int playerLevel;
    private String playerName;
    private int[] playerPosition;
    private String savegamePath;
    private int lastSection;

    public Savegame() {

    }
    public static boolean savegameShowLoad(File dir) {
        File[] files = dir.listFiles();
        assert files != null;
        return files.length > 1;
    }
    public static File[] savegameList(File dir) {
        File[] files = dir.listFiles();
        if(files != null) {
            for (File file : files) {
                if (file.isFile()) System.out.println(file.getName());
            }
        }
        return files;
    }
    public static boolean savegameExists(File dir)  {
        File[] files = dir.listFiles();
        if(files != null) {
            for (File file : files) {
                if (file.isFile()) return true;
            }
        }
        return false;
    }
    //setter methods
    public void setPlayerHealth(int playerHealth) {this.playerHealth = playerHealth;}
    public void setPlayerHealthMAX(int playerHealthMAX) {this.playerHealthMAX = playerHealthMAX;}
    public void setPlayerInventory(String[] playerInventory) {this.playerInventory = playerInventory;}
    public void setPlayerLevel(int playerLevel) {this.playerLevel = playerLevel;}
    public void setPlayerName(String playerName) {this.playerName = playerName;}
    public void setPlayerPosition(int[] playerPosition) {this.playerPosition = playerPosition;}
    public void setSavegamePath(String savegamePath) {this.savegamePath = savegamePath;}
    public void setLastSection(int lastSection) {this.lastSection = lastSection;}
    //getter methods
    public int getPlayerHealth() {return this.playerHealth;}
    public int getPlayerHealthMAX() {return this.playerHealthMAX;}
    public String[] getPlayerInventory() {return this.playerInventory;}
    public String getPlayerName() {return this.playerName;}
    public String getSavegamePath() {return this.savegamePath;}
    public int getLastSection() {return this.lastSection;}
}