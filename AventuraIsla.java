/**
 * SEGUNDO AVANCE DEL PROYECTO: AVENTURA EN LA ISLA DEL TESORO
 * ENTREGABLE 02: "DESAFÍOS Y PISTAS"
 * 
 * CURSO:
 * INF-02 FUNDAMENTOS DE PROGRAMACIÓN SCP0
 * 
 * PROFESORA:
 * YUSSELIN MURCIA CÉSPEDES
 * 
 * GRUPO DE TRABAJO:
 * GRUPO E
 * 
 * ESTUDIANTES:
 * KENNETH CHAVES SOTO
 * LUIS ALEJANDRO BLANCO ÁLVAREZ
 **/ 


 import java.io.*;

 public class AventuraIsla {    
     //CREAR LOS OBJETOS DE ENTRADA Y SALIDA
     static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     static PrintStream out = System.out;
 
     //CREAR EL MAIN PRINCIPAL
     public static void main(String[] args) throws IOException {
         
        //DECLARACIÓN DE VARIABLES
        int location = 1, action, jugando = 1, puntos = 0;
        String inventario = "", objeto01 = "", objeto02 = "", objeto03 = "", objeto04 = "", respuestaAdivinanzaCueva;
    
        //MENSAJE AL INICIAR EL VIDEOJUEGO
        out.println("\n¡BIENVENIDO AL JUEGO DE LA AVENTURA EN ISLA DEL TESORO!");

        while (jugando == 1) { 
            
            //PLAYA
            if (location == 1) {
            out.println("\n--------------------\n\nEstás en la playa y lo ideal es avanzar.\nEl sol brilla, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti.");
            out.println("\n¿Qué deseas hacer?\n");
            out.println("1. Ir al Norte\n2. Examinar el cofre\n3. Salir del juego");
            out.print("\nIngrese el número que determinará tu acción: ");
            action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA
                switch (action) {
                    case 1 -> {location = 2;} //JUNGLA
                    case 2 -> {
                        if (inventario.contains("| Mapa |")) {
                            out.println("\n--------------------\n\nYa guardaste el mapa en tu inventario.");
                            out.println("Actualmente este es tu inventario: " + inventario);
                        }
                        else {
                            out.println("\n--------------------\n\n¡Hallaste un mapa dentro del cofre!");
                            objeto01 += "| Mapa |";
                            inventario += objeto01;
                            out.println("Actualmente este es tu inventario: " + inventario);
                            out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                            out.println("\n¡Recuerda bien estas instrucciones!"); 
                        } 
                    }
                    case 3 -> {jugando = 0;} //SALIR
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //JUNGLA
            if (location == 2) {
                out.println("\n--------------------\n\nLlegaste a la jungla.\nLos árboles son altos y la vegetación frondosa. Ves caminos en todas direcciones.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur\n5. Salir del juego");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA
                switch (action) {
                    case 1 -> {location = 4;} //RUINAS
                    case 2 -> {location = 3;} //CUEVA
                    case 3 -> {location = 5;} //MONTAÑA
                    case 4 -> {location = 1;} //PLAYA
                    case 5 -> {jugando = 0;}  //SALIR
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //CUEVA
            if (location == 3) {
                out.println("\n--------------------\n\nEstás en la entrada de una cueva.\nMiras hacia dentro, oyes ruidos extraños, pero está muy oscuro y no ves bien.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva\n3. Salir del juego");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA
                switch (action) {
                    case 1 -> {location = 2;} //JUNGLA
                    case 2 -> {location = 6;} //ACERTIJO
                    case 3 -> {jugando = 0;}  //SALIR
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //RUINAS
            if (location == 4) {
                out.println("\n--------------------\n\nLlegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Sur\n2. Recoger objeto en la entrada\n3. Examinar símbolos\n4. Salir del juego");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS
                switch (action) {
                    case 1 -> {location = 2;} //JUNGLA
                    case 2 -> {
                        if (inventario.contains("| Antorcha |")) {
                            out.println("\n--------------------\n\nYa guardaste la antorcha en tu inventario.");
                            out.println("Actualmente este es tu inventario: " + inventario);
                        }
                        else {
                            out.println("\n--------------------\n\n¡Recogiste una antorcha!");
                            objeto02 += "| Antorcha |";
                            inventario += objeto02;
                            out.println("Actualmente este es tu inventario: " + inventario);
                            out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");   
                        } 
                    }
                    case 3 -> {location = 7;} //ACERTIJO
                    case 4 -> {jugando = 0;} //SALIR
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //MONTAÑA
            if (location == 5) {
                out.println("\n--------------------\n\nEstás estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo\n3. Intentar escalar\n4. Salir del juego");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA
                switch (action) {
                    case 1 -> {location = 2;} //JUNGLA
                    case 2 -> {
                        if (inventario.contains("| Pico |")) {
                            out.println("\n--------------------\n\nYa guardaste la pico en tu inventario.");
                            out.println("Actualmente este es tu inventario: " + inventario);
                        }
                        else {
                            out.println("\n--------------------\n\n¡Hallaste una pico!");
                            objeto03 += "| Pico |";
                            inventario += objeto03;
                            out.println("Actualmente este es tu inventario: " + inventario);
                            out.println("\nAhora podrás excavar o romper en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertos lugares!");
                            out.println("Regresemos y sigamos explorando.");  
                        }
                    }
                    case 3 -> {location = 8;} //ACERTIJO
                    case 4 -> {jugando = 0;}  //SALIR
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }
            
            //ACERTIJOS Y PUNTUACIÓN
            
            //ACERTIJO DE LA CUEVA
            if (location == 6) {
                if (inventario.contains("| Antorcha |")) {        
                    out.println("\n--------------------\n\n¡Tienes la antorcha! Puedes explorar dentro.\nLlegaste al fondo de la cueva y ves un cofre con seguro y una nota que dice:\n\n'¿Qué será, qué es, que mientras más grande, menos ves?'\n\nSi respondes el acertijo se abrirá el cofre.");
                    out.println("\n¿Qué deseas hacer?\n");
                    out.println("1. Tratar de resolver la adivinanza\n2. Dejarlo para más adelante\n3. Salir del juego");
                    out.print("\nIngrese el número que determinará tu acción: ");
                    action = Integer.parseInt(in.readLine());

                    //ACCIONES QUE SE PUEDEN HACER DENTRO DE LA CUEVA
                    switch (action) {
                        case 1 -> {
                            out.print("\nIntenta adivinar la respuesta correcta: ");
                            respuestaAdivinanzaCueva = in.readLine();
                            if (respuestaAdivinanzaCueva.equalsIgnoreCase("La oscuridad")) {
                                puntos ++;
                                if (inventario.contains("| Libro traductor |")) {
                                    out.println("\n--------------------\n\nYa guardaste el libro traductor en tu inventario.");
                                    out.println("Actualmente este es tu inventario: " + inventario);
                                }
                                else {
                                    out.println("\n--------------------\n\n¡Respuesta correcta! El cofre se ha abierto.\nHallaste un libro que sirve para traducir símbolos extraños.");
                                    objeto04 = "| Libro traductor |";
                                    inventario += objeto04;
                                    out.println("Actualmente este es tu inventario: " + inventario);
                                    out.println("\n¡Obtuviste +" + puntos + " punto por resolver el acertijo!\nLlevas "+ puntos + "/4 acertijos resueltos. ¡Ve a por más!");
                                    out.println("\nEn fin, salgamos de la cueva..."); 
                                    location = 3;
                                }
                            } 
                            else {
                                out.println("\n--------------------\n\nRespuesta incorrecta...");
                                location = 6;                               
                            }
                        }
                        case 2 -> {location = 3;}
                        case 3 -> {jugando = 0;}
                        default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                    }
                }
                else {
                    out.println("Está muy oscuro. Quizá más adelante halles algo que te pueda servir para ver mejor.");
                    location = 3;
                }
            }
            //ACERTIJO RUINAS
            
        }
        //MENSAJE DE DESPEDIDA DEL VIDEOJUEGO
        out.println("\n--------------------\n\nGracias por jugar. ¡Hasta la próxima!");
    }
} //FIN DEL PROGRAMA