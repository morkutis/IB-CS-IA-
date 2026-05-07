import java.io.Serializable;
import java.util.ArrayList;

public class Spinta implements Serializable {
    String shelfname;
    ArrayList<ArrayList<Knyga>> kubai;
    public Spinta(String shelfname, int cubecount) {
        this.shelfname = shelfname;
        kubai = new ArrayList<>();

        for (int i=0; i<cubecount; i++) {
            kubai.add(new ArrayList<Knyga>());
        }

    }
    public void AddBookToCube(Knyga uzrasas, int cubeNumber) {
        if (cubeNumber<1) {
            System.out.println("Invalid number");
        } kubai.get(cubeNumber-1).add(uzrasas);
        

    }
       
    }

