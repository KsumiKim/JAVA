package com.echattingwhat.test.echattingwhat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echattingwhat.test.echattingwhat.entity.Employee;
import com.echattingwhat.test.echattingwhat.entity.Translation;

public interface TranslationRepository extends JpaRepository<Translation, Integer> {

	// that's it ... no need to write any code LOL!
}
