package engeto.company.com;

import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class ListOfStatesTaxes {

    String source;
    List<State> importedStatesTaxes;

    public ListOfStatesTaxes(String source) {
        this.source = source;
        this.importedStatesTaxes = new ArrayList<>();
    }

    public void setTaxRatesOfCountriesFromJSON() throws IOException {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(source)) {

            // dostaneme JSON do objektu
            Object javaObject = new JSONParser().parse(reader);

            // cast java objektu do JSONObjektu
            JSONObject jsonObject = (JSONObject) javaObject;

            // vytáhni jen objekt "rates"
            Map rates = (Map)jsonObject.get("rates");

            for (Map.Entry state : (Iterable<Map.Entry>) rates.entrySet()) {

                // založ nový stát a naplň atribut pro zkratku
                State newState = new State();
                newState.setStateShort(state.getKey().toString());

                // vytáhni pro každý stát jeho atributy
                Map stateInfo = (Map)rates.get(newState.getStateShort());

                for (Map.Entry stateInfoIt : (Iterable<Map.Entry>) stateInfo.entrySet()){

                    switch(stateInfoIt.getKey().toString()){
                        case "country":
                            newState.setStateLong(stateInfoIt.getValue().toString());
                            break;
                        case "standard_rate":
                            newState.setBaseRate(Double.parseDouble(stateInfoIt.getValue().toString()));
                            break;
                        case "reduced_rate":
                            if(stateInfoIt.getValue().toString().equals("false")){
                                newState.setLoweredRate(newState.getBaseRate());
                            } else {
                                newState.setLoweredRate(Double.parseDouble(stateInfoIt.getValue().toString()));
                            }
                            break;
                        case "parking_rate":
                            if(stateInfoIt.getValue().toString().equals("false")){
                                newState.setParkingRate(false);
                            } else {
                                newState.setParkingRate(true);
                            }
                            break;
                        default:
                            break;
                    }
                }
                importedStatesTaxes.add(newState);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void setTaxRatesOfCountries() throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            while ((bufferedReader.read()) != -1) {

                String readLine = bufferedReader.readLine();
                String[] separatedData = readLine.split("\t");
                State newState = new State();

                newState.setStateShort(separatedData[0]);
                newState.setStateLong(separatedData[1]);
                newState.setBaseRate(Double.parseDouble(separatedData[2]));
                newState.setLoweredRate(Double.parseDouble(separatedData[3]));
                newState.setParkingRate(Boolean.parseBoolean(separatedData[4]));

                importedStatesTaxes.add(newState);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<State> getImportedStatesTaxesByLimit(double limit) {

        List<State> returnList = new ArrayList<>();

        for (State state:importedStatesTaxes) {

            if (state.getBaseRate() > limit){
                returnList.add(state);
            }
        }
        return returnList;
    }

    public List<State> getImportedStatesTaxes() {
        return importedStatesTaxes;
    }
}
