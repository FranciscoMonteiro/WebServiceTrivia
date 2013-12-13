/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import java.util.List;
import pt.altran.entities.Answer;
import pt.altran.entities.Question;

/**
 *
 * @author User
 */

public interface QuestionServiceLocal {

    void create(Question question);

    void edit(Question question);

    void remove(Question question);

    Question find(Object id);

    List<Question> findAll();

    List<Question> findRange(int[] range);

    int count();
    
    public Question getCurrentQuestion();

    public void setCurrentQuestion(Question currentQuestion);
    
    public void setCurrentAnswer(Answer currentAnswer);
    
}
