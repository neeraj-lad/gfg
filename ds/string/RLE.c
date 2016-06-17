#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* encode(char *s)
{
    int len = strlen(s);
    char *res = (char *)malloc(sizeof(char) * 2 * len + 1);

    int i, j = 0;
    for (i = 0; i < len; i++)
    {
        res[j++] = s[i]; 

        int count = 1;
        for (i = i + 1; i < len; i++)
            if (s[i] == s[i-1])
                count++;
            else
                break;
        i--;

        int d;
        while (count)
        {
            d = count % 10;
            res[j++] = '0' + d;
            count /= 10;
        }
    }
    res[j] = '\0';

    return res;
}

int main()
{
    char *s = "aaabbbbccddddeee";
    char *res = encode(s);
    if (strlen(res) >= strlen(s))
        printf("%s => %s (%s)\n", s, s, res);
    else
        printf("%s => %s\n", s, res);
   
    char *s1 = "abcde";
    char *res1 = encode(s1);
    if (strlen(res1) >= strlen(s1))
        printf("%s => %s (%s)\n", s1, s1, res1);
    else
        printf("%s => %s\n", s1, res1);
    
    return 0;    
}

