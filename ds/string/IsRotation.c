#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

bool is_rotation(char *s1, char *s2)
{
    int m = strlen(s1);
    int n = strlen(s2);

    if (m != n)
        return false;

    char *concat = (char *)malloc(sizeof(char) * 2 * m + 1);
    concat[0] = '\0';

    strcat(concat, s1);
    strcat(concat, s2);

    void *p = strstr(concat, s2);

    return p != NULL;
}

int main()
{
    char s1[] = "aabc";
    char s2[] = "bcaa";

    if (is_rotation(s1, s2))
        printf("%s and %s are rotations of each other\n", s1, s2);
    else
        printf("%s and %s are not rotations of each other\n", s1, s2);
    return 0;    
}

