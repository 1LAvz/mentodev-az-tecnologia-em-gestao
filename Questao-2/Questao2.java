/* 
 * @author: Lucas Avanzi
 * JRE System Library used: JavaSE-1.8
 * Exercise completed using Collection Map, HashMaps, and Arrays.
 */


//Libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Questao2 {
	
	public static void main(String[] args){
	
		try {
			//Reading an external file
			File file = new File(args.length > 0 ? args[0] : "./Questao2.txt");
			Scanner scan = new Scanner(file);
			
			// Reading first line of the file out of the loop so it can be checked to continue or not. 
			String fisrtLineValidation = scan.nextLine();
			String[] arrValidation = fisrtLineValidation.split(" ");
			int n = Integer.parseInt(arrValidation[0]);
			int k = Integer.parseInt(arrValidation[1]);
			
			while (n != 0 && k != 0) {
				
				String[] evenLinesStrs = scan.nextLine().split(" ");
				
				//Convert string array to int array.
				int[] numbers = new int[evenLinesStrs.length];
				for(int i = 0; i < evenLinesStrs.length; i++) {
					numbers[i] = Integer.parseInt(evenLinesStrs[i]);
				}
				
				//Sort numbers array.
				Arrays.sort(numbers);

				//Count how many times each number appears in the given sequence.
				HashMap<Integer, Integer> countRep = new HashMap<Integer, Integer>();
				int count = 1;
				
				for (int i=0; i<numbers.length; i++) {
					if(i<numbers.length - 1) {
						if(numbers[i] == numbers[i+1]) {
							countRep.put(numbers[i], ++count);
						} else { 
							count = 1;
						}
					}
				}

				//Count how many questions should be added to the new section of the site based on their frequency of appearance.
				int countQuestionsToBeAdded = 0;
				for (Map.Entry<Integer, Integer> entry : countRep.entrySet()) {
				    int value = entry.getValue();
				    if(value >= k) {
				    	countQuestionsToBeAdded++;
				    } 
				}
				
				System.out.println(countQuestionsToBeAdded);
				
				//Reading next line of the file.
				String oddLines = scan.nextLine();
				String[] arrOddLines = oddLines.split(" ");
				n = Integer.parseInt(arrOddLines[0]);
				k = Integer.parseInt(arrOddLines[1]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("O sistema nao pode encontrar o arquivo especificado.\nVerifique o diretorio informado.");
		}
	}
}
