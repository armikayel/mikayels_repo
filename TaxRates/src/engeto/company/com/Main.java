package engeto.company.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();

        DataImportOOP newImport = new DataImportOOP("C:\\Users\\armik\\OneDrive\\Dokumenty\\IDEA_projects\\vat_eu.csv");
        try {resultList = newImport.getTaxRatesOfCountries();
        } catch (IOException e) {
            System.out.println("Exception");
        }

        for (Map<String,String> m:resultList) {

            int baseRate = Integer.parseInt(m.get("baseRate"));

            if (baseRate > 20){
                System.out.println(m.get("stateLong")+" ("+baseRate+"%)");
            }
        }

        /*try {resultList = DataImportNONOOP.getImportedList("C:\\Users\\armik\\OneDrive\\Dokumenty\\IDEA_projects\\vat_eu.csv");
        } catch (IOException e) {
            System.out.println("Exception");
        }

        for (Map<String,String> m:resultList) {

            int baseRate = Integer.parseInt(m.get("baseRate"));

            if (baseRate > 20){
                System.out.println(m.get("stateLong")+" ("+baseRate+"%)");
            }
        }*/

    }
}
