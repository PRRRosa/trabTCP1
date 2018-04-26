package bank.ui.text.command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import bank.business.AccountOperationService;
import bank.business.domain.Transfer;
import bank.ui.text.BankTextInterface;

public class AuthenticateTransactionCommand extends Command{
	private final AccountOperationService accountOperationService;

	public AuthenticateTransactionCommand(BankTextInterface bankInterface, 
			AccountOperationService accountOperationService) {
		super(bankInterface);
		this.accountOperationService = accountOperationService;	
	}

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		Scanner accountIndex = new Scanner(System.in);
		List<Transfer> PendingTransfer = accountOperationService.listPendingTransfers();
		if(PendingTransfer.size()==0) {
			System.out.println("Nenhuma Pendencia");
		}
		else {
			System.out.println("Escolha o índice da transferência:");
			for(int i=0;i<PendingTransfer.size();i++) {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				System.out.print(i + ": ");
				System.out.print("Valor"+ ":" +  Double.toString(PendingTransfer.get(i).getAmount()) + " ");
				System.out.print("Data" + ":" + df.format(PendingTransfer.get(i).getDate()) + " ");
				System.out.println("Localiza��o"+":"+ PendingTransfer.get(i).getAccount().toString());	
			}
			
			int transferIndex = accountIndex.nextInt();
		}
		
	}

}
