<template>
  <div class="fecha">
  <h2>Fecha y hora</h2>
    <v-container>
      <v-dialog
        ref="dialog"
        v-model="modal"
        :return-value.sync="fechaS"
        persistent
        width="290px"
      >
        <template v-slot:activator="{ on }">
          <v-text-field
            v-model="fechaS"
            label="Seleccione la fecha"
            prepend-icon="event"
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker v-model="fechaP" scrollable>
          <v-spacer></v-spacer>
          <v-btn text color="primary" @click="modal = false">Cancelar</v-btn>
          <v-btn text color="primary" @click="$refs.dialog.save(fechaP), fechaSele(fechaP)" >Aceptar</v-btn>
        </v-date-picker>
      </v-dialog>
    </v-container>
    <v-container fluid>
      <v-radio-group v-model="tiempo" :mandatory="true" @click="tiempoSelec(tiempo)" >
        <v-radio label="AM" value="am" ></v-radio>
        <v-radio label="PM" value="pm" ></v-radio>
      </v-radio-group>
        <v-select
          v-model="hora"
          :hint="`${hora}`"
          :items="horas"
          label="Hora"
          outlined
          @input="horaSeleccionada(hora)"
        ></v-select>
    </v-container>

  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { ITurno } from '@/store/models';

@Component
export default class Fecha extends Vue {

  private modal: Boolean = false;
  public fechaSeleccionada : String = '';
  private fechaS : String = '';
  private fechaP : String = '';
  private fechaT: String = '';

  private tiempo: String = '';
  private hora : String = '';
  private horas : Array = [];

  
  private async fechaSele(fechaP: String) {
    this.fechaSeleccionada = fechaP;
    this.$emit('fechaSeleccionada', this.fechaSeleccionada)
  }

  private async tiempoSelec(value: String){
    if(value == "am"){
      this.horas = ['08:00','09:00', '10:00', '11:00', '12:00'];
    }else{
      this.horas = ['18:00','19:00', '20:00'];
    }    
  }

  private async horaSeleccionada(hora: String){
    this.$emit('horaSeleccionada', hora)
  } 
  

}
</script>

