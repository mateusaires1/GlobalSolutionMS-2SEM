package fiap.microservico.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fiap.microservico.GlobalSolution.model.Regional;

@Repository
public interface RegionalRepository extends JpaRepository<Regional, Long>{

}
