import java.time.LocalDate;

public class Funcionario {

    private String nome;
    private LocalDate dataNascimento;
    private double salario;
    private TipoContrato tipoContrato;

    public Funcionario(String nome, LocalDate dataNascimento, double salario, TipoContrato tipoContrato) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.tipoContrato = tipoContrato;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    @Override
    public String toString() {
        return nome +
                " | Salário: R$ " + salario +
                " | Nascimento: " + dataNascimento +
                " | Contrato: " + tipoContrato;
    }
}