//**********************************************************
//  Codes.java       Authors: Lewis/Chase
//  Modified by W Guo
//  Demonstrates the use of queues to encrypt and decrypt messages.
//**********************************************************
import java.util.*;
public class Codes
{
   //-----------------------------------------------------------------
   //  Encode and decode a message using a key of values stored in
   //  a queue.
   //-----------------------------------------------------------------
   public static void main ( String[] args)
   { 
      int[] key = {-3, 1, 4, 1, 5, 9, 2, 6};
      int keyValue;

      String encoded = "", decoded = ""; 

      String message = "Life is not fair; get used to it. ";

                                              
      Queue keyQueue1 = new LinkedList();
      Queue keyQueue2 = new LinkedList();

      // load key queue
      for (int scan=0; scan < key.length; scan++)
      {
         keyQueue1.offer (new Integer(key[scan]));
         keyQueue2.offer (new Integer(key[scan]));
      }

      // encode message
      for (int scan=0; scan < message.length(); scan++)
      {
         keyValue = ((Integer) keyQueue1.poll()).intValue();
         encoded += (char) ((int)message.charAt(scan) + keyValue);
         keyQueue1.offer (new Integer(keyValue));
      }

      System.out.println ("Encoded Message:\n" + encoded + "\n");

      // decode message
      for (int scan=0; scan < encoded.length(); scan++)
      {
         keyValue = ((Integer) keyQueue2.poll()).intValue();
         decoded += (char) ((int)encoded.charAt(scan) - keyValue);
         keyQueue2.offer (new Integer(keyValue));
      }

      System.out.println ("Decoded Message:\n" + decoded);
   }
}


