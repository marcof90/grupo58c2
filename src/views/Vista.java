package views;

import model.Wallet;

public class Vista {
    
    public static void main(String[] args) {
        Wallet billetera = new Wallet();
        Wallet wallet2 = new Wallet();
        try {
            System.out.println(billetera.getSaldo()/0);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Ups paso algo");
        }
        
        try {
            System.out.println(billetera.saveMoney(600000));
            System.out.println(billetera.saveMoney(600000));
            System.out.println(billetera.saveMoney(600000));
            System.out.println(billetera.getSaldo()/0);
            System.out.println(billetera.saveMoney(200000));
            System.out.println(billetera.saveMoney(300000));
            System.out.println(billetera.breakLimit());
            System.out.println(billetera.getSaldo());
            System.out.println(wallet2.getSaldo());  
            System.out.println(wallet2.establecerMeta(1100000));          
            System.out.println(billetera.establecerMeta(900000));          
            System.out.println(billetera.establecerMeta(1900000));          
            System.out.println(billetera.saveMoney(1200000));
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }

    }

}
