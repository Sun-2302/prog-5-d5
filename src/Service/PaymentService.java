package Service;

import Exception.PaymentException;

public class PaymentService {

    public void verifyPayment(Double amount, double coffeePrice) throws PaymentException {
        if(amount < coffeePrice){
            throw new PaymentException("PaiementInsuffisant");
        }
    }
}
