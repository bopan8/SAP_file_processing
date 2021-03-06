package file_processing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//C:\Users\User\Desktop\fileTest\secondAttempt.txt
//C:\Users\User\Desktop\car.txt

public class App {

	public static void main(String[] args) throws IOException, LinesOutOfBoundriesException, WordsOutOfBoundriesException {
		
		Scanner scan = new Scanner(System.in);
		//entering URL
		System.out.println("PLese enter the path of the file you want to work with");
		String path = scan.nextLine();
		I_O.createFileCheck(path);
		System.out.println("				");
		System.out.println("Choose: ");
		System.out.println("1. Reading the file");
		System.out.println("2. Switching two lines ");
		System.out.println("3. Switching two word ");
		System.out.println("4. Quit");
		Scanner ch = new Scanner(System.in);
		int choose = ch.nextInt();
		
		while (choose > 0 && choose <4)
		{
			try {
				switch(choose)
				{
				case 1:
					I_O.readFile(path);
					break;
					
				case 2:
					HashMap map = null;
					try {
						map = CreatingHashMap.createMap(path);
					} catch (OneLineException e) {
						e.getMessage();
					}
					SwitchingLines.switchLines(map, path);
					break;
					
				case 3:
					HashMap mAp = null;
					try {
						mAp = CreatingHashMap.createMap(path);
					} catch (OneLineException e) {
						e.getMessage();
					}
					SwitchingWords.switchingWords(mAp, path);
					break;
				}
			} catch (IOException | LinesOutOfBoundriesException | WordsOutOfBoundriesException e) {
				e.printStackTrace();
			}
		System.out.println("				");
		System.out.println("Choose: ");
		System.out.println("1. Reading the file");
		System.out.println("2. Switching two lines ");
		System.out.println("3. Switching two word ");
		System.out.println("4. Quit");
		choose = ch.nextInt();
		}
		
		if(choose == 4) 
		{
			System.out.println("Goodbye");
		}
	}

}
