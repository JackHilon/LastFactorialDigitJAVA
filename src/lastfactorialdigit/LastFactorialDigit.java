/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfactorialdigit;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author marka
 */
public class LastFactorialDigit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int numberOfTests=EnterAPositiveInteger();
        
        int[] numbers=InitializeAnArray(numberOfTests);
        FillArrayWithNumbers(numbers);
        
        int[] factorials=FactorialOverArray(numbers);
        char[] myChars=LastStringCharOverIntArray(factorials);
        PrintCharArray(myChars);
        
    }
    
    // -------------------------------------------------------------------
    
    private static void PrintCharArray(char[] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.println(arr[i]);
        }
    }
    
    
    private static char[] LastStringCharOverIntArray(int[] a)
    {
        char[] res=new char[a.length];
        for (int i = 0; i < a.length; i++) 
        {
            res[i]=LastStringChar(ConvertNumber2String(a[i]));
        }
        return res;
    }
    
    private static char LastStringChar(String str)
    {
        return  str.charAt(str.length()-1);
    }
    
    private static String ConvertNumber2String(int a)
    {
        return String.valueOf(a);
    }
    
    
    // ==================================================================
    
    private static int[] FactorialOverArray(int[] arr)
    {
        int[] res=new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) 
        {
            res[i]=Factorial(arr[i]);
        }
        return res;
    }
    
    private static int Factorial(int a)
    {
        if(a==1)
            return 1;
        else return a*Factorial(a-1);
    }
    
    
    private static void FillArrayWithNumbers(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i]=EnterAPositiveInteger();
        }
    }
    
    private static int[] InitializeAnArray(int size)
    {
        int[] arr =new int[size];
        return arr;
    }
    
    private static int EnterAPositiveInteger()
    {
        int result=0;
        try{
        Scanner myInput=new Scanner(System.in);
        result= myInput.nextInt();
        if(result<1 || result>10)
            throw new InputMismatchException();
        return result;
        }
        catch(Exception ex)
        {
            System.out.println("Please enter valid integer");
            return EnterAPositiveInteger();
        }
    }
}
