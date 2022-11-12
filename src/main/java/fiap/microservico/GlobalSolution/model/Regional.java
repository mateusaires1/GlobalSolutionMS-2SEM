package fiap.microservico.GlobalSolution.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Regional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate data;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name= "veiculos_id")
	private List<Veiculo> veiculos;
	
	public Regional (List<Veiculo> veiculo) {
		this.data = LocalDate.now();
		this.veiculos = veiculo;
	}
	
}