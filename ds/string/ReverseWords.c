#include <stdio.h>

void reverse(char *begin, char *end)
{
    while (begin < end)
    {
        char t = *begin;
        *begin = *end;
        *end = t;
        begin++;
        end--;
    }
}

void reverse_words(char *s)
{
    char *start = NULL;
    char *end = s;

    while (*end)
    {
        if (start == NULL && *end != ' ')
            start = end;
        if (start != NULL && (*end == ' ' || *end == '\0'))
        {
            reverse(start, end-1);
            start = NULL;
        }
        end++;
    }
    reverse(s, end-1);
}

int main()
{
    char s[] = "   i am so so very happy!   !";
    printf("%s.\n", s);
    reverse_words(s);
    printf("%s.\n", s);
    
    return 0;    
}

