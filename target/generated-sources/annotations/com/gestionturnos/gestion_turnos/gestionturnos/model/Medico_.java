package com.gestionturnos.gestion_turnos.gestionturnos.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medico.class)
public abstract class Medico_ {

	public static volatile SingularAttribute<Medico, String> apellido;
	public static volatile SingularAttribute<Medico, String> direccion;
	public static volatile SingularAttribute<Medico, Integer> matricula;
	public static volatile ListAttribute<Medico, Turno> turnos;
	public static volatile SingularAttribute<Medico, Integer> idMedico;
	public static volatile SingularAttribute<Medico, String> estadoCivil;
	public static volatile SingularAttribute<Medico, String> sexo;
	public static volatile SingularAttribute<Medico, String> nombre;
	public static volatile SingularAttribute<Medico, String> especialidad;
	public static volatile SingularAttribute<Medico, Integer> dni;

	public static final String APELLIDO = "apellido";
	public static final String DIRECCION = "direccion";
	public static final String MATRICULA = "matricula";
	public static final String TURNOS = "turnos";
	public static final String ID_MEDICO = "idMedico";
	public static final String ESTADO_CIVIL = "estadoCivil";
	public static final String SEXO = "sexo";
	public static final String NOMBRE = "nombre";
	public static final String ESPECIALIDAD = "especialidad";
	public static final String DNI = "dni";

}

