import java.util.Random;

public class Motocicleta extends VeiculoMotorizado implements IPVA {
    private String[] desenho = new String[3];
    private static final float GASTOMOTOCICLETA = 0.25f;


    public Motocicleta(int id){
        super(id, 4, calcularIPVA(), calcularValor());
        
    
        desenho[0]="   ,_oo\n";
        desenho[1]=".-/c-//::\n";
        desenho[2]="(_)'==(_)\n\n";

    }

    public boolean mover(){
        
        boolean valida = true;
        if(super.getCombustivel() < this.GASTOMOTOCICLETA){
            System.out.println("Combustivel insuficiente");
            valida = false;
        }
        if(!super.rodasCalibradas()){
            valida = false;
        }
        
        if(!this.isPagoIPVA()){
            System.out.println("Ipva nao pago");
            valida = false;
        }
        
        if(valida){
            super.setDistanciaPercorrida(super.getDistanciaPercorrida() + 3);
        }
        
        return valida;
    }

    public float calcularIPVA(){
        return IPVA.VALOR_BASE * IPVA.CTE_MOTOCICLETA;
    }

    public float calcularValor(){
        Random r = new Random();
        return r.nextFloat() * 500;
    }

    public String toString(){
        return super.toString();
    }

}
