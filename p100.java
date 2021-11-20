/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p100;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author QUIQUE
 */
public class p100 {

    private static String temp;
    private static int[] digsNum;
    private static StringBuilder digsOrden;
	
    public static int ordMenMay (int num) {
		
        temp = Integer.toString(num);
	digsNum = new int [temp.length()];
		
	for (int i = 0; i < temp.length(); i++)
	{
	    digsNum[i] = temp.charAt(i) - '0';
	}
		
	Arrays.sort(digsNum);
	digsOrden = new StringBuilder();

	for (int xx : digsNum) 
	{
            digsOrden.append(xx);
	}
		
	int finalInt = Integer.parseInt(digsOrden.toString());
	return finalInt;
    }
	
    public static int ordMayMen (int num) {
		
        temp = Integer.toString(num);
        digsNum = new int [temp.length()];

        for (int i = 0; i < temp.length(); i++)
        {
            digsNum[i] = temp.charAt(i) - '0';
        }

        Arrays.sort(digsNum);
        digsOrden = new StringBuilder();

        for (int i = digsNum.length - 1; i>=0 ; i--) 
        {
            digsOrden.append(digsNum[i]);
        }

        int finalInt = Integer.parseInt(digsOrden.toString());
        return finalInt;
    }
	
    public static void main(String[] args) {
        // TODO code application logic here
        
        String entrada ="6\n"+
			"3524\n"+
			"1111\n"+
			"1121\n"+
        		"6174\n"+
			"352\n"+
			"1893\n"; 
        			 
       
       //in = new Scanner(entrada);
        Scanner in = new Scanner(System.in);
        int nc = in.nextInt();
       
        int nVeces = 0;
       
        for (int i = 0; i<nc; i++) {

    	    int num = in.nextInt();
    	   
    	    String tempn1 = Integer.toString(num);
	    StringBuilder strNum = new StringBuilder();
	    strNum.append(tempn1);
    	   
    	    int n1 , numT1= 0; // primer numero ascendente
    	    //int numT1 = 0;
    	    switch (tempn1.length()) {
                case 1:
    		    strNum.append(0);
	    	    strNum.append(0);
	    	    strNum.append(0);
	    	break;
    		case 2:
    		    strNum.append(0);
    		    strNum.append(0);
    		break;
    		case 3:
    		    strNum.append(0);   
    		    break;
	    }
    	   
    	    if (tempn1.length()!=4) {
    	        n1 = Integer.parseInt(strNum.toString());
    		numT1 = ordMayMen(n1);
    	    } else {
                numT1 = ordMayMen(num);
    	    }
    	   
    	    int n2 = ordMenMay(num);
            int dif = numT1 - n2;
           	      
	    if (dif ==0 ) nVeces = 8;
            else {
	       	nVeces = 1;
	        while (dif != 6174) {
                     
                    numT1 = ordMayMen(dif);
                    n2 = ordMenMay(dif);
		        		
                    tempn1 = Integer.toString(dif);
                    strNum = new StringBuilder();

                    /* Si la primera diferencia resulta que no es un numero de cuatro digitos 
                     * al numero ascendente (n1) le añado tantos ceros por la derecha como hagan
                     * falta, ya que por la izquierda se ignoran
                     */
                    if (tempn1.length() !=4) {
                        strNum.append(tempn1);
                        strNum.append(0);
                        numT1 = Integer.parseInt(strNum.toString());
                    }

                    dif = numT1 - n2;
                    nVeces ++;
                }
            }
	       
            if (num==6174) nVeces = 0;
            System.out.println(nVeces);

            nVeces = 0;
            numT1 = 0;
            n2 = 0;
            dif = 0;
        }
    }
}