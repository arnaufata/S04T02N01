package cat.itacademy.s04.t02.n01.controllers;

import cat.itacademy.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.s04.t02.n01.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaService fruitaService;

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
        /*El paràmetre anotat amb @RequestBody indica que Spring ha d'agafar el cos de la sol·licitud HTTP
        (que conté les dades de la fruita en format JSON, per exemple) i convertir-lo automàticament en un
        objecte de tipus Fruita. Això es fa gràcies a les capacitats de serialització/deserialització de Spring.*/
        try {
            Fruita novaFruita = fruitaService.addFruita(fruita);
            return new ResponseEntity<>(novaFruita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int id, @RequestBody Fruita fruita) {
        /*El paràmetre anotat amb @PathVariable("id") especifica que la part {id} de l'URL es correspondrà amb
        aquest paràmetre id del mètode. El valor provinent de l'URL s'injecta automàticament en aquest paràmetre.*/
        try {
            Fruita fruitaActualitzada = fruitaService.updateFruita(id, fruita);
            return new ResponseEntity<>(fruitaActualitzada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") int id) {
        try {
            fruitaService.deleteFruita(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            /* Aquest codi indica que l'eliminació ha estat exitosa, però no es retorna cap contingut en el cos
            de la resposta, ja que no hi ha dades que s'hagin de retornar quan esborres un recurs.*/
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOneFruita(@PathVariable("id") int id) {
        try {
            Fruita fruita = fruitaService.getFruitaByID(id);
            return new ResponseEntity<>(fruita, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        try {
            List<Fruita> fruites = fruitaService.getAllFruites();
            if (fruites.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                // la sol·licitud ha tingut èxit, però no hi ha dades disponibles per retornar.
            }
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
