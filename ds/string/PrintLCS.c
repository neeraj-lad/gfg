#include <stdio.h>
#include <string.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

void print_lcs(char *s1, char *s2, int m, int n)
{
    int dp[m+1][n+1];
    int i, j;
    for (i = 0; i <= m; i++)
        for (j = 0; j <= n; j++)
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else
            if (s1[i-1] == s2[j-1])
                dp[i][j] = 1 + dp[i-1][j-1];
            else
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);

    int index = dp[m][n];
    char lcs[index+1];
    lcs[index] = '\0';

    i = m, j = n;
    while (i > 0 && j > 0)
        if (s1[i-1] == s2[j-1])
        {
            lcs[index-1] = s1[i-1];
            i--, j--, index--;
        }
        else
        if (dp[i-1][j] > dp[i][j-1])
            i--;
        else
            j--;

    printf("LCS of %s and %s is %s\n", s1, s2, lcs);
}

int main()
{
    char s1[] = "aggtab";
    char s2[] = "gxtxayb";
    int m = strlen(s1);
    int n = strlen(s2);
    print_lcs(s1, s2, m, n);
    return 0;    
}

