package engeto.company.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataImportOOP {

    private String fileAddress;

    public DataImportOOP(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    /*private static String getAttributeName(int attributeOrder){
        switch(attributeOrder){
            case 1:
                return "stateShort";
            case 2:
                return "stateLong";
            case 3:
                return "baseRate";
            case 4:
                return "loweredRate";
            case 5:
                return "isParkingRate";
            default:
                return "";
        }
    }*/

    public List<Map<String, String>> getTaxRatesOfCountries() throws IOException {

        List<Map<String, String>> taxRatesOfCountries = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress))) {
            while ((bufferedReader.read()) != -1) {

                String readLine = bufferedReader.readLine();
                String[] separatedData = readLine.split("\t");

                Map<String, String> newState = new HashMap<String, String>();
                for(int i = 0; i < separatedData.length; i++){
                    Attributes attributeName = new Attributes(i+1);
                    newState.put(attributeName.getAttributeName(), separatedData[i]);
                }
                taxRatesOfCountries.add(newState);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taxRatesOfCountries;
    }
}
