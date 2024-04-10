package tema2;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

public class MainApp {
    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/numere1.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            File file = new File("src/main/resources/numere.json");
            ObjectMapper mapper = new ObjectMapper();
            List<PerecheNumere> persoane = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<PerecheNumere> nr = citire();
        System.out.println(nr);

        for (PerecheNumere p : nr) {
            System.out.println(p);
        }
        for (PerecheNumere p : nr) {
            System.out.println("1. Consecutive in Fibonaci:  "+p.suntConsecutiveInFibonacci());
            System.out.println("2. Cel mai mic multiplu comun: "+p.celMicMultipluComun());
            System.out.println("3. Suma cifrelor egale: "+p.sumaCifrelorEgala());
            System.out.println("4. Acelasi numar de cifre pare: "+p.numarCifrePare());

        }

        nr.add(new PerecheNumere(12, 13));
        scriere(nr);



    }
}
