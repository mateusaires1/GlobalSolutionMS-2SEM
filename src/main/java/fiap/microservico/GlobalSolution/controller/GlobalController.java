package fiap.microservico.GlobalSolution.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.microservico.GlobalSolution.model.Regional;
import fiap.microservico.GlobalSolution.model.Veiculo;
import fiap.microservico.GlobalSolution.repository.RegionalRepository;
import fiap.microservico.GlobalSolution.repository.VeiculoRepository;

@RestController
public class GlobalController {
	
	@Autowired
	private RegionalRepository regRepository;
	
	@Autowired
	private VeiculoRepository repository;
	
	// GET ALL VEICULOS
	@RequestMapping(value = "/veiculos", method = RequestMethod.GET)
	public List<Veiculo> listar() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/veiculos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Veiculo> GetById(@PathVariable(value = "id") long id) 
	{
		Optional<Veiculo> veiculo = repository.findById(id);
		if(veiculo.isPresent())
			return new ResponseEntity<Veiculo>(veiculo.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// POST VEICULO
	@RequestMapping(value = "/veiculos", method = RequestMethod.POST)
	public Veiculo Post(@RequestBody Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
	
	// PUT MARCA VEICULOS
	@RequestMapping(value = "/veiculos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Veiculo> Put(@PathVariable(value = "id") long id, @RequestBody Veiculo newVeiculo)
	{
		Optional<Veiculo> oldVeiculo = repository.findById(id);
		if(oldVeiculo.isPresent()) {
			Veiculo veiculo = oldVeiculo.get();
			veiculo.setMarca(newVeiculo.getMarca());
			repository.save(veiculo);
			return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//DELETAR VEICULOS
	@RequestMapping(value = "/veiculos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Veiculo> Delete(@PathVariable(value = "id") long id)
	{
		Optional<Veiculo> veiculo = repository.findById(id);
		if(veiculo.isPresent()) {
			repository.delete(veiculo.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// GET ALL REGIONAIS
	@RequestMapping(value = "/regional", method = RequestMethod.GET)
	public List<Regional> listarRegional() {
		return regRepository.findAll();
	}
	
	// POST REGIONAL
	@RequestMapping(value = "/regional", method = RequestMethod.POST)
	public Regional Post(@RequestBody Regional regional) {
		return regRepository.save(regional);
	}
	
	
	
}
