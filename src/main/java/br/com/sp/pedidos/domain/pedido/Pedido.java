package br.com.sp.pedidos.domain.pedido;

import java.time.LocalDateTime;

import java.lang.Boolean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.sp.pedidos.domain.PedidoItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PEDIDOS")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, updatable = false)
	private UUID userID;
	private LocalDateTime dataHora;
	private String descricao;
	private Float valorTotal;
	private Float valorFrete;
	private Float valorTotalGeral;
	private MetodoPagamento metodoPagamento;
	private Boolean actived;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<PedidoItem> itens = new ArrayList<PedidoItem>();
	
	public Pedido() {
		this.actived = true;
		this.dataHora = LocalDateTime.now();
	}

	public Pedido(UUID userID, String descricao, Float valorTotal, Float valorFrete,
			Float valorTotalGeral, MetodoPagamento metodoPagamento) {
		super();
		this.userID = userID;
		this.dataHora = LocalDateTime.now();
		this.descricao = descricao;
		this.valorTotal = valorTotal;
		this.valorFrete = valorFrete;
		this.valorTotalGeral = valorTotalGeral;
		this.metodoPagamento = metodoPagamento;
		this.actived = true;
	}
 
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserID() {
		return userID;
	}

	public void setUserID(UUID userID) {
		this.userID = userID;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Float valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Float getValorTotalGeral() {
		return valorTotalGeral;
	}

	public void setValorTotalGeral(Float valorTotalGeral) {
		this.valorTotalGeral = valorTotalGeral;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}
	
}
