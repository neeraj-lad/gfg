#include <stdio.h>
#include <stdlib.h>

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

int get_size(struct node *root)
{
    if (root == NULL)
        return 0;
    return 1 + get_size(root->left) + get_size(root->right);
}

int main()
{
    struct node *root = create_node(1);
    root->left = create_node(2);
    root->right = create_node(3);
    root->left->left = create_node(4);
    root->left->right = create_node(5);

    printf("Size of tree is %d\n", get_size(root));
    return 0;    
}

