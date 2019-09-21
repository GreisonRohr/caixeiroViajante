import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class principal {

	public static void main(String[] args) throws IOException {

		//variaveis utilizadas no arquivo eil101.txt
		//variaveis utilizadas no arquivo brazil58.txt
		//variaveis utilizadas no arquivo gil262.txt
		
		criaTabela matriz = null;

		int contExecução = 1;
		int contRota = 1, menorCaminho = 50000, posiçaoMenorCaminho = 0;
		int menor = 0, salvaRota = 0, rota = 1;

		int matrizDistanciasOrdenadas[][] = new int[59][59];
		int matrizRotaOrdenadas[][] = new int[59][59];

		ArrayList melhorRota = new ArrayList();
		ArrayList valorDistancias = new ArrayList();
		int somaCaminho[] = new int[59];
		int matrizDistanciasOrdenadas2[][] = new int[102][102];
		int matrizRotaOrdenadas2[][] = new int[102][102];
		int somaCaminho2[] = new int[102];
		
		int matrizDistanciasOrdenadas3[][] = new int[263][263];
		int matrizRotaOrdenadas3[][] = new int[263][263];
		int somaCaminho3[] = new int[263];


		int contSomaDistancias=0;

		Scanner ler = new Scanner(System.in);
		
		System.out.printf("ARQUIVOS DISPONIVEIS:\n");
		System.out.printf("\n");
		System.out.printf("brazil58.txt\n");
		System.out.printf("\n");

		System.out.printf("eil101.txt\n");
		System.out.printf("\n");

		System.out.printf("gil262.txt\n");
		System.out.printf("\n");



		System.out.printf("Informe o nome do arquivo texto:\n");// pede pro usuario digitar o arquivo desejado
		String nome = ler.nextLine();

		switch (nome) {//para escolher o arquivo digitado
		case "brazil58.txt":
			while (contExecução != 59) {

				matriz = new criaTabela();// cria matriz

				matriz.criarTabela(nome);

				menor = 9000;
				melhorRota.add(contExecução);

				while (contRota != 59) {//espande todas as rotas possiveis para a primeira cidade testando qual é a mais proxima
					for (int j = 1; j < 59; j++) {
						if (matriz.matrizDistancias[rota][j] != "0") {

							if (Integer.parseInt(matriz.matrizDistancias[rota][j]) < menor) {

								menor = Integer.parseInt(matriz.matrizDistancias[rota][j]);
								salvaRota = j;

							}

						}

					}

					for (int i = 1; i < 59; i++) {
						matriz.matrizDistancias[i][rota] = "0";
					}

					rota = salvaRota;
					melhorRota.add(salvaRota);
					matrizRotaOrdenadas[contExecução][contRota] = salvaRota;

					valorDistancias.add(menor);
					matrizDistanciasOrdenadas[contExecução][contRota] = menor;
					contRota++;
					menor = 9000;

				}

				contExecução++;
				// Reiniciar tudo
				contRota = 1;

				menor = 0;
				salvaRota = 0;
				rota = contExecução;

			} // fecha while ate 59

			// soma melhor rota

			for (int i = 1; i < 59; i++) {// soma todas rotas 
				for (int j = 1; j < 58; j++) {
					somaCaminho[i] = somaCaminho[i] + matrizDistanciasOrdenadas[i][j];

				}
			}

			for (int i = 1; i < somaCaminho.length; i++) {// salva menor rota
				if (somaCaminho[i] < menorCaminho) {
					menorCaminho = somaCaminho[i];
					posiçaoMenorCaminho = i;

				}
			}

			//a parte comentada a baixo pode ser utilizada para visualizar o conteudo do 
			//arquivo brazil58.txt e algumas matrizes utilizadas para o desenvolvimento
			
			/*System.out.println("\n\n");

			System.out.printf("\nConteúdo do arquivo texto:\n");

			for (int i = 0; i < 59; i++) {// mostra a matriz na tela
				for (int j = 0; j < 59; j++) {
					System.out.print(" " + matriz.matrizDistancias[i][j]);
				}
				System.out.println(" "); // muda de linha

			}
			System.out.println("\n\n");
			System.out.println("Distancias");
			System.out.println("\n\n");

			for (int i = 0; i < matriz.listXY.size(); i++) {// mostra distancias e suas cordenadas

				System.out.println(matriz.listXY.get(i) + ":" + matriz.distanciasOrdenadas.get(i));

			}

			System.out.println("\n\n");
			System.out.println("Rotas:");

			for (int i = 0; i < melhorRota.size() - 1; i++) {// mostra melhor rota

				System.out.print(melhorRota.get(i) + "-");

			}
			System.out.println("\n\n");

			System.out.println("caminho:");

			for (int i = 0; i < valorDistancias.size() - 1; i++) {// mostra melhor rota

				System.out.print(valorDistancias.get(i) + "-");

			}
			System.out.println("\n\n");

			System.out.printf("Total de distancias no arquivo: %s\n", matriz.listDistancias.size());

			System.out.printf("\nTodas as rotas:\n");

			for (int i = 0; i < 59; i++) {// mostra a matriz na tela
				for (int j = 0; j < 58; j++) {
					System.out.print(" " + matrizDistanciasOrdenadas[i][j]);
				}
				System.out.println(" "); // muda de linha

			}
			System.out.println("\n\n");

			System.out.printf("\nSoma das rotas:\n");

			for (int i = 1; i < somaCaminho.length; i++) {
				System.out.println(somaCaminho[i]);

			}*/
			System.out.println("\n\n");

			System.out.println("Custo do Melhor Caminho Encontrado:" + menorCaminho);
			System.out.println("\n");

			System.out.println("Melhor Caminho (Distancias):");

			for (int i = 1; i < 58; i++) {
				System.out.print(matrizDistanciasOrdenadas[posiçaoMenorCaminho][i] + "-");
			}

			System.out.println("\n");

			System.out.println("Melhor Caminho (Rota):");
			System.out.print(posiçaoMenorCaminho + "-");
			for (int i = 1; i < 58; i++) {
				System.out.print(matrizRotaOrdenadas[posiçaoMenorCaminho][i] + "-");
			}

			System.out.println("\n");

			/*pode ser utizado para visualizar algumas rotas possiveis
			 * 
			 * for (int i = 0; i < 59; i++) {// mostra a matriz na tela com possiveis caminhos
				for (int j = 0; j < 58; j++) {
					System.out.print(" " + matrizRotaOrdenadas[i][j]);
				}
				System.out.println(" "); // muda de linha

			}*/
			break;

		case "eil101.txt":
			
			while (contExecução != 102) {
				
				matriz = new criaTabela();// cria tabela

				matriz.criarTabela2(nome);
				
				
				menor = 9000;
				melhorRota.add(contExecução);

				while (contRota != 102) {//espande todas as rotas possiveis para cada cidade testando qual é a mais proxima
					for (int j = 1; j < 102; j++) {
						if (matriz.matrizSomaRota[rota][j] != 0) {

							if (matriz.matrizSomaRota[rota][j] < menor) {

								menor = matriz.matrizSomaRota[rota][j];
								salvaRota = j;

							}

						}

					}

					for (int i = 1; i < 102; i++) {
						matriz.matrizSomaRota[i][rota] = 0;
					}

					rota = salvaRota;
					melhorRota.add(salvaRota);
					matrizRotaOrdenadas2[contExecução][contRota] = salvaRota;

					valorDistancias.add(menor);
					matrizDistanciasOrdenadas2[contExecução][contRota] = menor;
					contRota++;
					menor = 9000;

				}

				contExecução++;
				// Reiniciar tudo
				contRota = 1;

				menor = 0;
				salvaRota = 0;
				rota = contExecução;
				
			}

				
			// soma melhor rota

						for (int i = 1; i < 102; i++) {// soma todas rotas
							for (int j = 1; j < 101; j++) {
								somaCaminho2[i] = somaCaminho2[i] + matrizDistanciasOrdenadas2[i][j];

							}
						}

						for (int i = 1; i < somaCaminho2.length; i++) {// salva menor rota
							if (somaCaminho2[i] < menorCaminho) {
								menorCaminho = somaCaminho2[i];
								posiçaoMenorCaminho = i;

							}
						}
				

						
			/*
			 * a parte comentada a baixo pode ser utilizada para visualizar o conteudo do
			 * arquivo brazil58.txt e algumas matrizes utilizadas para o desenvolvimento
			 * 
			 * System.out.println("\n\n");
			 

			System.out.printf("\nConteúdo do arquivo texto:\n");

			for (int i = 0; i < 101; i++) {// mostra a matriz na tela
				for (int j = 0; j < 3; j++) {
					System.out.print(" " + matriz.matrizDistancias2[i][j]);
				}
				System.out.println(" "); // muda de linha

			}
			System.out.println("\n\n");
			
			System.out.println("\n\n");

			System.out.printf("\n Matriz Soma Rota:\n");

			for (int i = 0; i < 101; i++) {// mostra a matriz na tela
				for (int j = 0; j < 101; j++) {
					System.out.print(" " + matriz.matrizSomaRota[i][j]);
				}
				System.out.println(" "); // muda de linha

			}
			System.out.println("\n\n");*/
			
			System.out.println("\n\n");

			System.out.println("Custo do Melhor Caminho Encontrado:" + menorCaminho);
			System.out.println("\n");

			System.out.println("Melhor Caminho (Distancias):");

			for (int i = 1; i < 101; i++) {
				System.out.print(matrizDistanciasOrdenadas2[posiçaoMenorCaminho][i] + "-");
			}

			System.out.println("\n");

			System.out.println("Melhor Caminho (Rota):");
			System.out.print(posiçaoMenorCaminho + "-");
			for (int i = 1; i < 101; i++) {
				System.out.print(matrizRotaOrdenadas2[posiçaoMenorCaminho][i] + "-");
			}

			System.out.println("\n");
			
			/*
			 * pode ser utizado para visualizar algumas rotas possiveis

			for (int i = 0; i < 102; i++) {// mostra a matriz na tela
				for (int j = 0; j < 101; j++) {
					System.out.print(" " + matrizRotaOrdenadas2[i][j]);
				}
				System.out.println(" "); // muda de linha

			}*/
			

			break;
			
		case "gil262.txt":
while (contExecução != 263) {
				
				matriz = new criaTabela();// cria tabela

				matriz.criarTabela3(nome);
				
				
				menor = 9000;
				melhorRota.add(contExecução);

				while (contRota != 263) {//espande todas as rotas possiveis para cada cidade testando qual é a mais proxima
					for (int j = 1; j < 263; j++) {
						if (matriz.matrizSomaRota3[rota][j] != 0) {

							if (matriz.matrizSomaRota3[rota][j] < menor) {

								menor = matriz.matrizSomaRota3[rota][j];
								salvaRota = j;

							}

						}

					}

					for (int i = 1; i < 263; i++) {
						matriz.matrizSomaRota3[i][rota] = 0;
					}

					rota = salvaRota;
					melhorRota.add(salvaRota);
					matrizRotaOrdenadas3[contExecução][contRota] = salvaRota;

					valorDistancias.add(menor);
					matrizDistanciasOrdenadas3[contExecução][contRota] = menor;
					contRota++;
					menor = 9000;

				}

				contExecução++;
				// Reiniciar tudo
				contRota = 1;

				menor = 0;
				salvaRota = 0;
				rota = contExecução;
				
			}

				
			// soma melhor rota

						for (int i = 1; i < 263; i++) {// soma todas rotas
							for (int j = 1; j < 262; j++) {
								somaCaminho3[i] = somaCaminho3[i] + matrizDistanciasOrdenadas3[i][j];

							}
						}

						for (int i = 1; i < somaCaminho3.length; i++) {// salva menor rota
							if (somaCaminho3[i] < menorCaminho) {
								menorCaminho = somaCaminho3[i];
								posiçaoMenorCaminho = i;

							}
						}
				

						
			/*
			 * a parte comentada a baixo pode ser utilizada para visualizar o conteudo do
			 * arquivo brazil58.txt e algumas matrizes utilizadas para o desenvolvimento
			 * 
			 * System.out.println("\n\n");
			 

			System.out.printf("\nConteúdo do arquivo texto:\n");

			for (int i = 0; i < 101; i++) {// mostra a matriz na tela
				for (int j = 0; j < 3; j++) {
					System.out.print(" " + matriz.matrizDistancias2[i][j]);
				}
				System.out.println(" "); // muda de linha

			}
			System.out.println("\n\n");
			
			System.out.println("\n\n");

			System.out.printf("\n Matriz Soma Rota:\n");

			for (int i = 0; i < 101; i++) {// mostra a matriz na tela
				for (int j = 0; j < 101; j++) {
					System.out.print(" " + matriz.matrizSomaRota[i][j]);
				}
				System.out.println(" "); // muda de linha

			}
			System.out.println("\n\n");*/
			
			System.out.println("\n\n");

			System.out.println("Custo do Melhor Caminho Encontrado:" + menorCaminho);
			System.out.println("\n");

			System.out.println("Melhor Caminho (Distancias):");

			for (int i = 1; i < 262; i++) {
				System.out.print(matrizDistanciasOrdenadas3[posiçaoMenorCaminho][i] + "-");
			}

			System.out.println("\n");

			System.out.println("Melhor Caminho (Rota):");
			System.out.print(posiçaoMenorCaminho + "-");
			for (int i = 1; i < 262; i++) {
				System.out.print(matrizRotaOrdenadas3[posiçaoMenorCaminho][i] + "-");
			}

			System.out.println("\n");
			
			/*
			 * pode ser utizado para visualizar algumas rotas possiveis

			for (int i = 0; i < 102; i++) {// mostra a matriz na tela
				for (int j = 0; j < 101; j++) {
					System.out.print(" " + matrizRotaOrdenadas2[i][j]);
				}
				System.out.println(" "); // muda de linha

			}*/
			

			
			
			break;

		}

	}
}
