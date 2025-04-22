/**
 * TERCER AVANCE DEL PROYECTO: AVENTURA EN LA ISLA DEL TESORO
 * ENTREGABLE 03: "EL TESORO Y LA VICTORIA"
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
 * LUIS ALEJANDRO BLANCO ÁLVAREZ
 * KENNETH CHAVES COTO
 **/

 import java.io.*;

 public class AventuraIsla {    
     //Objetos de entrada y salida
     static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     static PrintStream out = System.out;
 
     //RUTINA PARA BUSCAR OBJETOS EN EL INVENTARIO
     static boolean buscarObjeto(String[] inventario, String objeto) {
         for (int i = 0; i < inventario.length; i++) {
             if (inventario[i].equals(objeto)) {
                 return true;
             }
         }
         return false;
     }
     
     //RUTINA PARA GUARDAR OBJETOS EN EL INVENTARIO
     static void guardarObjeto(String[] inventario, String objeto) {
         
         int guardado = 0;
 
         for (int i = 0; i < inventario.length; i++) {
             if (inventario[i].equals("") && guardado == 0){
                 inventario[i] = objeto;
                 guardado = 1;
             } 
         }  
     }
 
     //RUTINA PARA IMPRIMIR INVENTARIO
     static void imprimirInventario(String[] inventario) {
         
         boolean hayObjetos = false;
     
         for (int i = 0; i < inventario.length; i++) {
             if (!inventario[i].equals("")) {
                 hayObjetos = true;
             }
         }
     
         if (hayObjetos) {
             out.print("Actualmente este es tu inventario: ");
             for (int i = 0; i < inventario.length; i++) {
                 if (!inventario[i].equals("")) {
                     out.print("| " + inventario[i] + " | ");
                 }
             }
         } 
         else {
             out.print("Actualmente tu inventario está vacío...");
         }
     }
     
     //RUTINA PARA FINALIZAR PARTIDA
     static int finalizarPartida(String[] inventario, boolean[] faro) {
 
         int puntos = 0;
 
         //PUNTAJE DE LA PARTIDA Y MENSAJE DE DESPEDIDA DEL VIDEOJUEGO
         if (buscarObjeto(inventario, "Libro traductor")) {
             puntos ++;
         } 
         if (faro[0] == true) {
             puntos ++;
         }
         if (buscarObjeto(inventario, "Armadura") || buscarObjeto(inventario, "Espada")) {
             puntos ++;
         }
         out.println("\n--------------------\n\nObtuviste un total de " + puntos + " puntos en tu recorrido.\n¡Completaste " + puntos + "/3 acertijos disponibles!");
         
         out.println("\nGracias por jugar. ¡Hasta la próxima!");
 
         return 0;
     }
 
     //RUTINA DEL ACERTIJO DEL BARCO PIRATA
     static int acertijoBarcoPirata(String[] inventario, boolean[] faro) throws IOException {
 
         int action;
         String respuestaAcertijos;
         
         out.println("\n--------------------\n\n¡Estás dentro del barco pirata! Lleva bastante tiempo abandonado, lo exploras\ny en lo más profundo de sus restos te encuentras una bóveda resguardada por una trampa letal.\n\nPara desactivar la trampa debes ingresar un código oculto en las siguientes letras: 'F A R U N O G I A'\n\n¡Halla la palabra secreta y lo que hay en la bóveda será tuyo!\n¡Pero sé sabio, nada más tienes 3 oportunidades, y una vez que empieces a adivinar\n no podrás irte hasta que lo resuelvas o mueras en e intento!");
         out.println("\n¿Qué deseas hacer?\n");
         out.println("1. Tratar de resolver el anagrama\n2. Dejarlo para más adelante\n3. Ver inventario\n4. Finalizar partida");
         out.print("\nIngrese el número que determinará tu acción: ");
         action = Integer.parseInt(in.readLine());
 
         //ACCIONES QUE SE PUEDEN HACER DENTRO DEL BARCO PIRATA
         switch (action) {
             case 1 -> {
                 for (int i = 0; i < 3;) {
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
                                 guardarObjeto(inventario, "Armadura");
                                 out.println("\n--------------------\n");    
                                 imprimirInventario(inventario);
                                 out.println();
                                 out.println("\nEn fin, desactivaste la trampa, así que volvamos de las ruinas...");
                                 return zonaRuinas(inventario, faro);
                             }
                             case 2 -> {
                                 guardarObjeto(inventario, "Espada");
                                 out.println("\n--------------------\n");    
                                 imprimirInventario(inventario);
                                 out.println();
                                 out.println("\nEn fin, desactivaste la trampa, así que volvamos de las ruinas...");
                                 return zonaRuinas(inventario, faro);
                             }
                             default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                             return acertijoBarcoPirata(inventario, faro);
                             }
                         }
                     }
                     else {
                         i ++;
                         out.println("\n--------------------\n\nRespuesta incorrecta... Llevas " + i + "/3 intentos.\n\n--------------------");
                                                 
                     }
                     
                 }
                 out.println("\n--------------------\n\nLlevas 3/3 intentos posibles...\nSe te acabaron los intentos, la trampa se activó y perdiste la vida...");
                 return finalizarPartida(inventario, faro); 
             }
             case 2 -> {return zonaBahiaPirata(inventario, faro);} //BAHÍA PIRATA
             case 3 -> {
                 out.println("\n--------------------\n");    
                 imprimirInventario(inventario);
                 out.println();
                 return acertijoBarcoPirata(inventario, faro);
             } //IMPRIMIR INVENTARIO
             case 4 -> {return finalizarPartida(inventario, faro);}  //FINALIZAR PARTIDA
             default -> {
                 out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                 return acertijoBarcoPirata(inventario, faro);
             }
         }
     }
 
     //RUTINA DEL ACERTIJO DE LAS RUINAS
     static int acertijoRuinas(String[] inventario, boolean[] faro) throws IOException {
 
         int action;
 
         if (buscarObjeto(inventario, "Libro traductor")) {
             out.println("\n--------------------\n\n¡Tienes el libro traductor! Puedes interpretar los símbolos en la pared:\n\n'Tras estas ruinas encuentras el camino, romper el muro debes para llegar a tu destino.\nSoy vigilante y guardián de mi playa, con mis ojos guío a todo el que me halla.\nCuando me veas, sabrás que has llegado y una recompensa te espera al otro lado.'\n\n¡El mensaje oculto nos dice que debes tirar abajo esta pared!");
             out.println("\n¿Qué deseas hacer?\n");
             out.println("1. Derribar el muro\n2. Dejarlo para más adelante\n3. Ver inventario\n4. Finalizar partida");
             out.print("\nIngrese el número que determinará tu acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER CON LOS SÍMBOLOS DE LAS RUINAS
             switch (action) {
                 case 1 -> {
                     if (buscarObjeto(inventario, "Pico")) {
                         out.println("\n--------------------\n\n¡Tienes el pico! Puedes derribar el muro e ir a explorar al otro lado.\nHas tirado la pared y encontraste un camino oculto. Sigues su largo trayecto y llegas a una nueva zona secreta...");
                         return zonaBahiaPirata(inventario, faro); //BAHÍA PIRATA
                         
                     } 
                     else {
                         out.println("\n--------------------\n\nEl muro es muy grande y pesado, necesitas una herramienta que te ayude a derribarlo.\nQuizá más adelante halles algo que te pueda servir.");
                         return zonaRuinas(inventario, faro);
                     }
                 }
                 case 2 -> {return zonaRuinas(inventario, faro);} //RUINAS
                 case 3 -> {
                     out.println("\n--------------------\n");    
                     imprimirInventario(inventario);
                     out.println();
                     return acertijoRuinas(inventario, faro);
                 } //IMPRIMIR INVENTARIO
                 case 4 -> {return finalizarPartida(inventario, faro);} //FINALIZAR PARTIDA
                 default -> {
                     out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                     return acertijoRuinas(inventario, faro);
                 }   
             }
         }
         else {
             out.println("\n--------------------\n\nNo tienes el conocimiento suficiente o una guía para entender qué dicen estos símbolos.\nQuizá más adelante halles algo que te pueda servir.");
             return zonaRuinas(inventario, faro);
         }
     }
     
     //RUTINA DEL ACERTIJO DE LA CUEVA
     static int acertijoCueva(String[] inventario, boolean[] faro) throws IOException {
         
         int action;
         String respuestaAcertijos;
         
         if (buscarObjeto(inventario, "Antorcha")) {        
             out.println("\n--------------------\n\n¡Tienes la antorcha! Puedes explorar dentro.\nLlegaste al fondo de la cueva y ves un cofre con seguro y una nota que dice:\n\n'¿Qué será, qué es, que mientras más grande, menos ves?'\n\nSi respondes el acertijo se abrirá el cofre.");
             out.println("\n¿Qué deseas hacer?\n");
             out.println("1. Tratar de resolver la adivinanza\n2. Dejarlo para más adelante\n3. Ver inventario\n4. Finalizar partida");
             out.print("\nIngrese el número que determinará tu acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER DENTRO DE LA CUEVA
             switch (action) {
                 case 1 -> {
                     out.print("\nIntenta adivinar la respuesta correcta: ");
                     respuestaAcertijos = in.readLine();
                     if (respuestaAcertijos.equalsIgnoreCase("La oscuridad")) {
                         if (buscarObjeto(inventario, "Libro traductor")) {
                             out.println("\n--------------------\n\nYa guardaste el libro traductor en tu inventario.");
                             imprimirInventario(inventario);
                             out.println();
                         }
                         else {
                             guardarObjeto(inventario, "Libro traductor");
                             out.println("\n--------------------\n\n¡Respuesta correcta! El cofre se ha abierto.\n\nHallaste un libro que sirve para traducir símbolos extraños.");
                             imprimirInventario(inventario);
                             out.println("\n\nEn fin, salgamos de la cueva..."); 
                             return zonaCueva(inventario, faro);
                         }
                     } 
                     else {
                         out.println("\n--------------------\n\nRespuesta incorrecta...");         
                     }
                     return acertijoCueva(inventario, faro);
                 }
                 case 2 -> {return zonaCueva(inventario, faro);} //CUEVA
                 case 3 -> {
                     out.println("\n--------------------\n");    
                     imprimirInventario(inventario);
                     out.println();
                     return acertijoCueva(inventario, faro);
                 } //IMPRIMIR INVENTARIO
                 case 4 -> {return finalizarPartida(inventario, faro);}  //FINALIZAR PARTIDA
                 default -> {
                     out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                     return acertijoCueva(inventario, faro);
                 }
             }
         }
         else {
             out.println("\n--------------------\n\nEstá muy oscuro.\nQuizá más adelante halles algo que te pueda servir para ver mejor.");
             return zonaCueva(inventario, faro);
         }
     }
 
 
     //RUTINA ZONA SECRETA DE LA BAHÍA
     static int zonaBahiaPirata(String[] inventario, boolean[] faro) throws IOException {
 
         int action;
         faro[0] = true;
         
         out.println("\n--------------------\n\n¡Estás en la bahía pirata! La zona más secreta de la isla.\nA lo lejos ves el faro tal como se esperaba y cerca tuyo ves un naufragio de lo que parece ser un barco pirata.");
         out.println("\n¿Qué deseas hacer?\n");
         out.println("1. Volver a las ruinas\n2. Examinar el barco\n3. Ver inventario\n4. Finalizar partida");
         out.print("\nIngrese el número que determinará tu acción: ");
         action = Integer.parseInt(in.readLine());
 
         //ACCIONES QUE SE PUEDEN HACER EN LA BAHÍA PIRATA
         switch (action) {
             case 1 -> {return zonaRuinas(inventario, faro);} //RUINAS
             case 2 -> {return acertijoBarcoPirata(inventario, faro);} //ACERTIJO BARCO PIRATA
             case 3 -> {
                 out.println("\n--------------------\n");    
                 imprimirInventario(inventario);
                 out.println();
                 return zonaBahiaPirata(inventario, faro);
             } //IMPRIMIR INVENTARIO
             case 4 -> {return finalizarPartida(inventario, faro);} //FINALIZAR PARTIDA
             default -> {
                 out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                 return zonaBahiaPirata(inventario, faro);
             }
         }
     }
     
     //RUTINA ZONA DE LA MONTAÑA
     static int zonaMontaña(String[] inventario, boolean[] faro) throws IOException {
         
         int action;
 
         out.println("\n--------------------\n\nEstás estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
         out.println("\n¿Qué deseas hacer?\n");
         out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo\n3. Intentar escalar\n4. Ver inventario\n5. Finalizar partida");
         out.print("\nIngrese el número que determinará tu acción: ");
         action = Integer.parseInt(in.readLine());
 
         //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA
         switch (action) {
             case 1 -> {return zonaJungla(inventario, faro);} //JUNGLA
             case 2 -> {
                 if (buscarObjeto(inventario, "Pico")) {
                     out.println("\n--------------------\n\nYa guardaste el pico en tu inventario.");
                     imprimirInventario(inventario);
                     out.println();
                 }
                 else {
                     guardarObjeto(inventario, "Pico");
                     out.println("\n--------------------\n\n¡Hallaste un pico!");
                     imprimirInventario(inventario);
                     out.println("\n\nAhora podrás excavar o romper en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertos lugares!");  
                 }
                 return zonaMontaña(inventario, faro);
             }
             case 3 -> {
                 if (buscarObjeto(inventario, "Armadura") || buscarObjeto(inventario, "Espada")) {
                     out.println("\n--------------------\n\n¡Subiste a la montaña!\n");
                     // return jefeFinal() PELEA JEFE FINAL
                     
                 }
                 else {
                     out.println("\n--------------------\n\nLo más recomentable es subir con algún objeto que te proteja en caso de peligro.\n¿Estás seguro que deseas subir sin equipamiento útil?");
                     out.println("\n¿Qué deseas hacer?\n");
                     out.println("1. Subir de todas formas\n2. No subir y seguir explorando\n3. Ver inventario\n4. Finalizar partida");
                     out.print("\nIngrese el número que determinará tu acción: ");
                     action = Integer.parseInt(in.readLine());
 
                     //ELEGIR SI SUBIR O NO LA MONTAÑA SIN EL EQUIPO ADECUADO
                     switch (action) {
                         case 1 -> {
                         out.println("\n--------------------\n\n¡Subiste a la montaña!\n(POR AHORA HASTA AQUÍ TERMINA EL JUEGO)"); 
                         // return jefeFinal() PELEA JEFE FINAL
                         }
                         case 2 -> {
                             return zonaMontaña(inventario, faro);
                         }
                         case 3 -> {
                             out.println("\n--------------------\n");    
                             imprimirInventario(inventario);
                             out.println();
                             return zonaMontaña(inventario, faro);
                         } //IMPRIMIR INVENTARIO
                         case 4 -> {return finalizarPartida(inventario, faro);} //FINALIZAR PARTIDA
                         default -> {
                             out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                             return zonaMontaña(inventario, faro);
                         }
                     }
                 }
             }
             case 4 -> {
                 out.println("\n--------------------\n");    
                 imprimirInventario(inventario);
                 out.println();
                 return zonaMontaña(inventario, faro);
             } //IMPRIMIR INVENTARIO
             case 5 -> {return finalizarPartida(inventario, faro);} //FINALIZAR PARTIDA
             default -> {
                 out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                 return zonaMontaña(inventario, faro);
             } //EN CASO DE INGRESAR UNA OPCIÓN INVÁLIDA
         }
 
         return 1; //SE DEBERÁ QUITAR
     }
     
     //RUTINA ZONA DE LAS RUINAS
     static int zonaRuinas(String[] inventario, boolean[] faro) throws IOException {
 
         int action;
         
         out.println("\n--------------------\n\nLlegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
         out.println("\n¿Qué deseas hacer?\n");
         out.println("1. Ir al Sur\n2. Recoger objeto en la entrada\n3. Examinar símbolos extraños\n4. Ver inventario\n5. Finalizar partida");
         out.print("\nIngrese el número que determinará tu acción: ");
         action = Integer.parseInt(in.readLine());
 
         //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS
         switch (action) {
             case 1 -> {return zonaJungla(inventario, faro);} //JUNGLA
             case 2 -> {
                 if (buscarObjeto(inventario, "Antorcha")) {
                     out.println("\n--------------------\n\nYa guardaste la antorcha en tu inventario.");
                     imprimirInventario(inventario);
                     out.println();
                 }
                 else {
                     guardarObjeto(inventario, "Antorcha");
                     out.println("\n--------------------\n\n¡Recogiste una antorcha!");
                     imprimirInventario(inventario);
                     out.println("\n\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");   
                 }
                 return zonaRuinas(inventario, faro);
             }
             case 3 -> {return acertijoRuinas(inventario, faro);} //ACERTIJO DE LAS RUINAS
             case 4 -> {
                 out.println("\n--------------------\n");    
                 imprimirInventario(inventario);
                 out.println();
                 return zonaRuinas(inventario, faro);
             } //IMPRIMIR INVENTARIO
             case 5 -> {return finalizarPartida(inventario, faro);} //FINALIZAR PARTIDA
             default -> {
                 out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                 return zonaRuinas(inventario, faro);
             } //EN CASO DE INGRESAR UNA OPCIÓN INVÁLIDA
         }
     }
     
     //RUTINA ZONA DE LA CUEVA
     static int zonaCueva(String[] inventario, boolean[] faro) throws IOException {
 
         int action;
 
         out.println("\n--------------------\n\nEstás en la entrada de una cueva.\nMiras hacia dentro, oyes ruidos extraños, pero está muy oscuro y no ves bien.");
         out.println("\n¿Qué deseas hacer?\n");
         out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva\n3. Ver inventario\n4. Finalizar partida");
         out.print("\nIngrese el número que determinará tu acción: ");
         action = Integer.parseInt(in.readLine());
 
         //ACCIONES QUE SE PUEDEN HACER FUERA DE LA CUEVA
         switch (action) {
             case 1 -> {return zonaJungla(inventario, faro);} //JUNGLA
             case 2 -> {return acertijoCueva(inventario, faro);} //ACERTIJO DE LA CUEVA
             case 3 -> {
                 out.println("\n--------------------\n");    
                 imprimirInventario(inventario);
                 out.println();
                 return zonaCueva(inventario, faro);
             } //IMPRIMIR INVENTARIO
             case 4 -> {return finalizarPartida(inventario, faro);}  //FINALIZAR PARTIDA
             default -> {
                 out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                 return zonaCueva(inventario, faro);
             } //EN CASO DE INGRESAR UNA OPCIÓN INVÁLIDA
         }
     }
     
     //RUTINA ZONA DE LA JUNGLA
     static int zonaJungla(String[] inventario, boolean[] faro) throws IOException {
         
         int action;
         
         out.println("\n--------------------\n\nLlegaste a la jungla.\nLos árboles son altos y la vegetación frondosa. Ves caminos en todas direcciones.");
         out.println("\n¿Qué deseas hacer?\n");
         out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur\n5. Ver inventario\n6. Finalizar partida");
         out.print("\nIngrese el número que determinará tu acción: ");
         action = Integer.parseInt(in.readLine());
 
         //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA
         switch (action) {
             case 1 -> {return zonaRuinas(inventario, faro);} //RUINAS
             case 2 -> {return zonaCueva(inventario, faro);} //CUEVA
             case 3 -> {return zonaMontaña(inventario, faro);} //MONTAÑA
             case 4 -> {return zonaPlaya(inventario, faro);} //PLAYA
             case 5 -> {
                 out.println("\n--------------------\n");    
                 imprimirInventario(inventario);
                 out.println();
                 return zonaJungla(inventario, faro);
             } //IMPRIMIR INVENTARIO
             case 6 -> {return finalizarPartida(inventario, faro);}//FINALIZAR PARTIDA
             default -> {
                 out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
                 return zonaJungla(inventario, faro);
             } //EN CASO DE INGRESAR UNA OPCIÓN INVÁLIDA
         }
     }
 
     //RUTINA ZONA DE LA PLAYA
     static int zonaPlaya(String[] inventario, boolean[] faro) throws IOException {
 
         int action;
 
         out.println("\n--------------------\n\nEstás en la playa y lo ideal es avanzar.\nEl sol brilla, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti.");
         out.println("\n¿Qué deseas hacer?\n");
         out.println("1. Ir al Norte\n2. Examinar el cofre\n3. Ver inventario.\n4. Finalizar partida");
         out.print("\nIngrese el número que determinará tu acción: ");
         action = Integer.parseInt(in.readLine());
 
         //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA
         switch (action) {
             case 1 -> {return zonaJungla(inventario, faro);} //JUNGLA
             case 2 -> {
                 if (buscarObjeto(inventario, "Mapa")) { //COMPROBAR SI EL OBJETO YA SE GUARDÓ
                     out.println("\n--------------------\n\nYa guardaste el mapa en tu inventario.");
                     imprimirInventario(inventario);
                     out.println();
                 }
                 else {
                     guardarObjeto(inventario, "Mapa"); //GUARDAR OBJETO ESPECÍFICO EN EL INVENTARIO
                     out.println("\n--------------------\n\n¡Hallaste un mapa dentro del cofre!");
                     imprimirInventario(inventario);
                     out.println("\n\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                     out.println("\n¡Recuerda bien estas instrucciones!"); 
                 } 
             }
             case 3 -> {
                 out.println("\n--------------------\n");    
                 imprimirInventario(inventario);
                 out.println();
             } //IMPRIMIR INVENTARIO
             case 4 -> {return finalizarPartida(inventario, faro);} //FINALIZAR PARTIDA
             default -> {out.println("\n--------------------\n\nIngresaste una opción inválida. ¡Intenta de nuevo!");
             } //EN CASO DE INGRESAR UNA OPCIÓN INVÁLIDA
         }
         return 1;
     }
 
     //RUTINA PRINCIPAL
     public static void main(String[] args) throws IOException {
         
         //MENSAJE AL INICIAR EL VIDEOJUEGO
         out.println("\n¡BIENVENIDO AL JUEGO DE LA AVENTURA EN ISLA DEL TESORO!");
 
         //DECLARAR VARIABLE BANDERA PARA INICIAR/FINALIZAR EL JUEGO
         int jugando;
         boolean[] faro = new boolean[1];
 
         //DECLARAR INVENTARIO
         String[] inventario = new String[6];
         for (int i = 0; i < inventario.length; i++) {
             inventario[i] = "";
         }
         
         do {
             
             //ZONA INICIAL PREDETERMINADA
             jugando = zonaPlaya(inventario, faro);
         
         } while (jugando != 0);         
         
     }
 }