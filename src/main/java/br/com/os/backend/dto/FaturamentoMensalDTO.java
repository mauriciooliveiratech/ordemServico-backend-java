package br.com.os.backend.dto;

import java.math.BigDecimal;

public class FaturamentoMensalDTO {
    private Integer mes; //1 a 12
    private BigDecimal total;


    public FaturamentoMensalDTO(Integer mes, BigDecimal total){
        this.mes = mes;
        this.total = total;

    }

    public Integer getMes(){
        return mes;
    }

    public BigDecimal getTotal(){
        return total;
    }





}
