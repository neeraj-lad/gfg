#include <stdio.h>
#include <stdbool.h>

bool is_path_circular(char *s)
{
    int dir = 0;
    int x = 0, y = 0;

    while (*s)
    {
        if (*s == 'G')
        {
            if (dir == 0)
                y++;
            else
            if (dir == 1)
                x++;
            else
            if (dir == 2)
                y--;
            else
                x--;
        }
        else
        {
            if (*s == 'L')
                dir = (4 + dir - 1) % 4;
            else
                dir = (dir + 4) % 4;
        }
        s++;
    }

    return (x == 0 && y == 0);
}

int main()
{
    char s[] = "GLGLGL";
    printf("Path is %s\n", s);
    if(is_path_circular(s))
        printf("Circular\n");
    else
        printf("Non Circular\n");
    return 0;    
}

