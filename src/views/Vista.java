package views;

import model.Wallet;

public class Vista {
    
    public static void main(String[] args){
        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        wallet1.setTieneLimite(false);
        
        System.out.println(wallet1.saveMoney(500000));
        
        System.out.println(wallet1.saveMoney(300000));
        
        System.out.println(wallet1.takeMoney(300000));
        
        wallet1.setTieneLimite(true);
        
        System.out.println(wallet1.saveMoney(100000));
        System.out.println(wallet1.saveMoney(300000));
        
        System.out.println(wallet1.takeMoney(100000));
        System.out.println(wallet1.takeMoney(300000));

        System.out.println(wallet1.getSaldo());
        System.out.println(wallet2.getSaldo()); 

        wallet1.transferirDinero(wallet2,50000);

        System.out.println(wallet1.getSaldo());
        System.out.println(wallet2.getSaldo());  

    }

}