package br.com.pedro.services.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")// Quando o nome da tabela é igual tanto na tabela e no DB,
//nãp é necessário colocar o name, é opcional. Quando for diferente é melhor especificar.
public class Person implements Serializable {

    private static final long SeriaVersionUID = 1L;

    //Mapeamento de atributos da classe.
    @Id // Irá transformar o id em uma coluna, não haverá necessidade da anotação @Column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Quando os nomes das colunas forem diferentes do que está no DB, do que está sendo mapeado aqui,
    //então precisamos definir as colunas.
    @Column(name = "first_name", nullable = false, length = 80)//Não poderá ser null, se for dará uma exceção, se for um nome muito grande se mão trará problemas e não irá persistir no DB.
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(nullable = false, length = 100)//Quando eu não passo o name, ele entende que o nome é o mesmo no banco e na entidade.
    private String address;

    @Column(nullable = false, length = 6)
    private String gender;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
