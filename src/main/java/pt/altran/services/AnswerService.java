/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.altran.entities.Answer;

/**
 *
 * @author User
 */
@Stateless
public class AnswerService extends AbstractService<Answer> implements AnswerServiceLocal {
    @PersistenceContext(unitName = "webServiceTrivia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnswerService() {
        super(Answer.class);
    }
    
}
