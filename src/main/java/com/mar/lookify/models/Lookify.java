package com.mar.lookify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Table(name="canciones")
public class Lookify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 50)
	private String titulo;
	@Size(min = 5, max = 50)
	private String artista;
	@Size(min = 1, max = 10)
	private String clasificacion; 
	    
	// Esto no permitirá que el campo createdAt sea modificado después de su creación.
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	    
	public Lookify() {
	}
	    
	public Lookify(Long id, String titulo, String artista, String clasificacion) {		
	  	this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.clasificacion = clasificacion;		
	}

	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
		
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}		

}
