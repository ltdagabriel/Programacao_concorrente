package lista1;

public class Contador {
    private int number;

    Contador() {
        number = 0;
    }

    int plus() {
        this.number += 1;
        return this.number;
    }

    int getNumber() {
        return number;
    }
}
