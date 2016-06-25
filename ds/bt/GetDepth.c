#include <stdio.h>
#include <stdlib.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

struct node
{
    int data;
    struct node *left, *right;
};

struct node* create_node(int data)
{
    struct node *node = (struct node*)malloc(sizeof(struct node));
    node->data = data;
    node->left = NULL;
    node->right = NULL;
}

int get_depth(struct node *root)
{
    if (root == NULL)
        return 0;
    return 1 + max(get_depth(root->left), get_depth(root->right));
}

int main()
{
    struct node *root = create_node(1);
    root->left = create_node(2);
    root->right = create_node(3);
    root->left->left = create_node(4);
    root->left->right = create_node(5);

    printf("Depth of the tree is %d\n", get_depth(root));
    return 0;    
}

