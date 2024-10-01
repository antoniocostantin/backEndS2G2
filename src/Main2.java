import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        System.out.println("Inserisci il numero di elementi seguito dal tasto Invio");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> randomIntegers = getRandomList(n);
        System.out.println("-------------------- FUNZIONE 1 ----------------------");
        printList(randomIntegers);
        System.out.println("-------------------- FUNZIONE 2 ----------------------");
        List<Integer> mirrored = mirrorList(randomIntegers);
        printList(mirrored);
        System.out.println("-------------------- FUNZIONE 3 ----------------------");
        printOddEven(mirrored, false);
        printOddEven(mirrored, true);

        scanner.close();
    }

    public static List<Integer> getRandomList(int n) {

        List<Integer> arr = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr.add(rnd.nextInt(0, 101));
        }
        Collections.sort(arr);
        return arr;
    }

    public static List<Integer> mirrorList(List<Integer> list) {
        List<Integer> mirrored = new ArrayList<>(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            mirrored.add(list.get(i));
        }
        return mirrored;
    }

    public static void printList(List<Integer> list) {
        System.out.println("Stampo lista lunga " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Posizione [" + (i) + "]: " + list.get(i));

        }
    }

    public static void printOddEven(List<Integer> list, boolean even) {
        System.out.println("Stampo lista lunga " + list.size());
        String evenOdd = even ? "pari" : "dispari";
        System.out.println("ma stampo solo i numeri in posizione " + evenOdd);
        int index = 0;
        for (Integer intero : list) {
            index++;
            if (even) {
                if (index % 2 == 0)
                    System.out.println("Posizione [" + index + "]: " + intero);
            } else {
                if (index % 2 != 0)
                    System.out.println("Posizione [" + index + "]: " + intero);
            }

        }
    }
}
