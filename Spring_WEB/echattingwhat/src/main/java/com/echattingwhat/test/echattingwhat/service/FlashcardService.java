package com.echattingwhat.test.echattingwhat.service;

import com.echattingwhat.test.echattingwhat.entity.Flashcard;

public interface FlashcardService {

	public Flashcard findFirst();

	//public Flashcard findById(int theId);
	
	public Flashcard findNextById(int theId);
	
}
