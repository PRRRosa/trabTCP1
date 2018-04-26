package bank.ui.text.command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import bank.business.AccountOperationService;
import bank.business.domain.Transfer;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;

public class ListPendingTransferCommand extends Command {
	private final AccountOperationService accountOperationService;

	public ListPendingTransferCommand(BankTextInterface bankInterface,
			AccountOperationService accountOperationService) {
		super(bankInterface);
		this.accountOperationService = accountOperationService;
	}
	public void execute() throws Exception {
		Long srcBranch = bankInterface.readBranchId();
		Long srcAccountNumber = bankInterface.readCurrentAccountNumber();


		List<Transfer> PendingTransfer = accountOperationService.listPendingTransfer(srcBranch,srcAccountNumber);
		if(PendingTransfer.size()==0) {
			System.out.println("Nenhuma Pendencia");
		}
		else {
		for(int i=0;i<PendingTransfer.size();i++) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			System.out.println(PendingTransfer[i]+ ":");
			System.out.println("Valor"+ ":" +  Double.toString(PendingTransfer[i].getAmount()));
			System.out.println("Data" + ":" + df.format(PendingTransfer[i].getDate()));
			System.out.println("Localização"+":"+ PendingTransfer[i].getAccount().toString());
			
		}
		}
		
	}

	
}