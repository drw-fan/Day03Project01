import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03Project01Main {
	
	public static void main (String[] args) {

		int[][] claimMatrix = new int[2000][2000];
		
		String claimString="";  //  #1 @ 509,796: 18x15
		int indexEndNumber=0, indexOfComma=0, indexOfColon=0, indexOfx=0;
		int startCol=0, startRow=0, numCols=0, numRows=0;
		String colString="", rowString="", numColString="", numRowString="";
		int totalInMultiClaims=0;
		
		

		try {
			File myFile = new File("claims.txt");
			Scanner inputFile = new Scanner(myFile);

			while (inputFile.hasNext()) {
				claimString = (inputFile.nextLine());
				
				indexEndNumber = claimString.indexOf('@');
				indexOfComma = claimString.indexOf(',');
				indexOfColon = claimString.indexOf(':');
				indexOfx = claimString.indexOf('x');
				
				
				startCol = Integer.parseInt(claimString.substring(indexEndNumber+2, indexOfComma));
				startRow = Integer.parseInt(claimString.substring(indexOfComma+1, indexOfColon));
				numCols = Integer.parseInt(claimString.substring(indexOfColon+2, indexOfx));
				numRows = Integer.parseInt(claimString.substring(indexOfx+1));

				for (int i = startRow; i <(startRow+numRows); i++) {
						for (int j =startCol; j < (startCol + numCols); j++) {
						claimMatrix[i][j]++;
					}
				}
			}

			inputFile.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File IO error!");		}
		
		for (int i=0; i<2000; i++) {
			for (int j=0; j<2000; j++) {
				if (claimMatrix[i][j] > 1)
					totalInMultiClaims++;
			}
		}
		
		System.out.println("Total in more than one claim = " + totalInMultiClaims);
	}
}
