package com.echattingwhat.test.echattingwhat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echattingwhat.test.echattingwhat.dao.EmployeeRepository;
import com.echattingwhat.test.echattingwhat.dao.FlashcardRepository;
import com.echattingwhat.test.echattingwhat.entity.Employee;
import com.echattingwhat.test.echattingwhat.entity.Flashcard;

@Service
public class FlashcardServiceImpl implements FlashcardService {

	private FlashcardRepository flashcardRepository;
	
	@Autowired
	public FlashcardServiceImpl(FlashcardRepository theflashcardRepository) {
		flashcardRepository = theflashcardRepository;
	}
	
	@Override
	public Flashcard findFirst() {
		
		Flashcard result =  flashcardRepository.findById(1);
		
		Flashcard firstCard = null;
		
		if (!result.equals(null))
			firstCard.setId(result.getId());
		else {
			throw new RuntimeException("Did not find flashcard with id, number one");
		}
		
		return firstCard;
	}

	@Override
	public Flashcard findNextById(int theId) {
		Flashcard result = flashcardRepository.findById(theId + 1);
		
		Flashcard NextCard = null;
		
		/*
		 * if (result.isPresent()) NextCard = result.get(); else { throw new
		 * RuntimeException("Did not find flashcard with id, number one"); }
		 */
		
		return NextCard;
	}

	/*
	 * @Override public Flashcard findById(int theId) { Optional<Flashcard> result =
	 * flashcardRepository.findById(theId);
	 * 
	 * Flashcard card = null;
	 * 
	 * if (result.isPresent()) card = result.get(); else { throw new
	 * RuntimeException("Did not find flashcard"); } return card; }
	 */

}






