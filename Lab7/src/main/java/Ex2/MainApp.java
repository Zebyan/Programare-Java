package Ex2;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.*;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Set<InstrumentMuzical> instrumente = new HashSet<>();
        instrumente.add(new Chitara("Yamaha", 2500, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Fender", 3000, TipChitara.ACUSTICA, 12));
        instrumente.add(new Chitara("Gibson", 3200, TipChitara.CLASICA, 8));
        instrumente.add(new SetTobe("Roland", 4500, TipTobe.ELECTRONICE, 5, 2));
        instrumente.add(new SetTobe("Tama", 2700, TipTobe.ACUSTICE, 6, 3));
        instrumente.add(new SetTobe("Pearl", 3500, TipTobe.ACUSTICE, 8, 4));

        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        File fisier = new File("instrumente.json");
        mapper.writeValue(fisier,instrumente);

        ObjectReader reader = mapper.readerFor(new HashSet<InstrumentMuzical>().getClass());
        Set<InstrumentMuzical> instrumenteCitite = reader.readValue(fisier);

        System.out.println(instrumenteCitite.getClass());

        
    }
}
