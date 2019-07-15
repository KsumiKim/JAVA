package com.echattingwhat.test.echattingwhat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.echattingwhat.test.echattingwhat.dao.PersonMongoDBRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringBootMongoDBTest {
    @Autowired()
    private PersonMongoDBRepository projectMongoDBRepository;
 
    @Test
    public void printProjectData() {
        System.out.println(projectMongoDBRepository.findAll());
    }
}
