# Passagem de Parâmetros entre Activities

## Introdução

- No Android, a navegação entre Activities é fundamental para criar uma experiência interativa em um aplicativo.
- Além da navegação, muitas vezes é necessário transferir dados entre uma Activity e outra. Isso pode ser feito utilizando **Intents** com o uso de parâmetros adicionais, armazenados em um **Bundle**.

## Objetivo

- Entender como passar dados entre diferentes Activities utilizando Intents e explorar boas práticas para essa transferência de dados.

## Conceitos

1. **Intent**: Objeto utilizado para solicitar uma ação a outra Activity. Pode ser usado para iniciar uma nova tela ou enviar/receber dados entre Activities.
2. **Bundle**: Mapa que contém pares de chave-valor, usados para passar dados de uma Activity para outra através de um Intent.

## Métodos para Passagem de Dados

- **putExtra(String chave, valor)**: Utilizado para colocar dados no Intent.
- **getIntent()**: Obtém o Intent que iniciou a Activity atual.
- **getExtras()**: Obtém o Bundle de dados passado através do Intent.
- **getXXXExtra(String chave)**: Recupera o valor associado à chave fornecida.

## Tipos de Dados que Podem Ser Passados

- Os tipos mais comuns incluem: `int`, `String`, `boolean`, `float`, `double`, `ArrayList`, e objetos que implementam a interface `Parcelable`.

## Exemplo: Passando Dados entre Activities

Na **MainActivity**, temos um botão que inicia a **DetalhesActivity** e passa dados:

```java
// MainActivity.java
Intent intent = new Intent(this, DetalhesActivity.class);
intent.putExtra("nome_aluno", "João");
intent.putExtra("idade_aluno", 20);
startActivity(intent);
```
Na **DetalhesActivity**, recuperamos os dados passados:

```java

// DetalhesActivity.java
@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_detalhes);

  Intent intent = getIntent();
  String nomeAluno = intent.getStringExtra("nome_aluno");
  int idadeAluno = intent.getIntExtra("idade_aluno", -1); // -1 é valor padrão

  // Exibir os dados em um TextView
  TextView textView = findViewById(R.id.textViewAluno);
  textView.setText("Nome: " + nomeAluno + "\nIdade: " + idadeAluno);
}
```
## Usando Bundle para Agrupar Múltiplos Dados
Outra abordagem é agrupar vários valores em um **Bundle** e passar o Bundle pelo Intent:

```java
// Passando dados em um Bundle
Bundle bundle = new Bundle();
bundle.putString("nome_aluno", "João");
bundle.putInt("idade_aluno", 20);
intent.putExtras(bundle);
```
## Considerações Importantes
- **Limitação de Tamanho**: Evite passar grandes quantidades de dados diretamente via Intent, como imagens ou listas grandes.
- **Serialização e Parcelable**: Ao passar objetos personalizados entre Activities, o objeto deve implementar a interface `Parcelable` ou `Serializable`.

## Atividade Prática
- Crie duas Activities: **CadastroAlunoActivity** e **DetalhesAlunoActivity**.
    - Na primeira tela, adicione dois campos de entrada (EditText) para o nome e a idade do aluno, e um botão para "Enviar Dados".
    - Na segunda tela, exiba os dados passados.

Método **enviarDados()** da **CadastroAlunoActivity**:

```java
public void enviarDados(View view) {
  String nome = editTextNome.getText().toString();
  Intent intent = new Intent(CadastroAlunoActivity.this, DetalhesAlunoActivity.class);
  intent.putExtra("nome", nome);
  startActivity(intent);
}
```
Método **detalhesAlunoActivity()**:
```java
String nomeRecebido = getIntent().getStringExtra("nome");

if (nomeRecebido != null) {
  textViewNome2.setText("Nome recebido: " + nomeRecebido);
}
```
## Configurações de SDK
No arquivo `build.gradle.kts(:app)`:

```java
android {
    namespace = "com.example.passagemdados"
    compileSdk = 34  // SDK para compilação (Android 14)

    defaultConfig {
        applicationId = "com.example.passagemdados"
        minSdk = 24  // Versão mínima suportada (Android 7.0)
        targetSdk = 33  // App otimizado para Android 13
        versionCode = 1
        versionName = "1.0"
    }
}
```
No arquivo **AndroidManifest.xml**, o atributo `tools:targetApi` deve estar alinhado com o `targetSdk` do projeto para garantir a compatibilidade.

## Referências:

- Lecheta, Ricardo R. *Google Android: Aprenda a Criar Aplicações para Dispositivos Móveis com o Android SDK*. Novatec, 2009.
- Talukder, Asoke; Yavagal, Roopa. *Mobile Computing*. McGraw-Hill, 2007.
- Silva, D. *Desenvolvimento para Dispositivos Móveis*. Pearson, 2017.
- Android Developers. Disponível em: [https://developer.android.com](https://developer.android.com).
