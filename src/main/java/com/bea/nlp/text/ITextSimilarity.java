/** 
 * Project Name:NLP 
 * File Name:ITextSimilarity.java 
 * Package Name:com.bea.nlp.text 
 * Date:2017年8月2日下午9:13:36 
 * Copyright (c) 2017,  All Rights Reserved. 
 * 
*/  
  
package com.bea.nlp.text;  

import java.util.List;

import com.bea.nlp.entity.Word;

/** 
 * ClassName:ITextSimilarity <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   获取2个字符串相似度得分 
 * Date:     2017年8月2日 下午9:13:36 <br/> 
 * @author   zsj
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface ITextSimilarity {

    public double getSimilarity(String str1, String str2);
    
    public double getSimilarity(List<Word> words1, List<Word> words2);
}
  