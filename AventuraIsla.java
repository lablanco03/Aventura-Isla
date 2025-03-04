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
        int location = 1, action, capacidad = 0, jugando = 1;
        String inventario = "", objeto01 = "", objeto02 = "", objeto03 = "";
    
        while (jugando == 1) {
            
            //MENSAJE AL INICIAR EL VIDEOJUEGO
            out.println("\n¡BIENVENIDO AL JUEGO DE LA AVENTURA EN ISLA DEL TESORO!\n");
            
            //PLAYA
            if (location == 1){
            out.println("--------------------\nEstás en la playa y es hora de avanzar.\nEl sol brilla, escuchas las olas reventar contra la arena y ves un cofre abandonado cerca de ti");
            out.println("\n¿Qué deseas hacer?");
            out.println("1. Ir al Norte\n2. Examinar el cofre");
            out.print("\nIngrese el número que determinará su acción: ");
            action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA PLAYA
                switch (action) {
                    case 1 -> {
                        location = 2; //JUNGLA
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
                        location = 2; //JUNGLA
                    }
                    default -> {jugando = 0;}
                }
            }

            //JUNGLA
            if (location == 2){
                out.println("\n--------------------\nSeguiste la ruta disponible, avanzaste al norte y llegaste a la jungla.\nLos árboles son altos y la vegetación frondosa, pero ves caminos en todas direcciones.");
                out.println("\n¿Qué deseas hacer?");
                out.println("1. Ir al Norte\n2. Ir al Oeste\n3. Ir al Este\n4. Ir al Sur");
                out.print("\nIngrese el número que determinará su acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA JUNGLA
                switch (action) {
                    case 1 -> {location = 4;} //RUINAS
                    case 2 -> {location = 3;} //CUEVA
                    case 3 -> {location = 5;} //MONTAÑA
                    case 4 -> {location = 1;} //PLAYA
                    default -> {jugando = 0;}
                }
            }

            //CUEVA
            if (location == 3) 
            {
                out.println("\n--------------------\nAvanzaste al oeste, ahora estás en la entrada de una cueva.\nEstá muy oscuro, oyes ruidos extraños, pero no ves bien.");
                out.println("\n¿Qué deseas hacer?");
                out.println("1. Ir al Este\n2. Intentar ir dentro de la cueva");
                out.print("\nIngrese el número que determinará su acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA CUEVA
                switch (action) {
                    case 1 -> {location = 2;} //JUNGLA
                    case 2 -> {
                        out.print("Está muy oscuro, será mejor regresar. Quizá más adelante halles algo que te pueda servir para ver mejor.");

                        location = 2; //JUNGLA
                    }
                    default -> {jugando = 0;}
                }
            }

            //RUINAS
            if (location == 4) 
            {
                out.println("\n--------------------\nSeguiste al norte y llegaste a unas ruinas.\nParecen antiguas y tienen unos símbolos extraños escritos en sus paredes.");
                out.println("\n¿Qué deseas hacer?");
                out.println("1. Ir al Sur\n2. Recoger objeto en la entrada");
                out.print("\nIngrese el número que determinará su acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LAS RUINAS
                switch (action) {
                    case 1 -> {
                        location = 2; //JUNGLA
                    }
                    case 2 -> {
                        if (inventario.contains("| Antorcha |")) {
                            out.println("\n--------------------\nYa guardaste el mapa en tu inventario.");
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
                        location = 2; //JUNGLA
                    }
                    default -> {jugando = 0;}
                }
            }

            //MONTAÑA
            if (location == 5)
            {
                out.println("\n--------------------\nDecidiste ir al este, ahora estás justo en la base de una montaña.\nSe ve muy grande y puede que halla algo interesante arriba o al menos verás un buen paisaje.");
                out.println("\n¿Qué deseas hacer?");
                out.println("1. Ir al Oeste\n2. Examinar objeto clavado en el suelo");
                out.print("\nIngrese el número que determinará su acción: ");
                action = Integer.parseInt(in.readLine());

                //ACCIONES QUE SE PUEDEN HACER EN LA MONTAÑA
                switch (action) {
                    case 1 -> {location = 2;} //JUNGLA
                    case 2 -> {
                        if (inventario.contains("| Pala |")) {
                            out.println("\n--------------------\nYa guardaste el mapa en tu inventario.");
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
                        location = 2; //JUNGLA
                    }
                    default -> {jugando = 0;}
                }
            } 
            
        }

        //MENSAJE DE DESPEDIDA DEL VIDEOJUEGO
        out.println("\n--------------------\n¡Gracias por jugar! ¡Hasta la próxima!");
 
    }
    
} //FIN DEL PROGRAMA