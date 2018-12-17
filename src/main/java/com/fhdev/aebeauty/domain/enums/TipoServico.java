package com.fhdev.aebeauty.domain.enums;

public enum TipoServico {
	
	CABELO(1, "Cabelo"),
	UNHA(2,"Unha");
	
	private int codigo;
	private String descricao;
	
	private TipoServico(int codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	//Método que retorna um objeto do tipo TipoServico
		public static TipoServico toEnum(Integer codigo) {
			
			if(codigo == null) {
				return null;
			}
			
			for (TipoServico x : TipoServico.values()) {
				
				if(codigo.equals(x.getCodigo())) {
					return x;
				}
			}
			
			throw new IllegalArgumentException("Id inválido: " + codigo);
			
		}

}
