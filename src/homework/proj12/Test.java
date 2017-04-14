package homework.proj12;

/**
 * @author Steven Lariscy
 */
public class Test {
    
    public static void main(String[] args) {
        String testString = "abc ABC -9? mno xyz";
        System.out.println("orig   : "+testString);
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("--  SubstitutionCipher  --");
        try{
            SubstitutionCipher subCipher = new SubstitutionCipher(5);
            
            String encodedString = subCipher.encode(testString);
            System.out.println("encoded: "+encodedString);

            String decodedString = subCipher.decode(encodedString);
            System.out.println("decoded: "+decodedString);
            
        } catch (IllegalArgumentException ex){
            System.err.println("Error creating SubstitutionCipher: " + ex);
        }
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("--  TranspositionCipher  --");
        try {
            TranspositionCipher transCipher = new TranspositionCipher(13);
            
            String encodedString = transCipher.encode(testString);
            System.out.println("encoded: "+encodedString);

            String decodedString = transCipher.decode(encodedString);
            System.out.println("decoded: "+decodedString);
            
        } catch (IllegalArgumentException ex){
            System.err.println("Error creating TranspositionCipher: " + ex);
        }
    }
    
}
