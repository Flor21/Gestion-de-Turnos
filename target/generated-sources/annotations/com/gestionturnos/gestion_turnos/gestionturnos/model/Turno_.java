package com.gestionturnos.gestion_turnos.gestionturnos.model;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Turno.class)
public abstract class Turno_ {

	public static volatile SingularAttribute<Turno, Date> fecha;
	public static volatile SingularAttribute<Turno, String> motivoConsulta;
	public static volatile SingularAttribute<Turno, Time> hora;
	public static volatile SingularAttribute<Turno, Paciente> paciente;
	public static volatile SingularAttribute<Turno, ObraSocial> obraSocial;
	public static volatile SingularAttribute<Turno, Medico> medico;
	public static volatile SingularAttribute<Turno, Integer> idTurno;

	public static final String FECHA = "fecha";
	public static final String MOTIVO_CONSULTA = "motivoConsulta";
	public static final String HORA = "hora";
	public static final String PACIENTE = "paciente";
	public static final String OBRA_SOCIAL = "obraSocial";
	public static final String MEDICO = "medico";
	public static final String ID_TURNO = "idTurno";

}

