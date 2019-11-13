<template>
  <div class="listarTurnop">
  <v-container grid-list-md text-xs-center>
    <v-layout row>
      <v-flex
        grow
        pa-1
      >
        <h1>Turnos</h1>
      </v-flex>
    </V-layout>
  </v-container>
    <v-list>
      <v-list-tile
      v-for="turno in turnoPaciente"
      >
        <v-list-tile-content>
          <v-list-tile-title v-text="turno.fecha"></v-list-tile-title>
        </v-list-tile-content>
        <v-list-tile-content>
          <v-list-tile-title v-text="turno.hora"></v-list-tile-title>
        </v-list-tile-content>
        <v-list-tile-content>
          <v-list-tile-title v-text="turno.motivoConsulta"></v-list-tile-title>
        </v-list-tile-content>
      </v-list-tile>
    </v-list>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import axios from 'axios';
import { ITurno } from '@/store/models';
import turnoPaciente from '@/store/modules/turnos';


@Component
export default class ListaTurnop extends Vue {
  private turnoPaciente: ITurno[]|null = null;

  private async created() {
    this.turnoPaciente = await turnoPaciente.getTurnoPaciente(51);
  }
  
}
</script>