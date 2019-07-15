package com.echattingwhat.test.echattingwhat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.echattingwhat.test.echattingwhat.entity.Flashcard;
import com.echattingwhat.test.echattingwhat.service.FlashcardService;

@Controller
@RequestMapping("/flashcard")
public class FlashcardController {

	private FlashcardService flashcardService;
	
	public FlashcardController(FlashcardService theFlashcardService) {
		flashcardService = theFlashcardService;
	}
	
	
	@GetMapping("/flashcard")
	public String showFlashcardLayout(Model theModel) {
		
		Flashcard firstcard = flashcardService.findFirst();
		theModel.addAttribute("flashcard", firstcard);
		
		return "flashcard";
	}

	@RequestMapping(value="/requestMeaning", method=RequestMethod.POST)
	@ResponseBody
	public String showFlashcardMeaning(int theId) {
		
//		Flashcard card = flashcardService.findById(theId);
		
//		return card.getMeaning();
		return null;
	}
}
