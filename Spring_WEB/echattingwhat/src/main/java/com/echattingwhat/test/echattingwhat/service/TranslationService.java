package com.echattingwhat.test.echattingwhat.service;

import com.echattingwhat.test.echattingwhat.entity.Translation;

public interface TranslationService {

	public Translation findById(int theId);
	
	public void save(Translation theTranslation);
}
