#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int commands() { 
	char help	[] = "/help";
	char quit	[] = "/quit";
	char go		[] = "/go";
    char use	[] = "/use";
    char talk	[] = "/talk";

	char userInput[] = "";
	//fgets(userInput, 20, stdin);
	scanf("%s", &userInput);

	if (strcmp(quit, userInput) == 0) {
          printf("The Game will shut down now.\n");
          return 1337;
	}
	else if (strcmp(help, userInput) == 0) {
		printf("\n");
		printf("/help	- This command here duh\n");
		printf("/quit	- quits the game.\n");
        printf("\n");
        printf("go		- \n");
        printf("use		- \n");
        printf("talk	- \n");
        printf("take	- \n");
        printf("\n");
        return 0;
	} 
	else if (strcmp(go,userInput) == 0) return 1;
	else if (strcmp(use, userInput) == 0) return 2;
	else if (strcmp(talk, userInput) == 0) return 3;

	printf("%s", userInput);
    printf("%s", quit);
	return 0; 
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
    }
    fclose(fp);
    return 0;
}

int savegameCreate() { //Unfinnished
	//freopen("Text.txt", "r",stdin);
	return 0;
}

//struct playerstatus {
//	char playerName[64];
//    int playerLevel;
//	int playerHealthCUR;
//	int playerHealthMAX;
//};

int main() {
	int gameStatus = 0;
	credits();
	//printf("[0] - Create savefile.\n");
    //printf("[1] - Load savefile.\n");

	/* 
	 * Falls im Archiv des Spieles noch kein Savegame erstellt worden ist, 
	 * soll direkt der Dialog zur Erstellung eines Saves ersteinen.
	 * 
	 * Wird ein Save gefunden, soll man in den auswahl "Bildschrim" kommen.
	 * Hier sind alle Saves aufgelistet mit dem Save "neues Spiel erstellen.
	 */ 

	printf("Type '/help' to list all commands.\n");

	while (gameStatus != 1337) { //Gameloop
		gameStatus = commands();
		printf("command %d executed.\n", gameStatus);
	}
	return 0;
}
