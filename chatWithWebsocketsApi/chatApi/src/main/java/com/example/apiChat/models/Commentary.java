package com.example.apiChat.models;

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
@Table(name = "COMMENTARY", schema = "public")
public class Commentary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "PUBLICATION")
	private Publication publication;
	
	@Column(name = "TEXT")
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "FILE")
	private FileModel file;
	
	@Column(name = "PUBLISHINGDATE")
	private LocalDateTime publishingDate;
	
	@ManyToOne
	@JoinColumn(name = "USER")
	private User user;
	
	@Column(name = "UPVOTES")
	private int upVotes;
	
	
}
