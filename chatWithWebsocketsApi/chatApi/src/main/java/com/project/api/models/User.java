package com.project.api.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "FRIENDCODE")
	private String friendCode;
	
	@ManyToOne
	@JoinColumn(name = "FILEMODEL", referencedColumnName = "ID")
	private FileModel photo;
	
	@Column(name = "LASTTIMEONLINE")
	private LocalDateTime lastTimeOnline;
}

