#include <stdio.h>
#include <stdlib.h>

int main()
{

    int numero;
    scanf("%d", &numero);

    if(numero%2!=0){
        printf("impar");
    }else{
        printf("par");
    }

    fflush(stdout);
    return 0;
}
