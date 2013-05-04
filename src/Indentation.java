import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;


/*
 * This program creates an indented version of input source file
 * This assumes that the input file's brackets takes one line,
 * and that its left and right brackets matches correctly
 */

public class Indentation {
	int numOfLeftBrackets = 0;
	
	void indent(String filePath){
		File fileName = new File(filePath);
		String filePathName = filePath.split("\\.")[0];
		String filePathFormat = filePath.split("\\.")[1];
		
		try {
			// Create the indented file with modified name under the same directory
			PrintWriter out = new PrintWriter(new FileWriter(filePathName + "Indented." + filePathFormat));
			Scanner scanner = new Scanner(fileName);
			String tabs;
			while(scanner.hasNext()){
				tabs = new String();
				String currentLine = scanner.nextLine();
				
				if(currentLine.contains("}")) numOfLeftBrackets--;
				
				for(int i = 0; i < numOfLeftBrackets; i++){
					tabs = tabs + "\t";
				}
				out.println(tabs + currentLine);
				
				if(currentLine.contains("{")) numOfLeftBrackets++;
			}
			
			scanner.close();
			out.close();
		} catch (Exception e) {
			// Do nothing
		}
		
		System.out.println("Indented File Created: \"" + filePathName + "Indented." + filePathFormat + "\"");///
	}


	public static void main(String[] args) {
		Indentation indentation = new Indentation();		
		JFileChooser chooser = new JFileChooser();
	    File f;
	    File inputFile;
		try {
			// Direct the file chooser to current working directory
			f = new File(new File("filename.txt").getCanonicalPath());
		    chooser.setSelectedFile(f);
		    chooser.showOpenDialog(null);
		    // Record user-chosen file and start indentation
		    inputFile = chooser.getSelectedFile();
		    System.out.println("File Chosen: \"" + inputFile.getAbsolutePath() + "\"");///
		    indentation.indent(inputFile.getAbsolutePath());
		} catch (Exception e) {
			// Do nothing
		}
	}

}
