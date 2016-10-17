
public class teste {

	public static void main(String[] args) {
		arquivoCSV file = new arquivoCSV();
		file.ler();
		
		// COLOQUE UM BREAKPOINT NESTA LINHA PARA CONFERIR SE GRAVOU TODOS OS DADOS DO CSV NO OBJETO "file"
		System.out.println("===================================");
		System.out.println("Imprimindo arrays para conferência:");
		System.out.println("-----------------------------------");
		if (file.ListaPorMinuto.size()>0){
			System.out.println("Horário | Valor");
			System.out.println("---------------");
			for (int i = 0; i<file.ListaPorMinuto.size(); i++){
				System.out.println(file.ListaPorMinuto.get(i).atributo + " | " + file.ListaPorMinuto.get(i).valor);
			}
			System.out.println("==============");
		}
		if (file.ListaRegião.size()>0){
			System.out.println("Região | Valor");
			System.out.println("--------------");
			for (int i = 0; i<file.ListaRegião.size(); i++){
				System.out.println(file.ListaRegião.get(i).atributo + " | " + file.ListaRegião.get(i).valor);
			}
			System.out.println("==============");
		}
		if (file.ListaCidade.size()>0){
			System.out.println("Cidade | Valor");
			System.out.println("--------------");
			for (int i = 0; i<file.ListaCidade.size(); i++){
				System.out.println(file.ListaCidade.get(i).atributo + " | " + file.ListaCidade.get(i).valor);
			}
			System.out.println("==============================");
		}
		if (file.ListaRelacionadas.size()>0){
			System.out.println("Pesquisas Relacionadas | Valor");
			System.out.println("------------------------------");
			for (int i = 0; i<file.ListaRelacionadas.size(); i++){
				System.out.println(file.ListaRelacionadas.get(i).atributo + " | " + file.ListaRelacionadas.get(i).valor);
			}
			System.out.println("=============================");
		}
		if (file.ListaAscensão.size()>0){
			System.out.println("Pesquisas em Ascensão | Valor");
			System.out.println("-----------------------------");
			for (int i = 0; i<file.ListaAscensão.size(); i++){
				System.out.println(file.ListaAscensão.get(i).atributo + " | " + file.ListaAscensão.get(i).valor);
			}
			System.out.println("===================");
		}
		System.out.println("FIM!");
	}
}
