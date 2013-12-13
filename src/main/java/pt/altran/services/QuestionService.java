/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.altran.entities.Answer;
import pt.altran.entities.Question;

/**
 *
 * @author User
 */
@WebService
@Stateful
public class QuestionService extends AbstractService<Question> implements QuestionServiceLocal {
    @PersistenceContext(unitName = "webServiceTrivia")
    private EntityManager em;
    
    private Question currentQuestion;
    private Answer currentAnswer;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionService() {
        super(Question.class);
    }

    @WebMethod
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    @WebMethod
    public void setCurrentAnswer(Answer currentAnswer) {
        this.currentAnswer = currentAnswer;
    }
    
    
}
