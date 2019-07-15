<template>
  <v-app>
    <v-toolbar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>HOSPITAL</span>
        <span class="font-weight-light">- PEDIATRICO</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      
    </v-toolbar>

    <v-content>
      <Paciente/>
    </v-content>
  </v-app>
</template>

<script>
import Paciente from '@/views/Paciente.vue';
export default {
  name: 'App',
  components: {
    Paciente
  },
  data () {
    return {
      //
    }
  }
}
</script>
