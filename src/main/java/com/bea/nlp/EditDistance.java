/** 
 * Project Name:NLP 
 * File Name:EditDistance.java 
 * Package Name:com.bea.nlp 
 * Date:2017年7月25日下午10:04:16 
 * Copyright (c) 2017,  All Rights Reserved. 
 * 
*/  
  
package com.bea.nlp;  

import org.apache.commons.lang3.StringUtils;

/** 
 * ClassName:EditDistance <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年7月25日 下午10:04:16 <br/> 
 * @author   alex
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class EditDistance {

    public static int genEditDistance(String src, String target){
        if(StringUtils.isBlank(src) || StringUtils.isBlank(target)) return 0;
        
        int srcLen = StringUtils.length(src);
        int targetLen = StringUtils.length(target);
        
        int matrix[][] = new int[srcLen + 1][targetLen + 1];
        char srcCharTmp;
        char targetCharTmp;
        int cost;
        
        for(int i = 0; i <= srcLen; i++){
            matrix[i][0] = i;
        }
        for(int j = 0; j <= targetLen; j++){
            matrix[0][j] = j;
        }
        
        for(int i = 1; i <= srcLen; i++){
            srcCharTmp = src.charAt(i - 1);
            for(int j = 1; j <= targetLen; j++){
                targetCharTmp = target.charAt(j - 1);
                cost = srcCharTmp == targetCharTmp ? 0 : 1;
                matrix[i][j] = min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1, matrix[i - 1][j - 1] + cost);
            }
        }
        
        return matrix[srcLen][targetLen];
    }
    
    private static int min(int a, int b, int c){
        int tmp = a < b ? a : b;
        return tmp < c ? tmp : c;
    }
    
    public static void main(String[] args) {
        String str1 = "日航机场";
        String str2 = "";
        System.out.println(genEditDistance(str1, str2));
    }
    
}
  