package cl12;

public class SampleExceptionDriver {
	
	public static void main(String[] args) {
		try{
			throw new SampleParentException();
		} catch (SampleParentException ex){
			System.out.println(ex.getMessage());
		}
	}

}
