#include <stdio.h>

int main (){


    int variabile;              // variabile intera

    printf("Inserisci variabile: ");
    scanf("%d", &variabile);

    int *puntatore;             // puntatore ad un intero

    puntatore = &variabile;     // assegno al puntatore l'indirizzo di variabile


    printf("Valore variabile: %d\n", variabile);

    printf("Valore puntato dal puntatore con *: %d\n", *puntatore);  //restituisce valore effettivo puntato dal puntatore

    /*printf("Inserisci valore effettivo puntatore: ");
    scanf(" %p", &puntatore);                               // non posso dire io quale indirizzo mettere */


    printf("Puntatore: %p\n", &puntatore);        //restituisce indirizzo (0x....) del puntatore (NOTA "%p" e &puntatore)


}