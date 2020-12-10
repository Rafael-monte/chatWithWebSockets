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
@Table(name = "PUBLICATION", schema = "public")
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "PUBLISHINGDATE")
	private LocalDateTime publishingDate;
	
	@Column(name="TAGS")
	private String tags;
	
	@Column(name = "UPVOTES")
	private int upVotes;
	
	@ManyToOne
	@JoinColumn(name = "FILE")
	private FileModel file;
	
	@ManyToOne
	@JoinColumn(name = "USER")
	private User user;
}

