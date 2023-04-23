package pac_programcion;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cuenta {

    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    public Cuenta(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = 0;

        gastos = new ArrayList<>();
        ingresos = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double addIngresos (String description, double cantidad){
        ingresos.add(new Ingreso(cantidad, description));
        saldo += cantidad;
        return saldo;

    }

    public double addGastos (String description, double cantidad) {
        try{
            if (this.saldo < cantidad) {
                throw new GastoException();
            }else{
                this.gastos.add(new Gasto(cantidad, description));
                this.saldo -= cantidad;
            }
        }catch (GastoException e){
        }finally {
            return this.saldo;
        }
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    @Override
    public String toString() {
        NumberFormat saldoFormato = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
        return "Cuenta: " + "\n" + usuario + "\n\tSaldo: " + saldoFormato.format(saldo);
    }
}
