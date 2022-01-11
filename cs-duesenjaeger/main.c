#include <stdio.h>
#include <stdbool.h>
#include <string.h>


//set characters to talk
bool name1Available = true;
bool name2Available = false;

//set directions to look
bool upAvailable = true;
bool downAvailable = true;
bool leftAvailable = true;
bool rightAvailable = true;

//set directions to go
bool southAvailable = true;
bool northAvailable = true;
bool eastAvailable = true;
bool westAvailable = true;


//open the map
int openMap(){
    FILE *fp;
    int c;

    fp = fopen("map.txt","r");
    while(1) {
        c = fgetc(fp);
        if( feof(fp) ) {
            break;
        }
        printf("%c", c);
    }
    fclose(fp);
    return 0;
}


//process commands
int commands(){
    char userInput[] = "";
    //fgets(userInput, 20, stdin);
    scanf("%s", &userInput); //scan for user input



    char quit[] = "/quit";  //keyword
    char *keywordQuit = strstr(userInput, quit); //search for keyword in user input
    if (keywordQuit != NULL) //search for substring
    {
        printf("The Game will shut down now.\n");
        return 1337;
    }

    char help[] = "/help";  //keyword
    char *keywordHelp = strstr(userInput, help); //search for keyword in user input
    if (keywordHelp != NULL) //search for substring
    {
        printf("-----------------------------------\n"
                "list of all commands:\n"
                "/quit - quit the game\n"
                "/help - open a list of all commands\n"
                "/go [north/south/east/west] - go in given direction\n"
                "/talk [name] - talk to given person\n"
                "/use [item] - use given item\n"
                "/look [up/down/forwards/backwards/right/left] - look in given direction\n"
                "/map - open the map\n"
                "/inv - open your inventory\n"
                "/save- save the game in current savegame\n"
                "-----------------------------------\n"
                );
        return 0;
    }

    char go[] = "/go";  //keyword
    char *keywordGo = strstr(userInput, go); //search for keyword in user input
    if (keywordGo != NULL) //search for substring
    {
        char south[] = "south";  //keyword
        char *keywordSouth = strstr(userInput, south); //search for keyword in user input
        if (keywordSouth != NULL && southAvailable == true){
            printf("You go south.\n");
            return 10;
        }

        char north[] = "north";  //keyword
        char *keywordNorth = strstr(userInput, north); //search for keyword in user input
        if (keywordNorth != NULL && northAvailable == true){
            printf("You go north.\n");
            return 11;
        }

        char west[] = "west";  //keyword
        char *keywordWest = strstr(userInput, west); //search for keyword in user input
        if (keywordWest != NULL && westAvailable == true){
            printf("You go west.\n");
            return 12;
        }

        char east[] = "east";  //keyword
        char *keywordEast = strstr(userInput, east); //search for keyword in user input
        if (keywordEast != NULL && eastAvailable == true){
            printf("You go east.\n");
            return 13;
        }
        //else - not a preset direction
        printf("You cannot go there!\n");
    }

    char talk[] = "/talk";  //keyword
    char *keywordTalk = strstr(userInput, talk); //search for keyword in user input
    if (keywordTalk != NULL) //search for substring
    {
        char name1[] = "Name1";  //keyword
        char *keywordName1 = strstr(userInput, name1); //search for keyword in user input
        if (keywordName1 != NULL && name1Available == true){              //check if character is available in this location
            printf("You talk to **name1**.\n");
            return 20;
        }
        char name2[] = "Name2";  //keyword
        char *keywordName2 = strstr(userInput, name2); //search for keyword in user input
        if (keywordName2 != NULL && name2Available == true){              //check if character is available in this location
            printf("You talk to **name2**.\n");
            return 21;
        }
        //else - nobody available to talk
        printf("nobody there to talk.\n");
    }

    char use[] = "/use";  //keyword
    char *keywordUse = strstr(userInput, use); //search for keyword in user input
    if (keywordUse != NULL) //search for substring
    {
        printf("404\n");
        return 0;
    }

    char look[] = "/look";  //keyword
    char *keywordLook = strstr(userInput, look); //search for keyword in user input
    if (keywordLook != NULL) //search for substring
    {
        char up[] = "up";  //keyword
        char *keywordUp = strstr(userInput, up); //search for keyword in user input
        if (keywordUp != NULL && upAvailable == true){
            printf("You look up.\n");
            return 40;
        }

        char down[] = "down";  //keyword
        char *keywordDown = strstr(userInput, down); //search for keyword in user input
        if (keywordDown != NULL && downAvailable == true){
            printf("You look down.\n");
            return 41;
        }

        char left[] = "left";  //keyword
        char *keywordLeft = strstr(userInput, left); //search for keyword in user input
        if (keywordLeft != NULL && leftAvailable == true){
            printf("You look to the left.\n");
            return 42;
        }

        char right[] = "right";  //keyword
        char *keywordRight = strstr(userInput, right); //search for keyword in user input
        if (keywordRight != NULL && rightAvailable == true){
            printf("You look to the right.\n");
            return 43;
        }
        //else - not a preset direction
        printf("nothing there.\n");
    }

    char map[] = "/map";  //keyword
    char *keywordMap = strstr(userInput, map); //search for keyword in user input
    if (keywordMap != NULL) //search for substring
    {
        printf("-----------------------------------\n");
        openMap();
        //printf("You are currently in: %d\n", playerLocation);
        printf("-----------------------------------\n");
        return 0;
    }

    char inv[] = "/inv";  //keyword
    char *keywordInv = strstr(userInput, inv); //search for keyword in user input
    if (keywordInv != NULL) //search for substring
    {
        printf("404\n");
        return 0;
    }
    //when no command gets recognized
    printf("unkown command.\n"
           "Try '/help'.\n");
    return 99;
}

int credits() {
    FILE *fp;
    int c;

    fp = fopen("credits2.txt","r");
    while(1) {
        c = fgetc(fp);
        if( feof(fp) ) {
            break;
        }
        printf("%c", c);
        int c, d;

        for (c = 1; c <= 600; c++)
            for (d = 1; d <= 600; d++)
            {}
    }
    fclose(fp);
    return 0;
}


/*return values
 *
 * go                   talk            use         look            misc
 * south    10          Name1   20                  up      40      unknown command 99
 * north    11          Name2   21                  down    41
 * west     12                                      left    42
 * east     13                                      right   43
 */


int savegameCreate() { //Unfinnished
    //freopen("Text.txt", "r",stdin);
    return 0;
}


//  struct playerstatus {
//  char playerName[64];
//  int playerLevel;
//	int playerHealthCUR;
//	int playerHealthMAX;
//  int playerLocation;
//};


int main() {
    int gameStatus = 0;
    credits();

    /*
     * Falls im Archiv des Spieles noch kein Savegame erstellt worden ist,
     * soll direkt der Dialog zur Erstellung eines Saves ersteinen.
     *
     * Wird ein Save gefunden, soll man in den Auswahl "Bildschrim" kommen.
     * Hier sind alle Saves aufgelistet mit dem Save "neues Spiel erstellen.
     */

    printf("Type '/help' to list all commands.\n");

    while (gameStatus != 1337) //Gameloop
    {
        gameStatus = commands();
        //printf("command %d executed.\n", gameStatus);
    }
    return 0;
}