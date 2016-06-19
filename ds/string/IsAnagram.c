#include <stdio.h>
#include <string.h>
#include <stdbool.h>

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
        if (s[j] <= x)
        {
            i++;
            swap(&s[i], &s[j]);
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

bool is_anagram(char *s1, char *s2)
{
    int m = strlen(s1);
    int n = strlen(s2);

    if (m != n)
        return false;

    quick_sort(s1, 0, m-1);
    quick_sort(s2, 0, n-1);

    int i;
    for (i = 0; i < m; i++)
        if (s1[i] != s2[i])
            return false;

    return true;
}

int main()
{
    char s1[] = "retest";
    char s2[] = "tesert";
    printf("%s %s\n", s1, s2);
    if (is_anagram(s1, s2))
        printf("They are Anagrams\n");
    else
        printf("They are not Anagrams\n"); 
    return 0;    
}
