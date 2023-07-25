package exercicio_fixacao.services;

import exercicio_fixacao.entities.Contract;

public class ContractService {


    OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){

    }
}
