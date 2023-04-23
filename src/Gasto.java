package pac_programcion;
import java.text.NumberFormat;

public class Gasto extends Dinero{

    public Gasto(double gasto, String description) {
        super.dinero = gasto;
        super.description = description;

    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "Gasto: " + super.description + ", cantidad: " + nf.format(dinero);
    }
}
