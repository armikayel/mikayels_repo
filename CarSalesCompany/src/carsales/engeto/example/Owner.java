package carsales.engeto.example;

import java.time.LocalDate;

public class Owner {
    String name;
    String surname;
    String address;
    boolean isVip;
    LocalDate birthDate;

    public Owner(){
        this("Joe","Doe","None",false,LocalDate.of(1990,01,01));
    }

    public Owner(String name, String surname, String address, boolean isVip, LocalDate birthDate){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.isVip = isVip;
        this.birthDate = birthDate;
    }

    public Owner(String name, String surname, boolean isVip){
        this(name, surname, "None",isVip,LocalDate.of(1990,01,01));
    }
    //------------------------------------------
    /*
    * name - jméno
    * surname - příjmení
    */
    public String getWholeName(){
        return name+" "+surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname (String surname){
        this.surname = surname;
    }

    //------------------------------------------
    /*
    * address - Adresa
    */
    public String getAddress (){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    //------------------------------------------
    /*
    * isVIP - je klient VIP klientem?
    */
    public boolean getIsVip(){
        return isVip;
    }

    public void setIsVip(boolean isVip){
        this.isVip = isVip;
    }
    //------------------------------------------
    /*
    * birthDate - datum narození
    */
    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }
}
