# AULA 03 - CRUD ANDROID SQLITE: Atualizar e Excluir

**Objetivo:** Criar um menu de contexto para atualizar ou excluir itens da lista de alunos em uma aplicação Android.

## Passos para Implementar Atualizar/Excluir

1. **Criar um menu chamado `menu_contexto.xml`** na pasta `app>res>menu`.

2. **Adicionar dois itens ao menu**, denominados 'Excluir' e 'Atualizar'.

3. **Método `onCreateContextMenu`:**
   - Inflar o menu de contexto quando um item é pressionado.
   - Código exemplo:
     ```java
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);
         MenuInflater i = getMenuInflater();
         i.inflate(R.menu.menu_contexto, menu);
     }
     ```

4. **Registrar o menu de contexto na ListView:**
   - Código exemplo:
     ```java
     registerForContextMenu(listView);
     ```

5. **Método `Excluir` em `ListarAlunosActivity`:**
   - Pergunta se deseja realmente excluir o aluno.
   - Código exemplo:
     ```java
     public void excluir(MenuItem item) {
         AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
         final Aluno alunoExcluir = alunosFiltrados.get(menuInfo.position);
         AlertDialog dialog = new AlertDialog.Builder(this)
             .setTitle("Atenção")
             .setMessage("Realmente deseja excluir o aluno?")
             .setNegativeButton("NÃO", null)
             .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     alunosFiltrados.remove(alunoExcluir);
                     alunos.remove(alunoExcluir);
                     dao.excluir(alunoExcluir);
                     listView.invalidateViews();
                 }
             }).create();
         dialog.show();
     }
     ```

6. **Método `Excluir` em `AlunoDao`:**
   - Excluir o aluno do banco de dados.
   - Código exemplo:
     ```java
     public void excluir(Aluno a) {
         banco.delete("aluno", "id = ?", new String[]{a.getId().toString()});
     }
     ```

7. **Método `Atualizar` em `ListarAlunosActivity`:**
   - Abre a janela de cadastro para atualizar o aluno.
   - Código exemplo:
     ```java
     public void atualizar(MenuItem item) {
         AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
         final Aluno alunoAtualizar = alunosFiltrados.get(menuInfo.position);
         Intent it = new Intent(this, MainActivity.class);
         it.putExtra("aluno", alunoAtualizar);
         startActivity(it);
     }
     ```

8. **Receber dados em `MainActivity`:**
   - Código exemplo:
     ```java
     private Aluno aluno = null;

     Intent it = getIntent();
     if(it.hasExtra("aluno")) {
         aluno = (Aluno) it.getSerializableExtra("aluno");
         nome.setText(aluno.getNome().toString());
         cpf.setText(aluno.getCpf());
         telefone.setText(aluno.getTelefone());
     }
     ```

9. **Modificar o método `salvar` em `MainActivity`:**
   - Verificar se o aluno é `null` para decidir entre cadastrar ou atualizar.
   - Código exemplo:
     ```java
     public void salvar(View view) {
         if (aluno == null) {
             aluno = new Aluno();
             aluno.setNome(nome.getText().toString());
             aluno.setCpf(cpf.getText().toString());
             aluno.setTelefone(telefone.getText().toString());
             long id = dao.inserir(aluno);
             Toast.makeText(this, "Aluno Inserido com sucesso!!", Toast.LENGTH_SHORT).show();
         } else {
             aluno.setNome(nome.getText().toString());
             aluno.setCpf(cpf.getText().toString());
             aluno.setTelefone(telefone.getText().toString());
             dao.atualizar(aluno);
             Toast.makeText(this, "Aluno Atualizado!!", Toast.LENGTH_SHORT).show();
         }
     }
     ```

10. **Método `Atualizar` em `AlunoDao`:**
    - Atualizar o aluno no banco de dados.
    - Código exemplo:
      ```java
      public void atualizar(Aluno aluno) {
          ContentValues values = new ContentValues();
          values.put("nome", aluno.getNome());
          values.put("cpf", aluno.getCpf());
          values.put("telefone", aluno.getTelefone());
          banco.update("aluno", values, "id = ?", new String[]{aluno.getId().toString()});
      }
      ```
