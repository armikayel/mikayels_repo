package carsales.engeto.example;

import java.time.LocalDate;

public class Car {

    String brand;
    int price;
    boolean isSold;
    LocalDate retrieveDay;
    Owner owner;
    double consumption;

    public Car(String brand, int price, boolean isSold, LocalDate retrieveDay, double consumption){
        this.brand = brand;
        this.price = price;
        this.isSold = isSold;
        this.retrieveDay = retrieveDay;
        this.owner = null;
        this.consumption = consumption;
    }

    //--------------------------------
    /*
    * Brand - ZNAČKA vozidla
    */
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }
    //--------------------------------
    /*
     * price - CENA vozidla
     */
    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
    //--------------------------------
    /*
    * isSold - je auto PRODANÉ (Ano/Ne)
    * retrieveDay - den odběru
    */
    public void setIsSold(boolean isSold, LocalDate retrieveDay){
        this.isSold = isSold;
        this.retrieveDay = retrieveDay;
    }

    public boolean getIsSold(){
        return isSold;
    }

    public LocalDate getRetrieveDay(){
        return retrieveDay;
    }
    //--------------------------------
    /*
     * consumption - spotřeba auta
     */
    public void setConsumption(double consumption){
        this.consumption = consumption;
    }

    public double getConsumption(){
        return consumption;
    }
    //--------------------------------
    /*
    * Owner - majitel auta
    */
    public void setOwner(String name, String surname, String address, boolean isVip, LocalDate birthDate){
       this.owner = new Owner(name, surname, address, isVip, birthDate);
    }

    public Owner getOwner() {
        return owner;
    }

    //------------------------------------------
    public void printOwner(Owner owner){
        System.out.println(owner.getWholeName());
        System.out.println(owner.getAddress());
        System.out.println(owner.getIsVip());
        System.out.println(owner.getBirthDate());
    }
}
