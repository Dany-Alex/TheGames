/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegames;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author goldtux
 */
public class TheGames {

  
String nombreGlobal;
    public static void main(String[] args) {
      
        TheGames objeto = new TheGames();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;                         //Guardarla opcion del usuario
        
        while (!salir) {
            System.out.println("******************************************************");
            System.out.println("\033[35mThe 3 Games");
            System.out.println("\u001B[0******************************************************");
            System.out.println("1. Anagrama");
            System.out.println("2. Dardos");
            System.out.println("3. 2048");
            System.out.println("0. Salir");

            try {                           //verificar si el usuario escribe un numero

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 0:
                        salir = true;
                        break;
                    case 1:
                        objeto.menu();
                        break;
                    case 2:
                        objeto.menuTarget();
                        break;
                    case 3:
                        objeto.iniciar();
                        objeto.MoverArriba();
                        objeto.ImprimirTablero();
                        objeto.GenerarAleatorio();
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }

        }
    }

    



    //------------------------------------------------------------------------------------
    //AQUI COMIENZA EL CODIGO DE SOPA
      
    Random aleatorio = new Random();
    String txt = "";
    int[] numeroAleatorio;
    String[] letrasAleatorias;

    private void juegoSopa() {
        String adivinacion, adivinacionMinuscula, palabraAdivinar;
        int lives = 2; // decalramos que va a tener 2 vida, esta variable sirve solo para que muestre cuantas vidas le quedan al usuario
        boolean igual;
        Scanner reader = new Scanner(System.in);
        System.out.println("******************************************************");
        System.out.println("\033[35mAnagrama");
        System.out.println("\u001B[0******************************************************");
        System.out.println("\033[32mTienes 3 Vidas");
        System.out.println("******************************************************");
        

        int n = letrasAleatorias.length;
        for (int i = 3; i > 0; i--) { // le indicamos que va acontar con 3 vidas y al fallar va a disminuir en 1

            System.out.println("Adivina la palabra: ");
            System.out.println("******************************************************");
            System.out.print("[ ");
            for (int k = 0; k <= n - 1; k++) { // recorremos el arreglo 
                if (letrasAleatorias[k] != null) { // imprime los que no tengon valor null
                    System.out.print(letrasAleatorias[k] + " ");// concatena las letras obtenidas del arreglo
                }
            }
            
            
            System.out.println("]");
            System.out.println("******************************************************");

            adivinacion = reader.next(); // se guarda en adivinacion lo que el usuario escreiba
            adivinacionMinuscula = adivinacion.toLowerCase(); // convertimos adivinacion en minusculas
            palabraAdivinar = txt.toLowerCase();// convertimos la palabra a adivinar en minusculas
            igual = palabraAdivinar.equals(adivinacionMinuscula); // verificamos si la palabra a adivinar y lo que el usuario escribio coinciden

            if (igual == true) { // si coinciden que le indique al usuario que gano

                System.out.println("******************************************************");
                System.out.println("\033[32mHas Ganado Felicidades!!!");
                i = 0;
                txt = " ";
            } else {// de lo contrario que le indique al usuario que perdio y que le muste cuantas vidas le quedan
                System.out.println("******************************************************");
                System.out.println("\033[31mFallaste..... te quedan " + lives+" vidas");
                System.out.println("******************************************************");
                lives--;

            }
        }// si no acierta en las tres opurtunidades que se le da al usuario muesta que perdio y cual era la palabra correcta
                    if (lives<=1) {
            System.out.println("******************************************************");
                System.out.println("\033[31mPerdiste..... la tespuesta correcta es: " + txt.toUpperCase());
                System.out.println("******************************************************");
        } 
        
    }

    private void addPalabra() {
        Scanner reader = new Scanner(System.in);
        System.out.println("******************************************************");
        System.out.println("\033[35mAnagrama");
        System.out.println("\u001B[0******************************************************");
        System.out.println("Ingresa una palabra:");
        System.out.println("******************************************************");
        txt = reader.next();                  //Leer palabra y se guarda en txt
        generarNumeroAleatorio(txt.toUpperCase()); //llamar al metodo generarNumerosAleatorios y enviarle el parametro txt       

    }

