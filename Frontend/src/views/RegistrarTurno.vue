<template>
  <div class="registrarTurno">
    <ListaObraSocial
      @medicoSeleccionado = "getMedico" />
    <Fecha
      @fechaSeleccionada="getFecha"
      @horaSeleccionada="getHora"/>
    <MotivoConsulta
      @motivoDeConsulta = "getMotivo"/>
    <v-container fluid>
      <v-layout align-center justify-center>      
        <v-flex  shrink
        pa-1>
          <v-btn color="red" dark @click="cancelar()">Cancelar
              <v-icon dark right>block</v-icon>
          </v-btn>  
        </v-flex>  
        <v-flex shrink
        pa-1>   
          <v-btn color="green" dark @click="obtenerTodo()">Aceptar
            <v-icon dark right>check_circle</v-icon>
          </v-btn>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import MotivoConsulta from '@/components/MotivoConsulta.vue';
import ListaMedicos from '@/components/ListaMedicos.vue';
import ListaObraSocial from '@/components/ListaObraSocial.vue';
import Fecha from '@/components/Fecha.vue';
import Hora from '@/components/Hora.vue';

@Component({
  components: {
    ListaObraSocial,
    Fecha,
    MotivoConsulta,
  },
  
})

export default class RegistrarTurno extends Vue {
  private fechaS : String;
  private horaS: String;
  private motivoE: String;
  private medicoObraS;

  obtenerTodo(data) {
    console.log(this.fechaS, this.horaS, this.motivoE, this.medicoObraS);
  }

  getFecha(fecha) {
    this.fechaS = fecha;
  }

  getHora(hora) {
    this.horaS = hora;
  }

  getMotivo(motivo) {
    this.motivoE = motivo;
  }

  getMedico(medicoObra) {
    this.medicoObraS = medicoObra;

  }
}

</script>
