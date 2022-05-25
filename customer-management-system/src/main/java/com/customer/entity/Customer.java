package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	private String id;
	private String fistname;
	private String lastname;
}
