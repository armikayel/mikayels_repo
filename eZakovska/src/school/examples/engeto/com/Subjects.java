package school.examples.engeto.com;

public enum Subjects {
        AJ("Anglický jazyk",true),
        CJ("Český jazyk",false),
        NJ("Německý jazyk", false),
        FJ("Francouzský jazyk",false),
        MA("Matematika",true),
        FY("Fyzika",true),
        CH("Chemie", true),
        ZS("Základy spol. ved.", true),
        DE("Dějepis", true),
        VV("Výtvarná výchova", true),
        CM("Cvičení z matematiky", false),
        CF("Cvičení z fyziky", false),
        TE("Tělocvik", true),
        JP("Japonština", false);

        private Subjects(String description, boolean isMandatory){}
    }
