package com.gestionturnos.gestion_turnos.gestionturnos.model;

import javax.persistence.Column;

/**
 * 
 * @author flor
 *
 */

public class ClaveMedicoObraSocial implements java.io.Serializable {
    @Column(name = "idMedico", nullable = false)
    private Integer idMedico;
    
    @Column(name = "idObraSocial", nullable = false)
    private Integer idObraSocial;
    
    public Integer getIdMedico(){
        return idMedico;
    }
    public void setIdMedico(Integer idMedico){
        this.idMedico = idMedico;
    }
    
    public Integer getIdObraSocial(){
        return idObraSocial;
    }
    public void setIdObraSocial(Integer idObraSocial){
        this.idObraSocial = idObraSocial;
    } 

    public ClaveMedicoObraSocial(){}

    public ClaveMedicoObraSocial(int idMedico, int idObraSocial){
        this.idMedico = idMedico;
        this.idObraSocial = idObraSocial;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idObraSocial == null) ? 0 : idObraSocial.hashCode());
        return result;
    }    
   
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ClaveMedicoObraSocial other = (ClaveMedicoObraSocial) obj;
		if (idObraSocial == null) {
            if (other.idObraSocial!= null)
				return false;
		} else if (!idObraSocial.equals(other.idObraSocial))
			return false;
		return true;
     
    }
        
    @Override
    public String toString() {
        return "ClaveMedicoObraSocial [idObraSocial = " + idObraSocial + ", idMedico=" + idMedico +"]";
    }
}