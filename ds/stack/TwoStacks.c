#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct TwoStacks
{
    int top1, top2;
    int capacity;
    int *array;
};

struct TwoStacks* createStack(int capacity)
{
    struct TwoStacks *ts = (struct TwoStacks*)malloc(sizeof(struct TwoStacks));
    ts->top1 = -1;
    ts->top2 = capacity;
    ts->capacity = capacity;
    ts->array = (int *)malloc(sizeof(int) * capacity);
    memset(ts->array, 0, sizeof(ts->array));
    return ts;
}

int is_full(struct TwoStacks *ts)
{
    return (ts->top1 + 1 == ts->top2);
}

int is_empty1(struct TwoStacks *ts)
{
    return (ts->top1 == -1);
}

int is_empty2(struct TwoStacks *ts)
{
   return (ts->top2 == ts->capacity-1); 
}

void push1(struct TwoStacks *ts, int n)
{
    if (is_full(ts))
    {
        printf("Stack 1 is Full\n");
        return;
    }
    ts->array[++ts->top1] = n;
}

void push2(struct TwoStacks *ts, int n)
{
    if (is_full(ts))
    {
        printf("Stack 2 is Full\n");
        return;
    }
    ts->array[--ts->top2] = n;
}

int pop1(struct TwoStacks *ts)
{
    if (is_empty1(ts))
    {
        printf("Stack 1 is Empty\n");
        return;
    }
    return ts->array[ts->top1--];
}

int pop2(struct TwoStacks *ts)
{
    if (is_empty2(ts))
    {
        printf("Stack 2 is Empty\n");
        return;
    }
    return ts->array[ts->top2--];
}

void print_stacks(struct TwoStacks *ts)
{
    int i;
    for (i = 0; i < ts->capacity; i++)
        printf("%d ", ts->array[i]);
    printf("\n");
}


int main()
{
    struct TwoStacks *ts = createStack(10);
    print_stacks(ts);
    printf("Push to Stack 1: %d\n", 5);
    push1(ts, 5);
    print_stacks(ts);
    printf("Push to Stack 2: %d\n", 10);
    push2(ts, 10);
    print_stacks(ts);
    printf("Push to Stack 2: %d\n", 15);
    push2(ts, 15);
    print_stacks(ts);
    printf("Push to Stack 1: %d\n", 11);
    push1(ts, 11);
    print_stacks(ts);
    printf("Push to Stack 2: %d\n", 7);
    push2(ts, 7);
    print_stacks(ts);
    printf("Popped from Stack 1: %d\n", pop1(ts));
    print_stacks(ts);
    printf("Popped from Stack 2: %d\n", pop2(ts));
    print_stacks(ts);
    return 0;    
}

