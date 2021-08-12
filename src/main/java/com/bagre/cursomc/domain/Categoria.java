package com.bagre.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// Essa classe será a responsável pela criação das categorias de produto
		
@Entity
public class Categoria implements Serializable { // O serializable é uma interface que fará com que todos os objetos da classe poderão ser convertidos para bytes
	private static final long serialVersionUID = 1L;
	//Quando um objeto é transformado em bytes, ele pode ser gravado em arquivos ou "jogados" na rede
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //atributos da classe
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria () { // construtor que vai instanciar o objeto
	}

	public Categoria(Integer id, String nome) { // construtor com parametro
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() { //getter
		return id;
	}

	public void setId(Integer id) {//setter
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	} 

	@Override // O hashCode e equals irão comparar os objetos pelo conteúdo/valor deles
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
}
