package carsales.engeto.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        CarShop pragueCarShop = new CarShop();


        Car firstCar = new Car("Honda",150_000,false,null,500.65);
        Car secondCar = new Car("Mercedes-benz",1_200_000,true,LocalDate.of(2019,5,4),511.65);
        Car thirdCar = new Car("Volvo",900_000,true, LocalDate.of(2020,8,2),811.65);
        Car fourthCar = new Car("Toyota",180_000,false,null,566.66);
        Car fifthCar = new Car("Hyundai",290_000,true,LocalDate.of(2020,9,2),745.09);
        Car sixthCar = new Car("Aston Martin",1_500_000,false,null,125.09);
        Car seventhCar = new Car("Dacia",5_000,true,LocalDate.of(2020,10,10),554.65);
        Car eighthCar = new Car("Skoda",159_000,false,null,999.99);

        //fourthCar.setOwner("Zdenek", "Novák","Jankovcova 16, Praha 7, 170 00",true,LocalDate.of(1976,9,10));
        //fourthCar.printOwner(fourthCar.getOwner());

        pragueCarShop.addCar(firstCar);
        pragueCarShop.addCar(secondCar);
        pragueCarShop.addCar(thirdCar);
        pragueCarShop.addCar(fourthCar);
        pragueCarShop.addCar(fifthCar);
        pragueCarShop.addCar(sixthCar);
        pragueCarShop.addCar(seventhCar);
        pragueCarShop.addCar(eighthCar);


        for (Car car : pragueCarShop.carsOffer){
            counter = counter + 1;
            if (counter%2 == 0){
                pragueCarShop.carsOffer.get(counter-1).setOwner("Kryštof", "Novák","Jankovcova 15, Praha 7, 170 00",true,LocalDate.of(1975,9,10));
            } else if(counter%3 == 0){
                pragueCarShop.carsOffer.get(counter-1).setOwner("Jan","Štěpnička","Johnova 4, Praha 4, 140 00",false,LocalDate.of(1991,2,23));
            } else if(counter%5 == 0){
                pragueCarShop.carsOffer.get(counter-1).setOwner("Michal","Dvořák","Merhautova 5, Praha 5, 150 00",true,LocalDate.of(1963,6,5));
            } else {
                pragueCarShop.carsOffer.get(counter-1).setOwner("George","Yolo","Downing Street 10, London",true,LocalDate.of(1945,1,2));
            }
        }


        for (Car car : pragueCarShop.carsOffer){
            Owner owner;
            owner = car.getOwner();
            if (owner == null){
                System.out.println("owner is null");
            } else {
                System.out.println("owner is NOT null");
            }

            car.printOwner(car.getOwner());
        }

        pragueCarShop.printAllCars();





    }
}
