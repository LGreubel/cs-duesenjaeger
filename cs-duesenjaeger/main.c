#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int credits() { 
	printf("cs-duesenjaeger\n");
	printf("--- Projektlead\n");
    printf("	--- Lucas G.\n");
    printf("\n");

	printf("--- Development management\n");
	printf("--- Marvin R.\n");
	printf("\n");

	printf("--- Development\n");
	printf("	--- Maximilian K. x Kevin S. x Laurin L.\n");
	printf("\n");

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
	credits();
	printf("[0] - Create savefile.\n");
    printf("[1] - Load savefile.\n");

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
	while (true) {
          savegameCreate();
          break;
	}
	
	return 0;
}