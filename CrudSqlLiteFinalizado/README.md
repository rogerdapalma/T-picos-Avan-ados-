# Aplicativo de Gerenciamento de Estudantes

Este é um aplicativo Android para o gerenciamento de informações de estudantes. Ele permite adicionar, editar, visualizar e excluir informações de estudantes, como nome, CPF, telefone e idade. O aplicativo foi desenvolvido com uma interface simples e intuitiva, utilizando o `RecyclerView` para exibir a lista de estudantes e `SQLite` como banco de dados local para armazenar as informações.

## Funcionalidades

### 1. Adicionar Estudante
- Permite adicionar um novo estudante ao banco de dados.
- Campos obrigatórios:
  - Nome: Texto (Obrigatório)
  - CPF: Formato `000.000.000-00` (Obrigatório e Validado)
  - Telefone: Formato `(000) 00000-0000` (Obrigatório e Validado)
  - Idade: Número inteiro (Obrigatório e Validado)

### 2. Editar Estudante
- Permite editar as informações de um estudante existente.
- Para editar um estudante, selecione um estudante da lista e clique no botão de editar (anteriormente botão de refresh).
- Os campos serão preenchidos automaticamente com as informações atuais do estudante selecionado.

### 3. Excluir Estudante
- Permite selecionar e excluir um ou mais estudantes da lista.
- Para excluir, selecione os estudantes que deseja remover e clique no botão de excluir.
- Um diálogo de confirmação será exibido antes da exclusão final.

### 4. Visualização da Lista de Estudantes
- A lista de estudantes cadastrados é exibida em um `RecyclerView`.
- Os itens da lista exibem informações como nome, CPF, telefone e idade.

### 5. Atualização Automática da Lista
- A lista de estudantes é atualizada automaticamente após adicionar, editar ou excluir um estudante.

## Estrutura do Código

### `MainActivity.java`
- **Responsável por:**
  - Exibir a lista de estudantes cadastrados.
  - Iniciar a atividade para adicionar ou editar um estudante.
  - Gerenciar a exclusão de estudantes.
  - Atualizar a lista após operações de adição, edição ou exclusão.

- **Principais métodos:**
  - `onCreate`: Inicializa a interface e configura os botões e o `RecyclerView`.
  - `onActivityResult`: Atualiza a lista de estudantes após uma operação de adição ou edição.
  - `deleteSelectedStudents`: Exclui os estudantes selecionados.
  - `refreshStudentList`: Atualiza o `RecyclerView` com a lista atualizada de estudantes.

### `AddEditStudentActivity.java`
- **Responsável por:**
  - Gerenciar a adição e edição de estudantes.
  - Validar a entrada de dados nos campos de texto.
  - Aplicar máscaras para CPF e telefone.
  - Enviar resultados de sucesso à `MainActivity` após uma operação.

- **Principais métodos:**
  - `onCreate`: Inicializa os campos de texto e o botão de salvar, e verifica se a operação é de adição ou edição.
  - `saveStudent`: Salva ou atualiza os dados do estudante no banco de dados.
  - `validateInput`: Valida os dados inseridos nos campos.
  - `loadStudentData`: Carrega os dados do estudante para edição.

### `StudentDatabaseHelper.java`
- **Responsável por:**
  - Gerenciar o banco de dados SQLite.
  - Criar, atualizar, inserir, editar e excluir registros de estudantes.

- **Principais métodos:**
  - `onCreate`: Cria a tabela de estudantes no banco de dados.
  - `addStudent`: Insere um novo estudante no banco de dados.
  - `updateStudent`: Atualiza os dados de um estudante existente.
  - `deleteStudent`: Remove um estudante do banco de dados.
  - `getAllStudents`: Recupera todos os estudantes cadastrados.
  - `getStudentById`: Recupera um estudante específico pelo ID.

### `StudentAdapter.java`
- **Responsável por:**
  - Exibir a lista de estudantes no `RecyclerView`.
  - Gerenciar a seleção de estudantes para edição ou exclusão.

- **Principais métodos:**
  - `onBindViewHolder`: Vincula os dados de cada estudante ao `RecyclerView`.
  - `getSelectedStudents`: Retorna a lista de estudantes selecionados.
  - `clearSelection`: Limpa a seleção de estudantes após uma operação.

## Instalação e Configuração

### Pré-requisitos
- Android Studio instalado.
- Dispositivo ou emulador Android.
