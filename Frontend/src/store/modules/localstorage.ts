import { VuexModule, Module, getModule } from 'vuex-module-decorators';
import store from '@/store';

@Module({
    namespaced: true,
    name: 'storage',
    store,
})
class Storage extends VuexModule {
    public setToken(token: string) {
        localStorage.setItem('access_token', token);
    }
    public getToken() {
        return localStorage.getItem('access_token');
    }
}

export default getModule(Storage);