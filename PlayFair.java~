/**
 * Java implementation of the Play Fair encryption algorirhm
 * @author Brandon Wayne Odiwuor
 * @author Vladimir Fomene
 */

import java.util.StringTokenizer;

public class PlayFair{
  
  /**
   * Breaks a string into pair of characters for encryption
   * @param plainText enter by our user
   * @return a string broken into pairs of characters ready for encryption
   */
  public static String breakStringIntoPairs(String plainText){
    String result = "";
    int wordCounter = 0;
    
    for(int i = 0; i < plainText.length(); i++) {
      //Check if the character is not a space character before copying it
      if (plainText.charAt(i) != ' ') {
        result += plainText.charAt(i);
        wordCounter++;
      }     
      //Puts space after every character pair
      if(wordCounter % 2 == 0 && plainText.charAt(i) != ' ' && i != plainText.length() - 1)
        result +=" ";
    }
    return result;
  }
  
  /**
   * Produces a cipher text from a string of character pairs its given
   * @param characterPairs the string of character pairs which is to be encrypted
   * @retruen cipher text produced from the  characterPairs string
   */
  public static String createCipher(String characterPairs, char[][] matrix){
    String cipherText = "";
    
    StringTokenizer st = new StringTokenizer(characterPairs);
    
    while (st.hasMoreTokens()){
      String characterPair = st.nextToken();
      char encryptedCharOne;
      char encryptedCharTwo;
      int[][] charPositions = findCharPositionInMatrix(characterPair.charAt(0), characterPair.charAt(1), matrix);
      
      //column case
      if(charPositions[1][1] == charPositions[0][1]){
        encryptedCharOne = matrix[((charPositions[0][0] - 1) + 5) % 5] [charPositions[0][1]];
        encryptedCharTwo = matrix[((charPositions[1][0] - 1) + 5) % 5][charPositions[1][1]];
      }
      
      //row case
      else if(charPositions[1][0] == charPositions[0][0]){
        encryptedCharOne = matrix[((charPositions[0][0] - 1) + 5) % 5][charPositions[1][1]];
        encryptedCharTwo = matrix[((charPositions[1][0] - 1) + 5) % 5][charPositions[0][1]];
      }
      
      //rectangle case
      else{
        encryptedCharOne = matrix[charPositions[0][0]][charPositions[1][1]];
        encryptedCharTwo = matrix[charPositions[1][0]][charPositions[0][1]];
      }
      
      cipherText += String.valueOf( encryptedCharOne) + String.valueOf( encryptedCharTwo);
    } 
    return cipherText;
  }
  
  public static String createPlainText(String encryptedText, char[][] matrix){
    String plainText = "";
    
    StringTokenizer st = new StringTokenizer(breakStringIntoPairs(encryptedText));
    
    while (st.hasMoreTokens()) {
      String characterPair = st.nextToken();  
      int[][] charPositions = findCharPositionInMatrix(characterPair.charAt(0), characterPair.charAt(1), matrix);
      char decryptedCharOne;
      char decryptedCharTwo;
      
      //column case
      if(charPositions[1][1] == charPositions[0][1]){
        decryptedCharOne = matrix[((charPositions[0][0] + 1)) % 5][charPositions[0][1]];
        decryptedCharTwo = matrix[((charPositions[1][0] + 1)) % 5] [charPositions[1][1]];
      }
      
      //row case
      else if(charPositions[1][0] == charPositions[0][0]){
        decryptedCharOne = matrix[((charPositions[0][0] + 1)) % 5][charPositions[1][1]];
        decryptedCharTwo = matrix[((charPositions[1][0] + 1)) % 5][charPositions[0][1]];
      }
      
      // rectangle case
      else{
        decryptedCharOne = matrix[charPositions[0][0]][charPositions[1][1]];
        decryptedCharTwo = matrix[charPositions[1][0]][charPositions[0][1]];
      }
      
      plainText += String.valueOf(decryptedCharOne) + String.valueOf(decryptedCharTwo);
    } 
    return plainText;
  }
  
  /**
   * Returns a two dimensional character array containing the positions of the characters provided in the matrix provided
   * @param firstCharacter
   * @param secondCharacter
   * @return
   */
  public static int[][] findCharPositionInMatrix(char firstCharacter, char secondCharacter, char[][] matrix){
    int[][] charPositions = new int[2][2];
    
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        //Handle the case for rectangle
        if(firstCharacter == matrix[i][j]){
          charPositions[0][0] = i;
          charPositions[0][1] = j;
        }
        
        if(secondCharacter == matrix[i][j]){
          charPositions[1][0] = i;
          charPositions[1][1] = j;
        }
      }
    }
    return charPositions;
  }
}