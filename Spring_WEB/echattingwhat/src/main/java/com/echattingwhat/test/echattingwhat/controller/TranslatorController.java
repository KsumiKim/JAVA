package com.echattingwhat.test.echattingwhat.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/translate")
public class TranslatorController {

	// nmtReturnResult�� �Լ��� ���ؼ� �ѱ� - > ����� ����
	public String nmtReturnRseult(String original_str){
	    
	    //���ø����̼� Ŭ���̾�Ʈ ���̵�";
	    String clientId = "PAcSZfBqYXXfmWzQPzas";
	    //���ø����̼� Ŭ���̾�Ʈ ��ũ����";
	    String clientSecret = "rmUTD0IwAb";
	    
	    String resultString ="";
	    try {
	        //original_str ���� �츮�� ��ȯ�� �� 
	        String text = URLEncoder.encode(original_str, "UTF-8");
	        
	        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("X-Naver-Client-Id", clientId);
	        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	        // post request
	        String postParams = "source=ko&target=en&text=" + text;
	        con.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	        wr.writeBytes(postParams);
	        wr.flush();
	        wr.close();
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        if(responseCode==200) { // ���� ȣ��
	            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        } else {  // ���� �߻�
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	        }
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = br.readLine()) != null) {
	            response.append(inputLine);
	        }
	        br.close();
	        System.out.println(response.toString());
	        
	        resultString = response.toString();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return resultString;
	}
	
}
