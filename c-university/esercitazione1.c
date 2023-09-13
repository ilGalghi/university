#include <stdio.h>

// dichiarazioni delle funzioni per gli esercizi
void esercizio1();
void esercizio2();
void esercizio3();
void esercizio4();
void esercizio5();
void esercizio6();
void esercizio7();
void esercizio8();
void esercizio9();
void esercizio10();
void esercizio11();
void esercizio12();
void esercizio13();
void esercizio14();

//main
int main() {
    int scelta;
    
    printf("Seleziona l'esercizio da eseguire (1-14): ");
    scanf("%d", &scelta);
    
    // seleziona l'esercizio in base alla scelta dell'utente
    switch (scelta) {
        case 1:
            esercizio1();
            break;
        case 2:
            esercizio2();
            break;
        case 3:
            esercizio3();
            break;
        
        case 4:
            esercizio4();
            break;

        case 5:
            esercizio5();
            break;

        case 6:
            esercizio6();
            break;

        case 7:
            esercizio7();
            break;

        case 8:
            esercizio8();
            break;

        case 9:
            esercizio9();
            break;

        case 10:
            esercizio10();
            break;

        case 11:
            esercizio11();
            break;

        case 12:
            esercizio12();
            break;

        case 13:
            esercizio13();
            break;

        case 14:
            esercizio14();
            break;
        // case per gli altri esercizi...
        default:
            printf("L'esercizio selezionato non esiste\n");
            break;
    }
    
    return 0;
}

// implementazione delle funzioni per gli esercizi
void esercizio1() {
    // codice per l'esercizio 1

    int a,x,b;
    printf("CALCOLO EQUAZIONE a x + b = 0:\n");
    printf("Inserire A: ");
    scanf("%i", &a);
    printf("Inserire B: ");
    scanf("%i", &b);

    x = b/(-a);
    printf("x vale: %i\n", x);
}


void esercizio2() {
    // codice per l'esercizio 2
    
    float a, b, c, tot;
    float media;
    
    c = 0;

    printf("CALCOLO MEDIA ARITMETICA (0 per finire):\n");
    printf("Inserire numero A1: ");
    scanf("%f", &a);

    tot = a;

    while (b != 0) {
        
        printf("Inserire numero B: ");
        scanf("%f", &b);

        tot += b;

        c +=1;

    }

    //printf("Il totale è: %f\n", tot);
    //printf("Il C è: %f\n", c);

    media = tot/c;

    printf("La media è: %f\n", media);


}


void esercizio3() {
    // codice per l'esercizio 3
    

    int x, i, j;
    
    j = 0;

    printf("CALCOLO QUADRATO CON *:\n");

    printf("Inserisci numero: ");
    scanf("%i", &x);

    for (i=0; i < x; i++){

        //printf("I= %i", i);

        for (j=0; j < x; j++){

            //printf("J= %i", j);

            printf("*");

        }

        printf("*\n");
    }

}


void esercizio4() {
    // codice per l'esercizio 4
    

    int x, i, j, k,s,l;

    printf("CALCOLO LATI QUADRATO CON *:\n");

    printf("Inserisci numero: ");
    scanf("%i", &x);


    //PRIMA RIGA
    for (l=0; l < x-1; l++){

            //printf("l= %i", l);

            printf("*");
    }

    printf("*\n");

    for (i=0; i < x-2; i++){

        //printf("I= %i", i);

        for (j=0; j<1; j++){

            //printf("J= %i", j);

            printf("*");


            for (k=0; k < x-2; k++){

                //printf("k= %i", k);

                printf(" ");

            }

            printf("*\n");

        }

    }


    //ULTIMA RIGA
    for (s=0; s < x-1; s++){

        //printf("s= %i", s);

        printf("*");
    }

    printf("*\n");

}


void esercizio5() {
    // codice per l'esercizio 5
    

    int c,n,f,f1,f2;

    c=0;
    f=1;
    f1=1;
    f2=2;

    printf("CALCOLO CIFRE FIBONACCI\n");

    printf("Inserisci numero cifre: ");
    scanf("%i", &n);

    printf("1\n");

    while (c<n-1){

        printf("%i \n", f);
     
        f = f1+f2;
        f1 = f2;
        f2 = f;

        c+=1;
    }

}


