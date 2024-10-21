# NutriComp - Comparador de Alimentos Nutricionais

**Autor:** Roger da Palma

## Objetivo Geral

NutriComp é um aplicativo projetado para comparar informações nutricionais de alimentos e sugerir alternativas mais saudáveis ou adequadas conforme as necessidades dos usuários. Ele ajuda a visualizar valores nutricionais, calcular porções e sugerir substituições alimentares de maneira eficiente.

## Funcionalidades Principais

- **Cadastro de Usuários:** Criação de contas de usuário com validação de email e senha.
- **Exibição de Alimentos:** Listagem de alimentos organizados por categorias, como "Carnes e derivados" ou "Frutas e derivados".
- **Busca de Alimentos:** Filtragem dinâmica dos alimentos conforme o usuário digita.
- **Comparação de Alimentos:** Comparação entre dois alimentos, exibindo suas composições nutricionais (a ser implementado em futuras versões).
- **Alternativas Nutricionais:** Exibição de alimentos alternativos nutricionalmente semelhantes.
- **Cálculo Nutricional por Gramas:** Ajuste dinâmico da porção e cálculo dos valores nutricionais baseados no peso inserido (planejado para atualizações futuras).

## Funcionalidades Futuras

- Comparação detalhada entre dois alimentos, exibindo a quantidade por gramas e valores nutricionais calculados.
- Integração de histórico de comparações, permitindo que os usuários revisitem comparações passadas.

## Banco de Dados

O NutriComp utiliza `SQLite` para armazenar os dados de forma local. Isso permite o uso do aplicativo offline, mantendo informações nutricionais e de usuários diretamente no dispositivo.

### Tabelas

1. **Usuário:**
   - `idusuario`: Identificador único.
   - `nome`: Nome do usuário.
   - `email`: Endereço de email.
   - `senha`: Senha para login.
  
2. **Alimento:**
   - `idalimento`: Identificador único.
   - `nome`: Nome do alimento.
   - `categoria`: Categoria a qual o alimento pertence.
   - `calorias`, `carboidratos`, `proteinas`, `gorduras`, `fibras`: Valores nutricionais por 100g.
   - `quantidadeporgramas`: Quantidade de gramas para cálculo nutricional.

3. **Comparativo:**
   - `idcomparativo`: Identificador único.
   - `idusuario`: Referência ao usuário.
   - `idalimento1`, `idalimento2`: Referências aos alimentos comparados.
   - `data`: Data do comparativo.
   - `quantidadeporgramas`: Quantidade usada na comparação.

## Bibliotecas Utilizadas

- **AndroidX RecyclerView:** Exibição eficiente de listas de dados, como a listagem de alimentos.
- **SQLite:** Banco de dados local para armazenamento de usuários e informações nutricionais.
- **Java TextWatcher:** Monitora a entrada de texto para busca dinâmica de alimentos.
- **Material Design:** Design moderno e intuitivo para uma experiência do usuário agradável.

## Estrutura do Projeto

- **MainActivity.java:** Tela inicial com a listagem das categorias de alimentos.
- **FoodListActivity.java:** Exibe os alimentos registrados em cada categoria, com filtro dinâmico na barra de pesquisa.
- **LoginActivity.java:** Tela de login de usuários com validação de email e senha.
- **RegisterActivity.java:** Tela de cadastro de novos usuários.
- **CategoryAdapter.java:** Adaptador usado para listar categorias no `RecyclerView`.
- **FoodAdapter.java:** Adaptador para listar alimentos e seus detalhes nutricionais.

## Desafios Enfrentados

- **Integração com SQLite:** Manter o banco de dados sincronizado com as informações nutricionais e garantir a correta busca dos alimentos por categoria.
- **Exibição Dinâmica:** Ajustar o `RecyclerView` para buscar e exibir resultados conforme o usuário digita.
- **Navegação entre Activities:** Manter o fluxo adequado ao navegar entre a tela inicial, categorias e a listagem de alimentos.

## Próximas Atualizações

- **Comparação de Alimentos:** Será adicionada a funcionalidade de comparar dois alimentos e exibir a composição nutricional somada.
- **Cálculo Nutricional por Gramas:** Permitir que o usuário insira a quantidade de gramas desejada, e o aplicativo calculará os valores nutricionais com base nessa quantidade.
  
---

# Planejamento Scrum

## Metodologia de Trabalho

Utilizamos Scrum para organizar e desenvolver o aplicativo, garantindo entregas contínuas e melhorias iterativas. Aqui está o cronograma detalhado das tarefas:

### Sprints

| Sprint    | Funcionalidade                                                  | Status          | Duração   |
|-----------|------------------------------------------------------------------|-----------------|-----------|
| **Sprint 1** | Configuração inicial do projeto e criação do banco de dados SQLite | **Concluído**   | 2 semanas |
| **Sprint 2** | Implementação das telas de login e cadastro                   | **Concluído**   | 2 semanas |
| **Sprint 3** | Criação da listagem de alimentos por categoria com filtro dinâmico | **Concluído**   | 2 semanas |
| **Sprint 4** | Implementação da funcionalidade de comparação entre alimentos | **Em Andamento**| 2 semanas |
| **Sprint 5** | Exibição de alternativas nutricionais e ajuste por porção     | **Planejado**   | 2 semanas |
| **Sprint 6** | Melhorias de interface e experiência do usuário (UX)          | **Planejado**   | 2 semanas |

## Funcionalidades Concluídas

- **Cadastro e Login de Usuários:** Validado com checagem de email e senha.
- **Listagem de Alimentos por Categoria:** Exibição de alimentos com barra de pesquisa dinâmica.
- **Navegação entre telas:** Tela inicial, login, registro e listagem funcionando corretamente.
  
## Funcionalidades Futuras

- **Comparação entre alimentos**: Implementação e cálculo de valores nutricionais com base na quantidade de gramas.
- **Sugestões de alimentos alternativos**: Baseado nos valores nutricionais dos alimentos selecionados.

---

## Ferramentas e Tecnologias Utilizadas

- **IDE:** Android Studio.
- **Linguagem:** Java.
- **Banco de Dados:** SQLite.
- **Bibliotecas:** AndroidX, Material Design.

---

## Considerações Finais

O **NutriComp** está se aproximando das funcionalidades finais, com a comparação detalhada e ajuste de porções sendo implementados nas próximas sprints. O uso de metodologias ágeis como Scrum permite uma abordagem flexível, garantindo que o produto evolua com base no feedback dos usuários e nos testes realizados.

