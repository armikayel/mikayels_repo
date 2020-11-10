package school.examples.engeto.com;

public enum Grades {
    NaN("NEHODNOCENO",0),
    VYBORNY("Výborný",1),
    CHVALITEBNY("Chvalitebný",2),
    DOBRY("Dobrý", 3),
    DOSTATECNY("Dostatečný",4),
    NEDOSTATECNY("Nedostatečný",5);

    private Grades(String description, int number){}
}
