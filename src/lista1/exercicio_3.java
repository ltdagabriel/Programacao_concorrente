package lista1;

public class exercicio_3 {
    public static void main(String[] args){
        Contador temp = new Contador();
        for(int i=0; i< 10000;i++){
            Implement_threads a = new Implement_threads(temp);
            a.start();
        }
    }
}
