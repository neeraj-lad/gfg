#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Stack
{
    int top;
    int capacity;
    int *array;
};

struct Stack* createStack(int capacity)
{
    struct Stack *st = (struct Stack*)malloc(sizeof(struct Stack));
    st->top = -1;
    st->capacity = capacity;
    st->array = (int *)malloc(sizeof(int) * capacity);
}

int is_full(struct Stack *st)
{
    return (st->top == st->capacity-1);
}

int is_empty(struct Stack *st)
{
    return (st->top == -1);
}

void push(struct Stack *st, int n)
{
    if (is_full(st))
    {
        printf("Stack Overflow\n");
        return;
    }
    st->array[++st->top] = n;
}

int pop(struct Stack *st)
{
    if (is_empty(st))
    {
        printf("Stack Underflow\n");
        return;
    }
    return st->array[st->top--];
}

int eval_postfix(char *exp)
{
    int n = strlen(exp);
    struct Stack *st = createStack(n);
    if (!st)
        return -1;

    int i;
    for (i = 0; i < n; i++)
        if (isdigit(exp[i]))
            push(st, exp[i] - '0');
        else
        {
            int v1 = pop(st);
            int v2 = pop(st);
            switch (exp[i])
            {
                case '+':   push(st, v2 + v1);
                            break;
                case '-':   push(st, v2 - v1);
                            break;
                case '*':   push(st, v2 * v1);
                            break;
                case '/':   push(st, v2 / v1);
                            break;
            }
        }
    return pop(st);
}

int main()
{
    char *exp = "231*+9-";
    printf("Postfix exp: %s is evaluated to %d\n", exp, eval_postfix(exp));
    return 0;    
}

