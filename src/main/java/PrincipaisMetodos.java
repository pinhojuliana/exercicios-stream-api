import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipaisMetodos {
    private List<Integer> numeros;

    public PrincipaisMetodos(){
        this.numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, 45);
    }

    //1
    public List<Integer> mostrarOrdemNumerica(){
        return numeros.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    //2
    public int somarNumerosPares(){
       return numeros.stream()
               .filter(n -> n%2 == 0 )
               .reduce(0, Integer::sum);
    }
    //3
    public boolean verificarSeSaoPositivos(){
        return numeros.stream()
                .allMatch(n -> n>0);
    }
    //4
    public void removerValoresImpares(){
        numeros.removeIf(n -> n%2 != 0);
    }
    //5
    public double calcularMediaNumerosMaioresCinco(){
        return numeros.stream().filter(n -> n>5)
                .mapToDouble(n -> n)
                .average().orElse(0.0);
    }
    //6
    public boolean verificarMaiorQueDez(){
        return numeros.stream()
                .anyMatch(n -> n>10);
    }
    //7
    public int encontrarMaiorNumero(){
        return numeros.stream().max(Integer::compareTo).orElseThrow();
    }
    //8
    public int somarTodosOsNumeros(){
        return numeros.stream().reduce(0, Integer::sum);
    }
    //9
    public boolean verificarRepeticaoNumero(){
        return numeros.stream()
                .distinct()
                .count() != numeros.size();
    }
    //10
    public List<Integer> agruparImparesMultTresCinco(){
        return numeros.stream().filter(n -> n%2!=0 && (n%3 == 0 || n%5 == 0))
                .collect(Collectors.toList());
    }

}
