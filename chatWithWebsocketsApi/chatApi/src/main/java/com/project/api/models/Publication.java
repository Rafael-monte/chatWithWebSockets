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
@Table(name = "PUBLICATION")
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
	@JoinColumn(name = "FILE", referencedColumnName = "ID")
	private FileModel file;
	
	@ManyToOne
	@JoinColumn(name = "USER", referencedColumnName="ID")
	private User user;
}

