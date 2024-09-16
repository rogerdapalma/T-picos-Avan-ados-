# Aplicativo de Cadastro de Alunos

Este é um exemplo de **passagem de dados entre atividades** em um aplicativo Android. O projeto demonstra como passar informações, como o nome e a idade de um aluno, de uma atividade para outra.

## Arquivos principais

### 1. CadastroAlunoActivity.java
Este arquivo Java contém a lógica para a tela de cadastro de alunos. Nessa tela, o usuário pode inserir o nome e a idade de um aluno e enviar os dados para a tela de detalhes.

- **Passagem de Dados**: Ao clicar no botão "Enviar Dados", as informações inseridas são passadas para a `DetalhesAlunoActivity` usando um `Intent`.
- **Layout associado**: `activity_cadastro_aluno.xml`
- **Componentes principais**:
  - `EditText` para o nome do aluno.
  - `EditText` para a idade do aluno.
  - `Button` para enviar os dados.

### 2. DetalhesAlunoActivity.java
Este arquivo Java contém a lógica para exibir os detalhes de um aluno. Ele recebe os dados da `CadastroAlunoActivity` (nome e idade) e os exibe na interface.

- **Recepção de Dados**: Recebe o nome e a idade do aluno da `CadastroAlunoActivity` via `Intent`.
- **Layout associado**: `activity_detalhes_aluno.xml`
- **Componentes principais**:
  - `TextView` para exibir o nome do aluno.
  - `TextView` para exibir a idade do aluno.

## Layouts

### 1. activity_cadastro_aluno.xml
Este arquivo define o layout para a tela de cadastro de alunos, que contém dois campos de entrada e um botão para enviar os dados.

- **Componentes**:
  - `EditText` para o nome.
  - `EditText` para a idade.
  - `Button` para enviar os dados.

### 2. activity_detalhes_aluno.xml
Este arquivo define o layout para a tela de detalhes do aluno, que exibe o nome e a idade do aluno cadastrados.

- **Componentes**:
  - `TextView` para o nome do aluno.
  - `TextView` para a idade do aluno.

## Configurações do Manifest

O arquivo `AndroidManifest.xml` contém as configurações básicas do aplicativo, incluindo as declarações de atividades.

- **Atividades**:
  - `CadastroAlunoActivity`: Configurada como a tela principal do aplicativo.
  - `DetalhesAlunoActivity`: Responsável por exibir os detalhes do aluno após a passagem de dados.

## Como funciona a passagem de dados

1. **Cadastro de Aluno**:
   - Na `CadastroAlunoActivity`, o usuário insere o nome e a idade do aluno.
   - Ao clicar no botão "Enviar Dados", os dados são colocados em um `Intent` e enviados para a `DetalhesAlunoActivity`.

2. **Recepção dos Dados**:
   - Na `DetalhesAlunoActivity`, os dados (nome e idade) são recebidos do `Intent` e exibidos em `TextViews` na tela.

## Requisitos

- **SDK mínimo**: 21 (Lollipop)
- **SDK alvo**: 31 (Android 12)

