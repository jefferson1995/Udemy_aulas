package default_methods.application.services;

import java.security.InvalidParameterException;

public interface InterestService {

    double getInterestRate();

    /*
        Não será necessário adicionar os métodos nas classes que irão implementar esta
        interface, porque vai ser padão na interface
     */
    default double payment(double amount, int months) {
        if (months < 1) {
            throw new InvalidParameterException("Months must be greater than zero ");
        }
        /*
            amount * (1 + interestRate / 100)n
         */
        return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
    }


}


