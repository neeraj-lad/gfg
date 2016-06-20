#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Stack
{
    int top;
    int capacity;
    char *array;
};

struct Stack* createStack(int capacity)
{
    struct Stack *st = (struct Stack*)malloc(sizeof(struct Stack));
    st->top = -1;
    st->capacity = capacity;
    st->array = (char *)malloc(sizeof(char) * capacity);
    return st;
}

int is_full(struct Stack *st)
{
    return (st->top == st->capacity-1);
}

int is_empty(struct Stack *st)
{
    return (st->top == -1);
}

void push(struct Stack *st, char c)
{
    if (is_full(st))
        return;
    st->array[++st->top] = c;
}

int pop(struct Stack *st)
{
    if (is_empty(st))
        return;
    return st->array[st->top--];
}

void reverse(char *s)
{
    int n = strlen(s);

    struct Stack *st = createStack(n);

    int i;
    for (i = 0; i < n; i++)
        push(st, s[i]);
    for (i = 0; i < n; i++)
        s[i] = pop(st);
}

int main()
{
    char s[] = "una tormenta que";
    printf("%s\n", s);
    reverse(s);
    printf("%s\n", s);
    return 0;    
}

