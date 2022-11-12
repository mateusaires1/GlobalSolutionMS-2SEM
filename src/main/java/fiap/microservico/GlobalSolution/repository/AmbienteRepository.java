package fiap.microservico.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fiap.microservico.GlobalSolution.model.Ambiente;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long>{

}
