package exceptions;

public class NegativeCycleTimeException extends RuntimeException{

	private final String errorMessage;
	
	public NegativeCycleTimeException() {
		
		super();
		this.errorMessage = "Negative Cycle times don't make sense."
				+ " This can be dangerous because any code using acceleration limits"
				+ " can suddenly reverse direction violently upon being enabled for a"
				+ " second time in a row."; 
	}
	
	public NegativeCycleTimeException(String errorMessage) {
		
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public String getMessage() {
		
		return errorMessage;
	}
}
