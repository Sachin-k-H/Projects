package com.sachin.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Registered_Images")
public class Images {
	@Id
	@GeneratedValue
	private int id;
	private String imagename;
	private long imagesize;
	private String imagetype;
	private int userid;
	private String imageuploadedby;
    private LocalDateTime imageuploadedate;
	private String imagemodifiedby;
	private LocalDateTime imagemodifiedate;
    private String imagestatus;
	

}
