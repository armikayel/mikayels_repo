package engeto.company.com;

import java.time.LocalDate;

public class SingleMeasurement implements Comparable<SingleMeasurement>{
    private LocalDate date;
    private int day;
    private double avg_temp;
    private double max_temp;
    private double min_temp;
    private double pressure;
    private double windSpeed;
    private double humidity;
    private double precipitation;

    public SingleMeasurement(int year, int month, int day, double avg_temp, double max_temp, double min_temp, double pressure, double windSpeed, double humidity, double precipitation) {
        this.date = LocalDate.of(year,month,day);
        this.day = day;
        this.avg_temp = avg_temp;
        this.max_temp = max_temp;
        this.min_temp = min_temp;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    public SingleMeasurement() {
    }

    public int getDay() {
        return day;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAvg_temp() {
        return avg_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    @Override
    public int compareTo(SingleMeasurement o) {
        return Integer.compare(this.day, o.getDay());
    }
}
