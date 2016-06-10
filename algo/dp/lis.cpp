#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int lis_dp(int a[], int n)
{
    int dp[n];
    for (int i = 0; i < n; i++)
        dp[i] = 1;
    for (int i = 1; i < n; i++)
        for (int j = 0; j < i; j++)
            if (a[i] > a[j] && dp[i] < dp[j] + 1)
                dp[i] = dp[j] + 1;

    int mx = -1;
    for (int i = 0; i < n; i++)
        mx = max(mx, dp[i]);
    return mx;
}

int lis(int a[], int n, int i, int j)
{
    if (i == n)
        return 0;
    if (i == j)
        return lis(a, n, i+1, j) + 1;
    if (a[i] >= a[j])
        return max(lis(a, n, i+1, i) + 1, lis(a, n, i+1, j));
    else
        return lis(a, n, i+1, j);
}

int main()
{
    int a[] = {10, 22, 9, 33, 21, 50, 41, 60};
    int n = sizeof a / sizeof a[0];
    cout << "Length of Longest Increasing Subsequence is: " << lis(a, n, 0, 0) << endl;

    cout << "Length of Longest Increasing Subsequence using DP is: " << lis_dp(a, n) << endl;
	return 0;
}

