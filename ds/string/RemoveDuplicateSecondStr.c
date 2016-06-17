#include <stdio.h>
#include <stdlib.h>

int* get_count_array(char *str)
{
    int *count = (int *)calloc(sizeof(int), 256);
    int i;
    for (i = 0; *(str+i); i++)
        count[*(str+i)]++;
    return count;
}

char* remove_duplicate(char *s1, char *s2)
{
    int* count = get_count_array(s2);

    int i = 0, j = 0;

    while (*(s1+i))
    {
        if (count[*(s1+i)] == 0)
        {
            *(s1+j) = *(s1+i);
            j++;
        }
        i++;
    }
    *(s1+j) = '\0';

    return s1;
}

int main()
{
    char s1[] = "geeksforgeeks";
    char s2[] = "mask";

    printf("%s\n", remove_duplicate(s1, s2));

    return 0;    
}

