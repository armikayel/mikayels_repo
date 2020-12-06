package engeto.company.com;

import java.util.Comparator;

public class SortByMinTemp implements Comparator<SingleMeasurement> {
    @Override
    public int compare(SingleMeasurement o1, SingleMeasurement o2) {
        return Double.compare(o1.getMin_temp(), o2.getMin_temp());
    }
}
