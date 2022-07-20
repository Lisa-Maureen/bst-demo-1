package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class BstProvider{
    private final String filepath = "src/main/resources/DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv";
    private Map<String, Bst> bstMap;

    public BstProvider() {

        bstMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){

            String line;
            line = br.readLine();       //1. Zeile abschneiden (Spaltennamen)
            System.out.println(line);   //1. Zeile ausgeben (zur Kontrolle)

            while ((line = br.readLine()) != null) {
                String[] entries = line.split(";");
                Bst bst = new Bst(
                        entries[0], entries[1], entries[2], entries[3],
                        entries[4], entries[5], entries[6], entries[7],
                        entries[8], entries[9], entries[10], entries[11]
                );
                bstMap.put(entries[1], bst);

            }
            /*System.out.println(bstMap.get("xbhbk".toUpperCase()));
            System.out.println(bstMap.get("xaprd".toUpperCase()));
            System.out.println(bstMap.get("xaps".toUpperCase()));
            System.out.println(bstMap.get("xapw".toUpperCase()));*/
        }

        catch(IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }

    public Bst findByCode (String code){
        return bstMap.get(code);
    }
}
