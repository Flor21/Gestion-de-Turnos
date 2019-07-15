<template>
<div class="paciente">
    <v-carousel hide-delimiters>
     <v-carousel-item
      v-for="(item,i) in items"
      :key="i"
      :src="item.src"
        ></v-carousel-item>
    </v-carousel>
  
    </div>
</template>

<script>
  export default {
    data () {
      return {
        items: [
          {
            src: 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.adsttc.com%2Fmedia%2Fimages%2F5101%2Fa0c4%2Fb3fc%2F4b51%2F3000%2F0015%2Flarge_jpg%2Feacsn_hospavila_06.jpg%3F1414599952&f=1'
          },
          {
            src: 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.hospitalveugenia.com%2Fwp-content%2Fuploads%2F2015%2F04%2FHabitacion_tipo.jpg&f=1'
          },
          {
            src: 'https://qtxasset.com/2016-08/careteam_1.jpg?xgd2rUrhjEbGTrm2xKnfmCOEJLU2Kr_y'
          },
          {
            src: 'https://www.aarc.org/wp-content/uploads/2017/01/multidisc_teams.jpg'
          }
        ]
      }
    }
  }
</script>

