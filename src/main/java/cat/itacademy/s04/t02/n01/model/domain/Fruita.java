package cat.itacademy.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruita")
public class Fruita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "QUANTITAT_QUILOS")
    private int quantitatQuilos;

   /* public Frutia() {

    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }

    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }

}
