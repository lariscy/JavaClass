package cl12;

public class SampleParentException extends Exception {
	
	public SampleParentException() {
		super("SampleParentException message");
	}
	
	public SampleParentException(String message){
		super(message);
	}

}
