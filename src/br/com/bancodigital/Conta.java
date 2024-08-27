package br.com.bancodigital;

public abstract class Conta implements IConta {
    
    private static final int Agencia_Padrao = 1 ;
    private static int Sequencial = 1 ;

    protected int agencia;
    protected int numero;
    private double saldo;

    private Cliente cliente;

    //Construtor
    public Conta(Cliente cliente) {
        this.agencia = Conta.Agencia_Padrao;
        this.numero = Sequencial++;
        this.cliente = cliente;
        this.saldo = 0d;
    }

    //Metodos

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        if(saldo > valor){
            saldo -= valor;
            System.out.println("Valor retirado - R$" + valor);
        } else System.err.println("Não é possivel retirar o valor, não tem saldo suficiente!");

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Valor depositado R$ %.2f", valor );
        System.out.printf(" - Valor disponivel atual R$ %.2f\n", saldo);
    }

    @Override
    public void tranferir(double valor, Conta contaDestino) {
        if(this.getSaldo() > valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
            // System.out.println("Valor retirado - R$" + valor);
        } else System.err.println("Não é possivel retirar o valor de " + valor + ", não tem saldo suficiente!");
    }

    @Override
    public void extratoBancario() {
        System.out.print(String.format("Agencia %d" , this.agencia) + ", ");
        System.out.print(String.format("Conta nº %d" , this.numero) + ", ");
        System.out.print(String.format("Cliente: %s", this.cliente.getNome()) + ", ");
        System.out.print("Saldo Disponivel: " + this.saldo + "\n");
    }

    @Override
    public String toString() {

        String resposta = "Conta ";
        
        if (this instanceof ContaCorrente)
            resposta = "Conta corrente ";
        else if (this instanceof ContaPoupanca)
                resposta = "Conta Poupança ";

        return resposta + " [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
    }

    
}
