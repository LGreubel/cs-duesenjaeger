#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#include "commands.h"
#include "credits.h"

/*return values
 *
 * go                   talk            use         look            misc
 * south    10          Name1   20                  up      40      unknown command 99
 * north    11          Name2   21                  down    41
 * west     12                                      left    42
 * east     13                                      right   43
 */

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