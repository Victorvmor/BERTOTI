# **AULA 01 - (14/02/2025)**
# **Crie um repositório chamado "bertoti" -> pasta "engenhariadesoftware" -> arquivo "readme.md" e faça as seguintes atividades (já vou comentá-las):**

**1. Comentar com suas palavras o primeiro trecho do livro Software Engineering at Google, Oreilly. (vou postar abaixo)**

**2. Comentar com suas palavras o segundo trecho do livro Software Engineering at Google, Oreilly.(vou postar abaixo)**

**3. Listar e explicar 3 exemplos de tradeoffs**


Oque é engenharia de sortwear? (lousa do professor)

-Programação+Tempo+Escalabilidade+TradOff

**TradOff:** Entregar uma coisa por outra. 

**Exemplo:** 
-Ter a portabilidade do java para rodar em vários programas, porém, terá uma complexidade maior para SER DESENVOLVIDO. Uma troca equivalente!
        
-Banco do Brazil (não usava um linguagem de programação escalonavel): Pouca complexidade, barata, porém pouca escalabilidade. Ou seja, transações podem sofrer erro mais facilmente.
        
 -Matematicos usando python para desenvolver sistemas para os ajudarem, porém, é muito lento, assim tendo que adiconar C++ para poder rodar mais facilmente. Dois trabalhos




# ATIVIDADE 01:


## TRECHO 01: 
"O que exatamente queremos dizer com engenharia de software? O que distingue "engenharia de software" de "programação" ou "ciência da computação"? E por que o Google teria uma perspectiva única a adicionar ao corpo de literatura de engenharia de software escrita nos últimos 50 anos?

Os termos "programação" e "engenharia de software" têm sido usados de forma intercambiável por um bom tempo em nossa indústria, embora cada termo tenha ênfases e implicações diferentes. Os estudantes universitários tendem a estudar ciência da computação e conseguir empregos escrevendo código como "programadores".

"Engenharia de software", no entanto, soa mais sério, como se implicasse a aplicação de algum conhecimento teórico para construir algo real e preciso. Engenheiros mecânicos, civis, aeronáuticos e os de outras disciplinas de engenharia praticam engenharia. Todos trabalham no mundo real e usam a aplicação de seus conhecimentos teóricos para criar algo real. Engenheiros de software também criam "algo real", embora seja menos tangível do que as coisas que outros engenheiros criam.

Ao contrário dessas profissões de engenharia mais estabelecidas, a teoria ou prática atual da engenharia de software não é tão rigorosa. Engenheiros aeronáuticos devem seguir diretrizes e práticas rígidas, porque erros em seus cálculos podem causar danos reais; a programação, de forma geral, tradicionalmente não seguiu práticas tão rigorosas. Mas, à medida que o software se torna mais integrado em nossas vidas, devemos adotar e confiar em métodos de engenharia mais rigorosos. Esperamos que este livro ajude outros a ver um caminho em direção a práticas de software mais confiáveis."

RESOLUÇÃO DO PENSAMENTO:
-Ao decorrer do texto percebemos que o nome "Engenharia de softwear" parece ter sido criado e desenvolvido de forma rápida, tanto que muitos não entendem exatamente qual sua função real, já que como dito no texto, engenharias do "mundo real" são facilmente entendidas, mesmo por um leigo no assunto, pelo menos, é vista de forma concretar. Se pararmos para entender toda essa situção, alguns pontos podem ser observado: a rapida acenssão da tecnologia; a propagação do mundo virtual de modo tão rapido que não havia tempo de se pensar no que realmente é; e a naturalidade de "não precisamos saber",pois, somente é oque é. Muito dificilmente um usuario irá ver por dentro de um programa, mas, por dentro de um avião, ou prédio 



## TRECHO 02: 
"Programação ao Longo do Tempo

Proponhamos que “engenharia de software” não se limite apenas ao ato de escrever código, mas inclua todas as ferramentas e processos que uma organização usa para construir e manter esse código ao longo do tempo. Quais práticas uma organização de software pode introduzir para manter seu código valioso a longo prazo? Como os engenheiros podem tornar uma base de código mais sustentável e a própria disciplina de engenharia de software mais rigorosa? Não temos respostas definitivas para essas perguntas, mas esperamos que a experiência coletiva do Google ao longo das últimas duas décadas ilumine possíveis caminhos para encontrar essas respostas.

Uma das principais ideias que compartilhamos neste livro é que a engenharia de software pode ser vista como “programação integrada ao longo do tempo”. Quais práticas podemos introduzir em nosso código para torná-lo sustentável — capaz de reagir às mudanças necessárias — ao longo de seu ciclo de vida, desde a concepção até a introdução, manutenção e descontinuação?

O livro enfatiza três princípios fundamentais que acreditamos que as organizações de software devem ter em mente ao projetar, arquitetar e escrever seu código:"

RESOLUÇÃO DO PENSAMENTO:
Bom, levando em consideração a frase dito acima, devemos tratar a enhgeharia e softwear como qualquer outra engenharia, assim adionando normas de estrutura como exemplo, forçano muitos a ja saberem como agir para atender os pontos ditos acimas, manutenção etc.







# 21/02/2025



## Atividade 4 - Classe UML (não consegui)
Classe UML - Loja Eletrônicos


Classe UML







## **Atividade 5 - Java**
```java
package loja;

public class Livro {
	private String titulo;
	private String autor;
	private String genero;
	private int paginas;
	private double preco;

	public Livro(String titulo, String autor, String genero, int paginas, double preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.paginas = paginas;
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}

```

## **Classe Loja Arquivo: LojaLivros.java**
```java
package loja;

import java.util.LinkedList;
import java.util.List;

public class LojaLivros {

	private List<Livro> livros = new LinkedList<Livro>();

	public void cadastrarLivro(Livro livro) {
		livros.add(livro);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public List<Livro> encontrarLivro(String titulo, String autor) {
		List<Livro> encontrados = new LinkedList<Livro>();
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo) && livro.getAutor().equals(autor)) {
				encontrados.add(livro);
			}
		}
		return encontrados;
	}
}
```

## **Atividade 6 - Testes**

```java
package loja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LojaLivrosTest {

	@Test
	void test() {
		LojaLivros loja = new LojaLivros();

		Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", "Romance", 256, 29.90);
		Livro livro2 = new Livro("A Revolução dos Bichos", "George Orwell", "Fábula", 112, 19.99);

		loja.cadastrarLivro(livro1);
		loja.cadastrarLivro(livro2);

		assertEquals(loja.getLivros().size(), 2);

		List<Livro> encontrados1 = loja.encontrarLivro("Dom Casmurro", "Machado de Assis");
		List<Livro> encontrados2 = loja.encontrarLivro("A Revolução dos Bichos", "George Orwell");

		assertEquals(encontrados1.get(0).getGenero(), "Romance");
		assertEquals(encontrados2.get(0).getPaginas(), 112);
	}
}
```
