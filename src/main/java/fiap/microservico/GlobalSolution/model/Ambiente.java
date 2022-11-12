package fiap.microservico.GlobalSolution.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ambiente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String bairro;
	private String cidade;
	private String estado;
	private Long temperatura;
	private String qualidadeAr;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Long temperatura) {
		this.temperatura = temperatura;
	}
	public String getQualidadeAr() {
		return qualidadeAr;
	}
	public void setQualidadeAr(String qualidadeAr) {
		this.qualidadeAr = qualidadeAr;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ambiente other = (Ambiente) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
	
	