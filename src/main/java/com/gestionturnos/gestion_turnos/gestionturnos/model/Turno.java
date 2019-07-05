package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.expression.ParseException;

/**
 * 
 * @author flor
 *
 */
@Entity
public class Turno implements java.io.Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 9066465383169529803L;
    
    /*  Id Turno    */
    @Id
    @Column(name = "idTurno")
    private Integer idTurno;

    /*  Fecha del turno */
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private java.util.Date fecha;

    /*  Hora del turno  */
    @NotNull
    @Column(name = "hora", nullable = false)
    private java.sql.Time hora;
    
    /*  Motivo de la consulta   */
    @NotNull
    @Column(name = "motivo_consulta")
    private String motivoConsulta;

    /*  Relacion con Paciente   */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "Paciente_idPaciente", referencedColumnName = "idPaciente", nullable = false)
    private Paciente paciente;

    /*  Relacion con Medico */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "Medico_idMedico", referencedColumnName = "idMedico", nullable = false)
    private Medico medico;

    /*  Relacion con ObraSocial */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "ObraSocial_idObraSocial", referencedColumnName = "idObraSocial", nullable = false)
    private ObraSocial obraSocial;

    public Turno(){ 

    }
    
    public Turno (int idT, String fech, String hora1, String motConsulta, ObraSocial obraSoc, Medico med, Paciente pac) throws ParseException {
        
        idTurno = idT;
        try{
          this.setFecha(fech);  
          
        }
        catch( java.text.ParseException e){
           System.out.println(e);
        }
        try{
          this.setHora(hora1);  
          
        }
        catch( java.text.ParseException e1){
           System.out.println(e1);
        }
        motivoConsulta = motConsulta;
        obraSocial = obraSoc;
        paciente = pac;
        medico = med;
        
        
    }
    
    public void setFecha(String fecha) throws ParseException, java.text.ParseException {
        
        java.util.Date sqldate;
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	Date imputDate = dateFormat.parse(fecha);
	sqldate = new java.util.Date(imputDate.getTime());
        this.fecha = sqldate;
    }
    
    public void setHora(String hora) throws ParseException, java.text.ParseException {
        java.sql.Time sqltime;
        DateFormat timeFormat = new SimpleDateFormat("hh:mm");
        Date imputTime = timeFormat.parse(hora);
        sqltime = new java.sql.Time(imputTime.getTime());
        this.hora = sqltime;
    }
    /*  Getters and Setters */

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTurno == null) ? 0 : idTurno.hashCode());
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
		final Turno other = (Turno) obj;
		if (idTurno == null) {
			if (other.idTurno != null)
				return false;
		} else if (!idTurno.equals(other.idTurno))
			return false;
		return true;
     
    }
        
    @Override
    public String toString() {
        return "Turno [id = " + idTurno + ", fecha=" + fecha + ", hora=" + hora +", motivoConsulta= " + motivoConsulta +"]";
    }
      
}