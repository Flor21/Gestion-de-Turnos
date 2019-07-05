package com.gestionturnos.gestion_turnos.gestionturnos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


/**
 * 
 * @author flor
 *
 */

@Entity
//@IdClass(ClaveMedicoObraSocial.class)
public class MedicoObraSocial {
    @Id
    @Column(name = "idMedicoObraSocial")
    private Integer idMedicoObraSocial;
    
    /*  Id Medico   */
    
    private Integer idMedico;
    
    /*  Id Obra Social  */
    
    private Integer idObraSocial;

    public MedicoObraSocial(){}

    public Integer getIdObraSocial() {
        return idObraSocial;

    }

    public void setIdObraSocial(Integer idObraSocial){
        this.idObraSocial = idObraSocial;
    }

    public Integer getIdMedico() {
	    return idMedico;
    }

    public void setIdMedico(Integer idMedico){
        this.idMedico = idMedico;
    }

    public Integer getIdMedicoObraSocial() {
	    return idMedicoObraSocial;
    }

    public void setIdMedicoObraSocial(Integer idMedicoObraSocial){
        this.idMedicoObraSocial = idMedicoObraSocial;
    }



}
