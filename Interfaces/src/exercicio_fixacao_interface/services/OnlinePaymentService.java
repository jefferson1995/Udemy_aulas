package exercicio_fixacao_interface.services;

public interface OnlinePaymentService {

    double paymentFee(double amount);
    double interest(double amount, int months);


}
