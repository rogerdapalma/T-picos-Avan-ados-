# Aplicativo de Gerenciamento de Estudantes

Este é um aplicativo Android simples para gerenciar informações de estudantes. Ele permite adicionar, visualizar e listar estudantes. O aplicativo foi desenvolvido utilizando Java e SQLite para o armazenamento de dados.

## Funcionalidades

- Adicionar um novo estudante
- Listar todos os estudantes cadastrados
- Visualizar detalhes de um estudante

## Estrutura do Projeto

### 1. `AndroidManifest.xml`

Este arquivo define as atividades do aplicativo e as configurações básicas da aplicação.

### 2. `activity_main.xml`

Layout principal do aplicativo contendo um `RecyclerView` para listar os estudantes e um botão flutuante para adicionar novos estudantes.

### 3. `activity_add_edit_student.xml`

Layout para adicionar ou editar informações de um estudante. Inclui campos de entrada para nome, CPF, telefone e idade, além de um botão para salvar as informações.

### 4. `student_item.xml`

Layout para cada item de estudante exibido na lista, mostrando nome, CPF, telefone e idade.

### 5. `MainActivity.java`

Atividade principal do aplicativo. Responsável por exibir a lista de estudantes e iniciar a atividade para adicionar um novo estudante.

### 6. `AddEditStudentActivity.java`

Atividade para adicionar ou editar um estudante. Inclui lógica para capturar os dados de entrada do usuário e salvar no banco de dados.

### 7. `Student.java`

Classe de modelo que representa um estudante, contendo campos para nome, CPF, telefone e idade, além dos métodos getter e setter.

### 8. `StudentAdapter.java`

Adaptador para o `RecyclerView` que exibe a lista de estudantes. Responsável por vincular os dados dos estudantes aos elementos de interface do usuário no layout `student_item.xml`.

### 9. `StudentDatabaseHelper.java`

Classe que gerencia o banco de dados SQLite. Inclui métodos para criar a tabela de estudantes, adicionar um novo estudante e recuperar todos os estudantes.

## Como Funciona

### Adicionando um Estudante

1. Na tela principal (`MainActivity`), clique no botão flutuante (`FloatingActionButton`).
2. Isso abrirá a atividade `AddEditStudentActivity`.
3. Preencha os campos de nome, CPF, telefone e idade.
4. Clique no botão "Salvar" para adicionar o estudante ao banco de dados.

### Listando Estudantes

1. Na tela principal (`MainActivity`), a lista de estudantes será carregada automaticamente do banco de dados e exibida no `RecyclerView`.

## Como Executar o Projeto

1. Clone o repositório.
2. Abra o projeto no Android Studio.
3. Conecte um dispositivo Android ou inicie um emulador.
4. Execute o aplicativo a partir do Android Studio.

## Requisitos

- Android Studio
- Dispositivo ou Emulador Android com versão mínima API 16


