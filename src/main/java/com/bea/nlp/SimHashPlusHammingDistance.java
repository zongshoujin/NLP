/**
 * Creation Date:2017年8月2日-下午2:35:32
 * 
 * Copyright 2008-2017 © 同程网 Inc. All Rights Reserved
 */
package com.bea.nlp;

import java.math.BigInteger;

/** 
 * ClassName:EditDistance <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年7月22日 下午10:04:16 <br/> 
 * @author   zsj
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class SimHashPlusHammingDistance {

	private final int hashBitCount = 128;
	
	private BigInteger hash(String word) {
        if (word == null || word.length() == 0) {
            return new BigInteger("0");
        }
        char[] charArray = word.toCharArray();
        BigInteger x = BigInteger.valueOf(((long) charArray[0]) << 7);
        BigInteger m = new BigInteger("1000003");
        BigInteger mask = new BigInteger("2").pow(hashBitCount).subtract(new BigInteger("1"));
        long sum = 0;
        for (char c : charArray) {
            sum += c;
        }
        x = x.multiply(m).xor(BigInteger.valueOf(sum)).and(mask);
        x = x.xor(new BigInteger(String.valueOf(word.length())));
        if (x.equals(new BigInteger("-1"))) {
            x = new BigInteger("-2");
        }
        return x;
    }
	
	public String simHash(String word){
		float[] hashBit = new float[hashBitCount];
		float weight = 1;
		BigInteger hash = hash(word);
		for (int i = 0; i < hashBitCount; i++) {
            BigInteger bitMask = new BigInteger("1").shiftLeft(i);
            if (hash.and(bitMask).signum() != 0) {
                hashBit[i] += weight;
            } else {
                hashBit[i] -= weight;
            }
        }
		StringBuffer fingerprint = new StringBuffer();
        for (int i = 0; i < hashBitCount; i++) {
            if (hashBit[i] >= 0) {
                fingerprint.append("1");
            } else {
                fingerprint.append("0");
            }
        }
        return fingerprint.toString();
	}
	
	private int hammingDistance(String simHash1, String simHash2) {
        if (simHash1.length() != simHash2.length()) {
            return -1;
        }
        int distance = 0;
        int len = simHash1.length();
        for (int i = 0; i < len; i++) {
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
	
	public double calculate(String word1, String word2){
		String simHash1 = simHash(word1);
		String simHash2 = simHash(word2);
		int hammingDistance = hammingDistance(simHash1, simHash2);
		int maxDistance = simHash1.length();
        double score = (1 - hammingDistance / (double) maxDistance);
        return score;
	}
}

