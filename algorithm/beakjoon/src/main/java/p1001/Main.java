package p1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String[] sList = string.split(" ");


        int i1 = Integer.parseInt(sList[0]);
        int i2 = Integer.parseInt(sList[1]);

        System.out.println(i1 - i2);
    }
}