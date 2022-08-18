package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_temas")
public class Tema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="O atributo Descrição é obrigatório")
	@Size(min=3, max=255, message="O atributo Descrição deve conter no mínimo 03 e no máximo 255 caracteres.")
	private String descricao;
	
	@OneToMany(mappedBy="tema", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties ("tema")
	private List<Postagem> postagem;
	
	/*Insira os Getters and Setters*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Postagem> getPostagem(){
		return postagem;
	}
	
	public void setPostagem (List<Postagem> postagem) {
		this.postagem=postagem;
	}

}
