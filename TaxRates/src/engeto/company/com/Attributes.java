package engeto.company.com;

public class Attributes {

    private int attributeOrder;
    private String attributeName;

    public Attributes(int attributeOrder) {
        this.attributeOrder = attributeOrder;
        this.attributeName = setAttributeName(attributeOrder);
    }

    public void setAttributes(int attributeOrder) {
        this.attributeOrder = attributeOrder;
        this.attributeName = setAttributeName(attributeOrder);
    }

    public String getAttributeName() {
        return attributeName;
    }

    public int getAttributeOrder() {
        return attributeOrder;
    }

    private static String setAttributeName(int attributeOrder){
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
}
