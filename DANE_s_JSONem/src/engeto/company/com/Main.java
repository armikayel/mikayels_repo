package engeto.company.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ListOfStatesTaxes listOfStatesTaxes = new ListOfStatesTaxes("C:\\Users\\armik\\OneDrive\\Dokumenty\\ENGETO_java_akademie\\rates.json");

        // vytáhni dta ze souboru
        try {
            listOfStatesTaxes.setTaxRatesOfCountriesFromJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Zadej limit:");
        Scanner input = new Scanner(System.in);
        double limit = input.nextDouble();
        System.out.println("Zadaný limit je: " + limit);

        List<State> statesList = new ArrayList<>();
        statesList = listOfStatesTaxes.getImportedStatesTaxesByLimit(limit);

        //vypsat státy a sazby splnujici podmínku limitu
        for (State state : statesList) {
            System.out.println(state.getStateLong() + " (" + state.getBaseRate() + "%)");
        }

        //vypsat stát s nejvyssi sazbou dane
        statesList = listOfStatesTaxes.getImportedStatesTaxes();

        List<Double> rates = new ArrayList<>();
        List<String> states = new ArrayList<>();
        rates.add(0.0);

        for (State state : statesList) {
            double currentStatesRate = state.getBaseRate();
            String currentState = state.getStateLong();

            if (currentStatesRate < rates.get(0)) {
                continue;
            } else if (currentStatesRate > rates.get(0)) {
                rates.clear();
                states.clear();
                rates.add(currentStatesRate);
            }
            states.add(currentState);
        }

        StringBuilder message = new StringBuilder("Nejvyšší sazbu daně " + rates.get(0) + "% má ");
        for (String state: states){
            message.append(state);
            message.append(", ");
        }
        System.out.println(message.replace(message.length() - 2,message.length(),".")+"\n");


        //vypsat státy seřazené dle sazby daně
        Collections.sort(statesList);
        System.out.println("Výpis států dle výše sazby daně od nejnižší: ");
        statesList.stream().map(s -> s.stateLong).forEach(System.out::println);
        System.out.println("----");
        System.out.println("Výpis států dle výše sazby daně od nejvyšší: ");
        Collections.reverse(statesList);
        statesList.stream().map(s -> s.stateLong).forEach(System.out::println);


    }
}
