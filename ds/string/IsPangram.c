#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool is_pangram(char *s)
{
   int *count = (int *)calloc(sizeof(int), 26);
   int i;
   for (i = 0; s[i]; i++)
   {
        if ('A' <= s[i] && s[i] <= 'Z')
            count[s[i] - 'A'] = 1;
        else
        if ('a' <= s[i] && s[i] <= 'z')
            count[s[i] - 'a'] = 1;
   }
   for (i = 0; i < 26; i++)
       if (count[i] == 0)
           return false;

   return true;
}

int main()
{
    char s[] = "The quick brown fox jumps over the lazy dog";
    if (is_pangram(s))
        printf("\"%s\" is a Pangram\n", s);
    else
        printf("\"%s\" is not a Pangram\n", s);
    return 0;    
}

