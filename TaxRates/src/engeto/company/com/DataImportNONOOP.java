package engeto.company.com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataImportNONOOP {

    //ArrayList<Map<String,String>> importedList = new ArrayList<Map<String,String>>();

    private static String getAttributeName(int attributeOrder){
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
    }

    public static ArrayList<Map<String,String>> getImportedList(String fileAddress) throws IOException {

        ArrayList<Map<String,String>> importedList = new ArrayList<Map<String,String>>();

        FileReader fileReader = new FileReader(fileAddress);

        int i;
        boolean newLine = true;
        int attributeOrder = 1;

        Map<String,String> newState = new HashMap<String, String>();
        StringBuilder importedValue = new StringBuilder();

        while ((i = fileReader.read()) != -1) {

            char importedChar = (char)i;

            if (importedChar != '\t' && importedChar != '\n'){

                importedValue.append(Character.toString(importedChar));

            } else if (importedChar == '\t'){

                newState.put(getAttributeName(attributeOrder), importedValue.toString());
                importedValue = new StringBuilder();
                attributeOrder ++;

            } else {

                importedList.add(newState);
                newState = new HashMap<String, String>();
                attributeOrder = 1;
                importedValue = new StringBuilder();

            }
        }
        fileReader.close();
        return importedList;
    }
}
