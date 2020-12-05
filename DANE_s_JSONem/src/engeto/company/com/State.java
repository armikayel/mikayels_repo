package engeto.company.com;

public class State implements Comparable<State>{
      String stateShort;
      String stateLong;
      double baseRate;
      double loweredRate;
      boolean isParkingRate;

    public State() {
        this.stateShort = "";
        this.stateLong = "";
        this.baseRate = 0.0;
        this.loweredRate = 0.0;
        this.isParkingRate = false;
    }

    public String getStateShort() {
        return stateShort;
    }

    public void setStateShort(String stateShort) {
        this.stateShort = stateShort;
    }

    public String getStateLong() {
        return stateLong;
    }

    public void setStateLong(String stateLong) {
        this.stateLong = stateLong;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public double getLoweredRate() {
        return loweredRate;
    }

    public void setLoweredRate(double loweredRate) {
        this.loweredRate = loweredRate;
    }

    public boolean isParkingRate() {
        return isParkingRate;
    }

    public void setParkingRate(boolean parkingRate) {
        isParkingRate = parkingRate;
    }

    @Override
    public int compareTo(State otherState) {
        return Double.compare(getBaseRate(), otherState.getBaseRate());
    }
}
