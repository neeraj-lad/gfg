#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

bool is_palin(char *ct, int i, int j, char *p)
{
    int a = i, b = j;
    while (i < j)
    {
        if (ct[i] != ct[j])
            return false;
        i++, j--;
    }
    int k;
    for (k = 0; k < (b-a+1); k++)
        p[k] = ct[a+k];
    p[k] = '\0';

//    p = ct+a;
    return true;
}

bool is_rot_palin(char *s, char *p)
{
    int n = strlen(s);

    char *ct= (char *)malloc(sizeof(char) * 2 * n + 1);
    ct[0] = '\0';
    strcat(ct, s);
    strcat(ct, s);

    int i;
    for (i = 0; i < strlen(ct) - n + 1; i++)
        if (is_palin(ct, i, i+n-1, p))
            return true;

    return false;
}

int main()
{
    char s[] = "aab";
    char *p = (char *)malloc(sizeof(char) * (strlen(s) + 1));
    if (is_rot_palin(s, p))
        printf("%s is a rotation of Palindrome %s\n", s, p);
    else
        printf("%s is not a rotation of a Palindrome\n", s);

    char s1[] = "aaba";
    char *p1 = (char *)malloc(sizeof(char) * (strlen(s1) + 1));
    if (is_rot_palin(s1, p1))
        printf("%s is a rotation of Palindrome %s\n", s1, p1);
    else
        printf("%s is not a rotation of a Palindrome\n", s1);
 
    return 0;    
}

