package bank.business.domain;

/**
 * @author Ingrid Nunes
 * 
 */
public class Transfer extends Transaction {

	private CurrentAccount destinationAccount;
	
	public enum TransferStatus{
		FINALIZED,PENDING,CANCELED
	}
	
	private TransferStatus status;
	
	public void setFinalized() {
		status=TransferStatus.FINALIZED;
	}

	public void setCanceled() {
		status=TransferStatus.CANCELED;
	}
	
	public void setPending() {
		status=TransferStatus.PENDING;
	}
	
	public TransferStatus getStatus() {
		return status;
	}

	public Transfer(OperationLocation location, CurrentAccount account,
			CurrentAccount destinationAccount, double amount) {
		super(location, account, amount);
		this.destinationAccount = destinationAccount;
	}

	/**
	 * @return the destinationAccount
	 */
	public CurrentAccount getDestinationAccount() {
		return destinationAccount;
	}



}
