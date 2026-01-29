package exercicio_5.model.services;

import exercicio_5.model.entities.Contract;
import exercicio_5.model.entities.Installment;

public class ContractService {
 
    private OnlinePaymentService onlinePaymentService;
    
    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void ProcessContract(Contract contract, Integer months){
        final Double amount = contract.getTotalValue() / months;
        Installment[] installments = new Installment[months];
        for(int i = 0; i < months; i++){
            Installment aux = new Installment(contract.getDate().plusMonths(i+1), amount + onlinePaymentService.paymentFee(amount + onlinePaymentService.interest(amount, i+1)) + onlinePaymentService.interest(amount, i+1));
            installments[i]= aux;
        }
        contract.setInstallments(installments);
    }
}
