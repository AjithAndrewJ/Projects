package Sprint1.BankingApplicationSystem;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		 super(message);
	 }
}
