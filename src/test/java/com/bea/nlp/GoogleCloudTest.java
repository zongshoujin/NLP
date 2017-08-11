/**
 * Creation Date:2017年8月11日-上午9:15:12
 * 
 * Copyright 2008-2017 © 同程网 Inc. All Rights Reserved
 */
package com.bea.nlp;

import java.io.IOException;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

/**
 * Description Of The Class<br/>
 * QQ:1211956756
 * 
 * @author 	zsj07814(宗寿金)
 * @version 1.0.0, 2017年8月11日-上午9:15:12
 * @since 2017年8月11日-上午9:15:12
 */
public class GoogleCloudTest {

	public static void main(String[] args) throws IOException {
		// Instantiates a client
	    LanguageServiceClient language = LanguageServiceClient.create();

	    // The text to analyze
	    String text = "Hello, world!";
	    Document doc = Document.newBuilder()
	            .setContent(text).setType(Type.PLAIN_TEXT).build();

	    // Detects the sentiment of the text
	    Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

	    System.out.printf("Text: %s%n", text);
	    System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
	}
}

