/* 
 * @author: Lucas Avanzi
 * JRE System Library used: JavaSE-1.8
 * Exercise completed using Collection ArrayList.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao5 {

	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			File file = new File(args.length > 0 ? args[0] : "./Questao5.txt");
			Scanner scan = new Scanner(file);
			
			ArrayList<Integer> number = new ArrayList<>();
			ArrayList<String> side = new ArrayList<>();
			
			while(scan.hasNextLine()) {
					
				int n = Integer.parseInt(scan.nextLine().trim());

				//Filling the information into the arrays
				for(int i = 0; i < n; i++) {
					String[] rl = scan.nextLine().split(" ");
					number.add(Integer.parseInt(rl[0]));
					side.add(rl[1]);
				}
				
				//Manipulating data so we can find formed pairs of boots
				int count = 0;
				for(int i=0; i<number.size(); i++) {
					if(i != number.size()-1 && number.get(i) != null) {
						for(int j=i+1; j<number.size(); j++) {
							if(number.get(i) == number.get(j)) {
								if(!side.get(i).equals(side.get(j))) {
									count++;
									number.set(i, null);
									number.set(j, null);
								}
							}
						}
					}
				}
				
				System.out.println(count);
				
				count = 0;
				number.clear();
				side.clear();
			}
		} catch (FileNotFoundException e) {
			System.out.println("O sistema nao pode encontrar o arquivo especificado.\nVerifique o diretorio informado.");
		}
	}
}
