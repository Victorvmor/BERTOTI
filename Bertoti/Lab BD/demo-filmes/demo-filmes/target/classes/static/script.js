// A URL da API continua a mesma
const API_URL = 'http://localhost:8080/filmes';

document.addEventListener('DOMContentLoaded', () => {

    // Pega os elementos do HTML
    const form = document.getElementById('form-filme');

    // ATUALIZAÇÃO: Trocamos a tabela pelo grid de cards
    const filmesGrid = document.getElementById('filmes-grid');

    const btnCancelar = document.getElementById('btn-cancelar');

    // Campos do formulário (sem mudança)
    const filmeIdInput = document.getElementById('filmeId');
    const tituloInput = document.getElementById('titulo');
    const diretorInput = document.getElementById('diretor');
    const anoInput = document.getElementById('anoLancamento');
    const generoInput = document.getElementById('genero');

    // 1. FUNÇÃO: Limpar o formulário (sem mudança)
    function limparFormulario() {
        form.reset();
        filmeIdInput.value = '';
    }

    // 2. AÇÃO: Botão de Cancelar (sem mudança)
    btnCancelar.addEventListener('click', limparFormulario);

    // 3. FUNÇÃO: Carregar filmes (A GRANDE MUDANÇA)
    // Agora cria CARDS em vez de linhas de tabela
    async function carregarFilmes() {
        filmesGrid.innerHTML = ''; // Limpa o grid
        const response = await fetch(API_URL);
        const filmes = await response.json();

        filmes.forEach(filme => {
            // Cria o elemento <div> do card
            const card = document.createElement('div');
            card.className = 'filme-card'; // Adiciona a classe CSS

            // Preenche o HTML interno do card
            card.innerHTML = `
                <div class="filme-card-info">
                    <h3>${filme.titulo}</h3>
                    <p><span>Diretor:</span> ${filme.diretor}</p>
                    <p><span>Ano:</span> ${filme.anoLancamento}</p>
                    <p><span>Gênero:</span> ${filme.genero}</p>
                    <small style="color: #555;">ID: ${filme.id}</small>
                </div>
                <div class="filme-card-acoes">
                    <button class="card-btn edit" data-id="${filme.id}">Editar</button>
                    <button class="card-btn delete" data-id="${filme.id}">Excluir</button>
                </div>
            `;

            // Adiciona o novo card ao grid na tela
            filmesGrid.appendChild(card);
        });
    }

    // 4. AÇÃO: Enviar formulário (Sem NENHUMA mudança)
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const id = filmeIdInput.value;
        const filmeData = {
            titulo: tituloInput.value,
            diretor: diretorInput.value,
            anoLancamento: parseInt(anoInput.value),
            genero: generoInput.value,
        };

        let url = API_URL;
        let method = 'POST';
        if (id) {
            url = `${API_URL}/${id}`;
            method = 'PUT';
        }

        await fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(filmeData),
        });

        limparFormulario();
        await carregarFilmes();
    });

    // 5. AÇÃO: Gerenciador de cliques (AGORA NO GRID)
    // A lógica é a mesma, mas o "ouvinte" está no grid
    filmesGrid.addEventListener('click', async (event) => {

        const target = event.target; // Onde o usuário clicou

        // --- AÇÃO DE DELETAR ---
        if (target.classList.contains('delete')) {
            const id = target.getAttribute('data-id');
            if (confirm(`Tem certeza que quer excluir o filme ID ${id}?`)) {
                await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
                await carregarFilmes();
            }
        }

        // --- AÇÃO DE EDITAR ---
        if (target.classList.contains('edit')) {
            const id = target.getAttribute('data-id');

            const response = await fetch(`${API_URL}/${id}`);
            const filme = await response.json();

            // Preenche o formulário (sem mudança)
            filmeIdInput.value = filme.id;
            tituloInput.value = filme.titulo;
            diretorInput.value = filme.diretor;
            anoInput.value = filme.anoLancamento;
            generoInput.value = filme.genero;

            window.scrollTo(0, 0); // Rola para o topo
        }
    });

    // --- Início ---
    carregarFilmes();
});