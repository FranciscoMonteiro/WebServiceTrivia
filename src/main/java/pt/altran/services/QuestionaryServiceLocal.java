/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import java.util.List;
import pt.altran.entities.Questionary;

/**
 *
 * @author User
 */

public interface QuestionaryServiceLocal {

    void create(Questionary questionary);

    void edit(Questionary questionary);

    void remove(Questionary questionary);

    Questionary find(Object id);

    List<Questionary> findAll();

    List<Questionary> findRange(int[] range);

    int count();
    
}
