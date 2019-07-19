<template>
    <div class="registrarTurno">
    <ListaObraSocial/>
    <Fecha/>
    <Hora/>
    <MotivoConsulta/>
    
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
    ListaMedicos,
    Fecha,
    Hora,
    MotivoConsulta,
  },
})

export default class RegistrarTurno extends Vue {}

</script>
