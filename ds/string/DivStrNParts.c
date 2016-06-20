#include <stdio.h>
#include <string.h>

void divide_string(char *s, int n)
{
    int len = strlen(s);
    if (len % n != 0)
    {
        printf("\"%s\" cannot be divided into %d parts\n", s, n);
        return;
    }

    int part_len = len / n;

    char res[n+1][part_len+1];
    int i, j, k;
    j = 0, k = 0;
    for (i = 0; i < strlen(s); i++)
    {
        if (i % part_len == 0)
        {
            res[j][k] = '\0';
            j++, k = 0;
        }
        res[j][k++] = s[i];
    }

    for (j = 1; j <= n; j++)
        printf("%d -> %s\n", j, res[j]);
}

int main()
{
    char s[] = "a_simple_divide_string_quest";
    int n = 4;
    printf("s = %s and n = %d\n", s, n);
    divide_string(s, n);
    return 0;    
}

