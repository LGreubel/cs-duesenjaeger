#include <stdio.h>
#include <stdbool.h>

int savegameCreate() { //Unfinnished
	char username[20];
	char savename[20];

	printf("What's your name?\n");
	fgets(username, 20, stdin);
	
	printf("Give your save a name.\n");
	fgets(savename, 20, stdin);

	FILE *out_file = fopen(savename, "w");
}

int main() {
	//Startupscreen
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

	printf("[0] - Create savefile.\n");
    printf("[1] - Load savefile.\n");

    bool saveisda = false;
	savegameCreate();
	/* 
	 * 
	 * Falls im Archiv des Spieles noch kein Savegame erstellt worden ist, 
	 * soll direkt der Dialog zur Erstellung eines Saves ersteinen.
	 * 
	 * Wird ein Save gefunden, soll man in den auswahl "Bildschrim" kommen.
	 * Hier sind alle Saves aufgelistet mit dem Save "neues Spiel erstellen.
	 * 
	 */ 

	//Gameloop
	while (true) {
		
          break;
	}

	return 0;
}