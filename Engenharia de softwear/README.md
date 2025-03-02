# AULA 01 - (14/02/2025)
Crie um repositório chamado "bertoti" -> pasta "engenhariadesoftware" -> arquivo "readme.md" e faça as seguintes atividades (já vou comentá-las):

 1. Comentar com suas palavras o primeiro trecho do livro Software Engineering at Google, Oreilly. (vou postar abaixo)
 2. Comentar com suas palavras o segundo trecho do livro Software Engineering at Google, Oreilly.(vou postar abaixo)
 3. Listar e explicar 3 exemplos de tradeoffs


Oque é engenharia de sortwear? (lousa do professor)
-Programação+Tempo+Escalabilidade+TradOff

TradOff: Entregar uma coisa por outra. 
Exemplo: -Ter a portabilidade do java para rodar em vários programas, porém, terá uma complexidade maior para SER DESENVOLVIDO. Uma troca equivalente!
        
        -Banco do Brazil (não usava um linguagem de programação escalonavel): Pouca complexidade, barata, porém pouca escalabilidade. Ou seja, transações podem sofrer erro mais facilmente.
        
       -Matematicos usando python para desenvolver sistemas para os ajudarem, porém, é muito lento, assim tendo que adiconar C++ para poder rodar mais facilmente. Dois trabalhos




#ATIVIDADE 01:
TRECHO 01: 
"O que exatamente queremos dizer com engenharia de software? O que distingue "engenharia de software" de "programação" ou "ciência da computação"? E por que o Google teria uma perspectiva única a adicionar ao corpo de literatura de engenharia de software escrita nos últimos 50 anos?

Os termos "programação" e "engenharia de software" têm sido usados de forma intercambiável por um bom tempo em nossa indústria, embora cada termo tenha ênfases e implicações diferentes. Os estudantes universitários tendem a estudar ciência da computação e conseguir empregos escrevendo código como "programadores".

"Engenharia de software", no entanto, soa mais sério, como se implicasse a aplicação de algum conhecimento teórico para construir algo real e preciso. Engenheiros mecânicos, civis, aeronáuticos e os de outras disciplinas de engenharia praticam engenharia. Todos trabalham no mundo real e usam a aplicação de seus conhecimentos teóricos para criar algo real. Engenheiros de software também criam "algo real", embora seja menos tangível do que as coisas que outros engenheiros criam.

Ao contrário dessas profissões de engenharia mais estabelecidas, a teoria ou prática atual da engenharia de software não é tão rigorosa. Engenheiros aeronáuticos devem seguir diretrizes e práticas rígidas, porque erros em seus cálculos podem causar danos reais; a programação, de forma geral, tradicionalmente não seguiu práticas tão rigorosas. Mas, à medida que o software se torna mais integrado em nossas vidas, devemos adotar e confiar em métodos de engenharia mais rigorosos. Esperamos que este livro ajude outros a ver um caminho em direção a práticas de software mais confiáveis."

RESOLUÇÃO DO PENSAMENTO:
-Ao decorrer do texto percebemos que o nome "Engenharia de softwear" parece ter sido criado e desenvolvido de forma rápida, tanto que muitos não entendem exatamente qual sua função real, já que como dito no texto, engenharias do "mundo real" são facilmente entendidas, mesmo por um leigo no assunto, pelo menos, é vista de forma concretar. Se pararmos para entender toda essa situção, alguns pontos podem ser observado: a rapida acenssão da tecnologia; a propagação do mundo virtual de modo tão rapido que não havia tempo de se pensar no que realmente é; e a naturalidade de "não precisamos saber",pois, somente é oque é. Muito dificilmente um usuario irá ver por dentro de um programa, mas, por dentro de um avião, ou prédio 



TRECHO 02: 
"Programação ao Longo do Tempo

Proponhamos que “engenharia de software” não se limite apenas ao ato de escrever código, mas inclua todas as ferramentas e processos que uma organização usa para construir e manter esse código ao longo do tempo. Quais práticas uma organização de software pode introduzir para manter seu código valioso a longo prazo? Como os engenheiros podem tornar uma base de código mais sustentável e a própria disciplina de engenharia de software mais rigorosa? Não temos respostas definitivas para essas perguntas, mas esperamos que a experiência coletiva do Google ao longo das últimas duas décadas ilumine possíveis caminhos para encontrar essas respostas.

