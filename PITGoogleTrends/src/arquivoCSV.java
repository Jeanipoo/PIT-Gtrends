import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.Scanner;

public class arquivoCSV {
		public ArrayList<valores> ListaPorMinuto = new ArrayList<valores>();
		valores PorMinuto = new valores();
		public ArrayList<valores> ListaRegiao = new ArrayList<valores>();
		valores Regi�o = new valores();
		public ArrayList<valores> ListaCidade = new ArrayList<valores>();
		valores Cidade = new valores();
		public ArrayList<valores> ListaRelacionadas = new ArrayList<valores>();
		valores Relacionadas = new valores();
		public ArrayList<valores> ListaAscensao = new ArrayList<valores>();
		valores Ascens�o = new valores();
		public String termo = "termo";

		private static final CopyOption REPLACE_EXISTING = null;
		
		public void download(String termo_procurado){
			String URL1 = "start chrome https://www.google.com/trends/trendsReport?date=now%201-H^&q=";
			String URL2 = "^&export=1";
			String URL = URL1 + termo_procurado + URL2;
			System.out.println("Realizando Download");
			try {
				Runtime.getRuntime().exec(new String[]{"cmd", "/c", URL});
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Path from = Paths.get("C:\\Users\\Jean\\Downloads\\report.csv");
			Path to = Paths.get("C:\\Users\\Jean\\Desktop\\PIT_GoogleTrends\\Download.csv");
			try {
				Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void ler(){
			ListaCidade.add(Cidade);
			ListaAscensao.add(Ascens�o);
			ListaRelacionadas.add(Relacionadas);
			String[] Palavras = {""};
			String[] Hora = {""};
			int ConverteHora = 0;
			int cont11 = 1;
			int cont13 = 1;
			
			try
			{
				FileReader arquivo = new FileReader("C:\\Users\\Jean\\Desktop\\PIT_GoogleTrends\\Download.csv");
				BufferedReader leitor = new BufferedReader(arquivo);
				String linha = leitor.readLine();
				while(linha != null)
				{			
					System.out.println("Linha 1.1: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 1.2: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 1.3: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 1.4: " + linha);
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					Palavras = linha.split(",");
					System.out.println("Linha 2.1: " + Palavras[0] + " | " + Palavras[1]);
					termo = Palavras[1];
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					int cont3 = 1;
					while (Palavras.length > 1){
						Palavras = linha.split(",");
						if (Palavras.length>1){
							
							Palavras[0] = Palavras[0].substring(11, 16);
							Hora = Palavras[0].split(":");
							ConverteHora = Integer.parseInt(Hora[0]);
							if (ConverteHora>1){
								ConverteHora = ConverteHora-2;
							} else {
								ConverteHora = ConverteHora+22;
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
					System.out.println("Linha 4.1: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 4.2: " + linha);
					linha = leitor.readLine();
					System.out.println("Linha 4.3: " + linha);
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					Palavras = linha.split(",");
					System.out.println("Linha 5.1: " + Palavras[0] + " | " + Palavras[1]);
					linha = leitor.readLine();
					
					System.out.println("---------------------------");
					int cont6 = 1;
					while (Palavras.length > 1){
						Palavras = linha.split(",");
						if (Palavras.length>1){
							//Palavras[0] = convertePais(Palavras[0]);
							System.out.println("Linha 6." + cont6 + ": " + Palavras[0] + " | " + Palavras[1]);
							
							Regi�o = null;
							Regi�o = new valores();
							Regi�o.atributo = Palavras[0];
							if (!Palavras[1].equals(" ")){
								Regi�o.valor = Integer.parseInt(Palavras[1]);
							}
							ListaRegiao.add(Regi�o);
							
							linha = leitor.readLine();
							cont6++;
						}
					}
					
					if(linha != null){
					
						System.out.println("---------------------------");
						System.out.println("Linha 7.1: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 7.2: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 7.3: " + linha);
						linha = leitor.readLine();
						
						if(linha != null){
						
							System.out.println("---------------------------");
							Palavras = linha.split(",");
							System.out.println("Linha 8.1: " + Palavras[0] + " | " + Palavras[1]);
							linha = leitor.readLine();
							
							System.out.println("---------------------------");
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
						System.out.println("Linha 10.1: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 10.2: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 10.3: " + linha);
						linha = leitor.readLine();
						System.out.println("Linha 10.4: " + linha);
						linha = leitor.readLine();
						
						System.out.println("---------------------------");
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
						Palavras = linha.split(",");
					}
					
					while (Palavras.length > 1){
						if(linha != null){
							Palavras = linha.split(",");
							if (Palavras.length>1){
								System.out.println("Linha 13." + cont13 + ": " + Palavras[0] + " | " + Palavras[1]);
								
								Ascens�o = null;
								Ascens�o = new valores();
								Ascens�o.atributo = Palavras[0];
								if (!Palavras[1].equals(null)){
									Palavras[1] = Palavras[1].replace("+", "");
									Palavras[1] = Palavras[1].replace(".", "");
									Palavras[1] = Palavras[1].replace("%", "");
									Ascens�o.valor = Integer.parseInt(Palavras[1]);
									Ascens�o.valor = (Ascens�o.valor)/100;
								}
								ListaAscensao.add(Ascens�o);
								
								linha = leitor.readLine();
								cont13++;
							}
						}
					}
					if(linha != null){
						
						System.out.println("---------------------------");
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
		
		public String convertePais(String portugues){
			String ingles = "bean";
			switch (portugues){
				case "�?ustria":
					ingles = "Austria";
					break;
				case "�?frica do Sul":
					ingles = "South Africa";
					break;
				case "Albânia":
					ingles = "Albania";
					break;
				case "Arábia Saudita":
					ingles = "Saudi Arabia";
					break;
				case "Alemanha":
					ingles = "Germany";
					break;
				case "Argélia":
					ingles = "Algeria";
					break;	
				case "Argentina":
					ingles = "Argentina";
					break;
				case "Austrália":
					ingles = "Australia";
					break;
				case "Azerbaijão":
					ingles = "Azerbaijan";
					break;
				case "Bélgica":
					ingles = "Belgium";
					break;
				case "Bolívia":
					ingles = "Bolivia";
					break;
				case "Bósnia e Herzegovina":
					ingles = "Bosnia and Herzegovina";
					break;
				case "Brasil":
					ingles = "Brazil";
					break;
				case "Bulgária":
					ingles = "Bulgaria";
					break;
				case "Canadá":
					ingles = "Canada";
					break;
				case "Cingapura":
					ingles = "Singapore";
					break;
				case "Chile":
					ingles = "Chile";
					break;
				case "Colômbia":
					ingles = "Colombia";
					break;
				case "Costa do Marfim":
					ingles = "Ivory Coast";
					break;
				case "Costa Rica":
					ingles = "Costa Rica";
					break;
				case "Croácia":
					ingles = "Croatia";
					break;
				case "Dinamarca":
					ingles = "Denmark";
					break;
				case "Egito":
					ingles = "Egypt";
					break;
				case "El Salvador":
					ingles = "El Salvador";
					break;
				case "Emirados �?rabes Unidos":
					ingles = "United Arab Emirates";
					break;
				case "Equador":
					ingles = "Ecuador";
					break;
				case "Espanha":
					ingles = "Spain";
					break;
				case "Filipinas":
					ingles = "Philippines";
					break;
				case "Finlândia":
					ingles = "Finland";
					break;
				case "França":
					ingles = "France";
					break;
				case "Eslováquia":
					ingles = "Slovakia";
					break;
				case "Estados Unidos":
					ingles = "United States";
					break;
				case "Grécia":
					ingles = "Greece";
					break;
				case "Guatemala":
					ingles = "Guatemala";
					break;
				case "Holanda":
					ingles = "Netherlands";
					break;
				case "Honduras":
					ingles = "Honduras";
					break;
				case "Hungria":
					ingles = "Hungary";
					break;
				case "�?ndia":
					ingles = "India";
					break;
				case "Indonésia":
					ingles = "Indonesia";
					break;
				case "Itália":
					ingles = "Italy";
					break;
				case "Irlanda":
					ingles = "Ireland";
					break;
				case "Irã":
					ingles = "Iran";
					break;
				case "Iraque":
					ingles = "Iraq";
					break;
				case "Israel":
					ingles = "Israel";
					break;
				case "Japão":
					ingles = "Japan";
					break;
				case "Jordânia":
					ingles = "Jordan";
					break;
				case "Líbano":
					ingles = "Lebanon";
					break;
				case "Lituânia":
					ingles = "Lithuania";
					break;
				case "México":
					ingles = "Mexico";
					break;
				case "Malásia":
					ingles = "Malaysia";
					break;
				case "Marrocos":
					ingles = "Morocco";
					break;
				case "Nigéria":
					ingles = "Nigeria";
					break;
				case "Noruega":
					ingles = "Norway";
					break;
				case "Nova Zelândia":
					ingles = "New Zealand";
					break;
				case "Panamá":
					ingles = "Panama";
					break;
				case "Paquistão":
					ingles = "Pakistan";
					break;
				case "Peru":
					ingles = "Peru";
					break;
				case "Polônia":
					ingles = "Poland";
					break;
				case "Porto Rico":
					ingles = "Puerto Rico";
					break;
				case "Portugal":
					ingles = "Portugal";
					break;
				case "Reino Unido":
					ingles = "UK";
					break;
				case "República Dominicana":
					ingles = "Dominican Republic";
					break;
				case "República Tcheca":
					ingles = "Czech Republic";
					break;
				case "Romênia":
					ingles = "Romania";
					break;
				case "Rússia":
					ingles = "Russia";
					break;
				case "Sérvia":
					ingles = "Serbia";
					break;
				case "Suécia":
					ingles = "Sweden";
					break;
				case "Suíça":
					ingles = "Switzerland";
					break;
				case "Tailândia":
					ingles = "Thailand";
					break;
				case "Tunísia":
					ingles = "Tunisia";
					break;
				case "Turquia":
					ingles = "Turkey";
					break;
				case "Uruguai":
					ingles = "Uruguay";
					break;
				case "Ucrânia":
					ingles = "Ucrania";
					break;
				case "Venezuela":
					ingles = "Venezuela";
					break;
				case "Vietnã":
					ingles = "Vietnam";
					break;
				default:
					System.out.println("Pa�s n�o convertido: " + portugues);
			}
			return ingles;
		}
}
