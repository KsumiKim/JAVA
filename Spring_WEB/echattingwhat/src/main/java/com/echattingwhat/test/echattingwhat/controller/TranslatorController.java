package com.echattingwhat.test.echattingwhat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.echattingwhat.test.echattingwhat.entity.Translation;
import com.echattingwhat.test.echattingwhat.service.PapagoApi;
import com.echattingwhat.test.echattingwhat.service.TranslationService;

@Controller
@RequestMapping("/translate")
public class TranslatorController {

	private TranslationService translationService;
	
	public TranslatorController(TranslationService theTranslationService) {
		translationService = theTranslationService;
	}
	
	@GetMapping("/papago")
	public String inputText(Model theModel) {
		
		Translation translation = new Translation();
		
		theModel.addAttribute("translation", translation);

		return "papagoapi";
	}
	
	@PostMapping("/save")
	public String saveInputText(@ModelAttribute("translation") Translation theTranslation) {
		
		translationService.save(theTranslation);
		
		return "result";
	}
	
	@GetMapping("/showResult")
	public String showResult(Model theModel) {
		
		return "result";
	}
}





