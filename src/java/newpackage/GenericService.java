/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;

/**
 *
 * @author pavikumbhar
 */
public interface GenericService<T, D, ID> {
     
    D findOne(ID id);
    
    List<D> findAll();
    
    void save(D dto);

    
}
