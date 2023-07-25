package exercicio_fixacao.services;

public class PaypalService implements OnlinePaymentService {


    public double paymentFee(double amount) {
        return amount * 0.02;
    }


    public double interest(double amount, int months) {
        return months + months;
    }
}
