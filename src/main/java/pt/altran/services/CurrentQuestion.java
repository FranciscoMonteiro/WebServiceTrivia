/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import javax.ejb.Singleton;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.core.Context;
import pt.altran.entities.Question;

/**
 *
 * @author User
 */
@Singleton
public class CurrentQuestion {

    @Context
    private Question question;
    
    public Question getQuestion() {
        return question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    
}
