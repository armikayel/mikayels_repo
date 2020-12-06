package engeto.company.com;

import java.util.Comparator;

public class SortByMaxTemp implements Comparator<SingleMeasurement> {
    @Override
    public int compare(SingleMeasurement o1, SingleMeasurement o2) {
        return Double.compare(o1.getMax_temp(), o2.getMax_temp());
    }
}
