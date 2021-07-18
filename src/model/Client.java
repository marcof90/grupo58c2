package model;
public class Client extends User { // Hereda las propiedades de User
    private Wallet wallet;

    public Client(String newName) {
        super();
        wallet = new Wallet();
        setName(newName);
    }

    public Wallet getWallet() {
        return wallet;
    }
    /* @Override // Notación
    public int getStatus() {
        // TO*D*O Auto-generated method stub
        return super.getStatus();
    } */
}
