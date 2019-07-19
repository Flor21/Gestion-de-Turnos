<template>
  <div class="listaObraSocial">
    <v-container fluid>
    <v-layout row wrap align-center>
      <v-flex xs6>
        <v-subheader>Selecione la Obra social</v-subheader>
      </v-flex>

      <v-flex xs6>
        <v-select
          v-model="select"
          :hint="`${select.nombre}`"
          :items="items"
          item-text="nombre"
          item-value="idObraSocial"
          label="Selecionar"
          persistent-hint
          return-object
          single-line
          @input="obraSeleccionada(select)"
        >
        </v-select>
      </v-flex>

       <v-flex xs6>
        <v-subheader>Selecione el Medico</v-subheader>
      </v-flex>

      <v-flex xs6>
        <v-select
          v-model="sel"
          :hint="`${sel.apellido},${sel.nombre}`"
          :items="ite"
          item-text="apellido"
          item-value="nombre"
          label="Seleccionar"
          persistent-hint
          return-object
          single-line
        >
        </v-select>
      </v-flex>
    </v-layout>
  </v-container>
</div>

  </div> 
</template>


<script lang="ts">
import { IObraSocial } from '@/store/models';
import { getObraSociales } from '@/store/modules/axios';
import { Component, Vue } from 'vue-property-decorator';
import { getMedicos } from '@/store/modules/axios';
import { getMedicoObraSociales } from '@/store/modules/axios';
import { getMedicoObra } from '@/store/modules/axios';
import { IMedico } from '@/store/models';
import { IMedicoObraSocial } from '@/store/models';



@Component
export default class ListaObraSocial extends Vue {
  private items: IObraSocial[]|null = null;
  private select: IObraSocial = {} as IObraSocial;
  private ite: IMedicoObraSocial[]|null = null;
  private sel: IMedicoObraSocial = {} as IMedicoObraSocial;

  private async created() {
    const laomalo = await getObraSociales();
    this.items = laomalo;
    //this.select = this.items[0];
  }
  private async obraSeleccionada(obra: IObraSocial) {
    //console.log(obra.idObraSocial)
    const medicos = await getMedicoObra(obra.idObraSocial);
    this.ite = medicos;
    //console.log(medicos)
  }
 
}

</script>
