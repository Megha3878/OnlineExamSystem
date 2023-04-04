package com.csmtech.model;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name="candidate")
@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candid;
	
	private String candname;
	
	private String candusername;
	
	private String candpassword;
	
	private String candidateemail;
	
	private String candMobile;
	
	private Date canddob;
	
	private Date dateexam;
	
	private String status;
	 
	private String isdelete;
	
	private String address;
	
}
