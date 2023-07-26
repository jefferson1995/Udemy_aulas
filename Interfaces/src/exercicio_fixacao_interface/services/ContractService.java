package exercicio_fixacao_interface.services;

import exercicio_fixacao_interface.entities.Contract;
import exercicio_fixacao_interface.entities.Installment;

import java.time.LocalDate;

public class ContractService {


    OnlinePaymentService onlinePaymentService;

    public ContractService() {

    }

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

        double basicQuota = contract.getTotalValue() / months; //Divide valor total pelo número de parcelas

        //Pega a lista e adiciona um novo installment
        for (int i = 1; i <= months; i++) {

            LocalDate dueDate = contract.getDate().plusMonths(i); //Adiciona um mês depois na data atual do contrato

            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);  //calcula a taxa

            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota)); //adiciona


        }
    }
}
