# Trabalho de TCP: etapa 1 :ok_hand: :joy: :ok_hand:
Desenvolvimento da 1a etapa do trabalho da disciplina de Técnicas de Construção de Programas.

## Objetivos: :floppy_disk: :eggplant: :sweat_drops:
- Diagrama de classes -- deve ser legível contendo apenas todas (desde a interface ao
armazenamento de dados) as classes relacionadas com as funcionalidades adicionadas ou modificadas, focar
nas classes envolvidas nas funcionalidades e eventuais classes para contextualizá-las (evitar classes soltas)

- Diagramas de sequência -- devem ser legíveis, mostrando o fluxo de execução completo das
funcionalidades adicionadas ou modificadas (um diagrama por funcionalidade);

- Explicação textual das alterações realizadas. O relatório deve se entregue em um arquivo único no formato PDF.

- Arquivo do projeto da ferramenta CASE escolhida (Astah ou StarUML), contento os diagramas desenvolvidos.

- Arquivo .jar que deve ser executável, ou seja, classe main e classpath devem constar no arquivo Manifest. :shit: :shit:

- Arquivo .zip contendo o seu projeto Eclipse (:shit::shit::shit:), que deve:
  1. Conter todos os arquivos fonte, i.e., arquivos .java e outros como .properties;
  2. Conter arquivos de configuração do projeto do Eclipse (.classpath, .project, etc.) para que o projeto possa ser importado. Caso o projeto não seja criado no Eclipse, após a conclusão do projeto, configure um projeto no Eclipse com o código fonte desenvolvido para possibilitar a entrega.
  
## Crescimento: :muscle:
O sistema deve ter uma funcionalidade adicional de segurança, que solicita autorização de um funcionário para que uma transferência acima de R$5.000,00 seja realizada em um caixa eletrônico. Dessa forma, a funcionalidade de transferência deve ter este novo comportamento. Estão marcadas em negrito as modificações.
1. Usuário solicita realizar uma transferência.
2. Caso a solicitação seja feita de um caixa eletrônico, a agência e conta do cliente (usuário) são recuperadas da sessão, caso contrário (a solicitação seja feita de uma agência), o sistema solicita ao funcionário (usuário) agência e conta do cliente.
3. Sistema solicita a agência e conta de destino da transferência, e o usuário informa.
4. Sistema solicita a quantidade a ser transferida, e o usuário informa.
5. Caso haja saldo suficiente na conta de origem
  * **Caso a solicitação seja feita em uma agência, ou seja, feita em um caixa eletrônico e a quantidade a ser transferida seja inferior a R$5.000,00:**
    * Sistema debita o valor a ser transferido da conta de origem;
    * Sistema credita o valor a ser transferido para a conta de destino;
    * Sistema registra a transação com estado FINALIZADA em ambas as contas de origem e de destino.  
  * **Caso a solicitação seja feita em um caixa eletrônico e a quantidade a ser transferida seja superior
ou igual à R$5.000,00:**
    * Sistema debita o valor a ser transferido da conta de origem
    * Sistema registra a transação com estado PENDENTE na conta de origem
6. Caso não haja saldo suficiente na conta de origem, sistema informa que não é possível realizar a transação.
7. Sistema exibe o status da operação.
8. Sistema retorna ao menu principal.


Além da modificação na operação de transferência, o sistema tem uma nova funcionalidade: autorizar transferência.
Esta funcionalidade deve funcionar da seguinte forma.
1. Funcionário solicita visualizar transferências pendentes.
2. Sistema informa as transferências em estado PENDENTE.
3. Funcionário seleciona uma transferência PENDENTE.
4. Sistema exibe a transferência selecionada, informando conta de origem, conta de destino, e valor, e solicita a autorização do funcionário.
5. Caso o funcionário autorize a transferência
  * Sistema credita o valor a ser transferido para a conta de destino
  * Sistema altera a transação para estado FINALIZADA na conta de origem
  * Sistema registra a transação com estado FINALIZADA na conta de destino
6. Caso o funcionário não autorize a transferência
  * Sistema credita o valor a ser transferido de volta para a conta de origem
  * Sistema altera a transação para estado CANCELADA na conta de origem
7. Sistema exibe o status da operação.
8. Sistema retorna ao menu principal.
