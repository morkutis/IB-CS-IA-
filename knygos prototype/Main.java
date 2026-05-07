import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileInputStream;
public class Main {
    public static void main(String[] args) {
        
        ArrayList<Knyga> sarasas = new ArrayList<>(); //init everything
        Scanner reader = new Scanner(System.in);
        ObjectOutputStream out = null;
        int cubenumber;

        File file = new File("storeddata.dat");
        if(file.exists()) {
            try { //read file
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("storeddata.dat"));
                sarasas = (ArrayList<Knyga>) in.readObject();
                in.close();
                System.out.println("Uzkrauti " + sarasas.size() + " knygu vienetai is failo");
            } catch(IOException | ClassNotFoundException e) {
                System.out.println("Error loading books from file: " + e.getMessage());
            }
        }
        
        
        while (true) { //menu loop
            System.out.println("Rinkites veiksma: 1 - prideti nauja knyga, 2 - ieskoti pagal zanra, 3 - visu knygu sarasas, 4 - baigti programa");
            int choice = -1;
            try {
                choice = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ne tokia komanda");
                reader.close();
                return;
            }
            if(choice == 1) { // log new book
            Knyga uzrasas = new Knyga();
            System.out.println("Iveskite knygos pavadinima: ");
            uzrasas.name  = reader.nextLine();
            System.out.println("Iveskite autoriu: ");
            uzrasas.auth = reader.nextLine();
            System.out.println("Iveskite parasymo metus ");
            uzrasas.yor = reader.nextLine();
            System.out.println("Iveskite zanra: ");
            uzrasas.genre = reader.nextLine();
            sarasas.add(uzrasas);
            System.out.println("Irasykite spinteles numeri:");
            cubenumber = reader.nextLine();

            }
            else if (choice == 2) { //atrinkti pagal zanra
                System.out.println("Iveskite zanra, kurio ieskote: ");
                String ieskoma = reader.nextLine();
                for (Knyga uzrasas : sarasas) {
                uzrasas.ThemeSort(ieskoma);
                }
            }
            else if (choice == 3) { //knygu sarasas
                for (Knyga uzrasas : sarasas) {
                    System.out.println(uzrasas.name);
                }
            }
            else if (choice == 4) { // baigti programa
                try {
                    try { //open file for writing
                    out = new ObjectOutputStream(new FileOutputStream("storeddata.dat"));
                    } catch (IOException e) {
                    System.out.println("Error opening file: " + e.getMessage());
                     }
                    out.writeObject(sarasas);
                } catch (IOException e) {
                System.out.println("Error writing book to file: " + e.getMessage());
            }
                reader.close();
                try {
                        out.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
                return;
            }
            else {
                System.out.println("ne tokia komanda");
            }
        }
    }
}