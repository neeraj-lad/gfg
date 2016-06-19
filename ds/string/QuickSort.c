#include <stdio.h>
#include <string.h>

void swap(char *a, char *b)
{
    char t = *a;
    *a = *b;
    *b = t;
}

int partition(char *s, int start, int end)
{
    char x = s[end];
    int i = start-1, j;
    for (j = start; j < end; j++)
    {
        if (s[j] <= x)
        {
            i++;
            swap(&s[i], &s[j]);
        }
    }
    swap(&s[i+1], &s[end]);
    return (i+1);
}

void quick_sort(char *s, int start, int end)
{
    if (start < end)
    {
        int p = partition(s, start, end);
        quick_sort(s, start, p-1);
        quick_sort(s, p+1, end);
    }
}

int main()
{
    char s[] = "dolor te destapa.. si.. te";
    printf("%s\n", s);
    quick_sort(s, 0, strlen(s)-1);
    printf("%s\n", s);

    return 0;    
}

