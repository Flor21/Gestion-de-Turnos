package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, Integer> idPaciente;
	public static volatile SingularAttribute<Paciente, Date> fechaNacimiento;
	public static volatile SingularAttribute<Paciente, ObraSocial> obraSocial;
	public static volatile SingularAttribute<Paciente, String> apellido;
	public static volatile SingularAttribute<Paciente, String> direccion;
	public static volatile ListAttribute<Paciente, Turno> turnos;
	public static volatile SingularAttribute<Paciente, String> sexo;
	public static volatile SingularAttribute<Paciente, Integer> telefono;
	public static volatile SingularAttribute<Paciente, String> nombre;
	public static volatile SingularAttribute<Paciente, Integer> dni;

	public static final String ID_PACIENTE = "idPaciente";
	public static final String FECHA_NACIMIENTO = "fechaNacimiento";
	public static final String OBRA_SOCIAL = "obraSocial";
	public static final String APELLIDO = "apellido";
	public static final String DIRECCION = "direccion";
	public static final String TURNOS = "turnos";
	public static final String SEXO = "sexo";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String DNI = "dni";

}

