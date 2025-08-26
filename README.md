# Análise do Código

1) O código termina antes de todas as threads terminarem de executar, logo a saída acaba sendo zero
2) O número de threads e o numero de submits não batem, pois o loop executa 2 vezes mais que o número de threads reservadas
o ideal seria criar uma constante referênciando o mesmo valor
3) Cada thread le o arquivo em sua integridade e adiciona à mesma lista o valor de suas linhas, talvez esse não seja o objetivo do código
4) Uma solução seria dividir o arquivo em pedaços e distribuir sua leitura entre as threads, mas acredito que fuja do escopo do teste
5) O código antes de imprimir a saída precisa esperar por todas as threads finalizarem

# Solução ajustada

1) Criei uma solução com ajustes de alguns pontos citados acima
2) Apesar da sugestão de distribuir a leitura do arquivo pelas threads, a implementação não fora realizada, assim o comportamento reflete à intenção do código original, porém aguardando à finalização das threads
3) A solução foi implementada usando um código padrão Spring Boot e uma classe CommandLineRunner para executar o exeplo de código com facilidade
4) Para a execução basta importar o código para alguma IDE IntelliJ ou VS Code, compilar e rodar o jar gerado
