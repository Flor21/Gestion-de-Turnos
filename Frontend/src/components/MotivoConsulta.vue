<template>
    <div class="motivoConsulta">
            <h2>Motivo</h2>
            <v-container>
                <v-layout>
                    <v-flex xs12 md4>
                        <v-text-field
                            v-model="motivoConsulta"
                            :counter="5"
                            label="Escriba su consulta"
                            required
                            @input="obtMotivo(motivoConsulta)"
                        ></v-text-field>
                    </v-flex>
                </v-layout>
            </v-container>
    </div>
</template>

<script lang="ts">
import { Component,Vue } from 'vue-property-decorator';
import { ITurno } from '@/store/models';

@Component
export default class MotivoConsulta extends Vue {
    private motivo: string = '';
    private motivoConsulta: string = '';
    private mot: string = '';

    private async created() {
        this.$emit('motivoDeConsulta', this.motivo)
    }
    private async obtMotivo( mot: string) {
        console.log(mot);
        this.motivo = mot;
    }
}

</script>