package cadastroee.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Produto {


    @Id
    @GeneratedValue(stategy = GeneratedType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade;
    private double preco;

    
}