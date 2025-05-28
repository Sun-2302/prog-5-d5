import Model.Coffee;
import Service.CoffeeService;
import Service.DispenserService;
import Service.PaymentService;
import Exception.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<Coffee> coffeeList = List.of(
                new Coffee("Expresso", 1.0, 4),
                new Coffee("Mocha", 3.0, 2),
                new Coffee("Latte", 2.0, 0)
        );

        CoffeeService coffeeService = new CoffeeService(coffeeList);
        PaymentService paymentService = new PaymentService();
        DispenserService dispenserService = new DispenserService();

        System.out.println("Bienvenue !");
        System.out.print("Entrez le mode de paiement (carte/cash) : ");
        String paymentMethod = scanner.nextLine(); //To Do

        System.out.println("Voici les boissons disponibles : ");
        for(Coffee coffee : coffeeService.listAvailableCoffee()){
            System.out.println("- " + coffee.getName() + " " + coffee.getPrice() + "€");
        }

        System.out.print("\nEntrez le nom de la boisson : ");
        String chosenName = scanner.nextLine();

        try {
            Coffee chosenCoffee = null;
            for (Coffee coffee : coffeeService.listAvailableCoffee()) {
                if (coffee.getName().equalsIgnoreCase(chosenName)) {
                    chosenCoffee = coffee;
                    break;
                }
            }

            if (chosenCoffee == null) {
                throw new CoffeeUnavailableException("Boisson indisponible.");
            }

            System.out.print("Insérez l'argent en euros : ");
            double amountInserted = scanner.nextDouble();

            paymentService.verifyPayment(amountInserted, chosenCoffee.getPrice());

            dispenserService.prepareCoffee(chosenCoffee);

        } catch (CoffeeUnavailableException | PaymentException | MachineException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }
}