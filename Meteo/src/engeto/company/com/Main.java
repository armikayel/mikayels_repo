package engeto.company.com;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // vytvoříme novou instanci modelu měření
        AllMeasurements measurements = new AllMeasurements("C:\\Users\\armik\\OneDrive\\Dokumenty\\ENGETO_java_akademie\\B2BTUR01_07_2019.csv");

        // naplníme model imported dat ze souboru
        try {measurements.setAllMeasurements();
        } catch (IOException e) {
            System.out.println("Exception");
        }

        // vytáhneme si získaná data
        List<SingleMeasurement> importedMeasurements = measurements.getImportedMeasurements();

        // 1.) Přivítat uživatele výpisem na standardní výstup:
        System.out.println("--------------------------------------------------------------------------------"+"\n"+
                           "Welcome to the application for Meteorological Data Analysis.");

        // 2.1) vypsat celkový počet denních záznamů, které se budou vyhodnocovat
        System.out.println("--------------------------------------------------------------------------------"+"\n"+
                           "We have "+importedMeasurements.size()+" meteorological daily records to analyze.");

        // 2.2) vypsat průměrnou denní teplotu
        System.out.println("Average temperature for the reporting period: "+measurements.getAvgTemp());

        // 2.3) vypsat maximální teplotu za období s uvedením max. tep. a den zjisteneho maxima
        SingleMeasurement m = measurements.getExtremeTempMeasurement("max");
        System.out.println("Maximum temperature for the reporting period: "+m.getDate()+" was "+m.getMax_temp());

        // 2.4) vypsat minimální teplotu za období s uvedením min. tep. a den zjisteneho maxima
        m = measurements.getExtremeTempMeasurement("min");
        System.out.println("Maximum temperature for the reporting period: "+m.getDate()+" was "+m.getMin_temp());

        // 2.5) celkový počet větrných dnů za dané období
        System.out.println("Number of windy days:"+measurements.getAllWindyDays());

        // 2.6) celkový počet klidných dnů za dané období
        System.out.println("Number of calm days:"+measurements.getAllCalmDays());

        // 2.7) souhrnný přehled srážek
        System.out.println("Precipitation summary in month decades: "+measurements.getPrecipitationPerTenDays(1)+"mm - "
                            +measurements.getPrecipitationPerTenDays(2)+"mm - "+measurements.getPrecipitationPerTenDays(3)+" mm\n"+
                            "--------------------------------------------------------------------------------");
        // 3.) Vypsat na standardní výstup graf rozložení denních teplot.
        measurements.printAsterisks();
    }
}
