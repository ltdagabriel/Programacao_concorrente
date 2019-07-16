package A09_ColecoesConcorrentes.ex_02;

public class Carta {
    private int numero;
    private String simbolo;
    private String naipe;

    Carta(int numero, String simbolo, String naipe){
        this.numero = numero;
        this.naipe = naipe;
        this.simbolo = simbolo;
    }
    public void print(){
        if (simbolo != null) System.out.print(simbolo);
        else System.out.print(numero);
        System.out.printf(" de %s%n", naipe);
    }
}
