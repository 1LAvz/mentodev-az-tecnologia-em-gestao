/* 
 * @author: Lucas Avanzi
 * JRE System Library used: JavaSE-1.8
 * Exercise completed using Collection HashMap, Arrays.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Questao3 {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("./Questao3.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			//String arrays with arguments
			String[] firstLine = scan.nextLine().split(" ");
			String[] secondLine = scan.nextLine().split(" ");
			
			//Converting firsttLine string into int
			int n = Integer.parseInt(firstLine[0]); //All volunteers
			int r = Integer.parseInt(firstLine[1]); //All volunteers that are not missing
			
			//Converting secondLine string array into int array
			int[] secondLineInteger = new int[secondLine.length];
			for(int i=0; i<secondLine.length; i++) {
				secondLineInteger[i] = Integer.parseInt(secondLine[i]);
			}
			
			//Sorting IDs of the volunteers that returned
			Arrays.sort(secondLineInteger);
			
			//HashMap of returned ids
			HashMap<Integer, Integer> returnedIds = new HashMap<Integer, Integer>();
			for(int i=0; i<secondLineInteger.length; i++) {
				returnedIds.put(i, secondLineInteger[i]);
			}
			
			//if all volunteers returned
			if(n == r) {
				System.out.println("*");
			}
			//else someone is missing
			else {
				for(int i=0; i<n; i++) {
					//contains value i+1 because ids starts from number 1
					if(!returnedIds.containsValue(i+1)) {
						System.out.print((i+1 + " "));
					}  
				}
				System.out.println();
			}
		}
	}
}
