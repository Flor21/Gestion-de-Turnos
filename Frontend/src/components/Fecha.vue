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
            v-model="fecha"
            label="Seleccione la fecha"
            prepend-icon="event"
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker v-model="fecha" scrollable>
          <v-spacer></v-spacer>
          <v-btn text color="primary" @click="modal = false">Cancelar</v-btn>
          <v-btn text color="primary" @click="$refs.dialog.save(fechaN)"  @input="obtFecha(fechaN)">Aceptar</v-btn>
        </v-date-picker>
      </v-dialog>
    </v-container>
    <v-container fluid>
      <v-radio-group v-model="tiempo" :mandatory="true" @click="tiempoSelec" >
        <v-radio label="AM" :value="am" ></v-radio>
        <v-radio label="PM" :value="pm" ></v-radio>
      </v-radio-group>
      <v-col class="d-flex" cols="12" sm="6">
        <v-select
          v-model="hora"
          :hint="`${hora}`"
          :items="hora"
          label="Hora"
          outlined
        ></v-select>
      </v-col>
    </v-container>

  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { ITurno } from '@/store/models';

@Component
export default class Fecha extends Vue {

  private modal: Boolean = false;
  private fechaSeleccionada : ITurno = {} as ITurno;
  private fechaS : ITurno = {} as ITurno;
  private tiempo: String = '';
  private hora : Array = [];
  private am: String = 'am';
  private pm: String = 'pm';

  private async created() {
    this.fechaSeleccionada = fechaS;
  }

  private async tiempoSelec(value: String){
    console.log(value);
    if(value == "am"){
      this.hora = ['08:00','09:00', '10:00', '11:00', '12:00'];
    }else{
      this.hora = ['18:00','19:00', '20:00'];
    }
  }
  
  

}
</script>

