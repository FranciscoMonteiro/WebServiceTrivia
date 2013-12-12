/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import java.util.List;
import pt.altran.entities.Option;

/**
 *
 * @author User
 */

public interface OptionServiceLocal {

    void create(Option option);

    void edit(Option option);

    void remove(Option option);

    Option find(Object id);

    List<Option> findAll();

    List<Option> findRange(int[] range);

    int count();
    
}
