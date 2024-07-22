package br.com.sp.pedidos.domain.pedido;

public enum MetodoPagamento {
	PIX(1, "Pix"),
	CREDITO(2, "Crédito"),
	DEBITO(3, "Débito"),
	BOLETO(4, "Boleto");
	
	private Integer id;
	private String name;
	
	private MetodoPagamento(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
