/**
 * A test class for PlayFair class 
 */
public class PlayFairTest{
  public static void main(String[] args){
    // Matrix for encryption
    char[][] matrix = {{'S', 'P', 'I', 'D', 'E'}, {'R', 'M', 'A', 'N', 'B'}, {'C', 'F', 'G', 'H', 'J'}, {'K', 'L', 'O', 'T', 'U'}, {'V', 'W', 'X', 'Y', 'Z'} };
    
    // Testing breakStringIntoPair() function
    String stringCharPairs = PlayFair.breakStringIntoPairs("THE BROWN FOX JUMPS OVER THE LAZY DOG");
    testMethod(stringCharPairs, "TH EB RO WN FO XJ UM PS OV ER TH EL AZ YD OG");
    
    // Testing createCipher() function
    String cipherText = PlayFair.createCipher(stringCharPairs, matrix);
    testMethod(cipherText, "HNZEAKYMGLZGLBVWKXSBHNPUBXTYGA");
    
    // Testing createPlainText() function
    String plainText = PlayFair.createPlainText(cipherText, matrix);
    testMethod(plainText, "THEBROWNFOXJUMPSOVERTHELAZYDOG");
    
  }
  
  /* 
   * The function takes a function's return value and compares it to what the function should to return
   * @param returnedValue the value returned by a funtion
   * @param expectedReturnValue the value that is to be returned by a function
   */
  public static void testMethod(String returnedValue, String expectedReturnValue){
    if(returnedValue.equals(expectedReturnValue))
      System.out.println(" OK function returned: " + returnedValue + " expected: " + expectedReturnValue);
    else
      System.out.println(" X function returned: " + returnedValue + " expected: " + expectedReturnValue);
  }
}