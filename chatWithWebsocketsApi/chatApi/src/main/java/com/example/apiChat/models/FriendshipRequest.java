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
@Table(name="FRIENDSHIPREQUEST", schema = "public")
public class FriendshipRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USERWHOSENT")
	private User userWhoSent;
	
	@ManyToOne
	@JoinColumn(name = "DESTINATARY")
	private User destinatary;
	
	@Column(name = "SENDDATE")
	private LocalDateTime sendDate;
	
}
