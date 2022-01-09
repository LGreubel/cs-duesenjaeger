#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int commands() { 
	char commands[2][20] = {"/help", "/quit"};
	char userInput[20];
	fgets(userInput, 20, stdin);

	//if (strcmp(commands[1][20], userInput)) return 1337;

	printf("%s", userInput);
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
	int game = 0;
	//credits();
	//printf("[0] - Create savefile.\n");
    //printf("[1] - Load savefile.\n");

	/* 
	 * 
	 * Falls im Archiv des Spieles noch kein Savegame erstellt worden ist, 
	 * soll direkt der Dialog zur Erstellung eines Saves ersteinen.
	 * 
	 * Wird ein Save gefunden, soll man in den auswahl "Bildschrim" kommen.
	 * Hier sind alle Saves aufgelistet mit dem Save "neues Spiel erstellen.
	 * 
	 * ichmagpfusch:
	 * goto ichmagpfusch;
	 */ 

	printf("Type '/help' to list all commands.");

	//Gameloop
        while (game != 1337) {
          game = commands();
	}
	return 0;
}
