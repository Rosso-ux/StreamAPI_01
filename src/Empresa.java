import java.util.List;

public class Empresa {

    private String nome;
    private List<Funcionario> funcionarios;

    public Empresa(String nome, List<Funcionario> funcionarios) {
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}