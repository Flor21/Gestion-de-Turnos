import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Paciente from './views/Paciente.vue';
import Medico from './views/Medico.vue';
import RegistrarTurno from './views/RegistrarTurno.vue';
import ListarTurnop from './views/ListarTurnop.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Paciente,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue'),
    },
    {
      path: '/paciente',
      name: 'paciente',
      component: Paciente,
    },
    {
      path: '/medico',
      name: 'medico',
      component: Medico,
    },
    {
      path: '/registrarTurno',
      name: 'registrarTurno',
      component: RegistrarTurno,
    },
    {
      path: '/listarTurnop',
      name: 'listarTurnop',
      component: ListarTurnop,
    },
  ],
});
