package cat.itacademy.s04.t02.n01.model.services;

import cat.itacademy.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.s04.t02.n01.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitaService {

    @Autowired
    private FruitaRepository fruitaRepository;

    public Fruita addFruita(Fruita fruita){
        return fruitaRepository.save(fruita);
    }

    public Fruita updateFruita(int id, Fruita fruita) throws Exception {
        Fruita fruitaActualitzada = fruitaRepository.findById(id)
                .orElseThrow(() -> new Exception("Fruita no trobada amb ID: " + id));

        fruitaActualitzada.setNom(fruita.getNom());
        fruitaActualitzada.setQuantitatQuilos(fruita.getQuantitatQuilos());
        return fruitaRepository.save(fruitaActualitzada);
    }

    public void deleteFruita(int id) throws Exception {
        fruitaRepository.deleteById(id); //el mètode deleteById(id) ja llença les excepcions
                                        // necessàries (EmptyResultDataAccessException) si l'ID no existeix
    }

    public Fruita getFruitaByID(int id) throws Exception {
        return fruitaRepository.findById(id)
                .orElseThrow(() -> new Exception("Fruita no trobada amb ID: " + id));
    }

    public List<Fruita> getAllFruites() {
        return fruitaRepository.findAll();
    }
}