void esercizio6() {
    // codice per l'esercizio 6
    
    int N, M;
    printf("CALCOLO SCACCHIERA\n");
    printf("Valori N e M (M sottomultiplo di N):\n");
    printf("Inserisci N: ");
    scanf("%i", &N);

    printf("Inserisci M: ");
    scanf("%i", &M);

    int row, col, block_row, block_col;
    for (row = 0; row < N*M; row++) {
        block_row = row / M;
        for (col = 0; col < N*M; col++) {
            block_col = col / M;
            if ((block_row + block_col) % 2 == 0) {
                printf("**");
            } else {
                printf("--");
            }
        }
        printf("\n");
    }

    return;
}




void esercizio7() {
    // codice per l'esercizio 7
   
    printf("CALCOLARE MINIMO (0 per finire):\n");
    int n,m,N;
        

    printf("Inserire numero: ");
    scanf("%i", &n);

    m=n;

    while (N!=0){

        printf("Inserire numero: ");
        scanf("%i", &N);


        if (N<m && N!=0){

            m=N;
        }

        //printf("M=%i \n", m);

    }

    printf("Il minimo è %i\n", m);

}


void esercizio8() {
    // codice per l'esercizio 8

    int n,m,N;

    printf("STAMPA ASTERISCHI (0 per finire):\n");

    N=1;
    
    while (N!=0){

        printf("Inserire numero: ");
        scanf("%i", &N);
        
        
        for (n=0; n<N-1; n++){


            printf("*");



        }

        if (N!=0){


        
        printf("*\n");
        }

    }


}


void esercizio9() {
    // codice per l'esercizio 9

    int n, bit, result = 0, weight = 1;
    printf("Inserisci il numero di bit del numero binario: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        printf("Inserisci il bit %d: ", i);
        scanf("%d", &bit);
        if (bit == 1) {
            result += weight;
        }
        weight *= 2;
    }
    printf("Il numero decimale corrispondente è %d\n", result);
    return;
}


void esercizio10() {
    // codice per l'esercizio 10
    
    int a,i,k,c;

    printf("CALCOLO TRIANGOLO FLOYD:\n");
    printf("Inserire numero: ");
    scanf("%i", &a);
    c =1;


    for (i=0; i<=a; i++){

        for (k=1; k<=i; k++){


            printf("%i ", c);
            c+=1;
        }

    printf("\n");
    }

}


void esercizio11() {
    // codice per l'esercizio 11

    int a, b, MIN, c, MCD, mcm;

    c = 1;

    printf("CALCOLO MCD e mcm: \n");

    printf("Inserisci n1: ");
    scanf("%i", &a);

    printf("Inserisci n2: ");
    scanf("%i", &b);

    if (a<b)

        MIN = a;

    else
        MIN = b;
    


    while (c <= MIN){

        if ((a%MIN==0) && (b%MIN==0)){

            MCD = MIN;
            break;
            
        }
        else{
            MIN-=1;
        }

    }

    printf("MCD = %i \n", MCD);
    printf("mcm = %i \n", (a*b)/MCD);


}


void esercizio12() {
    // codice per l'esercizio 12

    float a, Rn, Rn1, R;
    int n;

    printf("CALCOLO RADICE QUADRATA (approx 100):\n");

    printf("Inserisci numero: ");
    scanf("%f", &a);

    Rn = a/2;

    for (n=0; n<100; n++){

        R = ((Rn + (a/Rn)) / 2);        

        //printf("N vale %i \n", n);

        Rn = R;

    }

    printf("%f \n", R);

}


void esercizio13() {
    // codice per l'esercizio 13

    int R;
    printf("CALCOLO CERCHIO RAGGIO n:\n");
    printf("Inserisci il raggio del cerchio: ");
    scanf("%d", &R);

    for (int y = -R; y <= R; y++) {
        for (int x = -R; x <= R; x++) {
            if (x*x + y*y <= R*R) {
                printf("*");
            } else {
                printf("_");
            }
        }
        printf("\n");
    }

    return;
}







//codice per esercizio 14

int is_extraordinary(int n){
    int digits[10] = {0};
    int i, product, digit;
    for (i = 0; i < 7; i++) {
        digits[n % 10]++;
        n /= 10;
    }
    for (i = 2; i <= 6; i++) {
        product = n * i;
        while (product > 0) {
            digit = product % 10;
            if (digits[digit] == 0) {
                return 0;
            }
            product /= 10;
        }
    }
    return 1;
}

void esercizio14() {
    // codice per l'esercizio 14

    int n = 1234567;
    while (!is_extraordinary(n)) {
        n++;
    }
    printf("Il più piccolo numero straordinario è %d\n", n);
}
