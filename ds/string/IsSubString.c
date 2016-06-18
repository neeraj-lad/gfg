#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool is_substring_iterative(char *s1, char *s2, int m, int n)
{
    int i, j = 0;
    for (i = 0; i < m && j < n; i++)
        if (s1[i] == s2[j])
            j++;

    return (j == n);
}

bool is_substring_recursive(char *s1, char *s2, int m, int n)
{
     if (n < 0)
       return true;
     if (m < 0)
       return false;

   if (s1[m] == s2[n])
       return is_substring_recursive(s1, s2, m-1, n-1);
   else
       return is_substring_recursive(s1, s2, m-1, n);
}

int main()
{
    char *s1 = "geeksforgeesk";
    char *s2 = "gksfrgsk";
    int m = strlen(s1);
    int n = strlen(s2);

    if (is_substring_recursive(s1, s2, m, n))
        printf("%s is a Substring of %s\n", s1, s2);
    else
        printf("%s is not a Substring of %s\n", s1, s2);
     if (is_substring_iterative(s1, s2, m, n))
        printf("%s is a Substring of %s\n", s1, s2);
    else
        printf("%s is not a Substring of %s\n", s1, s2);
    return 0;    
}

