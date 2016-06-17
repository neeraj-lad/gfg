#include <stdio.h>
#include <stdbool.h>

bool is_numeric(char c)
{
    return (c >= '0' && c <= '9');
}

int atoi(char *s)
{
    if (s == NULL)
    {
        printf("Null String. Incorrect Input\n");
        return 0;
    }

    int res = 0, sign = 1, i = 0;

    if (s[i] == '-')
    {
        sign = -1;
        i++;
    }

    for (; s[i] != '\0'; i++)
        if (is_numeric(s[i]))
            res = res * 10 + s[i] - '0';
        else
        {
            printf("Non-numeric String. Incorrect Input\n");
            return 0;
        }

    if (sign == -1)
        res *= -1;

    return res;
}

int main()
{
    char s[] = "-134";
    int v = atoi(s);
    printf("%d\n", v);
    return 0;    
}

