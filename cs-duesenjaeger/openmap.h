#pragma once
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

// open the map
int openMap() {
  FILE *fp;
  int c;

  fp = fopen("map.txt", "r");
  while (1) {
    c = fgetc(fp);
    if (feof(fp)) {
      break;
    }
    printf("%c", c);
  }
  fclose(fp);
  return 0;
}