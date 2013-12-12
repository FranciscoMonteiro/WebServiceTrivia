/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.services;

import java.util.List;
import pt.altran.entities.Tuser;

/**
 *
 * @author User
 */

public interface TuserServiceLocal {

    void create(Tuser tuser);

    void edit(Tuser tuser);

    void remove(Tuser tuser);

    Tuser find(Object id);

    List<Tuser> findAll();

    List<Tuser> findRange(int[] range);

    int count();
    
}
