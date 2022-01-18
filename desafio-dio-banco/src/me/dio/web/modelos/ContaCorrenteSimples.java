package me.dio.web.modelos;

public class ContaCorrenteSimples extends ContaCorrente {
    
    
    public ContaCorrenteSimples(String numero, String agencia, Cliente dono, double saldo){
        super(numero, agencia, dono,saldo);
    }

    public ContaCorrenteSimples(String numero, String agencia, Cliente dono){
        this(numero,agencia,dono,0.0);
    }

}
