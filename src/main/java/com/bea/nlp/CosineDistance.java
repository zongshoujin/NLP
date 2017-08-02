/** 
 * Project Name:NLP 
 * File Name:CosineDistance.java 
 * Package Name:com.bea.nlp 
 * Date:2017年8月2日下午8:49:37 
 * Copyright (c) 2017,  All Rights Reserved. 
 * 
*/  
  
package com.bea.nlp;  

import java.util.List;

import com.bea.nlp.entity.Word;
import com.bea.nlp.text.AbstractTextSimilarity;

/** 
 * ClassName:CosineDistance <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年8月2日 下午8:49:37 <br/> 
 * @author   zsj
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class CosineDistance extends AbstractTextSimilarity {

    @Override
    public double getSimilarityImpl(List<Word> words1, List<Word> words2) {
        return 0;
    }

}
  