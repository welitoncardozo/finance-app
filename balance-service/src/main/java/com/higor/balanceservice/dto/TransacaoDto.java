package com.higor.balanceservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoDto {
	
	private Integer idUser;
	private BigDecimal valor;
	private String tipo;

}
