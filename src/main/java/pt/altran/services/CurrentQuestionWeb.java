/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author User
 */
@WebService(serviceName = "currentQuestionWeb")
public class CurrentQuestionWeb {
    
    @Inject
    private CurrentQuestion currentQuestionService;
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getQuestion")
    public String currentQuestion() {
        return currentQuestionService.getQuestion().getQuestionContent();
    }

}
