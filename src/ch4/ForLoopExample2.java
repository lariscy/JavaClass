package ch4;

public class ForLoopExample2 {
	
	public static void main(String[] args){
		
		for (char i = 'A'; i <= 'Z'; i++){
			for (char j = 'A'; j <= i; j++){
				System.out.print(j);
			}
			System.out.println();
		}
		for (char i = 'Y'; i >= 'A'; i--){
			for (char j = 'A'; j <= i; j++){
				System.out.print(j);
			}
			System.out.println();
		}
		
	}

}
