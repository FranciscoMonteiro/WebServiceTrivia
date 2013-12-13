/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.altran.entities.Question;
import pt.altran.entities.Questionary;

/**
 *
 * @author User
 */

@WebService
public class QuestionaryService extends AbstractService<Questionary> implements QuestionaryServiceLocal {
    @PersistenceContext(unitName = "webServiceTrivia")
    private EntityManager em;
    
    private Questionary currentQuestionary;
    private Question currentQuestion;
    private Iterator<Question> iteratorQuestion; 
    
    @Inject
    private CurrentQuestion currentQuestionService;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionaryService() {
        super(Questionary.class);        
    }
    
    @WebMethod
    public String start(){
        currentQuestionary = find(new BigDecimal(1));
        iteratorQuestion = currentQuestionary.getQuestionCollection().iterator();
        System.out.println(currentQuestionary);
        try {
            while(nextQuestion()){
                currentQuestionService.setQuestion(currentQuestion);
                System.out.println("questão: " + currentQuestionService.getQuestion().getQuestionContent());
                Thread.sleep(10000);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(QuestionaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "done";
    }
    public boolean nextQuestion(){
        if(!iteratorQuestion.hasNext())
            return false;
        currentQuestion = iteratorQuestion.next();
        return true;
    }
    
}
