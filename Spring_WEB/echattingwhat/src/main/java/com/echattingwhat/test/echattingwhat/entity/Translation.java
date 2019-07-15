package com.echattingwhat.test.echattingwhat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;
import com.echattingwhat.test.echattingwhat.service.PapagoApi;

@Entity
@Table(name="translation")
public class Translation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="inputText")
	private String inputText;

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		PapagoApi api = new PapagoApi();
		String result = api.nmtReturnRseult(inputText);
		
		String outputText = jsonParsing(result);
		
		this.inputText = outputText;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String jsonParsing(String translated) {	
		String outputText = "";
		
		try {
			JSONObject jsonObj = new JSONObject(translated);
			JSONObject message = jsonObj.getJSONObject("message");
			
			message.get("@type");
			message.get("@service");
			message.get("@version");
			
			JSONObject result = (JSONObject) message.get("result");
			result.get("srcLangType");
			result.get("tarLangType");
			outputText = (String) result.get("translatedText");
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputText;
	}
	
}
