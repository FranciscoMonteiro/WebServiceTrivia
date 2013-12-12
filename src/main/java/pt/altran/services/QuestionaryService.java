/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.altran.entities.Questionary;

/**
 *
 * @author User
 */
@Stateless
public class QuestionaryService extends AbstractService<Questionary> implements QuestionaryServiceLocal {
    @PersistenceContext(unitName = "webServiceTrivia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionaryService() {
        super(Questionary.class);
    }
    
}
