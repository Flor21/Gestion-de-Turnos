<template>
  <div class="fecha">
    <h1>Fecha</h1>
    <v-container>
      <v-layout justify-center>
        <v-flex xs6>
          <v-card dark color="blue accent-1" class="pa-3 ma-4" width=100>            
           <v-date-picker 
            v-model="fechaActual"
            locale="es"
            :min="minimo"
            @input="obtFecha(fechaActual)"
            >
            </v-date-picker>
          </v-card>
        </v-flex>
        <v-flex xs3>
          <v-card dark color="blue accent-1" class="pa-3 ma-4">          
            <v-time-picker
            v-model="horaselec" 
            min="8:00"
            max="19:00"
            @input="obtHora(horaselec)"
            ></v-time-picker>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { ITurno } from '@/store/models';

@Component
export default class Fecha extends Vue {
  private fechaselec: ITurno = {} as ITurno;
  private horaselec: ITurno = {} as ITurno;
  private minimo: string = '';
  private fechaActual: string = '';

  private async created() {
    this.fechaActual = new Date().toISOString().substr(0,10);
    this.minimo = new Date().toISOString().substr(0, 10);
    this.fechaselec = { 
      idTurno: 10,
      fecha: this.fechaActual,
      hora: '',
      motivoConsulta: '',
      turnos: [],
    }
  }
  
  private async obtFecha(fecha: ITurno) {

    console.log(fecha);
  }
  private async obtHora(hora: ITurno){
    console.log(hora);
  }
  

}
</script>

