package cat.itacademy.s04.t02.n01.model.repository;

import cat.itacademy.s04.t02.n01.model.domain.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
}