Uma das principais ideias que compartilhamos neste livro é que a engenharia de software pode ser vista como “programação integrada ao longo do tempo”. Quais práticas podemos introduzir em nosso código para torná-lo sustentável — capaz de reagir às mudanças necessárias — ao longo de seu ciclo de vida, desde a concepção até a introdução, manutenção e descontinuação?

O livro enfatiza três princípios fundamentais que acreditamos que as organizações de software devem ter em mente ao projetar, arquitetar e escrever seu código:"

RESOLUÇÃO DO PENSAMENTO:
Bom, levando em consideração a frase dito acima, devemos tratar a enhgeharia e softwear como qualquer outra engenharia, assim adionando normas de estrutura como exemplo, forçano muitos a ja saberem como agir para atender os pontos ditos acimas, manutenção etc.







21/02/2025
```



Atividade 4 - Classe UML
Classe UML - Loja Eletrônicos


Classe UML







Atividade 5 - Java
Classe Principal - LojaEletrônicos Arquivo: LojaEletrônicos.java

```java
package loja;

import java.util.LinkedList;
import java.util.List;

public class LojaEletronicos {

	// Lista de objetos privada criada para armazenar os tipos de celulares da loja

	private List<Celular> celulares = new LinkedList<Celular>();

	// Metodo para cadastrar um celular na lista

	public void cadastrarCelular(Celular celular) {
		celulares.add(celular);
	}

	public List<Celular> getCelular() {
		return celulares;
	}

	// Encontrar o celular dentro da lista privada

	public List<Celular> encontrarCelular(String nome, String so) {
		List<Celular> encontrados = new LinkedList<Celular>();
		for(Celular celular: celulares) {
			if(celular.getNome().equals(nome) && (celular.getSo().equals(so))) {
				encontrados.add(celular);
			}
		}
		return encontrados;
	}
}



Classe Celular Arquivo: Celular.java

```java

package loja;

import java.util.List;

public class Celular {
		private String nome;
		private String so;
		private String marca;
		private String cor;
		private double preco;
		
	//	//Criado o metodo construtor, definido como publico
		public Celular(String nome, String so, String marca, String cor, double preco) {
			this.nome = nome;
			this.so = so;
			this.marca = marca;
			this.cor = cor;
			this.preco = preco;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getSo() {
			return so;
		}
		public void setSo(String so) {
			this.so = so;
		}
		
		public String getMarca() {
			return marca;
		}
		
		public void setMarca(String marca) {
			this.marca = marca;
		}
		
		public String getCor() {
			return cor;
		}
		
		public void setCor(String cor) {
			this.cor = cor;
		}
		
		public double getPreco() {
			return preco;
		}
		
		public void setPreco(double preco) {
			this.preco = preco;
		}
	
}
```



Atividade 6 - Testes
Classe LojaEletronicoTest

```java

package loja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LojaEletronicosTest {

	@Test
	void test() {
		LojaEletronicos loja = new LojaEletronicos();
		
		//Criando objetos para cadastrar 
		
		Celular Samsung = new Celular ("S25","Android", "Samsung", "Azul Marinho", 1900.99);
		Celular Apple = new Celular("Iphone 15 Pro Max","IOS", "Apple", "Branco", 5699.99);
		
		//Processo de novos celulares
		loja.cadastrarCelular(Samsung);
		loja.cadastrarCelular(Apple);
		
		//Verificando o cadastro dos celulares
		assertEquals(loja.getCelular().size(), 2);
		
		List<Celular> encontradosSamsung = loja.encontrarCelular("S25", "Android");
		List<Celular> encontradosApple = loja.encontrarCelular("Iphone 15 Pro Max", "IOS");
		
		assertEquals(encontradosSamsung.get(0).getMarca(), "Samsung");
		assertEquals(encontradosApple.get(0).getCor(), "Branco");
			
	}

}
```
