import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CEP que deseja buscar [Utilize apenas números]: ");
        String cep = input.nextLine();

        API api = new API("https://viacep.com.br/ws/", cep);
        api.requisicao();
    }
}