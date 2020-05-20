/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;
import java.math.BigInteger;
import java.util.Scanner;

public class Affine
{
    static Scanner s = new Scanner(System.in);
    static int a;
    static int b;
    private static int mod = 26;

    public static String encryptionMessage(String in)
    {
        StringBuilder sb = new StringBuilder();
    for (int i = 0; i < in.length(); i++)
    {
        char x = in.charAt(i);
        if (Character.isLetter(x))
        {
            x =(char)((a*(x-'a')+b)%mod+'a');
        }
        sb.append(x);
    }
    return sb.toString();
    }

    public static String decryptionMessage(String in)
    {
//        int inv=0;
    
    StringBuilder builder = new StringBuilder();
//    for (int i = 0; i < 26; i++)
//            {
//            int flag = (a * i) % 26;
//                if (flag == 1)
//                {
//                    inv = i;
//                }
//            }
    BigInteger inverse = BigInteger.valueOf(a).modInverse(BigInteger.valueOf(mod));
    for (int i = 0; i < in.length(); i++)
    {
        char x = in.charAt(i);
        if (Character.isLetter(x))
        {
            int inv = inverse.intValue()*(x-'a'-b+mod); 
            x = (char)(inv%mod+'a');
        }
        builder.append(x);
    }
    return builder.toString();
    }
 
    public static void main(String[] args)
    {

       String message = s.next();
       encryptionMessage(message);
       decryptionMessage(encryptionMessage(message));
        
    }
}
