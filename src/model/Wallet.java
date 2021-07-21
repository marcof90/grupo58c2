package model;

import java.util.ArrayList;


public class Wallet {

    public static final int CAPACIDAD_MAXIMA = 1000000;

    private int saldo;
    private boolean tieneLimite;
    private int meta;

    public static final int TOPE_TRANSACCION = 200000;
    public static final double TAZA_TRANSFERENCIA = 0.02;

    /**
     * Listas
     */

    private ArrayList<Transaction> movimientos;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        meta = 0;
        movimientos = new ArrayList<>();
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

        if (tieneLimite  && value > TOPE_TRANSACCION){
            return "El valor a ingresar debe ser menor a $200000";
        }
        
        saldo += value; // saldo = saldo + value
        Transaction ingreso = new Transaction(value, "hoy", 1, "Ingreso de dinero");
        movimientos.add(ingreso);
        if(verificarMeta()){System.out.println("Has cumplido la meta!");}
        return "Transacción exitosa, nuevo saldo " + saldo;
    }
    
    public String takeMoney(int value){
                
        if(saldo < value ) {
            return "Saldo insuficiente";
        }
        if(tieneLimite && (value > TOPE_TRANSACCION)){
            return "Supera el tope de transaccion " + TOPE_TRANSACCION;
        }
        //NO mirar esto: ((!(value < TOPE_TRANSACCION) && !tieneLimite) || !((!(value < TOPE_TRANSACCION) && tieneLimite) ))
            
            
        this.saldo -= value;
        Transaction retiro = new Transaction(value, "hoy", 2, "Retiro de dinero");
        movimientos.add(retiro);
        return "Transacción exitosa, nuevo saldo " + saldo;
        }
    

    public String breakLimit(){
        if(!tieneLimite){
            return "Tu cuenta no tiene limites!";
        }
        if(saldo >= 10000){
            saldo -= 10000;
            setTieneLimite(false); // tieneLimite = false;
            Transaction limite = new Transaction(10000, "hoy", 2, "Romper limites");
            movimientos.add(limite);
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

    public String transferirDinero(int value, Wallet otraWallet) {

        int saldoTaza= (int)(saldo-(TAZA_TRANSFERENCIA*value));
        if(saldoTaza < value ) {
            return "Saldo insuficiente";
        }
        else{
            saldo= saldoTaza-value;
            otraWallet.saveMoney(value);
        
            return "Transferencia exitosa, el nuevo saldo es " + saldo;
        }
    }

    public void displayMovimientos(){
        for (Transaction movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }
}
