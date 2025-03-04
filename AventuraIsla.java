/**
 * PRIMER AVANCE DEL PROYECTO: AVENTURA EN LA ISLA DEL TESORO
 * ENTREGABLE 01: "EL MAPA Y LA BRÚJULA"
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
         int location = 1, action, capacidad = 0;
         String inventario = "", objeto01 = "", objeto02 = "", objeto03 = "";
      
         //MENSAJE AL INICIO DEL VIDEOJUEGO
         out.println("\n¡BIENVENIDO AL JUEGO DE LA AVENTURA EN ISLA DEL TESORO!\n");
         
         //PLAYA (1st)
         if (location == 1){
         out.println("--------------------\nEstás en la playa y es hora de avanzar.\nEl sol brilla, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti");
         out.println("\n¿Qué deseas hacer?");
         out.println("1. Ir al Norte\n2. Examinar el cofre");
         out.print("\nIngrese el número que determinará su acción: ");
         action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA (1st)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (1st)
                 }
                 case 2 -> {
                     if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste un mapa dentro del cofre!");
                         objeto01 += "| Mapa |";
                         inventario += objeto01;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                         out.println("\n¡Recuerda bien estas instrucciones!\n¡Avancemos a la siguiente área!");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (1st)
                 }
                 default -> {location = 9;}
             }
         }
 
         //JUNGLA (1st)
         if (location == 2){
             out.println("\n--------------------\nSeguiste la ruta disponible, avanzaste al norte y llegaste a la jungla.\nLos árboles son altos y la vegetación frondosa, pero ves caminos en todas direcciones.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA (1st)
             switch (action) {
                 case 1 -> {location = 4;} //RUINAS (1st)
                 case 2 -> {location = 3;} //CUEVA (1st)
                 case 3 -> {location = 5;} //MONTAÑA (1st)
                 case 4 -> {location = 1;} //PLAYA (2nd)
                 default -> {location = 9;}
             }
         }
 
         //CUEVA (1st)
         if (location == 3) 
         {
             out.println("\n--------------------\nAvanzaste al oeste, ahora estás en la entrada de una cueva.\nEstá muy oscuro, oyes ruidos extraños, pero no ves bien.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA (1st)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (2nd)
                 case 2 -> {
                     out.print("Está muy oscuro, será mejor regresar. Quizá más adelante halles algo que te pueda servir para ver mejor.");
 
                     location = 2; //JUNGLA (2nd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //RUINAS (1st)
         if (location == 4) 
         {
             out.println("\n--------------------\nSeguiste al norte y llegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Sur\n2. Recoger objeto en la entrada");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS (1st)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (2nd)
                 }
                 case 2 -> {
                     if (capacidad < 3) {
                         out.println("\n--------------------\n¡Recogiste una antorcha!");
                         
                         objeto02 += "| Antorcha |";
                         inventario += objeto02;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");
                         out.println("Por ahora regresemos a la anterior zona.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (2nd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //MONTAÑA (1st)
         if (location == 5)
         {
             out.println("\n--------------------\nDecidiste ir al este, ahora estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA (1st)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (2nd)
                 case 2 -> {
                     if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste una pala!");
                         objeto03 += "| Pala |";
                         inventario += objeto03;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nAhora podrás excavar en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertas zonas!");
                         out.println("Regresemos y sigamos explorando.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (2nd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //SEGUNDA OCASIÓN EN LA QUE SE PREGUNTA DIRECCIONES O SE GUARDA OBJETOS EN EL INVENTARIO
 
         //PLAYA (2nd)
         if (location == 1)
         {
         out.println("\n--------------------\nRegresaste a la playa y es hora de avanzar.\nEl sol sigue brillando, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti");
         out.println("\n¿Qué deseas hacer?");
         out.println("1. Ir al Norte\n2. Examinar el cofre");
         out.print("\nIngrese el número que determinará su acción: ");
         action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA (2nd)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (2nd)
                 }
                 case 2 -> {
                     if (inventario.contains("| Mapa |")) {
                         out.println("\n--------------------\nYa guardaste el mapa en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste un mapa dentro del cofre!");
                         objeto01 += "| Mapa |";
                         inventario += objeto01;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                         out.println("\n¡Recuerda bien estas instrucciones!\n¡Avancemos a la siguiente área!");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (2nd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //JUNGLA (2nd)
         if (location == 2)
         {
             out.println("\n--------------------\nRegresaste a la jungla.\nLos árboles son altos y la vegetación frondosa, pero ves caminos en todas direcciones.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA (2nd)
             switch (action) {
                 case 1 -> {location = 4;} //RUINAS (2nd)
                 case 2 -> {location = 3;} //CUEVA (2nd)
                 case 3 -> {location = 5;} //MONTAÑA (2nd)
                 case 4 -> {location = 1;} //PLAYA (3rd)
                 default -> {location = 9;}
             }
         }
 
         //CUEVA (2nd)
         if (location == 3) 
         {
             out.println("\n--------------------\nAvanzaste al oeste, ahora estás en la entrada de una cueva.\nEstá muy oscuro, oyes ruidos extraños, pero no ves bien.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA (2nd)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (3rd)
                 case 2 -> {
                     out.print("Está muy oscuro, será mejor regresar. Quizá más adelante halles algo que te pueda servir para ver mejor.");
 
                     location = 2; //JUNGLA (3rd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //RUINAS (2nd)
         if (location == 4) 
         {
             out.println("\n--------------------\nSeguiste al norte y llegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Sur\n2. Recoger objeto en la entrada");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS (2nd)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (3rd)
                 }
                 case 2 -> {
                     if (inventario.contains("| Antorcha |")) {
                         out.println("\n--------------------\nYa guardaste la antorcha en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Recogiste una antorcha!");
                         objeto02 += "| Antorcha |";
                         inventario += objeto02;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");
                         out.println("Por ahora regresemos a la anterior zona.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; ////JUNGLA (3rd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //MONTAÑA (2nd)
         if (location == 5)
         {
             out.println("\n--------------------\nDecidiste ir al este, ahora estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA (2nd)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (3rd)
                 case 2 -> {
                     if (inventario.contains("| Pala |")) {
                         out.println("\n--------------------\nYa guardaste la pala en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste una pala!");
                         objeto03 += "| Pala |";
                         inventario += objeto03;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nAhora podrás excavar en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertas zonas!");
                         out.println("Regresemos y sigamos explorando.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (3rd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //TERCERA OCASIÓN EN LA QUE SE PREGUNTA DIRECCIONES O SE GUARDA OBJETOS EN EL INVENTARIO
 
         //PLAYA (3rd)
         if (location == 1)
         {
         out.println("\n--------------------\nRegresaste a la playa y es hora de avanzar.\nEl sol sigue brillando, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti");
         out.println("\n¿Qué deseas hacer?");
         out.println("1. Ir al Norte\n2. Examinar el cofre");
         out.print("\nIngrese el número que determinará su acción: ");
         action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA (3rd)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (3rd)
                 }
                 case 2 -> {
                     if (inventario.contains("| Mapa |")) {
                         out.println("\n--------------------\nYa guardaste el mapa en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste un mapa dentro del cofre!");
                         objeto01 += "| Mapa |";
                         inventario += objeto01;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                         out.println("\n¡Recuerda bien estas instrucciones!\n¡Avancemos a la siguiente área!");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (3rd)
                 }
                 default -> {location = 9;}
             }
         }
 
         //JUNGLA (3rd)
         if (location == 2)
         {
             out.println("\n--------------------\nRegresaste a la jungla.\nLos árboles son altos y la vegetación frondosa, pero ves caminos en todas direcciones.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA (3rd)
             switch (action) {
                 case 1 -> {location = 4;} //RUINAS (3rd)
                 case 2 -> {location = 3;} //CUEVA (3rd)
                 case 3 -> {location = 5;} //MONTAÑA (3rd)
                 case 4 -> {location = 1;} //PLAYA (4th)
                 default -> {location = 9;}
             }
         }
 
         //CUEVA (3rd)
         if (location == 3) 
         {
             out.println("\n--------------------\nAvanzaste al oeste, ahora estás en la entrada de una cueva.\nEstá muy oscuro, oyes ruidos extraños, pero no ves bien.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA (3rd)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (4th)
                 case 2 -> {
                     out.print("Está muy oscuro, será mejor regresar. Quizá más adelante halles algo que te pueda servir para ver mejor.");
 
                     location = 2; //JUNGLA (4th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //RUINAS (3rd)
         if (location == 4) 
         {
             out.println("\n--------------------\nSeguiste al norte y llegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Sur\n2. Recoger objeto en la entrada");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS (3rd)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (4th)
                 }
                 case 2 -> {
                     if (inventario.contains("| Antorcha |")) {
                         out.println("\n--------------------\nYa guardaste la antorcha en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Recogiste una antorcha!");
                         objeto02 += "| Antorcha |";
                         inventario += objeto02;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");
                         out.println("Por ahora regresemos a la anterior zona.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (4th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //MONTAÑA (3rd)
         if (location == 5)
         {
             out.println("\n--------------------\nDecidiste ir al este, ahora estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA (3rd)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (4th)
                 case 2 -> {
                     if (inventario.contains("| Pala |")) {
                         out.println("\n--------------------\nYa guardaste la pala en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste una pala!");
                         objeto03 += "| Pala |";
                         inventario += objeto03;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nAhora podrás excavar en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertas zonas!");
                         out.println("Regresemos y sigamos explorando.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (4th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //CUARTA OCASIÓN EN LA QUE SE PREGUNTA DIRECCIONES O SE GUARDA OBJETOS EN EL INVENTARIO
 
         //PLAYA (4th)
         if (location == 1)
         {
         out.println("\n--------------------\nRegresaste a la playa y es hora de avanzar.\nEl sol sigue brillando, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti");
         out.println("\n¿Qué deseas hacer?");
         out.println("1. Ir al Norte\n2. Examinar el cofre");
         out.print("\nIngrese el número que determinará su acción: ");
         action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA (4th)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (4th)
                 }
                 case 2 -> {
                     if (inventario.contains("| Mapa |")) {
                         out.println("\n--------------------\nYa guardaste el mapa en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste un mapa dentro del cofre!");
                         objeto01 += "| Mapa |";
                         inventario += objeto01;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                         out.println("\n¡Recuerda bien estas instrucciones!\n¡Avancemos a la siguiente área!");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (4th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //JUNGLA (4th)
         if (location == 2)
         {
             out.println("\n--------------------\nRegresaste a la jungla.\nLos árboles son altos y la vegetación frondosa, pero ves caminos en todas direcciones.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA (4th)
             switch (action) {
                 case 1 -> {location = 4;} //RUINAS (4th)
                 case 2 -> {location = 3;} //CUEVA (4th)
                 case 3 -> {location = 5;} //MONTAÑA (4th)
                 case 4 -> {location = 1;} //PLAYA (5th)
                 default -> {location = 9;}
             }
         }
 
         //CUEVA (4th)
         if (location == 3) 
         {
             out.println("\n--------------------\nAvanzaste al oeste, ahora estás en la entrada de una cueva.\nEstá muy oscuro, oyes ruidos extraños, pero no ves bien.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA (4th)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (5th)
                 case 2 -> {
                     out.print("Está muy oscuro, será mejor regresar. Quizá más adelante halles algo que te pueda servir para ver mejor.");
 
                     location = 2; //JUNGLA (5th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //RUINAS (4th)
         if (location == 4) 
         {
             out.println("\n--------------------\nSeguiste al norte y llegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Sur\n2. Recoger objeto en la entrada");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS (4th)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (5th)
                 }
                 case 2 -> {
                     if (inventario.contains("| Antorcha |")) {
                         out.println("\n--------------------\nYa guardaste la antorcha en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Recogiste una antorcha!");
                         objeto02 += "| Antorcha |";
                         inventario += objeto02;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");
                         out.println("Por ahora regresemos a la anterior zona.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (5th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //MONTAÑA (4th)
         if (location == 5)
         {
             out.println("\n--------------------\nDecidiste ir al este, ahora estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA (4th)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (5th)
                 case 2 -> {
                     if (inventario.contains("| Pala |")) {
                         out.println("\n--------------------\nYa guardaste la pala en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste una pala!");
                         objeto03 += "| Pala |";
                         inventario += objeto03;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nAhora podrás excavar en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertas zonas!");
                         out.println("Regresemos y sigamos explorando.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (5th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //QUINTA OCASIÓN EN LA QUE SE PREGUNTA DIRECCIONES O SE GUARDA OBJETOS EN EL INVENTARIO
 
         //PLAYA (5th)
         if (location == 1)
         {
         out.println("\n--------------------\nRegresaste a la playa y es hora de avanzar.\nEl sol sigue brillando, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti");
         out.println("\n¿Qué deseas hacer?");
         out.println("1. Ir al Norte\n2. Examinar el cofre");
         out.print("\nIngrese el número que determinará su acción: ");
         action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA (5th)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (5th)
                 }
                 case 2 -> {
                     if (inventario.contains("| Mapa |")) {
                         out.println("\n--------------------\nYa guardaste el mapa en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste un mapa dentro del cofre!");
                         objeto01 += "| Mapa |";
                         inventario += objeto01;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                         out.println("\n¡Recuerda bien estas instrucciones!\n¡Avancemos a la siguiente área!");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (5th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //JUNGLA (5th)
         if (location == 2)
         {
             out.println("\n--------------------\nRegresaste a la jungla.\nLos árboles son altos y la vegetación frondosa, pero ves caminos en todas direcciones.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA (5th)
             switch (action) {
                 case 1 -> {location = 4;} //RUINAS (5th)
                 case 2 -> {location = 3;} //CUEVA (5th)
                 case 3 -> {location = 5;} //MONTAÑA (5th)
                 case 4 -> {location = 1;} //PLAYA (6th)
                 default -> {location = 9;}
             }
         }
 
         //CUEVA (5th)
         if (location == 3) 
         {
             out.println("\n--------------------\nAvanzaste al oeste, ahora estás en la entrada de una cueva.\nEstá muy oscuro, oyes ruidos extraños, pero no ves bien.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA (5th)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (6th)
                 case 2 -> {
                     out.print("Está muy oscuro, será mejor regresar. Quizá más adelante halles algo que te pueda servir para ver mejor.");
 
                     location = 2; //JUNGLA (6th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //RUINAS (5th)
         if (location == 4) 
         {
             out.println("\n--------------------\nSeguiste al norte y llegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Sur\n2. Recoger objeto en la entrada");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS (5th)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (6th)
                 }
                 case 2 -> {
                     if (inventario.contains("| Antorcha |")) {
                         out.println("\n--------------------\nYa guardaste la antorcha en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Recogiste una antorcha!");
                         objeto02 += "| Antorcha |";
                         inventario += objeto02;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");
                         out.println("Por ahora regresemos a la anterior zona.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (6th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //MONTAÑA (5th)
         if (location == 5)
         {
             out.println("\n--------------------\nDecidiste ir al este, ahora estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA (5th)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (6th)
                 case 2 -> {
                     if (inventario.contains("| Pala |")) {
                         out.println("\n--------------------\nYa guardaste la pala en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste una pala!");
                         objeto03 += "| Pala |";
                         inventario += objeto03;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nAhora podrás excavar en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertas zonas!");
                         out.println("Regresemos y sigamos explorando.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (6th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //SEXTA OCASIÓN EN LA QUE SE PREGUNTA DIRECCIONES O SE GUARDA OBJETOS EN EL INVENTARIO
 
         //PLAYA (6th)
         if (location == 1)
         {
         out.println("\n--------------------\nRegresaste a la playa y es hora de avanzar.\nEl sol sigue brillando, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti");
         out.println("\n¿Qué deseas hacer?");
         out.println("1. Ir al Norte\n2. Examinar el cofre");
         out.print("\nIngrese el número que determinará su acción: ");
         action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA (6th)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (6th)
                 }
                 case 2 -> {
                     if (inventario.contains("| Mapa |")) {
                         out.println("\n--------------------\nYa guardaste el mapa en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste un mapa dentro del cofre!");
                         objeto01 += "| Mapa |";
                         inventario += objeto01;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nEl mapa muestra lo siguiente:\nExiste una densa jungla en el centro de la isla,\nal norte hay unas ruinas antiguas,\nal oeste una gran cueva,\nal este una inmensa montaña,\nal sur la playa en la que te encuentras.");
                         out.println("\n¡Recuerda bien estas instrucciones!\n¡Avancemos a la siguiente área!");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (6th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //JUNGLA (6th)
         if (location == 2)
         {
             out.println("\n--------------------\nRegresaste a la jungla.\nLos árboles son altos y la vegetación frondosa, pero ves caminos en todas direcciones.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA (6th)
             switch (action) {
                 case 1 -> {location = 4;} //RUINAS (6th)
                 case 2 -> {location = 3;} //CUEVA (6th)
                 case 3 -> {location = 5;} //MONTAÑA (6th)
                 case 4 -> {location = 1;} //PLAYA (7th)
                 default -> {location = 9;}
             }
         }
 
         //CUEVA (6th)
         if (location == 3) 
         {
             out.println("\n--------------------\nAvanzaste al oeste, ahora estás en la entrada de una cueva.\nEstá muy oscuro, oyes ruidos extraños, pero no ves bien.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA (6th)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (7th)
                 case 2 -> {
                     out.print("Está muy oscuro, será mejor regresar. Quizá más adelante halles algo que te pueda servir para ver mejor.");
 
                     location = 2; //JUNGLA (7th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //RUINAS (6th)
         if (location == 4) 
         {
             out.println("\n--------------------\nSeguiste al norte y llegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Sur\n2. Recoger objeto en la entrada");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS (6th)
             switch (action) {
                 case 1 -> {
                     location = 2; //JUNGLA (7th)
                 }
                 case 2 -> {
                     if (inventario.contains("| Antorcha |")) {
                         out.println("\n--------------------\nYa guardaste la antorcha en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Recogiste una antorcha!");
                         objeto02 += "| Antorcha |";
                         inventario += objeto02;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nPuedes usarla para iluminar espacios oscuros o calentarte si hace frío.\n¡Te será muy útil en ciertos sitios!");
                         out.println("Por ahora regresemos a la anterior zona.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (7th)
                 }
                 default -> {location = 9;}
             }
         }
 
         //MONTAÑA (6th)
         if (location == 5)
         {
             out.println("\n--------------------\nDecidiste ir al este, ahora estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
             out.println("\n¿Qué deseas hacer?");
             out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo");
             out.print("\nIngrese el número que determinará su acción: ");
             action = Integer.parseInt(in.readLine());
 
             //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA (6th)
             switch (action) {
                 case 1 -> {location = 2;} //JUNGLA (7th)
                 case 2 -> {
                     if (inventario.contains("| Pala |")) {
                         out.println("\n--------------------\nYa guardaste la pala en tu inventario.");
                         out.println("Actualmente este es tu inventario: " + inventario);
                     }
                     else if (capacidad < 3) {
                         out.println("\n--------------------\n¡Hallaste una pala!");
                         objeto03 += "| Pala |";
                         inventario += objeto03;
                         out.println("Actualmente este es tu inventario: " + inventario);
                         out.println("\nAhora podrás excavar en lugares donde puede que halla algo valioso oculto.\n¡Puede serte útil en ciertas zonas!");
                         out.println("Regresemos y sigamos explorando.");
                         capacidad++;   
                     } 
                     else if (capacidad == 3){
                         out.println("\n--------------------\nYa llevas 3 objetos. No tienes más espacio en tu inventario");
                     }
                     location = 2; //JUNGLA (7th)
                 }
                 default -> {location = 9;}
             }
         }
 
         if (location == 9) {
             out.println("\n--------------------\nOpción no válida.\n¡Gracias por jugar!");
         }
 
     }
    
 }
 
 /*
  * LOS TÉRMINOS QUE VIENEN AL LADO DE LOS NOMBRES DE LOS LUGARES, COMO LO SERÍA (1st), (2nd), (3rd), (4th)
  * Y SUCESIVAMENTE, SE REFIEREN A SI ES EFECTIVAMENTE LA PRIMERA, SEGUNDA, TERCERA, CUARTA O LA
  * DETERMINADA OCASIÓN NÚMERO "TAL" EN LA QUE SE VISITA ESE LUGAR PARA REALIZAR ALGUNA DE LOS OPCIONES
  * DISPONIBLES POR ZONA.
  */                           