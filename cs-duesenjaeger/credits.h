#pragma once
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int credits() {
  FILE *fp;
  int c;

  fp = fopen("credits2.txt", "r");
  while (1) {
    c = fgetc(fp);
    if (feof(fp)) {
      break;
    }
    printf("%c", c);
    int c, d;

    for (c = 1; c <= 600; c++)
      for (d = 1; d <= 600; d++) {
      }
  }
  fclose(fp);
  return 0;
}