import { VuexModule, Action, Mutation, Module, getModule } from 'vuex-module-decorators';
import store from '@/store';
import { ITurno } from '../models';
import { getTurnos, getTurno, deleteTurno, createTurno, getTurnoPaciente } from './axios';

@Module({
    namespaced: true,
    name: 'turnos',
    store,
    dynamic: true,
})
class TurnoModule extends VuexModule {
    private turnos: ITurno[]|null = null;
    private turno: ITurno|null = null;
    private turnoPaciente: ITurno[]|null = null;

    public get turnolist() {
        return this.turnos;
    }

    @Action({ commit: 'setTurnos' })
    public async getTurnos() {
        const turnos = await getTurnos();
        return turnos;
    }

    @Action({ commit: 'setTurno' })
    public async createTurno(turno: ITurno) {
        const turnoNew = await createTurno(turno);
        return turnoNew;
    }

    @Action({ commit: 'setTurno' })
    public async getTurno(idTurno: number) {
        const turno = await getTurno(idTurno);
        return turno;
    }

    @Action({ commit: 'setTurnoPaciente' })
    public async getTurnoPaciente(idPaciente: number) {
        const turnoPaciente = await getTurnoPaciente(idPaciente);
        return turnoPaciente;
    }    

    @Mutation
    private setTurno(turno: ITurno|null) {
        this.turno = turno;
    }

    @Mutation
    private setTurnos(turnos: ITurno[]|null) {
        this.turnos = turnos;
    }
    
    @Mutation
    private setTurnoPaciente(turnoPaciente: ITurno[]|null) {
        this.turnoPaciente = turnoPaciente;
    }

}

export default getModule(TurnoModule);