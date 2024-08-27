package br.com.bancodigital;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> listaContas;

    
    public Banco(String nome) {
        this.nome = nome;
        this.listaContas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return listaContas;
    }

    public void adicionaConta(Conta conta) {
        this.listaContas.add(conta);
    }

    public void removerConta(Conta conta) {
        if ( !listaContas.isEmpty()) {
            for (Conta c : listaContas) {
                if (c.getNumero() == conta.getNumero()) {
                    listaContas.remove(conta);
                }
            }
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public void imprimirContas() {
        System.out.println(this.nome + ": " + listaContas.toString());
    }

    public void imprimirClientes() {
        if ( !listaContas.isEmpty()) {
            System.out.print("Clientes: ") ;
            for (Conta c : listaContas) {
                System.out.print(c.getCliente().toString() + ", ");
            }
        } else 
            System.out.println("Sem clientes no momento!");
    }
}
