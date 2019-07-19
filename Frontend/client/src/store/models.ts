export interface IMedico{
    idMedico: number;
    apellido: string;
    nombre: string;
    dni: number;
    sexo: string;
    estadoCivil: string;
    direccion: string;
    matricula: number;
    especilidad: string;
    medicos: [];
}

export interface IMedicoObraSocial{
    idMedicoObraSocial: number;
    idMedico: number;
    idObraSocial: number;
    medicoObraSociales: [];
}

export interface IObraSocial{
    idObraSocial: number;
    nombre: string;
    direccion: string; 
    obraSociales: [];  
}

export interface ITurno{
    idTurno: number;
    fecha: string;
    hora: string;
    motivoConsulta: string;
    turnos: [];
}

export interface IPaciente{
    idPaciente: number;
    apellido: string;
    nombre: string;
    dni: number;
    fechaNacimiento: string;
    sexo: string;
    direccion: string;
    telefono: number;
    pacientes: [];
}
