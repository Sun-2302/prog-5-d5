package Service;

import Model.Coffee;
import Exception.MachineException;

public class DispenserService {
    public void prepareCoffee(Coffee coffee) throws MachineException {
        try {
            System.out.println("Préparation de " + coffee.getName() + " en cours");
            Thread.sleep(1000);
            coffee.decrementStock();
            System.out.println("Votre café est prêt");
        } catch (InterruptedException e){
            throw new MachineException("Erreur lors de la préparation");
        }
    }
}
