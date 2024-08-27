import br.com.bancodigital.Banco;
import br.com.bancodigital.Cliente;
import br.com.bancodigital.ContaCorrente;
import br.com.bancodigital.ContaPoupanca;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Cliente maria = new Cliente("Maria");
        Cliente jose = new Cliente("José");

        ContaCorrente contaCorrente = new ContaCorrente(maria);
        contaCorrente.extratoBancario();
        contaCorrente.depositar(5570.90);
        contaCorrente.extratoBancario();


        ContaPoupanca contaPoupanca = new ContaPoupanca(jose);
        contaPoupanca.depositar(9999.12556);
        contaPoupanca.extratoBancario();
        contaPoupanca.tranferir(2222.0, contaCorrente);
        contaPoupanca.tranferir(87500.0, contaCorrente);

        // System.out.println(contaCorrente);

        Banco nubank = new Banco("Nubank"); 
        // nubank.imprimirContas();
        nubank.adicionaConta(contaPoupanca);
        nubank.adicionaConta(contaCorrente);
        nubank.imprimirContas();
        nubank.imprimirClientes();

    }
}
