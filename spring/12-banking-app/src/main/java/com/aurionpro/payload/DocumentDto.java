package com.aurionpro.payload;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {
	
	private int id;
	private String title;
	
    private String documentUrl;
    private Date uploadDate;


}
