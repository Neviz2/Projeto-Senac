import { useState, useEffect } from 'react'
import './App.css'

function App() {
  
  // 1. Criamos a variável 'clientes' (começa vazia) usando a ferramenta oficial do React
  const [clientes, setClientes] = useState([])
  
  // 2. O useEffect dispara a busca ao carregar a página
  useEffect(() => { 
    fetch(import.meta.env.VITE_API_URL + '/clientes') 
      .then(resposta => resposta.json()) // Pega o pacote que veio do Spring e transforma em JSON
      .then(dados => setClientes(dados)) // Salva os dados recebidos dentro da variável 'clientes'
      .catch(erro => console.error("Erro ao buscar dados:", erro)) // Mostra erro no console se o servidor cair
  }, []) // ⚠️ Atenção: Estes colchetes vazios são essenciais para o React não entrar em loop infinito!
  
  return (
    <div>
      <h1>Sistema de Assistência Técnica</h1>
      <h2>Meus Clientes na Nuvem:</h2>

      {/* 3. Pegamos a variável clientes e criamos uma tag <li> para cada um */}
      <ul>
        {clientes.length === 0 ? (
          <p>Carregando dados...</p>
        ) : (
          clientes.map(cliente => (
            <li key={cliente.id}>
              <strong>{cliente.nome}</strong> - {cliente.telefone}
            </li>
          ))
        )}
      </ul>
    </div>
  )
}

export default App