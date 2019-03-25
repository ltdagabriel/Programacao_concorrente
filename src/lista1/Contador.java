package lista1;

public class Contador {
    private int number;
    Contador(){
        number=0;
    }

    public int plus(){
        this.number+=1;
        return this.number;
    }

    public int getNumber() {
        return number;
    }
}
