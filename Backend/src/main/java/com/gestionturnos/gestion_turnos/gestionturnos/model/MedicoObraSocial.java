package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


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
    private String idMedicoObraSocial = UUID.randomUUID().toString().replace("-","");
    
    /*  Id Medico   */
    
    private String idMedico;
    
    /*  Id Obra Social  */
    
    private String idObraSocial;

    public MedicoObraSocial(){}

    public String getIdObraSocial() {
        return idObraSocial;

    }

    public void setIdObraSocial(String idObraSocial){
        this.idObraSocial = idObraSocial;
    }

    public String getIdMedico() {
	    return idMedico;
    }

    public void setIdMedico(String idMedico){
        this.idMedico = idMedico;
    }

    public String getIdMedicoObraSocial() {
	    return idMedicoObraSocial;
    }

    public void setIdMedicoObraSocial(String idMedicoObraSocial){
        this.idMedicoObraSocial = idMedicoObraSocial;
    }



}
