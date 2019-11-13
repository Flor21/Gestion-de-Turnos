import axios from 'axios';
import { IMedico, IMedicoObraSocial, IObraSocial, IPaciente, ITurno } from '../models';
import storage from './localstorage';

const autorizacion: string = 'Autorizacion';
export const baseUrl = axios.create({
    baseURL: 'http://localhost:8080',
});

/*      MEDICO      */
export async function getMedicos(): Promise<IMedico[]|null> {
try {
    const response = await baseUrl.get('/medico');
    return (response.data);
} catch(err){
    console.error(err);
}
return null;
}

export async function getMedico(idMedico: string): Promise<IMedico|null> {
    try {
        const response = await baseUrl.get(`medico/${idMedico}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getMatricula(matricula: string): Promise<IMedico|null> {
    try {
        const response = await baseUrl.get(`medico/matricula/${matricula}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getEspecialidad(especialidad: string): Promise<IMedico|null> {
    try {
        const response = await baseUrl.get(`medico/especialidad/${especialidad}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function createMedico(medico: IMedico): Promise<IMedico|null> {
    try {
        const response = await baseUrl.post(`medico/create`,medico);
        console.log(response);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function deleteMedico(idMedico: string) {
    try {
        const response = await baseUrl.delete(`medico/${idMedico}`);
    } catch (err){
        console.error(err);
    }

}

/*      MEDICO OBRA SOCIAL      */
export async function getMedicoObraSociales(): Promise<IMedicoObraSocial[]|null>{
    try {
        const response = await baseUrl.get('/medicoObraSocial');
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getMedicoObra(idObraSocial: number): Promise<IMedicoObraSocial[]|null> {
    try {
        const response = await baseUrl.get(`medicoObraSocial/medicos/${idObraSocial}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
} 

export async function getObraSocialMed(idMedico: string): Promise<IMedicoObraSocial[]|null> {
    try {
        const response = await baseUrl.get(`medicoObraSocial/obraSocial/${idMedico}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function createMedicoObraSocial(medicoObraSocial: IMedicoObraSocial): Promise<IMedicoObraSocial|null> {
    try {
        const response = await baseUrl.post(`medicoObraSocial`,medicoObraSocial);
        console.log(response);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function deleteMedicoObraSocial(idMedico: string, idObraSocial: string) {
    try {
        const response = await baseUrl.delete(`medicoObraSocial/medico/${idMedico}/obraSocial/${idObraSocial}`);
    } catch (err){
        console.error(err);
    }

}

/*      OBRA SOCIAL      */

export async function getObraSociales(): Promise<IObraSocial[]|null> {
    try {
        const response = await baseUrl.get('/obraSocial');
        return (response.data.content);
    } catch (err){
        console.error(err);
    }
    return null;
}

export async function getObraSocial(idObraSocial: string): Promise<IObraSocial|null> {
    try {
        const response = await baseUrl.get(`obraSocial/${idObraSocial}`);
        return (response.data);
    } catch(err) {
        console.error(err);
    }
    return null;
}

export async function createObraSocial(obraSocial: IObraSocial): Promise<IObraSocial|null> {
    try {
        const response = await baseUrl.post(`medico`,obraSocial);
        console.log(response);
        return (response.data);
    } catch(err) {
        console.error(err);
    }
    return null;
}

export async function deleteObraSocial(idObraSocial: string) {
    try {
        const response = await baseUrl.delete(`obraSocial/${idObraSocial}`)
    } catch(err){
        console.error(err);
    }
}

/*      TURNO       */

export async function getTurnos(): Promise<ITurno[]|null> {
    try {
        const response = await baseUrl.get('/turno');
        return (response.data.content);
    } catch(err) {
        console.error(err);
    }
    return null;
}

export async function getTurno(idTurno: number): Promise<ITurno|null> {
    try {
        const response = await baseUrl.get(`turno/${idTurno}`);
        return (response.data.content);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getTurnoPaciente(idPaciente: number): Promise<ITurno[]|null> {
    try {
        const response = await baseUrl.get(`turno/turnos/paciente/${idPaciente}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getTurnoMedico(idMedico: number): Promise<ITurno[]|null> { 
    try {
        const response = await baseUrl.get(`turno/turnos/medico/${idMedico}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function createTurno(turno: ITurno): Promise<ITurno|null> {
    try {
        const response = await baseUrl.post(`turno`,turno);
        console.log(response);
        return (response.data);
    } catch(err) {
        console.error(err);
    }
    return null;
}

export async function deleteTurno(idTurno: string) {
    try {
        const response = await baseUrl.delete(`turno/${idTurno}`);
    } catch (err){
        console.error(err);
    }
    return null;
}

/*      PACIENTE        */

export async function getPacientes(): Promise<IPaciente[]|null> {
    try {
        const response = await baseUrl.get('/paciente');
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getPaciente(idPaciente: number): Promise<IPaciente|null> {
    try {
        const response = await baseUrl.get(`paciente/${idPaciente}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getDni(dni: number): Promise<IPaciente|null> {
    try {
        const response = await baseUrl.get(`paciente/dni/${dni}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null;
}

export async function getPacienteObraSocial(idObraSocial: number): Promise<IPaciente|null> {
    try {
        const response = await baseUrl.get(`paciente/obraSocial/${idObraSocial}`);
        return (response.data);
    } catch(err){
        console.error(err);
    }
    return null
}

export async function createPaciente(paciente: IPaciente): Promise<IPaciente|null> {
    try {
        const response = await baseUrl.post(`paciente`,paciente);
        console.log(response);
        return (response.data);
    } catch(err) {
        console.error(err);
    }
    return null;
}

export async function deletePaciente(idPaciente: string) {
    try {
        const response = await baseUrl.delete(`paciente/${idPaciente}`)
    } catch(err){
        console.error(err);
    }
    return null;
}
