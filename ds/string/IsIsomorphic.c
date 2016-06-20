#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool is_isomorphic(char *s1, char *s2)
{
    int m = strlen(s1);
    int n = strlen(s2);

    if (m != n)
        return false;


    bool *vis = (bool *)malloc(sizeof(bool) * 256);
    memset(vis, false, sizeof(vis));

    int *map = (int *)malloc(sizeof(int) * 256);
    int i;
    for (i = 0; i < 256; i++)
        map[i] = -1;

    for (i = 0; i < strlen(s1); i++)
        if (map[s1[i]] == -1)
        {
            if (vis[s2[i]]) 
                return false;

            vis[s2[i]] = true;
            map[s1[i]] = s2[i];
        }
        else
        if (map[s1[i]] != s2[i])
            return false;

    return true;
}

int main()
{
    char s1[] = "aabc";
    char s2[] = "xxyz";
    if (is_isomorphic(s1, s2))
        printf("%s and %s are Isomorphic\n", s1, s2);
    else
        printf("%s and %s are not Isomorphic\n", s1, s2);
    return 0;    
}

