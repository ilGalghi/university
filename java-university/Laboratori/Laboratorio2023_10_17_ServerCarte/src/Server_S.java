import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Server_S {
    public static void main(String args[]) throws IOException {
        // Crea un server socket per ascoltare le connessioni sulla porta 8080
        ServerSocket server = new ServerSocket(8080);
        // Accetta una connessione quando un client si connette
        Socket socket = server.accept();

        // Crea uno scanner per leggere dati dal socket (client)
        Scanner leggi = new Scanner(socket.getInputStream());
        // Legge le carte inviate dal client
        // Ha letto carte

        // Crea un arraylist per memorizzare numeri casuali e una stringa per la loro rappresentazione
        ArrayList<Integer> nums = new ArrayList<Integer>();
        String s;
        Random random = new Random();

        // Genera un numero casuale tra 1 e 10 e lo converte in una stringa
        int primo = random.nextInt(11) + 1;
        s = primo + "";
        nums.add(primo);

        // Genera altri 4 numeri casuali e li aggiunge all'arraylist
        for (int i = 0; i < 4; i++) {
            int j = random.nextInt(11);
            s = s + " " + j;
            nums.add(j);
        }

        // Legge il messaggio inviato dal client
        while (leggi.hasNextLine()) {
            String cliente = leggi.nextLine();
            System.out.println(cliente);
            if (cliente.equals("carte")) {
                // Se il messaggio è "carte", invia i numeri casuali al client
                PrintWriter scrivi = new PrintWriter(socket.getOutputStream());
                scrivi.println(s);
                scrivi.flush();
                break;
            } else
                System.out.println("errore");
        }

        // Crea un PrintWriter per inviare dati al client
        PrintWriter scrivi = new PrintWriter(socket.getOutputStream());

        // Legge il messaggio successivo inviato dal client
        String cambioclient;
        if (leggi.hasNextLine()) {
            cambioclient = leggi.nextLine();
            System.out.println(cambioclient);
            // Divide il messaggio per estrarre le scelte del cliente
            String[] scelte = cambioclient.split("cambio ");
            scelte = scelte[1].split(" ");

            // Genera nuovi numeri casuali e li sostituisce nelle posizioni scelte dal cliente
            for (int i = 0; i < scelte.length; i++) {
                primo = random.nextInt(11) + 1;
                nums.set(Integer.valueOf(scelte[i]) - 1, primo);
            }

            // Costruisce una stringa con i nuovi numeri casuali
            String numeri = String.valueOf(nums.get(0));
            for (int i = 1; i < nums.size(); i++) {
                numeri += " " + nums.get(i);
            }

            // Invia i nuovi numeri al client
            scrivi.println(numeri);
            scrivi.flush();
        } else {
            // Se non viene ricevuto un messaggio corretto, invia "errore" al client
            scrivi.println("errore");
            scrivi.flush();
        }

        // Chiude il socket
        socket.close();
    }
}
