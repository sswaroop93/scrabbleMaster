package scrabblemaster;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 public class Scrabble {
	
	private static ArrayList<String> words = new ArrayList<String>();
	private static int[] scrabbleScores = new int[] {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private static int maxScore;
	private static String maxWord;
	
	public static void main(String[] args) throws IOException {
		//String givenWord = args[0];
                
                 BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		  String line;
		  while ((line = br.readLine()) != null) {
                      String givenWord = line;
                      maxScore = 0;
                      givenWord = givenWord.toUpperCase();
                    readDictionary();
//		System.out.println("\n"+words.size());
		computeWordWithMaxScore(givenWord);
		System.out.println(maxWord+" "+maxScore);
            
	}
        }
	
	private static void  computeWordWithMaxScore(String givenWord) {
		
		for(String word : words){
                        int freeScore = isInRack(word,givenWord);
			if(freeScore > -1 ){
                                //System.out.println(word);
                               computeScrabbleScore(word,freeScore);
			}
		} 
		
	}
//modify this
	private static int isInRack(String word, String givenWord) {
		int missingLetterCount = 0;
                int freeScore = 0;
                int wordLength = givenWord.length();
		for(int i = 0; i < word.length(); i++){
			char presentChar = word.charAt(i);
			if(givenWord.contains(String.valueOf( presentChar))){
				givenWord = givenWord.replaceFirst(String.valueOf( presentChar),"");
			}
			else{
                                if(wordLength == 6 ){
                                    freeScore = scrabbleScores[presentChar - 'A'];
                                    missingLetterCount++;
                                    if(missingLetterCount > 1){
                                        return -1;
                                    }
                                }
                                return -1;
			}	
		}
		//return result;
                return freeScore;
//		return true;
	}

	public static void readDictionary() throws IOException
	{
//		  double prime_numbers[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
		  BufferedReader br = new BufferedReader(new FileReader("sowpods.txt"));
		  String line;
		  while ((line = br.readLine()) != null) {
//			 double  product = 1 ; 
//			 for(int i = 0 ; i < line.length() ; i ++)
//			 {
//				 int val = line.charAt(i) - 65;
//				 product *= prime_numbers[val];
//			 }
		     words.add( line);
		  }
//		  System.out.println(words);
		  br.close();
		  
	  }
	
	public static void computeScrabbleScore (String word, int freeScore)
	{
		
		int score = 0;
		char letters[] = word.toCharArray();
		for(int i = 0; i < letters.length; i++)
		{
			score += scrabbleScores[(letters[i] - 'A')];
		}
		score -= freeScore;
		if(score > maxScore)
		{
			maxScore = score;
			maxWord = word;
		}
	}


}
