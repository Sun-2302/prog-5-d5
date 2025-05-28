package Service;

import Model.Coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeService {
    private List<Coffee> coffeeList;

    public CoffeeService(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    public List<Coffee> listAvailableCoffee(){
        List<Coffee> availableCoffeeList = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            if (coffee.getStock()>0){
                availableCoffeeList.add(coffee);
            }
        }
        return availableCoffeeList;
    }
}
