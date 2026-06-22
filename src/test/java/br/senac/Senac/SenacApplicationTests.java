package br.senac.Senac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.senac.model.Clientes;

@SpringBootTest
class SenacApplicationTests {

	    @Test
    public void testarSeOsDadosDoClienteSaoSalvosCorretamente() {
        // 1. Cria o objeto do cliente vazio
        Clientes cliente = new Clientes();

        // 2. Insere os dados de teste
        cliente.setNome("Cliente Teste da Silva");
        cliente.setCpf("123.456.789-00");

        // 3. O JUnit verifica se o objeto guardou exatamente a informação correta
        assertEquals("Cliente Teste da Silva", cliente.getNome());
        assertEquals("123.456.789-00", cliente.getCpf());
    }
}
