#include <stdio.h>
#include <string.h>

void swap(char *a, char *b)
{
    char t = *a;
    *a = *b;
    *b = t;
}

void permute(char *s, int l, int r)
{
    if (l == r)
        printf("%s\n", s);
    else
    {
        int i;
        for (i = l; i <= r; i++)
        {
            swap(&s[l], &s[i]);
            permute(s, l+1, r);
            swap(&s[l], &s[i]);
        }
    } 
    
}

int main()
{
    char s[] = "abc";
    int n = strlen(s);
    permute(s, 0, n-1);
    return 0;    
}

