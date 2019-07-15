<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <ListaMedicos/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import ListaMedicos from '@/components/ListaMedicos.vue';


@Component({
  components: {
    ListaMedicos,
  },
})

export default class Home extends Vue {}

</script>
