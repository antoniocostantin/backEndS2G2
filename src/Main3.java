import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main3 {
    private static final Map<String, String> rubrica = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("-------------------- FUNZIONE 1 ----------------------");
        boolean continua = true;
        Scanner sc = new Scanner(System.in);
        try {
            do {

                System.out.println("Inserisci un nome da aggiunger in rubrica");
                String nome = sc.nextLine();
                System.out.println("Inserisci il suo numero di telefono");
                String telefono = sc.nextLine();
                addContact(nome, telefono);
                System.out.println("Inserisci '+' x aggiungerne un altro");
                String x = sc.nextLine();
                if (!Objects.equals(x, "+")) continua = false;
            } while (continua);


            addContact("Giacomo Poretti", "+39 3425456549");
            System.out.println("Aggiunti " + rubrica.size() + " contatti");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------- FUNZIONE 2 ----------------------");
        int totaleContattiPreEliminazione = rubrica.size();
        System.out.println("inserisci contatto da eliminare");
        String d = sc.nextLine();
        removeContactByName(d);
        System.out.println("Ho rimosso " + (totaleContattiPreEliminazione - rubrica.size()) + " contatti");

        System.out.println("-------------------- FUNZIONE 3 ----------------------");
        System.out.println("Inserisci il numero da cercare");
        String query = sc.nextLine();

        findPersonByPhoneNumber(query);

        System.out.println("-------------------- FUNZIONE 4 ----------------------");
        System.out.println("Inserisci il nome da cercare");
        String queryname = sc.nextLine();
        findNumberByName(queryname);
        System.out.println("-------------------- FUNZIONE 5 ----------------------");
        printList();
    }

    private static void addContact(String name, String phone) {
        rubrica.put(name, phone);
    }

    private static void removeContactByName(String name) {
        rubrica.remove(name);
    }

    private static void findPersonByPhoneNumber(String phone) {
        String result = "";
        for (String name : rubrica.keySet()) {
            if (phone.equals(rubrica.get(name))) {
                result = name;
            }
        }
        System.out.println(!result.isEmpty() ? result : "Contatto non trovato");
    }

    private static void findNumberByName(String name) {
        String phone = rubrica.get(name);
        System.out.println(phone != null ? phone : "Non trovato!");
    }

    private static void printList() {
        for (String name : rubrica.keySet()) {
            System.out.println("Nome: " + name + ", numero di telefono: " + rubrica.get(name));
        }
    }
}
