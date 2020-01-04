export interface IMedico {
    idMedico: string;
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

export interface IMedicoObraSocial {
    idMedicoObraSocial: string;
    idMedico: string;
    idObraSocial: string;
    medicoObraSociales: [];
}

export interface IObraSocial {
    idObraSocial: string;
    nombre: string;
    direccion: string; 
    obraSociales: [];  
}

export interface ITurno {
    idTurno: string;
    fecha: string;
    hora: string;
    motivoConsulta: string;
    turnos: [];
}

export interface IPaciente {
    idPaciente: string;
    apellido: string;
    nombre: string;
    dni: number;
    fechaNacimiento: string;
    sexo: string;
    direccion: string;
    telefono: number;
    pacientes: [];
}
