import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipaisMetodos {
    private List<Integer> numeros;

    public PrincipaisMetodos(){
        this.numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, 45));
    }

    public List<Integer> mostrarOrdemNumerica(){
        return numeros.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int somarNumerosPares(){
       return numeros.stream()
               .filter(n -> n%2 == 0 )
               .reduce(0, Integer::sum);
    }

    public boolean verificarSeSaoPositivos(){
        return numeros.stream()
                .allMatch(n -> n>0);
    }

    public void removerValoresImpares(){
        numeros.removeIf(n -> n%2 != 0);
    }

    public double calcularMediaNumerosMaioresCinco(){
        return numeros.stream().filter(n -> n>5)
                .mapToDouble(n -> n)
                .average().orElse(0.0);
    }

    public boolean verificarMaiorQueDez(){
        return numeros.stream()
                .anyMatch(n -> n>10);
    }

    public int encontrarSegundoMaiorNumero(){
        //return numeros.stream().max(Integer::compareTo).orElseThrow();
        return numeros.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1) //ignora o maior numero
                .findFirst() // pega o primeiro após o skip (segundo número)
                .orElseThrow();
    }

    public int somarTodosOsNumeros(){
        return numeros.stream().reduce(0, Integer::sum);
    }

    public boolean verificarRepeticaoNumero(){
        return numeros.stream()
                .distinct()
                .count() != numeros.size();
    }

    public List<Integer> agruparImparesMultTresCinco(){
        return numeros.stream().filter(n -> n%2!=0 && (n%3 == 0 || n%5 == 0))
                .collect(Collectors.toList());
    }

    public int somarQuadrados(){
        return (int) numeros.stream()
                .mapToDouble(n -> Math.pow(n, 2))
                .sum();
    }

    public int multiplicarNumeros(){
        return numeros.stream()
                .reduce(1, (a,b) -> (a*b));
    }

    public List<Integer> mostrarNumerosNoIntervalo(int primeiro, int ultimo){
        return numeros.stream()
                .filter(n -> (n>primeiro && n<ultimo))
                .collect(Collectors.toList());
    }

    public int encontrarMaiorPrimo(){
        return numeros.stream()
                .filter(this::isPrimo)
                .max(Integer::compareTo)
                .orElseThrow();
    }
    private boolean isPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarNegativo(){
        return numeros.stream()
                .anyMatch(n -> n < 0);
    }

    public String separarParImpar(){
        String pares = numeros.stream()
                .filter(n -> n%2 ==0)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "Números pares: [", "]"));
        String impares = numeros.stream()
                .filter(n -> n%2 !=0)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "\nNúmeros impares:[", "]"));

        return pares.concat(impares);
    }

    public List<Integer> mostrarNumerosPrimos(){
      return  numeros.stream()
              .filter(this::isPrimo)
              .collect(Collectors.toList());
    }

    public boolean verificarSeSaoIguais(){
        return numeros.stream()
                .allMatch(n -> n.equals(numeros.get(0)));
    }

    public int somaNumerosDivisiveisTresCinco(){
        return numeros.stream()
                .filter(n ->(n%3 == 0 && n%5 == 0))
                .reduce(0, Integer::sum);
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }
}
