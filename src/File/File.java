package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileReader;

public class File {
	private static final String FILENAME = "dulieu.txt";
	public void GhiFile(String ma) {
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
	    	bw.write(ma);
	    } catch (Exception e) {
	        System.err.println("Error writing to file: " + e.getMessage());
	    }
	}
	public String DocTuFile() {
		String ma = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            while (br.ready()) {
                ma = br.readLine();
            }
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
//		System.out.println(ma);
        return ma;
    }
}
