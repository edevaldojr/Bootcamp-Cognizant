package me.dio.web.controles;

import java.util.ArrayList;

import me.dio.web.modelos.Cliente;
import me.dio.web.modelos.ClientePF;
import me.dio.web.modelos.ClientePJ;
import me.dio.web.modelos.ContaCorrente;
import me.dio.web.modelos.ContaCorrenteEspecial;
import me.dio.web.modelos.ContaCorrenteSimples;
import me.dio.web.modelos.ContaPoupanca;

//DRY
//Don't
//Repeat
//Yourself

public class Banco {
    
    private String nome;
    private String email;
        
    private ArrayList<Cliente> clientes;
    private ArrayList<ContaCorrente> contas;
    

    public Banco(String nome, String email) {
        this.nome = nome;
        this.setEmail(email);
        
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();

    }

    private boolean adicionaCliente(Cliente cliente){
        if(buscaCliente(cliente.getDocumento())==null){
            clientes.add(cliente);
            return true;
        }
        return false;
    }


    private Cliente buscaCliente(String doc){

        for(int i=0;i<clientes.size();i++){
            Cliente cliente = clientes.get(i);

            if(cliente.getDocumento().equals(doc)){
                return cliente;
            }
        }
        return null;
    }


    public boolean adicionaClientePF(ClientePF cliente){
        return adicionaCliente(cliente);
    }
      
     //procurar na coleção de clientes um cliente com o CPF
    public ClientePF buscaClientePF(String cpf){
        return (ClientePF)buscaCliente(cpf); //percorer todos os clientes        
    }

    public boolean adicionaClientePJ(ClientePJ cliente){
        
        return adicionaCliente(cliente);
    }

    public ClientePJ buscaClientePJ(String cnpj){
        
        return (ClientePJ)buscaCliente(cnpj);
    }
    // busca conta generica
    private ContaCorrente buscaConta(String numero, String agencia){

        for(ContaCorrente c:contas){
            if(c.getAgencia().equals(agencia) && c.getNumero().equals(numero)){
                return c;
            }
        }
        return null;
        
    }

    // adiciona conta generica
    private Boolean adicionaConta(ContaCorrente conta){

        if(buscaConta(conta.getNumero(), conta.getAgencia()) == null){
            contas.add(conta);
            return true;
        }
        return false;   

    }
    
    public boolean adicionaContaSimples(ContaCorrenteSimples conta){
        
        return adicionaConta(conta);     

    }

    public ContaCorrenteSimples buscaContaSimples(String numero, String agencia){
        
        return (ContaCorrenteSimples)buscaConta(numero, agencia);

    }

    public boolean adicionaContaEspecial(ContaCorrenteEspecial conta){
        
        return adicionaConta(conta);  

    }

    public ContaCorrenteEspecial buscaContaEspecial(String numero, String agencia){
        
        return (ContaCorrenteEspecial)buscaConta(numero, agencia);
    }

    public boolean adicionaContaPoupanca(ContaPoupanca conta){
        
        return adicionaConta(conta);      
    }

    public ContaPoupanca buscaContaPoupanca(String numero, String agencia){
        
        return (ContaPoupanca)buscaConta(numero, agencia);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Cliente> getClientesPF(){
        return this.clientes;
    }

    public ArrayList<Cliente> getClientesPJ(){
        return this.clientes;
    }
    
    public ArrayList<ContaCorrenteSimples> getContasSimples(){
        ArrayList<ContaCorrenteSimples> retorno = new ArrayList<>();
        for (ContaCorrente  c : contas) {
            if(c instanceof ContaCorrenteSimples){
                retorno.add((ContaCorrenteSimples)c);
            }
        }
        return retorno;
    }

    public ArrayList<ContaCorrenteEspecial> getContasEspecial(){
        ArrayList<ContaCorrenteEspecial> retorno = new ArrayList<>();
        for (ContaCorrente  c : contas) {
            if(c instanceof ContaCorrenteEspecial){
                retorno.add((ContaCorrenteEspecial)c);
            }
        }
        return retorno;
    }

    public ArrayList<ContaPoupanca> getContasPoupanca(){
        ArrayList<ContaPoupanca> retorno = new ArrayList<>();
        for (ContaCorrente  c : contas) {
            if(c instanceof ContaPoupanca){
                retorno.add((ContaPoupanca)c);
            }
        }
        return retorno;
    }
}
