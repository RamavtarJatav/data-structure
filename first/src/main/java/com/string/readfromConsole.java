package com.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class readfromConsole {

    private static final Scanner scan = new Scanner(System.in);
    /*
     * Complete the function below.
     */
    static String dedup(String inputStr, int chunkSize) {
		return inputStr;
        // Write your code here.
    }

    static String redup(String deduplicatedStr, int chunkSize) {
		return deduplicatedStr;
        // Write your code here.


    }
    
    static String test(String inputStr, int chunkSize) {
        String deduplicatedStr = dedup(inputStr, chunkSize);
        if (deduplicatedStr.length() >= inputStr.length()) return "Deduplicated string length is greater than the input string length";
        String originalStr = redup(deduplicatedStr, chunkSize);
        return originalStr;
    }
    

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String inputStr = scan.nextLine();

        int chunkSize = Integer.parseInt(scan.nextLine().trim());

        String res = test(inputStr, chunkSize);

        bw.write(res);
        bw.newLine();

        bw.close();
    }
}


