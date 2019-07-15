<template>
  <div class="lista-medicos">
    <h1>Lista de Medicos</h1>
    <div v-for="medico in medicos">
      
      {{ medico.apellido }}
      {{ medico.nombre }} 
    </div>
    
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import axios from 'axios';


export interface Medico {
  idMedico: number;
  apellido: string;
  nombre: string;
  dni: number;
  sexo: string;
  estadoCivil: string;
  direccion: string;
  matricula: number;
  especialidad: string;
  giphyUrl: string;
}

@Component
export default class ListaMedicos extends Vue {
  public medicos: Medico[] = [];

  private async created() {
    const response = await axios.get('/medico');
    this.medicos = await response.data.content;
  }
}

</script>