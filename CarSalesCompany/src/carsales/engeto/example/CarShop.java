package carsales.engeto.example;

import java.util.ArrayList;

public class CarShop {
    ArrayList<Car> carsOffer = new ArrayList<>();

    public void addCar(Car newCar){
        carsOffer.add(newCar);
    }

    /*
     * ZJISTENI CELKOVE CENY VSECH AUT
     */
    public int getPriceSum(){
        int sumPrice = 0;
        for (Car car : carsOffer){
            sumPrice = sumPrice + car.getPrice();
        }
        return sumPrice;
    }

    /*
    * ZJISTENI CELKOVEHO POCTU AUT
    */
    public int getCarsCount(){
        return carsOffer.size();
    }
    /*
    * VYPIŠ VŠECHNA NABÍZENÁ AUTA
    */
    public void printAllCars(){
        for (Car car : carsOffer){
            System.out.println(car.getBrand());
        }
    }
}
