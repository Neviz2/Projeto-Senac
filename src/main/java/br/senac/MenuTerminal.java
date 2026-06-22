package br.senac; // Ajuste para o seu pacote principal

import br.senac.model.Clientes;
import br.senac.model.Mercadorias;
import br.senac.model.Servico;
import br.senac.service.ClientesService;
import br.senac.service.MercadoriasService;
import br.senac.service.ServicoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
// comandline parecdio com um main para rodar o codigo
public class MenuTerminal implements CommandLineRunner {


    
    private final ClientesService clientesService;
    private final MercadoriasService mercadoriasService;
    private final ServicoService servicoService;

    // faz um construtor de todas as clases 
    public MenuTerminal(ClientesService clientesService, 
                        MercadoriasService mercadoriasService, 
                        ServicoService servicoService) {
        this.clientesService = clientesService;
        this.mercadoriasService = mercadoriasService;
        this.servicoService = servicoService;
    }


        // aqui ele pega os dados do service e faz rodar tipo o mais que seria o run
        
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        while (!opcao.equals("0")) { // so sai do while se for = 0
            System.out.println("      SENAC SOLUTIONS - PAINEL ADMIN      ");
            System.out.println("1 - Modulo de Clientes");
            System.out.println("2 - Modulo de Equipamentos");
            System.out.println("3 - Modulo de Ordens de Servico (OS)");
            System.out.println("4 - Relatorios Gerenciais");
            System.out.println("0 - Encerrar Sistema");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextLine();


            // aqui entra nos outros menus
            switch (opcao) {
                case "1": menuClientes(scanner); break;
                case "2": menuEquipamentos(scanner); break;
                case "3": menuOS(scanner); break;
                case "4": menuRelatorios(scanner); break;
                case "0": System.out.println("\nEncerrando o terminal..."); break;
                default: System.out.println("\nOpcao invalida. Tente novamente.");
            }
        }
    }

    
    private void menuClientes(Scanner scanner) {
        System.out.println("\n--- GESTAO DE CLIENTES ---");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.print("Escolha: ");
        String op = scanner.nextLine();

        if (op.equals("1")) {
            // aqui criar um objt vazio

            Clientes cliente = new Clientes();

            System.out.print("Nome: "); cliente.setNome(scanner.nextLine());
            System.out.print("CPF: "); cliente.setCpf(scanner.nextLine());
            System.out.print("Telefone: "); cliente.setTelefone(scanner.nextLine());
            System.out.print("E-mail: "); cliente.setEmail(scanner.nextLine()); 
            
            // aqui faz o insert
            clientesService.salvar(cliente);
            System.out.println("=> Cliente cadastrado com sucesso!");

        } else if (op.equals("2")) {

            System.out.println("\n--- LISTA DE CLIENTES ---");

            List<Clientes> lista = clientesService.listarTodos(); // aqui faz o select * from clientes

            // aqui printa na tela os cliente

            for (Clientes c : lista) {
                System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome() + " | CPF: " + c.getCpf());
            }
        }
    }

    
    private void menuEquipamentos(Scanner scanner) {
        System.out.println("\n--- GESTAO DE EQUIPAMENTOS ---");
        System.out.println("1 - Cadastrar Equipamento");
        System.out.println("2 - Listar Equipamentos");
        System.out.print("Escolha: ");
        String op = scanner.nextLine();

        if (op.equals("1")) {
            Mercadorias merc = new Mercadorias();
            System.out.print("Tipo (ex: Notebook): "); merc.setTipo(scanner.nextLine());
            System.out.print("Marca: "); merc.setMarca(scanner.nextLine());
            System.out.print("Modelo: "); merc.setModelo(scanner.nextLine());
            System.out.print("Numero de Serie: "); merc.setNumeroSerie(scanner.nextLine()); 
            System.out.print("Defeito: "); merc.setDescDefeito(scanner.nextLine());
            
            mercadoriasService.salvarMerc(merc);
            System.out.println("=> Equipamento cadastrado com sucesso!");

        } else if (op.equals("2")) {
            System.out.println("\n--- LISTA DE EQUIPAMENTOS ---");
            List<Mercadorias> lista = mercadoriasService.ListarTodos();
            for (Mercadorias m : lista) {
                
                System.out.println("ID: " + m.getIdmerc() + " | Marca: " + m.getMarca() + " | Modelo: " + m.getModelo());
            }
        }
    }

    
    private void menuOS(Scanner scanner) {
        System.out.println("\n--- CONTROLE DE OS ---");
        System.out.println("1 - Abrir Nova OS");
        System.out.println("2 - Listar Todas as OS");
        System.out.print("Escolha: ");
        String op = scanner.nextLine();


        if (op.equals("1")) {

            Servico servico = new Servico();
            
            
            System.out.print("Digite o ID do Cliente: ");

            Long idCliente = Long.parseLong(scanner.nextLine()); // aqui pega o id cliente e convert para long para conseguir fazer o select

            Clientes cliente = new Clientes();

            cliente.setId(idCliente);
            servico.setCliente(cliente); 
            
            
            System.out.print("Digite o ID do Equipamento: ");
            Long idMerc = Long.parseLong(scanner.nextLine());
            Mercadorias mercadoria = new Mercadorias();
            mercadoria.setIdmerc(idMerc);
            servico.setMercadoria(mercadoria);

            
            System.out.print("Descricao do Servico/Defeito: "); 
            servico.setDescServico(scanner.nextLine());
            
         
            System.out.print("Responsavel (Tecnico): "); 
            servico.setResponsavel(scanner.nextLine());
            
            System.out.print("Custo R$: "); 
            servico.setCusto(Double.parseDouble(scanner.nextLine()));
            
         
            servico.setDataEnt(java.time.LocalDate.now());
            servico.setStatus("Aberta"); 
            
            servicoService.SalvarServico(servico);
            System.out.println("=> OS aberta com sucesso!");

        } else if (op.equals("2")) {
            System.out.println("\n--- LISTA DE OS ---");

            List<Servico> lista = servicoService.ListarTodosServicos();

            for (Servico s : lista) {
                
                System.out.println("ID: " + s.getId() + " | Cliente: " + s.getCliente().getNome() + " | Status: " + s.getStatus());
            }
        }
        else if (op.equals("3")) {

            System.out.println("\nATUALIZAR STATUS DA OS");

            System.out.print("Digite o ID da OS que deseja atualizar: ");
            
            Long idOs = Long.parseLong(scanner.nextLine());

            Servico osEncontrada = null;

            for (Servico s : servicoService.ListarTodosServicos()) {
                if (s.getId().equals(idOs)) {
                    osEncontrada = s; // Achou a OS!
                    break;
                }
            }

            if (osEncontrada != null) {

                System.out.println("Status atual: " + osEncontrada.getStatus());
                System.out.println("Novo Status:");
                System.out.println("1 - Em Andamento");
                System.out.println("2 - Aguardando Peça");
                System.out.println("3 - Finalizada (Encerrar)");
                System.out.print("Escolha: ");
                String novoStatus = scanner.nextLine();

                if (novoStatus.equals("1")) osEncontrada.setStatus("Em Andamento");
                else if (novoStatus.equals("2")) osEncontrada.setStatus("Aguardando Peca");
                else if (novoStatus.equals("3")) osEncontrada.setStatus("Finalizada");

                
                servicoService.SalvarServico(osEncontrada);

                System.out.println("Status da OS atualizado com sucesso!");

            } else {

                System.out.println("OS nao encontrada no banco de dados.");
            }
        }
    }

    
    private void menuRelatorios(Scanner scanner) {
        System.out.println("\n--- RELATORIOS ---");
        System.out.println("1 - Clientes Cadastrados");
        System.out.println("2 - Equipamentos Recebidos");
        System.out.println("3 - Ordens de Servico Gerais");
        System.out.print("Escolha: ");
        String op = scanner.nextLine();

        switch (op) {
            case "1":
                System.out.println("\nRELATORIO DE CLIENTES CADASTRADO");

                clientesService.listarTodos().forEach(c -> System.out.println("- " + c.getNome() + " (CPF: " + c.getCpf() + ")"));

                break;
            case "2":
                System.out.println("\nRELATORIO DE EQUIPAMENTOS");
                mercadoriasService.ListarTodos().forEach(m -> System.out.println("- " + m.getMarca() + " " + m.getModelo() + " | Defeito: " + m.getDescDefeito()));

                break;
            case "3":
                System.out.println("\nRELATORIO DE ORDENS DE SERVICO");

                servicoService.ListarTodosServicos().forEach(s -> System.out.println("- OS " + s.getId() + " | Cliente: " + s.getCliente().getNome() + " | Status: " + s.getStatus()));

                break;
        }
    }
}