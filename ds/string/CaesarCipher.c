#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* decrypt(char *s, int shift)
{
    char *res = (char *)malloc(sizeof(char) * strlen(s));

    int i;
    for (i = 0; i < strlen(s); i++)
        if (isupper(s[i]))
        {
            if (s[i] - shift < 'A')
            {
                int diff = 'A' - (s[i] - shift);
                res[i] = (char)('Z' - (diff - 1));
            }
            else
                res[i] = (char)((s[i] - shift - 'A') % 26 + 'A');
        }
        else
        {
            if (s[i] - shift < 'a')
            {
                int diff = 'a' - (s[i] - shift);
                res[i] = (char)('z' - (diff - 1));
            }
            else
                res[i] = (char)((s[i] - shift - 'a') % 26 + 'a');
        }

    res[i] = '\0';
    return res;
}

char* encrypt(char *s, int shift)
{
    char *res = (char *)malloc(sizeof(char) * strlen(s));

    int i;
    for (i = 0; i < strlen(s); i++)
        if (isupper(s[i]))
            res[i] = (char)((s[i] + shift - 'A') % 26 + 'A');
        else
            res[i] = (char)((s[i] + shift - 'a') % 26 + 'a');

    res[i] = '\0';
    return res;
}

int main()
{
    //char text[] = "attackatDAWN";
    char text[] = "PQRSTUVWXYZabcdef";
    int shift = 4;
    char *enc = encrypt(text, shift);
    char *dec = decrypt(enc, shift);

    printf("Text = %s, Encryption = %s, Decryption = %s\n", text, enc, dec);
    return 0;    
}

