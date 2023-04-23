package pac_programcion;
public class GastoException extends RuntimeException {

    public GastoException() {
        System.out.println("Saldo insuficiente");
    }
}
