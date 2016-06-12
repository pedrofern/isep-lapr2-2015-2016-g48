/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.mechanisms.TipoConflito;

/**
 *
 * @author Diana
 */
public class RegistoTiposConflito {
    
    private List<TipoConflito> regTipoConflitos;
    
    public RegistoTiposConflito(){
     this.regTipoConflitos = new ArrayList<>();
    }
}
