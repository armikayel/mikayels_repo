package engeto.company.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ArrayList<Map<String,String>> resultList = new ArrayList<Map<String,String>>();

        DataImportOOP newImport = new DataImportOOP("C:\\Users\\armik\\OneDrive\\Dokumenty\\IDEA_projects\\vat_eu.csv");
        try {resultList = newImport.getImportedList();
        } catch (IOException e) {
            System.out.println("Exception");
        }

        for (Map<String,String> m:resultList) {

            int baseRate = Integer.parseInt(m.get("baseRate"));

            if (baseRate > 20){
                System.out.println(m.get("stateLong")+" ("+baseRate+"%)");
            }
        }


        try {resultList = DataImportNONOOP.getImportedList("C:\\Users\\armik\\OneDrive\\Dokumenty\\IDEA_projects\\vat_eu.csv");
        } catch (IOException e) {
            System.out.println("Exception");
        }

        for (Map<String,String> m:resultList) {

            int baseRate = Integer.parseInt(m.get("baseRate"));

            if (baseRate > 20){
                System.out.println(m.get("stateLong")+" ("+baseRate+"%)");
            }
        }

    }

}
