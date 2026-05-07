import java.io.Serializable;

public class Knyga implements Serializable {
    String name;
    String auth;
    String yor;
    String genre;
    public void Format() { // knygos details
        System.out.println("Autorius: " + auth);
        System.out.println(name);
        System.out.println("Parašyta: " + yor);
    }
    public void ThemeSort(String zanras) { // atrinkti pagal theme
        System.out.println(zanras + " knygos yra:");
        if (zanras.equals(genre)) {
            System.out.println(name);
        }
        }
    }