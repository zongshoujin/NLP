/** 
 * Project Name:NLP 
 * File Name:AbstractTextSimilarity.java 
 * Package Name:com.bea.nlp.text 
 * Date:2017年8月2日下午9:15:10 
 * Copyright (c) 2017,  All Rights Reserved. 
 * 
*/  
  
package com.bea.nlp.text;  

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.bea.nlp.entity.Word;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

/** 
 * ClassName:AbstractTextSimilarity <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年8月2日 下午9:15:10 <br/> 
 * @author   zsj
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public abstract class AbstractTextSimilarity implements ITextSimilarity {

    @Override
    public double getSimilarity(String str1, String str2) {
        if((StringUtils.isBlank(str1) && StringUtils.isBlank(str2)) || 
            StringUtils.equalsIgnoreCase(str1, str2))
            return 1.0;
        
        if(StringUtils.isBlank(str1) || StringUtils.isBlank(str2)) 
            return 0.0;
        
        List<Term> words1 = HanLP.segment(str1);
        List<Term> words2 = HanLP.segment(str2);
        return getSimilarity(trans(words1), trans(words2));
    }

    @Override
    public double getSimilarity(List<Word> words1, List<Word> words2) {
        if((words1 == null || words1.size() == 0) && (words2 == null || words2.size() == 0))
            return 1.0;
        
        if((words1 == null || words1.size() == 0) || (words2 == null || words2.size() == 0))
            return 0.0;
        
        return getSimilarityImpl(words1, words2);
    }
    
    public abstract double getSimilarityImpl(List<Word> words1, List<Word> words2);
    
    private List<Word> trans(List<Term> terms){
        if(terms == null || terms.size() < 1) return new ArrayList<Word>(0);
        
        List<Word> result = new ArrayList<Word>(terms.size());
        for(Term t : terms){
            result.add(new Word(t.word, t.nature.name()));
        }
        
        return result;
    }

}
  