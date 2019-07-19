<template>
    <div class="motivoConsulta">
        <v-form v-model="valid">
            <v-container>
            
                <v-layout>
                    <v-flex xs12 md4>
                        <v-text-field
                            v-model="motivoConsulta"
                            :rules="nameRules"
                            :counter="5"
                            label="Escriba su consulta"
                            required
                        ></v-text-field>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-form>
    </div>
</template>

<script>
 export default {
    data: () => ({
      valid: false,
      motivoConsulta: '',
        nameRules: [
        v => !!v || 'El motivo de la Consulta es necesario',
        v => v.length <= 50 || 'El motivo de la Consulta debe ser menor a 50 letras'
      ]
    })
  }
</script>