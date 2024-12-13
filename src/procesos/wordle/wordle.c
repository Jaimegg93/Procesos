#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

// Función para obtener una palabra aleatoria
char* aleatoridad() {
    static char palabras[9][100] = {
        "MANZANA", "AEROPUERTO", "COCHE", "FELIPE",
        "RASCACIELOS", "CALIPO", "AZUCAR", "SILOFONO",
        "HIPOPOTOMONSTRUOESQUIPEDALEIOFOBIA"
    };
    srand(time(NULL)); // Inicializar la semilla para números aleatorios
    int i = rand() % 9;
    return palabras[i];
}

int main() {
    // Inicializar los arrays
    char palabra[100];
    strcpy(palabra, aleatoridad()); // Copiar la palabra aleatoria al array
    char intento[100];
    char wordle[100] = {0}; // Inicializar wordle con ceros

    printf("Intenta adivinar la palabra: ");
    scanf("%s", intento);

    // Comparar la palabra con el intento
    for (int i = 0; i < strlen(palabra); i++) {
        if (palabra[i] == intento[i]) {
            wordle[i] = intento[i]; // Si coincide, se copia el carácter
        } else {
            wordle[i] = ' '; // Si no coincide, se muestra un guion bajo
        }
    }
    wordle[strlen(palabra)] = '\0'; // Asegurar el carácter nulo al final

    printf("Resultado: %s\n", wordle);
    return 0;
}
