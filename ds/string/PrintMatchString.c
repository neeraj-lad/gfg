#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void print_match_string(char *word, char *list[], int list_size)
{
    int *count = (int *)calloc(sizeof(int), 256);

    int i;
    for (i = 0; word[i] != '\0'; i++)
        count[word[i]]++;

    int word_size = strlen(word);

    int j;
    printf("String containing same characters as \"%s\" are:\n", word);
    for (i = 0; i < list_size; i++)
    {
        int c = 0;
        for (j = 0; list[i][j] != '\0'; j++)
        {
            if (count[list[i][j]])
            {
                count[list[i][j]]--;
                c++;

                if (c == word_size)
                    break;
            }
       }
            if (c == word_size)
                printf("%s\n", list[i]);

            int k;
            for (k = 0; word[k] != '\0'; k++)
                count[word[k]]++;
    }
}

int main()
{
    char word[] = "sun";
    char *list[] = {"geeksforgeeks", "utensils", "samsung", "bunsen"};
    int list_size = sizeof (list) / sizeof(list[0]);
    print_match_string(word, list, list_size);
    return 0;    
}

