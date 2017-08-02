/** 
 * Project Name:NLP 
 * File Name:Word.java 
 * Package Name:com.bea.nlp.entity 
 * Date:2017年8月2日下午8:58:30 
 * Copyright (c) 2017,  All Rights Reserved. 
 * 
*/  
  
package com.bea.nlp.entity;  


/** 
 * ClassName:Word <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年8月2日 下午8:58:30 <br/> 
 * @author   zsj
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class Word {

    // 词名
    private String name;
    
    // 词性
    private String pos;
    
    // 权重，用于词向量分析
    private Float weight;
    
    private int frequency;

    public Word(String name, String pos) {
        super();
        this.name = name;
        this.pos = pos;
    }

    public Word(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
  