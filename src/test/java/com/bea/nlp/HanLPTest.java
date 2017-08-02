/** 
 * Project Name:NLP 
 * File Name:HanLPTest.java 
 * Package Name:com.bea.nlp 
 * Date:2017年8月2日下午9:03:46 
 * Copyright (c) 2017,  All Rights Reserved. 
 * 
*/  
  
package com.bea.nlp;  

import org.junit.Test;

import com.hankcs.hanlp.HanLP;

/** 
 * ClassName:HanLPTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年8月2日 下午9:03:46 <br/> 
 * @author   zsj
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class HanLPTest {

    @Test
    public void test01(){
        String str1 = "慢太湖酒店";
        String str2 = "慢太湖客栈";
        System.out.println(HanLP.segment(str1));
        System.out.println(HanLP.segment(str2));
    }
}
  