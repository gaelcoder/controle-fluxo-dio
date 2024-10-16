import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args){
        String [] candidatos = {"Gabriel", "Erick", "Mike", "Rod", "Juliana"};
        for(String candidato: candidatos){
            realizarContato(candidato);
        }

    }

    static void imprimirSelecionados(){
        String [] candidatos = {"Gabriel", "Erick", "Mike", "Rod", "Juliana"};

        System.out.println("Imprimindo lista de candidatos");

        for(int i=0; i < candidatos.length; i++) {
            System.out.println("Candidato nº" + (i + 1) + ": " + candidatos[i]);
        }

        System.out.println("Forma mais simples: ");
        int indice = 1;
        for(String candidato: candidatos){
            System.out.println("Candidato selecionado nº" + indice + ": " + candidato);
            indice++;
        }
    }

    static void realizarContato(String candidato){
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            System.out.println("Tentativa: " + tentativas + " de contato com " + candidato);
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando) {
                tentativas++;
            } else {
                System.out.println("Contato com " + candidato + " realizado com sucesso!");
            }

            if(tentativas == 3){
                System.out.println("Contato com " + candidato + " não foi realizado!");
            }

        }while (continuarTentando && tentativas<3);
    }

    //método

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Gabriel", "André", "Lucas", "Maria", "Leonardo", "Juliana", "Renata", "Erick", "Andrew", "Mike", "Rod"};

        int candidatosEscolhidos = 0;
        int candidatosAtual = 0;
        double salarioBase = 1600.0;

        while(candidatosEscolhidos < 5){

            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = pretensaoSalarial();
            System.out.println("O candidato " + candidato + " solicitou R$" + salarioPretendido + "como pretensão salarial.");
            if (salarioBase >= pretensaoSalarial()){
                System.out.println("O candidato " + candidato + "foi selecionado.");
                candidatosEscolhidos++;
            }
            candidatosAtual++;
        }
    }

    static double pretensaoSalarial() {
        return ThreadLocalRandom.current().nextDouble(1300,2000);
    }

    static void analisarCandidato(double pretensaoSalarial) {
        double salarioBase = 1600.0;
        if (salarioBase > pretensaoSalarial) {
            System.out.println("Ligue para o candidato");
        } else if (pretensaoSalarial==salarioBase){
            System.out.println("Ligue para o candidato com uma contra proposta");
        } else {
            System.out.println("Aguardando resultado dos outros candidatos...");
        }
    }
}