    private void menu() {
        Scanner read = new Scanner(System.in);
        boolean salir = false;
        int opcion;                         //Guardarla opcion del usuario
        TheGames objeto = new TheGames();
        while (!salir) {
        System.out.println("******************************************************");
        System.out.println("\033[35mAnagrama");
        System.out.println("\u001B[0******************************************************");
            System.out.println("1. Ingrear Palabras");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");

            try {                           //verificar si el usuario escribe un numero

                System.out.println("Escribe una de las opciones");
                opcion = read.nextInt();

                switch (opcion) {
                    case 1:

                        objeto.addPalabra();
                        break;
                    case 2:
                        objeto.juegoSopa();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                read.next();
            }

        }
    }

    private void generarNumeroAleatorio(String Palabra) {
        Random aleatorio = new Random();
        String[] numeroAleatorio = new String[Palabra.length() + 117];

        for (int l = 0; l < Palabra.length() + 117; l++) {
            int nran = aleatorio.nextInt(Palabra.length());  // se genera un numero aletorio
            numeroAleatorio[l] = "" + nran;                                //se gurada cada numeno aletario en un vector
        }
        for (int i = 0; i < numeroAleatorio.length; i++) {             // verifica si hay algun valor repertido
            for (int j = 0; j < numeroAleatorio.length - 1; j++) {
                if (i != j) {
                    if (numeroAleatorio[i].equals(numeroAleatorio[j])) {    // si hay valores repertidos
                        numeroAleatorio[i] = "";                     // eliminamos su valor

                    }
                }
            }
        }

        int n = numeroAleatorio.length;
        letrasAleatorias = new String[Palabra.length() + 117];
        String valor = "";
        for (int k = 0; k <= n - 1; k++) {                   //elige un valor de la pososcion 0 a la logitud del vector numeroAleatrio
            valor = numeroAleatorio[k];                     //valor es igual a algun numero aleatori guardado en el vector
            if (numeroAleatorio[k] != "") {                 // mostramos unicamente los que tienen no sean iguales a ""
                System.out.print(Palabra.charAt(Integer.parseInt(valor)));//convertimos valor en un entero e imprimimos el caracter de la palabra em la posisicon que valor nos indica
                letrasAleatorias[k] = "" + Palabra.charAt(Integer.parseInt(valor));//convertimos valor en un entero y gurdamos el caracter de la palabra em la posisicon que valor nos indica en un vector llamado letras
            }

        }
        System.out.println("");
    }
    //AQUI TERMINA EL CODIGO DE SOPA
    //------------------------------------------------------------------------------------
    
    
  //------------------------------------------------------------------------------------
    //AQUI COMIENZA EL CODIGO DE TARGET 
    
   
    int puntos;
    static int cantidadUsuarios;
    String[] names;
    int[] scores;
    
    static void CANTIDAD_JUGADORES() {
        TheGames objeto = new TheGames();
        Scanner read = new Scanner(System.in);
        int opcion, cantidadUsuarios;
        System.out.println("******************************************************");
        System.out.println("Elige una el numero de Jugador(es)");
        System.out.println("******************************************************");
        System.out.println("1. Jugardor");
        System.out.println("2. Jugardores");
        System.out.println("3. Jugardores");
        System.out.println("4. Jugardores");
        try {

            opcion = read.nextInt();

            switch (opcion) { 
                case 1:
                    cantidadUsuarios = 1;
                    objeto.Add_jugadores(cantidadUsuarios); // enviamos al metodo la cantidad de usuarios
                    break;
                case 2:
                    cantidadUsuarios = 2;
                    objeto.Add_jugadores(cantidadUsuarios);// enviamos al metodo la cantidad de usuarios
                    break;
                case 3:
                    cantidadUsuarios = 3;
                    objeto.Add_jugadores(cantidadUsuarios);// enviamos al metodo la cantidad de usuarios
                    break;
                case 4:
                    cantidadUsuarios = 4;
                    objeto.Add_jugadores(cantidadUsuarios);// enviamos al metodo la cantidad de usuarios
                    break;
                default:
                    System.out.println("Solo números entre 1 y 3");
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            read.next();
        }

    }

    void Add_jugadores(int cantidadUsuarios) {

        names = new String[cantidadUsuarios]; // crea un arreglo llamado names con tamaño de cantidad de usuario que le enviamos 
        Scanner ky = new Scanner(System.in);

        for (int i = 0; i < cantidadUsuarios; i++) { // agraga los usuario a un arreglo llamado names
            System.out.println("Ingrese el nombre para el jugador " + (i + 1) + " : ");
            names[i] = (ky.next());

        }
        Turno(cantidadUsuarios);// enviamos cantidad de usuario a turno 
    }

    public void Turno(int cantidadUsuarios) {
        scores = new int[cantidadUsuarios];
        int i = 0, j = 0,mayor = 0;
        String nameGanador = null;
        boolean seguir = true;
        
        do {
         
            for (i = 0; i < scores.length; i++) {
                if (scores[i] < 200) {// verificamos los punteos sean menores de 200 
                    for (j = 0; j < names.length; j++) {
                        if (scores[j] < 200) {// verificamos los punteos sean menores de 200 
                            System.out.println("******************************************************");
                            System.out.println("\033[33m| tunrno jugador: " + names[j]+ " | Puntos: "+scores[j]+" |"); // imprime al ugador y punteo dependiendo de su turno
                            
                            jugar(cantidadUsuarios, scores, j); // le enviamos a jugar la cantidad de usuario, los punteos y el turno
                            seguir = true;
                        } else {
                            seguir = false;
                            
                            break;
                        }
                    }
                } else {
                    seguir = false;
                     break;
                }
              
            }
        } while (seguir != false);
        
        for (int k = 0; k < names.length; k++) {
                                if (scores[k] > mayor) {
                                    mayor = scores[k];
                                    nameGanador=names[k];
                                }
             
                            }
        
        System.out.println("\033[32m------------------------------------------------------");
        System.out.println("\033[32mEl ganador es: " + nameGanador+" con "+mayor+" puntos");
        System.out.println("------------------------------------------------------\033[30m");
        
        for (int k = 0; k < scores.length; k++) {
                        if (scores[k] < 200) {
                            
                            seguir = true;
                        } else {
                            seguir = false;
                         
                            break;
                        }
                    } 

    }

    void jugar(int cantidadUsuarios, int scores[], int turnojugador) {
     
        System.out.println(opc_tiro(turnojugador, scores));
       
    }
    int opc_tiro(int turnojugador, int scores[]) {
  
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion, obtenido = 0; //Guardaremos la opcion del usuario
             for (int j = 0; j < scores.length; j++) { // verificamos los punteos sean menores de 200 
                        if (scores[j] < 200) {
                            
                            salir = false;
                        } else {
                            salir = true;
                         
                            break;
                        }
                    }               
        
        while (!salir) {
            System.out.println("******************************************************");
            System.out.println("\033[36mElige el tipo de tiro que sea realizar");
            System.out.println("\u001B[0******************************************************");
            System.out.println("1. Rápido con el dardo arriba del brazo");
            System.out.println("2. Controlado con el dardo arriba del brazo");
            System.out.println("3. Con el dardo bajo el brazo");
            System.out.println("4. Regresar al menu principal");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();                          

                switch (opcion) {
                    case 1:
                        obtenido = tiro1();                         // devuelve el valor que retorna tiro1
                        System.out.println("Has seleccionado 1. Rápido con el dardo arriba del brazo");
                        System.out.print("Puntos Obtenidos: " );
                        scores[turnojugador] = scores[turnojugador] + obtenido; //dependiendo del turno se le va a ir sumando el punteo a cada jugador 
                        return obtenido;

                    case 2:
                        obtenido = tiro2(); // devuelve el valor que retorna tiro2
                        System.out.println("Has seleccionado 2. Controlado con el dardo arriba del brazo");
                        System.out.print("Puntos Obtenidos: " );
                        scores[turnojugador] = scores[turnojugador] + obtenido;//dependiendo del turno se le va a ir sumando el punteo a cada jugador 
                        return obtenido;
                    case 3:
                        obtenido = tiro3(); // devuelve el valor que retorna tiro3
                        System.out.println("Has seleccionado 3. Con el dardo bajo el brazo");
                        System.out.print("Puntos Obtenidos: " );
                        scores[turnojugador] = scores[turnojugador] + obtenido;//dependiendo del turno se le va a ir sumando el punteo a cada jugador 
                        return obtenido;
                    case 4:
                        menuTarget(); // regresa el menu target
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        return obtenido;
    }
    int tiro1() {
        int[] punteo = {0, 50}; // se define un vector con 2 datos 
        int nran = aleatorio.nextInt(punteo.length); // se genera un numero aleatario 
        int tiro = punteo[nran]; 
        return tiro;
    }
    int tiro2() {
        int[] punteo = {10, 20, 30};// se define un vector con 3 datos
        int nran = aleatorio.nextInt(punteo.length);// se genera un numero aleatari
        int tiro = punteo[nran];//se guarda en tiro2 el valor obtenido 
        return tiro;
    }
    int tiro3() {
        int[] punteo = {0, 10, 20, 30, 40, 50};// se define un vector con 6 datos
        int nran = aleatorio.nextInt(punteo.length);// se genera un numero aleatari
        int tiro = punteo[nran];//se guarda en tiro3 el valor obtenido
        return tiro;
    }

    void menuTarget() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {
            System.out.println("******************************************************");
            System.out.println("\033[35mTAGET");
            System.out.println("\u001B[0******************************************************");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        CANTIDAD_JUGADORES(); // inicia el metodo cantidad jugadores

                        salir = true;
                        break;
                    case 2:
                         salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }

        } 
    }
    //AQUI TERMINA EL CODIGO DE TARGET
    //------------------------------------------------------------------------------------ 
    
 //------------------------------------------------------------------------------------
    //AQUI COMIENZA EL CODIGO DE 2048 
    
private final int[][] matriz = new int[4][4];

    private boolean perder = false;

    public void iniciar() {
        GenerarAleatorio();
        GenerarAleatorio();
        do {
            ImprimirTablero();
            Mover();
            perder = VerificarPerder();
            if (!perder) {
                GenerarAleatorio();
            }
        } while (!perder);
        System.out.println("Has Perdido!");
    }

    private void Mover() {
        boolean realizar = false;
        do {
            Scanner in = new Scanner(System.in);
            String respuesta=in.next().toLowerCase();
            char entrada =respuesta.charAt(0);

            switch (entrada) {
                case ('a'):
                    realizar = MoverIzquierda();
                    break;
                case ('d'):
                    realizar = MoverDerecha();
                    break;
                case ('w'):
                    realizar = MoverArriba();
                    break;
                case ('s'):
                    realizar = MoverAbajo();
                    break;
                default:
                    System.out.println("Solo puede seleccionar a,w,s,d");
            }
        } while (!realizar);
    }

    private boolean MoverAbajo() {
        System.out.println("MoverAbajo");

        boolean siguienteFila;
        boolean movimiento = false;

        for (int j = 0; j < 4; j++) {
            boolean[] collapsed = new boolean[4];
            do {
                siguienteFila = true;
                for (int i = 3; i > 0; i--) {
                    if ((matriz[i][j] == 0) && (matriz[i - 1][j] != 0)) {
                        matriz[i][j] = matriz[i - 1][j];
                        matriz[i - 1][j] = 0;
                        siguienteFila = false;
                        movimiento = true;
                    } else if ((matriz[i][j] != 0) && (matriz[i][j] == matriz[i - 1][j]) && !collapsed[i] && !collapsed[i - 1]) {
                        matriz[i][j] += matriz[i - 1][j];
                        matriz[i - 1][j] = 0;
                        collapsed[i] = true;
                        siguienteFila = false;
                        movimiento = true;
                    }
                }
            } while (!siguienteFila);
        }

        return movimiento;
    }

    private boolean MoverArriba() {
        System.out.println("Mover Arriba");

        boolean siguienteFila;
        boolean movimiento = false;

        for (int j = 0; j < 4; j++) {
            boolean[] collapsed = new boolean[3];
            do {
                siguienteFila = true;
                for (int i = 0; i < 3; i++) {
                    if ((matriz[i][j] == 0) && (matriz[i + 1][j] != 0)) {
                        matriz[i][j] = matriz[i + 1][j];
                        matriz[i + 1][j] = 0;
                        siguienteFila = false;
                        movimiento = true;
                    } else if ((matriz[i][j] != 0) && (matriz[i][j] == matriz[i + 1][j]) && !collapsed[i] && !collapsed[i + 1]) {
                        matriz[i][j] += matriz[i + 1][j];
                        matriz[i + 1][j] = 0;
                        collapsed[i] = true;
                        siguienteFila = false;
                        movimiento = true;
                    }
                }
            } while (!siguienteFila);
        }

        return movimiento;
    }

    private boolean MoverDerecha() {
        System.out.println("Mover Derecha");

        boolean siguienteFila;
        boolean movimiento = false;

        for (int i = 0; i < 4; i++) {
            boolean[] collapsed = new boolean[4];
            do {
                siguienteFila = true;
                for (int j = 3; j > 0; j--) {
                    if ((matriz[i][j] == 0) && (matriz[i][j - 1] != 0)) {
                        matriz[i][j] = matriz[i][j - 1];
                        matriz[i][j - 1] = 0;
                        siguienteFila = false;
                        movimiento = true;
                    } else if ((matriz[i][j] != 0) && (matriz[i][j] == matriz[i][j - 1]) && !collapsed[j] && !collapsed[j - 1]) {
                        matriz[i][j] += matriz[i][j - 1];
                        matriz[i][j - 1] = 0;
                        collapsed[j] = true;
                        siguienteFila = false;
                        movimiento = true;
                    }
                }
            } while (!siguienteFila);
        }

        return movimiento;
    }

    public boolean MoverIzquierda() {
        System.out.println("Mover Izquierda");

        boolean siguienteFila;
        boolean movimiento = false;

        for (int i = 0; i < 4; i++) {
            boolean[] collapsed = new boolean[3];
            do {
                siguienteFila = true;
                for (int j = 0; j < 3; j++) {
                    if ((matriz[i][j] == 0) && (matriz[i][j + 1] != 0)) {
                        matriz[i][j] = matriz[i][j + 1];
                        matriz[i][j + 1] = 0;
                        siguienteFila = false;
                        movimiento = true;
                    } else if ((matriz[i][j] != 0) && (matriz[i][j] == matriz[i][j + 1]) && !collapsed[j] && !collapsed[j + 1]) {
                        matriz[i][j] += matriz[i][j + 1];
                        matriz[i][j + 1] = 0;
                        collapsed[j] = true;
                        siguienteFila = false;
                        movimiento = true;
                    }
                }
            } while (!siguienteFila);
        }

        return movimiento;
    }

    private boolean VerificarPerder() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matriz[i][j] == 0) {
                    return false;
                } else if ((i != 0) && (matriz[i][j] == matriz[i - 1][j])) {
                    return false;
                } else if ((i != 3) && (matriz[i][j] == matriz[i + 1][j])) {
                    return false;
                } else if ((j != 0) && (matriz[i][j] == matriz[i][j - 1])) {
                    return false;
                } else if ((j != 3) && (matriz[i][j] == matriz[i][j + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    private void GenerarAleatorio() {
        boolean realizar = false;
        while (!realizar) {
            int n = (int) (Math.random() * 2);
            int m = (int) (Math.random() * 2);
            if (matriz[n][m] == 0) {
                matriz[n][m] = ((int) ((Math.random() * 2) + 1) * 2);
                realizar = true;
            }
        }
    }

    private void ImprimirTablero() {
        System.out.println("---------------------");
        System.out.println("|    |    |    |    |");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matriz[i][j] != 0) {
                    System.out.print(String.format("|%4d", matriz[i][j]));
                } else {
                    System.out.print("|    ");
                }
            }
            System.out.println("|\n|    |    |    |    |");
            if (i != 3) {
                System.out.println("|----|----|----|----|");
                System.out.println("|    |    |    |    |");
            } else {
                System.out.println("---------------------");
            }
        }
    }
    //AQUI TERMINA EL CODIGO DE 2048
     //------------------------------------------------------------------------------------
    
    
}
