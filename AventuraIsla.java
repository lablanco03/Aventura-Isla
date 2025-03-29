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
     
    //OBJETOS DE ENTRADA Y SALIDA
     static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     static PrintStream out = System.out;
 
     //MAIN PRINCIPAL
     public static void main(String[] args) throws IOException {
         
        //DECLARACIÓN DE VARIABLES
        int location = 1, action, jugando = 1, puntos = 0;
        boolean faro = false;
        String inventario = "", objetoMapa, objetoAntorcha, objetoPico, objetoLibro, objetoArmadura, objetoEspada, respuestaAcertijos;
        
    
        //MENSAJE AL INICIAR EL VIDEOJUEGO
        out.println("\n¡BIENVENIDO AL JUEGO DE LA AVENTURA EN ISLA DEL TESORO!");

        while (jugando == 1) { 
            
            //PLAYA
            if (location == 1) {
            out.println("\n--------------------\n\nEstás en la playa y lo ideal es avanzar.\nEl sol brilla, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti.");
            out.println("\n¿Qué deseas hacer?\n");
            out.println("1. Ir al Norte\n2. Examinar el cofre\n3. Finalizar partida");
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
                            objetoMapa = "| Mapa |";
                            inventario += objetoMapa;
                            out.println("Actualmente este es tu inventario: " + inventario);
                            out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                            out.println("\n¡Recuerda bien estas instrucciones!"); 
                        } 
                    }
                    case 3 -> {jugando = 0;} //FINALIZAR PARTIDA
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //JUNGLA
            if (location == 2) {
                out.println("\n--------------------\n\nLlegaste a la jungla.\nLos árboles son altos y la vegetación frondosa. Ves caminos en todas direcciones.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur\n5. Finalizar partida");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA
                switch (action) {
                    case 1 -> {location = 4;} //RUINAS
                    case 2 -> {location = 3;} //CUEVA
                    case 3 -> {location = 5;} //MONTAÑA
                    case 4 -> {location = 1;} //PLAYA
                    case 5 -> {jugando = 0;}  //FINALIZAR PARTIDA
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //CUEVA
            if (location == 3) {
                out.println("\n--------------------\n\nEstás en la entrada de una cueva.\nMiras hacia dentro, oyes ruidos extraños, pero está muy oscuro y no ves bien.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva\n3. Finalizar partida");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA
                switch (action) {
                    case 1 -> {location = 2;} //JUNGLA
                    case 2 -> {location = 7;} //ACERTIJO
                    case 3 -> {jugando = 0;}  //FINALIZAR PARTIDA
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //RUINAS
            if (location == 4) {
                out.println("\n--------------------\n\nLlegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Sur\n2. Recoger objeto en la entrada\n3. Examinar símbolos extraños\n4. Finalizar partida");
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
                            objetoAntorcha = "| Antorcha |";
                            inventario += objetoAntorcha;
                            out.println("Actualmente este es tu inventario: " + inventario);
                            out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");   
                        } 
                    }
                    case 3 -> {location = 8;} //ACERTIJO
                    case 4 -> {jugando = 0;} //FINALIZAR PARTIDA
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //MONTAÑA
            if (location == 5) {
                out.println("\n--------------------\n\nEstás estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo\n3. Intentar escalar\n4. Finalizar partida");
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
                            objetoPico = "| Pico |";
                            inventario += objetoPico;
                            out.println("Actualmente este es tu inventario: " + inventario);
                            out.println("\nAhora podrás excavar o romper en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertos lugares!");  
                        }
                    }
                    case 3 -> {
                        if (inventario.contains("| Armadura |") || inventario.contains("| Espada |")) {
                            out.println("\n--------------------\n\n¡Subiste a la montaña!\n(POR AHORA HASTA AQUÍ TERMINA EL JUEGO)");
                            jugando = 0;
                        }
                        else {
                            out.println("\n--------------------\n\nLo más recomentable es subir con algún objeto que mejore tus habilidades para el combate.\n¿Estás seguro que deseas subir sin equipamiento útil?");
                            out.println("\n¿Qué deseas hacer?\n");
                            out.println("1. Subir de todas formas\n2. No subir y seguir explorando\n3. Finalizar partida");
                            out.print("\nIngrese el número que determinará tu acción: ");
                            action = Integer.parseInt(in.readLine());

                            //ELEGIR SI SUBIR O NO LA MONTAÑA SIN EL EQUIPO ADECUADO
                            switch (action) {
                                case 1 -> {
                                out.println("\n--------------------\n\n¡Subiste a la montaña!\n(POR AHORA HASTA AQUÍ TERMINA EL JUEGO)");
                                jugando = 0;
                            }
                                case 2 -> {location = 5;}
                                case 3 -> {jugando = 0;}
                                default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                            }
                        }
                    }
                    case 4 -> {jugando = 0;} //FINALIZAR PARTIDA
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            //BAHÍA PIRATA (ZONA SECRETA)
            if (location == 6) {
                faro = true;
                out.println("\n--------------------\n\n¡Estás en la bahía pirata! La zona más secreta de la isla.\nA lo lejos ves el faro tal como se esperaba y cerca tuyo ves un naufragio de lo que parece ser que fue un barco pirata.");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Volver a las ruinas\n2. Examinar el barco\n3. Finalizar partida");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA BAHÍA PIRATA
                switch (action) {
                    case 1 -> {location = 4;} //RUINAS
                    case 2 -> {location = 9;} //ACERTIJO
                    case 3 -> {jugando = 0;}  //FINALIZAR PARTIDA
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

            
            //ACERTIJO DE LA CUEVA
            if (location == 7) {
                if (inventario.contains("| Antorcha |")) {        
                    out.println("\n--------------------\n\n¡Tienes la antorcha! Puedes explorar dentro.\nLlegaste al fondo de la cueva y ves un cofre con seguro y una nota que dice:\n\n'¿Qué será, qué es, que mientras más grande, menos ves?'\n\nSi respondes el acertijo se abrirá el cofre.");
                    out.println("\n¿Qué deseas hacer?\n");
                    out.println("1. Tratar de resolver la adivinanza\n2. Dejarlo para más adelante\n3. Finalizar partida");
                    out.print("\nIngrese el número que determinará tu acción: ");
                    action = Integer.parseInt(in.readLine());

                    //ACCIONES QUE SE PUEDEN HACER DENTRO DE LA CUEVA
                    switch (action) {
                        case 1 -> {
                            out.print("\nIntenta adivinar la respuesta correcta: ");
                            respuestaAcertijos = in.readLine();
                            if (respuestaAcertijos.equalsIgnoreCase("La oscuridad")) {
                                if (inventario.contains("| Libro traductor |")) {
                                    out.println("\n--------------------\n\nYa guardaste el libro traductor en tu inventario.");
                                    out.println("Actualmente este es tu inventario: " + inventario);
                                }
                                else {
                                    out.println("\n--------------------\n\n¡Respuesta correcta! El cofre se ha abierto.\nHallaste un libro que sirve para traducir símbolos extraños.");
                                    objetoLibro = "| Libro traductor |";
                                    inventario += objetoLibro;
                                    out.println("Actualmente este es tu inventario: " + inventario);
                                    out.println("\nEn fin, salgamos de la cueva..."); 
                                    location = 3;
                                }
                            } 
                            else {
                                out.println("\n--------------------\n\nRespuesta incorrecta...");
                                               
                            }
                        }
                        case 2 -> {location = 3;} //CUEVA
                        case 3 -> {jugando = 0;}  //FINALIZAR PARTIDA
                        default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                    }
                }
                else {
                    out.println("\n--------------------\n\nEstá muy oscuro.\nQuizá más adelante halles algo que te pueda servir para ver mejor.");
                    location = 3;
                }
            }
            
            //ACERTIJO RUINAS
            if (location == 8) {
                if (inventario.contains("| Libro traductor |")) {
                    out.println("\n--------------------\n\n¡Tienes el libro traductor! Puedes interpretar los símbolos en la pared:\n\n'Tras estas ruinas encuentras el camino, romper el muro debes para llegar a tu destino.\nSoy vigilante y guardián de mi playa, con mis ojos guío a todo el que me halla\nCuando me veas, sabrás que has llegado y una recompensa te espera al otro lado.'\n\n¡El mensaje oculto nos dice que debes tirar abajo esta pared!");
                    out.println("\n¿Qué deseas hacer?\n");
                    out.println("1. Derribar el muro\n2. Dejarlo para más adelante\n3. Finalizar partida");
                    out.print("\nIngrese el número que determinará tu acción: ");
                    action = Integer.parseInt(in.readLine());

                    //ACCIONES QUE SE PUEDEN HACER CON LOS SÍMBOLOS DE LAS RUINAS
                    switch (action) {
                        case 1 -> {
                            if (inventario.contains("| Pico |")) {
                                out.println("\n--------------------\n\n¡Tienes el pico! Puedes derribar el muro e ir a explorar al otro lado.\nHas tirado la pared y encontraste un camino oculto. Sigues su largo trayecto y llegas a una nueva zona secreta...");
                                location = 6; //BAHÍA PIRATA
                                
                            } 
                            else {
                                out.println("\n--------------------\n\nEl muro es muy grande y pesado, necesitas una herramienta que te ayude.\nQuizá más adelante halles algo que te pueda servir.");
                                location = 4;
                            }
                        }
                        case 2 -> {location = 4;} //RUINAS
                        case 3 -> {jugando = 0;}  //FINALIZAR PARTIDA
                        default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}   
                    }
                }
                else {
                    out.println("\n--------------------\n\nNo tienes el conocimiento suficiente o una guía para entender qué dicen estos símbolos.\nQuizá más adelante halles algo que te pueda servir.");
                    location = 4;
                } 
            }

            //ACERTIJO BARCO PIRATA
            if (location == 9) {
                out.println("\n--------------------\n\n¡Estás dentro del barco pirata! Lleva bastante tiempo abandonado, lo exploras\ny en lo más profundo de sus restos te encuentras una bóveda resguardada por una trampa letal.\n\nPara desactivar la trampa debes ingresar un código oculto en las siguientes letras: 'F A R U N O G I A'\n\n¡Halla la palabra secreta y lo que hay en la bóveda será tuyo!");
                out.println("\n¿Qué deseas hacer?\n");
                out.println("1. Tratar de resolver el anagrama\n2. Dejarlo para más adelante\n3. Finalizar partida");
                out.print("\nIngrese el número que determinará tu acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER DENTRO DEL BARCO PIRATA
                switch (action) {
                    case 1 -> {
                        out.print("\nIntenta descifrar la palabra oculta: ");
                        respuestaAcertijos = in.readLine();
                        if (respuestaAcertijos.equalsIgnoreCase("NAUFRAGIO")) {
                            out.println("\n--------------------\n\n¡Respuesta correcta! La bóveda ha sido abierta.\nHallaste una armadura y una espada que puedes usar para mejorar tu defensa y ataques, pero solo puedes llevar uno de los objetos.");
                            out.println("\n¿Qué deseas hacer?\n");
                            out.println("1. Llevarte la armadura\n2. Llevarte la espada\n3. Finalizar partida");
                            out.print("\nIngrese el número que determinará tu acción: ");
                            action = Integer.parseInt(in.readLine());

                            //ELEGIR QUÉ OBJETO LLEVARSE DEL BARCO PIRATA
                            switch (action) {
                                case 1 -> {
                                    objetoArmadura = "| Armadura |";
                                    inventario += objetoArmadura;
                                    out.println("Actualmente este es tu inventario: " + inventario);
                                    out.println("\nEn fin, salgamos de las ruinas...");
                                    location = 4;
                                }
                                case 2 -> {
                                    objetoEspada = "| Espada |";
                                    inventario += objetoEspada;
                                    out.println("Actualmente este es tu inventario: " + inventario);
                                    out.println("\nEn fin, salgamos de las ruinas...");
                                    location = 4;
                                }
                                default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                                }
                            }
                        }
                        else {
                            out.println("\n--------------------\n\nRespuesta incorrecta...");
                        }
                    }
                    case 2 -> {location = 6;} //BAHÍA PIRATA
                    case 3 -> {jugando = 0;}  //FINALIZAR PARTIDA
                    default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");}
                }
            }

        }

        //PUNTAJE DE LA PARTIDA Y MENSAJE DE DESPEDIDA DEL VIDEOJUEGO
        if (inventario.contains("| Libro traductor |")) {
            puntos ++;
        } 
        else if (faro == true) {
            puntos ++;
        }
        else if (inventario.contains("| Armadura |") || inventario.contains("| Espada |")) {
            puntos ++;
        }
        out.println("\n--------------------\n\nObtuviste un total de +" + puntos + " en tu recorrido.\n¡Completaste " + puntos + "/3 acertijos disponibles!");
        
        out.println("\nGracias por jugar. ¡Hasta la próxima!");
    }   
} //FIN DEL PROGRAMA