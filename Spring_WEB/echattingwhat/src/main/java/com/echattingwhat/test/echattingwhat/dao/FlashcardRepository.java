package com.echattingwhat.test.echattingwhat.dao;

import org.springframework.data.repository.Repository;

import com.echattingwhat.test.echattingwhat.entity.Flashcard;

public interface FlashcardRepository extends Repository<Flashcard, Integer> {
	public Flashcard findById(int id); 
	// that's it ... no need to write any code LOL!
}
