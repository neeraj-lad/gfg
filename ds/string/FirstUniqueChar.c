#include <stdio.h>
#include <stdlib.h>

int* get_count_array(char *s)
{
    int *count = (int *)calloc(sizeof(int), 256);

    int i;
    for (i = 0; *(s+i); i++)
        count[*(s+i)]++;

    return count;
}

int first_unique_char(char *s)
{
    int *count = get_count_array(s);

    int i = 0, index = -1;
    while (*(s+i))
    {
        if (count[*(s+i)] == 1) 
        {
            index = i;
            break;
        }
        i++;
    }
    free(count);
    return index;
}

int main()
{
    char s[] = "geeksforgeeks";
    int index = first_unique_char(s);

    if (index == -1)
        printf("No Unique char exists\n");
    else
        printf("First Unique char is: %c\n", s[index]);

    return 0;    
}

