package com.staff.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MessageDigestUtil {
	public static String getMD5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] input = str.getBytes();
			md.update(input);
			byte[] output = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte data : output){
				sb.append(String.format("%02X", data));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
