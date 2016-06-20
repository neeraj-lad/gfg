#include <stdio.h>
#include <string.h>

void remove_spaces(char *s)
{
    int n = strlen(s);

    int i, j = 0;
    for (i = 0; i < n; i++)
        if (s[i] != ' ')
            s[j++] = s[i];
    s[j] = '\0';
    printf("\"%s\" has size %zd\n", s, strlen(s));
}

int main()
{
    char s[] = "  siento gran    vacio    pero dime  ";
    printf("\"%s\" has size %zd\n", s, strlen(s));
    remove_spaces(s);
    return 0;    
}

