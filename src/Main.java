import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Empresa empresa1 = new Empresa(
                "Google",
                Arrays.asList(
                        new Funcionario("Ana", LocalDate.of(1980, 5, 10), 2800, TipoContrato.CLT),
                        new Funcionario("Carlos", LocalDate.of(1999, 3, 8), 8000, TipoContrato.CLT),
                        new Funcionario("Bruno", LocalDate.of(1978, 2, 20), 2500, TipoContrato.PJ)
                )
        );

        Empresa empresa2 = new Empresa(
                "Microsoft",
                Arrays.asList(
                        new Funcionario("Amanda", LocalDate.of(1982, 9, 15), 3000, TipoContrato.CLT),
                        new Funcionario("João", LocalDate.of(2003, 7, 25), 12000, TipoContrato.CLT),
                        new Funcionario("Pedro", LocalDate.of(2002, 1, 12), 9500, TipoContrato.CLT),
                        new Funcionario("Lucas", LocalDate.of(2001, 6, 30), 15000, TipoContrato.CLT)
                )
        );

        List<Empresa> empresas = Arrays.asList(empresa1, empresa2);

        System.out.println("Funcionários nascidos entre 1975 e 1985 com salário <= R$3000:");

        empresas.stream()
                .flatMap(empresa -> empresa.getFuncionarios().stream())
                .filter(funcionario ->
                        funcionario.getDataNascimento().getYear() >= 1975 &&
                                funcionario.getDataNascimento().getYear() <= 1985)
                .filter(funcionario -> funcionario.getSalario() <= 3000)
                .forEach(System.out::println);

        System.out.println();

        List<Integer> numeros = Arrays.asList(5, 8, 10, 3, 12, 15, 20);

        System.out.println("Soma dos pares: " + somaPares(numeros));

        System.out.println();

        System.out.println("30 maiores salários CLT de funcionários com menos de 25 anos:");

        maioresSalarios(empresas)
                .forEach(System.out::println);

    }

    public static int somaPares(List<Integer> numeros) {

        return numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .reduce(0, Integer::sum);

    }

    public static List<Double> maioresSalarios(List<Empresa> empresas) {

        return empresas.stream()
                .flatMap(empresa -> empresa.getFuncionarios().stream())
                .filter(funcionario -> funcionario.getTipoContrato() == TipoContrato.CLT)
                .filter(funcionario ->
                        Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears() < 25)
                .map(Funcionario::getSalario)
                .sorted((s1, s2) -> Double.compare(s2, s1))
                .limit(30)
                .collect(Collectors.toList());

    }

}