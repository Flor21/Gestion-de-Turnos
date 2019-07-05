package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.expression.ParseException;

/**
 * 
 * @author flor
 *
 */
@Entity
public class Paciente implements java.io.Serializable{ 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idPaciente")
    private Integer idPaciente;
   
    @NotNull
    @Size(min= 1, max=45)
    @Column(name = "apellido", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String apellido;
    
    @NotNull
    @Size(min= 1, max=45)
    @Column(name= "nombre", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,45}",message = "El nombre no puede contener caracteres no válidos")
    private String nombre;
    
    @NotNull
    @Min(1)
    @Column(name= "dni", nullable = false)
    private Integer dni;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de nacimiento debe ser menor a la fecha actual!")
    @Column(name= "fecha_nacimiento", nullable = false)
    private java.util.Date fechaNacimiento;
    
    @NotNull
    @Column(name= "sexo", nullable = false)
    //@Enumerated(EnumType.STRING)
    private String sexo;
    
    @NotNull
    @Column(name= "direccion", nullable = false)
    private String direccion;
    
    @NotNull
    @Min(1)
    @Column(name= "telefono", nullable = false)
    private Integer telefono;
    
     
    @JsonIgnore
    @OneToMany(mappedBy = "paciente",
            cascade = CascadeType.ALL,
            orphanRemoval = true)    
    private List<Turno> turnos;

    public List<Turno> getTurnos(){ 
        return turnos;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "ObraSocial_idObraSocial", referencedColumnName = "idObraSocial", 
            nullable = true)
    private ObraSocial obraSocial;
    
    public Paciente(){
        
    }
    public Paciente(int idP, String apelli, String nomb, int dninro, String fechnac, String sexoo, String direc, int telef, ObraSocial obrasoc) throws ParseException {
        
        idPaciente = idP;
        apellido = apelli;
        nombre = nomb;
        dni = dninro;
        try{
          this.setFechaNacimiento(fechnac);  
          
        }
        catch( java.text.ParseException e){
           System.out.println(e);
        }
        sexo = sexoo;
        direccion = direc;
        telefono = telef;
        obraSocial = obrasoc;
        
        }
    
    public void setFechaNacimiento(String fechaNacimiento) throws ParseException, java.text.ParseException {
        
        java.util.Date sqldate;
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	Date imputDate = dateFormat.parse(fechaNacimiento);
	sqldate = new java.util.Date(imputDate.getTime());
        this.fechaNacimiento = sqldate;
    }
    
    //Getters and Setters

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public java.util.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

   public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    
    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPaciente == null) ? 0 : idPaciente.hashCode());
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
		final Paciente other = (Paciente) obj;
		if (idPaciente == null) {
			if (other.idPaciente != null)
				return false;
		} else if (!idPaciente.equals(other.idPaciente))
			return false;
		return true;
     
    }
        
    @Override
    public String toString() {
        return "Paciente [id = " + idPaciente + ", nombre=" + nombre + ", apellido=" + apellido +", dni= " + dni +", sexo= " + sexo +", direccion= " + direccion +", telefono= " + telefono +"]";
    }
      
}