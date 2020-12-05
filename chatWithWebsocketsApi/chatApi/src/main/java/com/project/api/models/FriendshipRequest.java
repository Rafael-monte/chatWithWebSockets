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
@Table(name="FRIENDSHIPREQUEST")
public class FriendshipRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USERWHOSENT", referencedColumnName = "ID")
	private User userWhoSent;
	
	@ManyToOne
	@JoinColumn(name = "DESTINATARY", referencedColumnName = "ID")
	private User destinatary;
	
	@Column(name = "SENDDATE")
	private LocalDateTime sendDate;
	
}
