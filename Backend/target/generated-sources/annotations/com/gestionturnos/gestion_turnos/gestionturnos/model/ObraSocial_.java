package com.gestionturnos.gestion_turnos.gestionturnos.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ObraSocial.class)
public abstract class ObraSocial_ {

	public static volatile SingularAttribute<ObraSocial, Integer> idObraSocial;
	public static volatile ListAttribute<ObraSocial, Paciente> paciente;
	public static volatile SingularAttribute<ObraSocial, String> direccion;
	public static volatile ListAttribute<ObraSocial, Turno> turnos;
	public static volatile SingularAttribute<ObraSocial, String> nombre;

	public static final String ID_OBRA_SOCIAL = "idObraSocial";
	public static final String PACIENTE = "paciente";
	public static final String DIRECCION = "direccion";
	public static final String TURNOS = "turnos";
	public static final String NOMBRE = "nombre";

}

