package pac_programcion;
import java.text.NumberFormat;

public class Ingreso extends Dinero{

    public Ingreso(double ingreso, String description) {
        super.dinero = ingreso;
        super.description = description;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "Ingreso: " + super.description + ", cantidad: " + nf.format(dinero);
    }
}
