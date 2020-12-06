package engeto.company.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllMeasurements {
    String source;
    List<SingleMeasurement> importedMeasurements;

    public AllMeasurements(String source) {
        this.source = source;
        this.importedMeasurements = new ArrayList<>();
    }

    public void setAllMeasurements() throws IOException {

        int counter = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] separatedData = line.split(",");

                counter++;
                if (counter == 1) continue;

                SingleMeasurement newMeasurement = new SingleMeasurement(Integer.parseInt(separatedData[0]),
                        Integer.parseInt(separatedData[1]),
                        Integer.parseInt(separatedData[2]),
                        Double.parseDouble(separatedData[3]),
                        Double.parseDouble(separatedData[4]),
                        Double.parseDouble(separatedData[5]),
                        Double.parseDouble(separatedData[6]),
                        Double.parseDouble(separatedData[7]),
                        Double.parseDouble(separatedData[8]),
                        Double.parseDouble(separatedData[9]));

                importedMeasurements.add(newMeasurement);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SingleMeasurement> getImportedMeasurements() {
        return importedMeasurements;
    }

    public double getAvgTemp() {
        double avg_temps = 0.0;
        for (SingleMeasurement sm : importedMeasurements) {
            avg_temps += sm.getAvg_temp();
        }
        return Math.round((avg_temps /= importedMeasurements.size())*10)/10.0;
    }

    public SingleMeasurement getExtremeTempMeasurement(String minMax) {
        SingleMeasurement measurement = new SingleMeasurement();

        if (minMax.equals("max")) {
            importedMeasurements.sort(new SortByMaxTemp());
            measurement = importedMeasurements.get(importedMeasurements.size()-1);
        } else if (minMax.equals("min")) {
            importedMeasurements.sort(new SortByMinTemp());
            measurement = importedMeasurements.get(0);
        }
        return measurement;
    }

    public int getAllWindyDays() {
        int result = 0;
        for (SingleMeasurement m : importedMeasurements) {
            if (m.getWindSpeed() >= 4.2) {
                result++;
            }
        }
        return result;
    }

    public int getAllCalmDays() {
        int result = 0;
        for (SingleMeasurement m : importedMeasurements) {
            if (m.getWindSpeed() <= 1.8) {
                result++;
            }
        }
        return result;
    }

    public double getPrecipitationPerTenDays(int whichDecade) {

        double result = 0.0;
        int dayNumber = 0;
        int startPos;

        switch(whichDecade){
            case 1:
                startPos = 0;
                dayNumber = 10;
                break;
            case 2:
                startPos = 10;
                dayNumber = 20;
                break;
            case 3:
                startPos = 20;
                dayNumber = importedMeasurements.size();
                break;
            default:
                return result;
        }

        Collections.sort(importedMeasurements);

        for (int i = startPos; i < dayNumber; i++){
            SingleMeasurement m = importedMeasurements.get(i);
            result += m.getPrecipitation();
        }
        return Math.round(result*10)/10.0;
    }

    public void printAsterisks(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("   | 00--------10--------20--------30--------40");

        Collections.sort(importedMeasurements);
        int counter = 0;
        for (SingleMeasurement m: importedMeasurements) {
            counter++;
            // napíšeme den a pridame svislitko
            String row = counter/10 == 0? "0"+ counter :Integer.toString(counter);
            row = row+" |  ";

            // zjistíme rozsah pro dané jednotlivé měření
            int minTemp = (int) Math.round(m.getMin_temp());
            int maxTemp = (int) Math.round(m.getMax_temp());

            // vypíšeme mezery do minima
            for (int i = 0; i < minTemp; i++){
                row = row+" ";
            }

            // vypíšeme hvezdicky od minima do maxima
            for (int i = minTemp; i < maxTemp; i++){
                row = row+"*";
            }
            System.out.println(row);
        }
        System.out.println("   | 00--------10--------20--------30--------40");
        System.out.println("--------------------------------------------------------------------------------");
    }

}
