package model;

public class Wallet {

    public static final int CAPACIDAD_MAXIMA = 1000000;
    public static final int TOPE_TRANSACCION = 200000;
    public static final double TAZA_TRANSFERENCIA= 0.02;

    private int saldo;
    private boolean tieneLimite;
    private int meta;
    private int topeTransaccion;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        meta = 0;
        topeTransaccion = TOPE_TRANSACCION;
    }

    public int getTopeTransaccion(){
        return  topeTransaccion;

    }
    public int getSaldo(){
        return saldo;
    }

    public boolean getTieneLimite(){
        return tieneLimite;
    }

    public boolean establecerMeta(int value){
        if(value==0){
            meta = value;
            return true;
        }        
        if(value < 0 || value <= saldo || (value > CAPACIDAD_MAXIMA && tieneLimite)){
            return false;
        }        
        meta = value;
        return true;
    }

    public boolean verificarMeta(){
        if(meta == 0 || saldo < meta){
            return false;
        }
        return true;
    }

    public void setTieneLimite(boolean newTieneLimite){
        this.tieneLimite = newTieneLimite;
    }

    public String saveMoney(int value){
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite) {
            return "No se puede superar el limite " + CAPACIDAD_MAXIMA;
        }
        if (value>getTopeTransaccion() && tieneLimite){
            return "El valor supera el tope de transaccion  "+getTopeTransaccion();
        }
        saldo += value; // saldo = saldo + value
        if(verificarMeta()){System.out.println("Has cumplido la meta!");}
        return "Transacción exitosa, nuevo saldo " + saldo;
    }
    
    public String takeMoney(int value){
        if(saldo >= value){
            if (tieneLimite && value > getTopeTransaccion()){
                return "El valor supera el tope de transaccion "+getTopeTransaccion();
            }
            saldo -= value;
            return "Transacción exitosa, nuevo saldo " + saldo;
        }
        return "Saldo insuficiente";
    }

    public String breakLimit(){
        if(!tieneLimite){
            return "Tu cuenta no tiene limites!";
        }
        if(saldo >= 10000){
            saldo -= 10000;
            setTieneLimite(false); // tieneLimite = false;
            return "Has roto los limites!";
        }
        return "No tienes saldo suficiente :(";
    }

    public String compararCuenta(Wallet otraWallet) {
        if(saldo == otraWallet.getSaldo()){
            return "Las cuentas tienen en mismo saldo";
        }
        if(saldo > otraWallet.getSaldo()){
            return "La primera cuenta es mayor";
        }
        return "La segunda cuenta es mayor";
    }
    public void transferirDinero(Wallet otraWallet,int vtransferencia){
        this.takeMoney(vtransferencia);
        otraWallet.saveMoney(vtransferencia);
        this.takeMoney((int) (vtransferencia*TAZA_TRANSFERENCIA));
    }
}