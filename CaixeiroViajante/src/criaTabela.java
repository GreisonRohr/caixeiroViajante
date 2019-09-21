import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class criaTabela {
	
	//variaveis utilizadas no arquivo eil101.txt
	//variaveis utilizadas no arquivo brazil58.txt
	//variaveis utilizadas no arquivo gil262.txt

	
	int coluna = 0;
	int linhaMatriz = 1,linhaMatriz2=1;
	int salvaUltima = 0;

	int encerra = 0;
	
	ArrayList<String> listDistancias = new ArrayList<String>();
	String matrizDistancias[][] = new String[59][59];
	String matrizDistancias2[][] = new String[102][3];
	String matrizDistancias3[][] = new String[263][3];


	ArrayList listXY = new ArrayList();
	ArrayList<String> distanciasOrdenadas = new ArrayList<String>();
	
	int matrizSomaRota[][] = new int[102][102];
	int matrizSomaRota3[][] = new int[263][263];

	int somaRotaX=0,somaRotaY=0,contSomaDistancias=1;
	double somaRotaXY=0;

	
	
	public void criarTabela(String nome) throws IOException{ //metodo para o arquivo brazil58.txt
	
		//abre o arquivo e pega linha por linha
		FileReader arq = new FileReader(nome);
		BufferedReader lerArq = new BufferedReader(arq);

		String linha = lerArq.readLine(); // lê a primeira linha

		while (encerra != 1) {//while para ler todas as 58 linhas e salvar os dados em uma matriz
			String[] distancias = linha.split(" ");

			for (String valor : distancias) {// adiciona as distancias no arraylist
				if (valor.trim().length() > 1 && !"".equals(valor.trim())) {
					listDistancias.add(valor);
				}
			}
			coluna = 58 - distancias.length;

			for (int i = coluna; i < distancias.length + coluna; i++) {// adiciona valores na matriz
				matrizDistancias[linhaMatriz][i + 1] = listDistancias.get(salvaUltima++);

			}

			salvaUltima = listDistancias.size();//salva ultima distancia

			linhaMatriz++;

			linha = lerArq.readLine(); // lê da segunda até a última linha
			if (linha.equals("EOF")) {
				encerra = 1;
			}
		}

		arq.close();//fecha arquivo
		
		for (int i = 0; i < 59; i++) {// preenche a outra metade da matriz com as distancias corespondentes
			for (int j = 0; j < 59; j++) {
				if (matrizDistancias[i][j] == null) {
					if (i == j) {
						matrizDistancias[i][j] = "0";
					} else {
						matrizDistancias[i][j] = matrizDistancias[j][i];
					}
				} else {
					listXY.add(i + "até" + j);
					distanciasOrdenadas.add(matrizDistancias[i][j]);

				}
			}
		}
		
	}
	
	
	public void criarTabela2(String nome) throws IOException{//metodo para o arquivo eil101.txt
		
		//abre o arquivo para leitura linha por linha
		FileReader arq = new FileReader(nome);
		BufferedReader lerArq = new BufferedReader(arq);

		String linha = lerArq.readLine(); // lê a primeira linha


		while (encerra != 1) {//adiciona os valores de cada distancia em uma matriz
			String[] distancias = linha.split(" ");

			for (String valor : distancias) {
			
				if ( !"".equals(valor.trim())) {
					listDistancias.add(valor);
				}
			}

			for (int i = coluna; i < distancias.length; i++) {// adiciona valores na matriz
				matrizDistancias2[linhaMatriz2][i] = listDistancias.get(salvaUltima);
				salvaUltima++;
			}

			salvaUltima = listDistancias.size();
			linhaMatriz2++;

			linha = lerArq.readLine(); // lê da segunda até a última linha
			if (linha.equals("EOF")) {
				encerra = 1;
			}
		}
		
		while(contSomaDistancias!=102) {//faz a soma de todas as rotas de uma cidade a outra e armazena em uma matriz
			for(int i=1;i<102;i++) {
				
				/*
				xd = x[i] - x[j];
				yd = y[i] - y[j];
				dij = nint( sqrt( xd*xd + yd*yd) );
				*/
				
					
					somaRotaX= Integer.parseInt(matrizDistancias2[contSomaDistancias][1])-Integer.parseInt(matrizDistancias2[i][1]);
					somaRotaY= Integer.parseInt(matrizDistancias2[contSomaDistancias][2])-Integer.parseInt(matrizDistancias2[i][2]);	
					

				
				somaRotaX=somaRotaX*somaRotaX;
				somaRotaY=somaRotaY*somaRotaY;
				somaRotaXY=somaRotaX+somaRotaY;
				
				somaRotaXY= Math.sqrt(somaRotaXY);
				
				matrizSomaRota[contSomaDistancias][i]= (int) somaRotaXY;
				
			}
			
			contSomaDistancias++;
		}
		
		
	}
	
public void criarTabela3(String nome) throws IOException{//metodo para o arquivo gil262.txt
		
		//abre o arquivo para leitura linha por linha
		FileReader arq = new FileReader(nome);
		BufferedReader lerArq = new BufferedReader(arq);

		String linha = lerArq.readLine(); // lê a primeira linha


		while (encerra != 1) {//adiciona os valores de cada distancia em uma matriz
			String[] distancias = linha.split(" ");

			for (String valor : distancias) {
			
				if ( !"".equals(valor.trim())) {
					listDistancias.add(valor);
				}
			}

			for (int i = coluna; i < distancias.length; i++) {// adiciona valores na matriz
				matrizDistancias3[linhaMatriz2][i] = listDistancias.get(salvaUltima);
				salvaUltima++;
			}

			salvaUltima = listDistancias.size();
			linhaMatriz2++;

			linha = lerArq.readLine(); // lê da segunda até a última linha
			if (linha.equals("EOF")) {
				encerra = 1;
			}
		}
		
		while(contSomaDistancias!=263) {//faz a soma de todas as rotas de uma cidade a outra e armazena em uma matriz
			for(int i=1;i<263;i++) {
				
				/*
				xd = x[i] - x[j];
				yd = y[i] - y[j];
				dij = nint( sqrt( xd*xd + yd*yd) );
				*/
				
					
					somaRotaX= Integer.parseInt(matrizDistancias3[contSomaDistancias][1])-Integer.parseInt(matrizDistancias3[i][1]);
					somaRotaY= Integer.parseInt(matrizDistancias3[contSomaDistancias][2])-Integer.parseInt(matrizDistancias3[i][2]);	
					

				
				somaRotaX=somaRotaX*somaRotaX;
				somaRotaY=somaRotaY*somaRotaY;
				somaRotaXY=somaRotaX+somaRotaY;
				
				somaRotaXY= Math.sqrt(somaRotaXY);
				
				matrizSomaRota3[contSomaDistancias][i]= (int) somaRotaXY;
				
			}
			
			contSomaDistancias++;
		}
		
		
	}
	
	
	
}
