/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import java.util.List;
import pt.altran.entities.Answer;

/**
 *
 * @author User
 */

public interface AnswerServiceLocal {

    void create(Answer answer);

    void edit(Answer answer);

    void remove(Answer answer);

    Answer find(Object id);

    List<Answer> findAll();

    List<Answer> findRange(int[] range);

    int count();
    
}
