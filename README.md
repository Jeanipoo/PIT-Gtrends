# PIT-Gtrends

Para funcionar em computadores diferentes:

- Logar com uma conta Gmail no Chrome
- Alterar o idioma preferencial desta conta Gmail para Inglês
- Alterar o caminho do acesso ao arquivo CSV baixado, na classe arquivoCSV, para a pasta de download padrão
- Alterar o caminho do acesso ao arquivo CSV já renomeado, na controler ControllerDoArquivoCSV, para a pasta onde quiser armazenar

Problemas a resolver:
 - Fazer os gráficos ( no javascript ) carregarem ao primeiro clique
 - Resolver o problema na lógica da leitura, para quando tem pouco volume de pesquisa ou muito.
 - Resolver o problema na lógica da leitura, para quando há MUITO aumento no trends ( + de 1000% )
 - Montar Divs correto para não estourar layout
 - Gravar histórico dos downloads
 - Cruzar dados de pesquisas diferentes ( ex: Positivo e PUC ) e comparar na mesma tela
      - Problema: A quantidade de dados mostrados individualmente não é um número absoluto, e sim uma porcentagem...  não vai dar para comparar num mesmo gráfico as quantidades.
 - Pensar em como gravar em banco de dados
 - Pesquisa bibliográfica
 - Cartaz de apresentação
 
 Resolvido!
 - Download de mais de uma palavra
 - RESOLVIDO - Ler arquivo CSV e converter para Base64, e inglês, para poder montar os gráficos de Geo do google charts
