# O que são Generics?

Generics permitem criar classes, métodos ou interfaces que funcionam com qualquer tipo de dado, usando um parâmetro de tipo, geralmente `<T>`.  
Por exemplo, `Avaliacao<T>` pode ser `Avaliacao<Produto>`, `Avaliacao<Servico>`, etc.  
O `<T>` é um “espaço reservado” para o tipo real que será usado.

## Proposta do Exercício

Vamos criar objetos genéricos! Imagine que você trabalha em um site que oferece várias coisas: venda de produtos, serviços de instalação desses produtos e assinatura de alguns itens. Todas essas coisas têm algo em comum: podem ser avaliadas pelos consumidores.

Crie uma **classe genérica de Avaliação**, de modo que possamos ter, por exemplo: `Avaliacao<Servico>`, `Avaliacao<Produto>` e `Avaliacao<Assinatura>`. Essa classe deve ter:

- O item genérico de avaliação
- A nota
- Um comentário sobre a nota

Após criar a classe genérica, implemente também um **método estático** para calcular as médias das notas recebidas, independente do tipo de item avaliado.