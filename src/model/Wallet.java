package model;
public class Wallet {
    public static final float MAXIMUM = 1000000;
    /*  public por ser una propiedad, 
    static para que no cambie y pueda ser accesible por la clase 
    y final para que sea una constante */
    private float balance;
    private boolean hasLimit;
    private int goal;
    // Método constructor
    public Wallet() { //ctor
        super(); //Llama el constructor
        balance = 0;
        hasLimit = true;
        meta = 0;
        // Valores por defecto
    }
    // Getters:
    public float getBalance(){
        return balance;
    }
    /* Se pone float de acuerdo al tipo de dato que retorna,
    get es para traer un valor */
    public boolean getHasLimit(){
        return hasLimit;
    }
    public boolean putGoal(int value){
        if(value == 0){
            goal = value;
            return true;
        }
        if(value < 0 || value <= balance || value >= MAXIMUM && hasLimit){
            return false;
        }
        goal = value;
        return true;
    }

    public boolean checkGoal(){
        if(goal == 0 || goal < balance){
            return false;
        }
        return true;
    }
    // Setters:
    public void setHasLimit(boolean newHasLimit){
        hasLimit = newHasLimit;
    }
    /* public void setHasLimit(boolean hasLimit){
        this.hasLimit = hasLimit; // this referencia el elemento de esta clase
    } */

    public String saveMoney(int value){
        if(balance+value > MAXIMUM && hasLimit){
            return "No se puede superar el límite establecido de "+MAXIMUM+" pesos.";
            // Cuando una función llega al return, deja de ejecutarse
        }
        balance += value; // balance = balance + value
        return "Transacción exitosa, nuevo saldo = "+balance;
    }

    public String withdraw(int value){
        if(balance < value){
            return "Saldo insuficiente";
        }
        balance -= value;
        return "Transacción exitosa, nuevo saldo = "+balance;
    }

    public String breakLimit(){
        if(balance >= 10000 && hasLimit){
            balance -= 10000;
            setHasLimit(false);
            return "Has roto los límites";
        }
        if(!hasLimit){
            return "Tu cuenta no tiene límites";
        }
        return "No tienes saldo suficiente";
    }
}
