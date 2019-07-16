package A08_executor.part1_ex_01;

public
class Fatorial implements Runnable {

    private final int numbero;
    private final Ret retorno;

    Fatorial(int numbero, Ret retorno) {

        this.numbero = numbero;
        this.retorno = retorno;
    }

    @Override
    public void run() {
        int value = 1;
        for (int i = 1; i <= numbero; i++) {
            value *= i;
        }
        retorno.value = value;
    }
}

