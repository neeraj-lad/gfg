#include <stdio.h>
#include <stdlib.h>

void reverse(char *s, int i, int j)
{
    while (i < j)
    {
        char t = s[i];
        s[i++] = s[j];
        s[j--] = t;
    }
}

char* no_to_col(int n)
{
    char *res = (char *)malloc(sizeof(char) * 50);
    int i = 0;

    while (n)
    {
        int r = n % 26;
        if (r == 0)
        {
            res[i++] = 'Z';
            n = n / 26 - 1;
        }
        else
        {
            res[i++] = (r - 1) + 'A';
            n /= 26;
        }
    }
    res[i] = '\0';

    reverse(res, 0, i-1);
    return res;
}

int main()
{
    int n = 705;
    char *s = no_to_col(n);
    printf("%d => %s\n", n, s);
    return 0;    
}

