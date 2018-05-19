/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Chairz
 */
public class PasswordGenerator {

    /**
     * @param args the command line arguments
     */
	
	
    public String PasswordGenerator(String input) {
        // TODO code application logic here
        //Scanner s = new Scanner(System.in);
        //String password = s.nextLine();
        String password = input;
        
        char[] c = password.toCharArray();
        char[] specialChar = {'!','@','#','$','%','^','&','*','(',')','-','+'};
        Random r = new Random();
        StringBuilder result = new StringBuilder();
        int i = 0;
        int min,max,total;
        while(i<c.length){
            switch(c[i]){
                case '0':
                case '2':
                case '4':
                case '6':
                case '8':
                    min = 'a' - c[i];
                    max = 'z' - c[i];
                    total = c[i] + r.nextInt((max-min)+1)+min;
                    //System.out.println(total);
                    result.append((char)total);
                    break;
                case '1':
                case '3':
                case '5':
                case '7':
                case '9':
                    min = 'A' - c[i];
                    max = 'Z' - c[i];
                    total = c[i] + r.nextInt((max-min)+1)+min;
                    //System.out.println(total);
                    result.append((char)total);
                    break;
                    
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                    max = c[i] - '0';
                    min = c[i] - '9';
                    total = c[i] - (r.nextInt((max-min)+1)+min);
                    //System.out.println(total);
                    result.append((char)total);
                    break;
                case ':':
                    break;
            }
            if(i==4|| i == 8){
              result.setCharAt(i, specialChar[r.nextInt(13)]);
            }
            i++;
        }
        //System.out.println(result);
        return result.toString();
    }
    
}
