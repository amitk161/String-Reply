package com.beta.replyservice;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ReplyMessage {

	private final String message;

	public ReplyMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	// function written to reverse the String.
	public String reverseString(String inputMessage, int rule){
		StringBuilder result = new StringBuilder();
		if (rule == 1){
			result.append(inputMessage);
			result.reverse();
		}
		return result.toString();
	}

	// function written to encode the string via MD5 hash algorithm.
	public String encode(String input,int rule) {
		if (rule == 2){
			try {
				byte[] bytesOfMessage = input.getBytes("UTF-8");
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] thedigest = md.digest(bytesOfMessage);
				return convertByteArrayToHexString(thedigest);
			} catch (UnsupportedEncodingException e) {
				System.out.println("MD5.encode() threw an UnsupportedEncodingException");
			} catch (NoSuchAlgorithmException e) {
				System.out.println("MD5.encode() threw an NoSuchAlgorithmException");
			}
		}
		return null;
	}

	// function to display the converted hash and display as hex.
	private String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
	}
}