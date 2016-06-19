#include <stdio.h>
#include <string.h>

int max(int a, int b)
{
    return (a > b) ? a : b;
}

int lcs_dp(char *s1, char *s2, int m, int n)
{
    int dp[m+1][n+1];
    int i, j;

    for (i = 0; i <= m; i++)
        for (j = 0; j <= n; j++)
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else
            if (s1[i-1] == s2[j-1])
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);

    return dp[m][n];
}

int lcs_recursive(char *s1, char *s2, int m, int n)
{
    if (m == 0 || n == 0)
        return 0;
    if (s1[m] == s2[n])
        return 1 + lcs_recursive(s1, s2, m-1, n-1);
    else
        return max(lcs_recursive(s1, s2, m-1, n), lcs_recursive(s1, s2, m, n-1));
}

int main()
{
    char s1[] = "aggtab";
    char s2[] = "gxtxayb";
    int m = strlen(s1);
    int n = strlen(s2);

    printf("LCS for %s and %s is: %d\n", s1, s2, lcs_recursive(s1, s2, m, n));
    printf("LCS for %s and %s is: %d\n", s1, s2, lcs_dp(s1, s2, m, n));
    return 0;    
}

