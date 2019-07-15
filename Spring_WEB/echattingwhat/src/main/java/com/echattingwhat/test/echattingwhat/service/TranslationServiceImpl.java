package com.echattingwhat.test.echattingwhat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echattingwhat.test.echattingwhat.dao.EmployeeRepository;
import com.echattingwhat.test.echattingwhat.dao.TranslationRepository;
import com.echattingwhat.test.echattingwhat.entity.Employee;
import com.echattingwhat.test.echattingwhat.entity.Translation;

@Service
public class TranslationServiceImpl implements TranslationService {

	private TranslationRepository translationRepository;
	
	@Autowired
	public TranslationServiceImpl(TranslationRepository thetranslationRepository) {
		translationRepository = thetranslationRepository;
	}
	

	@Override
	public Translation findById(int theId) {
		// employeeId로 employee를 찾는다.
		Optional<Translation> result = translationRepository.findById(theId);
		
		Translation theTranslation = null;
		
		if (result.isPresent()) {
			theTranslation = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		// 매개변수로 받은 id를 가진 employee를 리턴한다. 
		return theTranslation;
	}


	@Override
	public void save(Translation theTranslation) {
		translationRepository.save(theTranslation);

	}

}






