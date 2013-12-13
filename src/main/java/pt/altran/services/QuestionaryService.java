/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
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
@Stateless
public class QuestionaryService extends AbstractService<Questionary> implements QuestionaryServiceLocal {
    @PersistenceContext(unitName = "webServiceTrivia")
    private EntityManager em;
    
    private Questionary currentQuestionary;
    private Question currentQuestion;
    private Iterator<Question> iteratorQuestion; 

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionaryService() {
        super(Questionary.class);        
    }
    
    @WebMethod
    public String start(){
        currentQuestionary = find(1);
        iteratorQuestion = currentQuestionary.getQuestionCollection().iterator();
        try {
            while(nextQuestion()){
                System.out.println("questão: " + currentQuestion.getQuestionContent());
                Thread.sleep(10);
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
