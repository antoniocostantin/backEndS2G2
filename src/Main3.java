import java.util.HashMap;
import java.util.Map;

public class Main3 {
    private static final Map<String, String> rubrica = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("-------------------- FUNZIONE 1 ----------------------");
        try {
            addContact("Aldo Baglio", "+39 3425456547");
            addContact("Giovanni Storti", "+39 3425456548");
            addContact("Giacomo Poretti", "+39 3425456549");
            System.out.println("Aggiunti " + rubrica.size() + " contatti");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------- FUNZIONE 2 ----------------------");
        int totaleContattiPreEliminazione = rubrica.size();
        removeContactByName("Giacomo Poretti");
        System.out.println("Ho rimosso " + (totaleContattiPreEliminazione - rubrica.size()) + " contatti");

        System.out.println("-------------------- FUNZIONE 3 ----------------------");
        findPersonByPhoneNumber("+39 3425456547");

        System.out.println("-------------------- FUNZIONE 4 ----------------------");
        findNumberByName("Aldo Baglio");
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
