import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class arquivoCSV {
		public ArrayList<valores> ListaPorMinuto = new ArrayList<valores>();
		valores PorMinuto = new valores();
		public ArrayList<valores> ListaRegião = new ArrayList<valores>();
		valores Região = new valores();
		public ArrayList<valores> ListaCidade = new ArrayList<valores>();
		valores Cidade = new valores();
		public ArrayList<valores> ListaRelacionadas = new ArrayList<valores>();
		valores Relacionadas = new valores();
		public ArrayList<valores> ListaAscensão = new ArrayList<valores>();
		valores Ascensão = new valores();
		public String Pesquisa;
		
		public void ler(){
			String[] Palavras = {"SHOW"};
			String[] Hora = {"EIN"};
			int ConverteHora = 0;
			int cont11 = 1;
			int cont13 = 1;
			
			/*
			 * Ordem de leitura CSV: 4(+1) - 3(+1) - 3(+1) - 4 - 4 - ..3
			 * =================
			 * 1) 4 linhas inteiras:
			 * 		Pesquisa na web do Google interesse: <PALAVRA>
			 * 		Todo o mundo na última hora
			 * 
			 * 		Interesse ao longo do tempo
			 * -----------------
			 * 2) Primeira linha com split:
			 * 		Tempo
			 * 			<PALAVRA>
			 * -----------------
			 * 3) X linhas com split:
			 * 		2016-10-09-23:03 UTC
			 * 			88
			 * =================
			 * 4) 3 linhas inteiras:
			 * 
			 * 
			 * 		Principais regiões para <PALAVRA>
			 * -----------------
			 * 5) Primeira linha com split:
			 * 		Região
			 * 			<PALAVRA>
			 * -----------------
			 * 6) X linhas com split:
			 * 		Estados Unidos
			 * 			100
			 * =================
			 * 7) 3 linhas inteiras:
			 * 
			 * 
			 * 		Principais cidades para <PALAVRA>
			 * -----------------
			 * 8) Primeira linha com split:
			 * 		Cidade
			 * 			<PALAVRA>
			 * -----------------
			 * 9) X linhas com split:
			 * 		Fall River (Estados Unidos)
			 * 			100
			 * =================
			 * 10) 4 linhas inteiras:
			 * 
			 * 
			 * 
			 * 		Principais pesquisas para <PALAVRA>
			 * -----------------
			 * 11) X linhas com split:
			 * 		cheesecake factory
			 * 			100
			 * =================
			 * 12) 4 linhas inteiras:
			 * 
			 * 
			 * 
			 * 		Pesquisas em ascensão para <PALAVRA>
			 * -----------------
			 * 13) X linhas com split:
			 * 		cheesecake factory coupons
			 * 			+130%
			 * =================
			 * 14) 3 linhas inteiras vazias
			 */
			
			try
			{
				FileReader arquivo = new FileReader("C:\\Users\\Jean\\Desktop\\PIT_GoogleTrends\\GoogleTrends0001.csv");
				BufferedReader leitor = new BufferedReader(arquivo);
				String linha = leitor.readLine();
				while(linha != null)
				{			
					// 1) 4 linhas
					System.out.println("Linha 1.1: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 1.2: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 1.3: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 1.4: " + linha);
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					// 2) 1 linha
					Palavras = linha.split(",");
					System.out.println("Linha 2.1: " + Palavras[0] + " | " + Palavras[1]);
					Pesquisa = Palavras[1];
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					// 3) X linhas
					int cont3 = 1;
					while (Palavras.length > 1){
						Palavras = linha.split(",");
						if (Palavras.length>1){
							
							Palavras[0] = Palavras[0].substring(11, 16);
							Hora = Palavras[0].split(":");
							ConverteHora = Integer.parseInt(Hora[0]);
							if (ConverteHora>0){
								ConverteHora = ConverteHora-1;
							} else {
								ConverteHora = 23;
							}
							Hora[0] = String.format("%02d", ConverteHora);
							Palavras[0] = Hora[0]+":"+Hora[1];
							
							System.out.println("Linha 3." + cont3 + ": " + Palavras[0] + " | " + Palavras[1]);
							
							PorMinuto = null;
							PorMinuto = new valores();
							PorMinuto.atributo = Palavras[0];
							if (!Palavras[1].equals(" ")){
								PorMinuto.valor = Integer.parseInt(Palavras[1]);
							}
							ListaPorMinuto.add(PorMinuto);
							
							linha = leitor.readLine();
							cont3++;
						}
					}
					
					System.out.println("---------------------------");
					// 4) 3 linhas
					System.out.println("Linha 4.1: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 4.2: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 4.3: " + linha);
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					// 5) 1 linha
					Palavras = linha.split(",");
					System.out.println("Linha 5.1: " + Palavras[0] + " | " + Palavras[1]);
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					// 6) X linhas
					int cont6 = 1;
					while (Palavras.length > 1){
						Palavras = linha.split(",");
						if (Palavras.length>1){
							System.out.println("Linha 6." + cont6 + ": " + Palavras[0] + " | " + Palavras[1]);
							
							Região = null;
							Região = new valores();
							Região.atributo = Palavras[0];
							if (!Palavras[1].equals(" ")){
								Região.valor = Integer.parseInt(Palavras[1]);
							}
							ListaRegião.add(Região);
							
							linha = leitor.readLine();
							cont6++;
						}
					}
					
					if(linha != null){
					
						System.out.println("---------------------------");
						// 7) 3 linhas
						System.out.println("Linha 7.1: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 7.2: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 7.3: " + linha);
						linha = leitor.readLine();
						
						if(linha != null){
						
							System.out.println("---------------------------");
							// 8) 1 linha
							Palavras = linha.split(",");
							System.out.println("Linha 8.1: " + Palavras[0] + " | " + Palavras[1]);
							linha = leitor.readLine();
							
							System.out.println("---------------------------");
							// 9) X linhas
							int cont9 = 1;
							while (Palavras.length > 1){
								Palavras = linha.split(",");
								if (Palavras.length>1){
									System.out.println("Linha 9." + cont9 + ": " + Palavras[0] + " | " + Palavras[1]);
									
									Cidade = null;
									Cidade = new valores();
									Cidade.atributo = Palavras[0];
									if (!Palavras[1].equals(" ")){
										Cidade.valor = Integer.parseInt(Palavras[1]);
									}
									ListaCidade.add(Cidade);
									
									linha = leitor.readLine();
									cont9++;
								}
							}
						}
					}
					
					if(linha != null){
					
						System.out.println("---------------------------");
						// 10) 4 linhas
						System.out.println("Linha 10.1: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 10.2: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 10.3: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 10.4: " + linha);
						linha = leitor.readLine();
						
						System.out.println("---------------------------");
						// 11) X linhas
						Palavras = linha.split(",");
					
					}
					
					while (Palavras.length > 1){
						Palavras = linha.split(",");
						if (Palavras.length>1){
							System.out.println("Linha 11." + cont11 + ": " + Palavras[0] + " | " + Palavras[1]);
							
							Relacionadas = null;
							Relacionadas = new valores();
							Relacionadas.atributo = Palavras[0];
							if (!Palavras[1].equals(" ")){
								Relacionadas.valor = Integer.parseInt(Palavras[1]);
							}
							ListaRelacionadas.add(Relacionadas);
							
							linha = leitor.readLine();
							cont11++;
						}
					}
						
					System.out.println("---------------------------");
					// 12) 4 linhas
					System.out.println("Linha 12.1: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 12.2: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 12.3: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 12.4: " + linha);
					linha = leitor.readLine();
						
					System.out.println("---------------------------");
						
					if(linha != null){
						
						// 13) X linhas
						Palavras = linha.split(",");
						
					}
					
					while (Palavras.length > 1){
						if(linha != null){
							Palavras = linha.split(",");
							if (Palavras.length>1){
								System.out.println("Linha 13." + cont13 + ": " + Palavras[0] + " | " + Palavras[1]);
								
								Ascensão = null;
								Ascensão = new valores();
								Ascensão.atributo = Palavras[0];
								if (!Palavras[1].equals(null)){
									Palavras[1] = Palavras[1].replace("+", "");
									Palavras[1] = Palavras[1].replace(".", "");
									Palavras[1] = Palavras[1].replace("%", "");
									Ascensão.valor = Integer.parseInt(Palavras[1]);
									Ascensão.valor = (Ascensão.valor)/100;
								}
								ListaAscensão.add(Ascensão);
								
								linha = leitor.readLine();
								cont13++;
							}
						}
					}
					if(linha != null){
						
						System.out.println("---------------------------");
						// 14) 3 linhas
						System.out.println("Linha 14.1: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 14.2: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 14.3: " + linha);
						linha = leitor.readLine();
						
					}
				}
				arquivo.close();
			}
			catch(IOException e)
			{
				System.err.printf("Erro ao abrir o arquivo: %s\n", e.getMessage());
			}
		}
}
