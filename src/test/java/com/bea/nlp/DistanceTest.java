/**
 * Creation Date:2017年7月27日-上午11:17:14
 * 
 * Copyright 2008-2017 © 同程网 Inc. All Rights Reserved
 */
package com.bea.nlp;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Description Of The Class<br/>
 * QQ:1211956756
 * 
 * @author 	zsj07814(宗寿金)
 * @version 1.0.0, 2017年7月27日-上午11:17:14
 * @since 2017年7月27日-上午11:17:14
 */
public class DistanceTest {

	private static final DecimalFormat format = new DecimalFormat("0.00");
	
	@Test
	public void FuzzyDistanceTest(){
		String s1 = "大阪第一j";
//		String s2 = "大阪第一酒店"; //0.67
//		String s2 = "南大阪格来德第一酒店"; //0.4
		String s2 = "大阪中央第一世界旅馆"; //0.4
		
		int len1 = StringUtils.length(s1);
		int len2 = StringUtils.length(s2);
		
		double max = Math.max(len1, len2) * 1.0;
		
		System.out.println(format.format(1 - (getLevenshteinDistance(s1, s2) / max)));
	}
	
	@Test
	public void EditDistanceTest(){
		String s1 = "大阪第一j";
		String s2 = "大阪第一酒店"; //0.67
//		String s2 = "南大阪格来德第一酒店"; //0.4
//		String s2 = "大阪中央第一世界旅馆"; //0.4
		
		int len1 = StringUtils.length(s1);
		int len2 = StringUtils.length(s2);
		
		double max = Math.max(len1, len2) * 1.0;	
		
		System.out.println(format.format(1 - (EditDistance.genEditDistance(s1, s2) / max)));
	}
	
	private static int getLevenshteinDistance(CharSequence s, CharSequence t){
		if (s == null || t == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        int n = s.length();
        int m = t.length();

        if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        }

        if (n > m) {
            // swap the input strings to consume less memory
            final CharSequence tmp = s;
            s = t;
            t = tmp;
            n = m;
            m = t.length();
        }

        final int p[] = new int[n + 1];
        // indexes into strings s and t
        int i; // iterates through s
        int j; // iterates through t
        int upper_left;
        int upper;

        char t_j; // jth character of t
        int cost;

        for (i = 0; i <= n; i++) {
            p[i] = i;
        }

        for (j = 1; j <= m; j++) {
            upper_left = p[0];
            t_j = t.charAt(j - 1);
            p[0] = j;

            for (i = 1; i <= n; i++) {
                upper = p[i];
                cost = s.charAt(i - 1) == t_j ? 0 : 1;
                // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
                p[i] = Math.min(Math.min(p[i - 1] + 1, p[i] + 1), upper_left + cost);
                upper_left = upper;
            }
        }

        return p[n];
	}
}

