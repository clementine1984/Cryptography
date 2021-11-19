package SoftwareExam;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class hash2 {
	public static void main(String[] args) throws Exception {
	     String hash64 =
				 "6P9c8GDP31jtJ7dAW3E2YRKa+ntW3YQd+dL55bOMu4Qa8LhA0GF4LMZqtzWQlSDxqrn1gacjC3lIUurKUeWm8w==";
	     
	     String message="This is the message to Keccak-512 MAC!000";
	     
	     
	     byte[] message_byte=message.getBytes();// trans from String to byte
	     //System.out.println(Arrays.toString(message.getBytes())); //output by way of byte
//
//	     byte[] hash = Base64.getDecoder().decode(hash64);
//
//
//	     byte[] hash1=message.getBytes();
	     //byte[] message64 = Base64.getDecoder().decode(message);
	
	     MessageDigest MD= MessageDigest.getInstance("SHA3-512");
	     
	//     System.out.println(Arrays.toString(message.getBytes()));
	 //    System.out.println(message.getBytes().length);
	     
	     
	   //  byte[] newHash = MD.digest(message.getBytes());
	        
	  //   String newHash64 = Base64.getEncoder().encodeToString(newHash);
		
	     
	     for(int i = 0;i<=50;i++) {
	       message_byte[message_byte.length-3]=(byte)i;
	    	 for(int j = 0;j<=50;j++) {
	    	 message_byte[message_byte.length-2]=(byte)j;
	    		 for(int k = 0;k<=50;k++) {		
	    			 message_byte[message_byte.length-1]=(byte)k;
	    			 
	    		     byte[] newHash = MD.digest(message_byte);
	    		        
	    		     String newHash64 = Base64.getEncoder().encodeToString(newHash);
	    		     //output string base 64
	    			 if(newHash64.equals(hash64)){
	    				 System.out.println(newHash64);
	    				 System.out.println(new String(message_byte));
	    				 // byte convert into string
	    		    	 System.out.println("OK");
	    		     }
	    			
			     }
		    	 
		     }
	    	 
	     }
		
	}
	
	
}
