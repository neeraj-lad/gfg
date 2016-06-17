#include <stdio.h>

int count_words(char *s)
{
    int count = 0;
    char *t = s;
    int flag = 0;       //when word is seen, set flag to 1

    while (*t)
    {
        if (*t == ' ' || *t == '\n' || *t == '\t')
            flag = 0;
        else
        if (flag == 0)  //first char after space
        {
            flag = 1;
            count++;
        }
        t++;
    }
    return count;
}

int main()
{
    char s[] = "  haha  i like   chipotle a lot    ";
    printf("\"%s\" has %d words\n", s, count_words(s));
    return 0;    
}

