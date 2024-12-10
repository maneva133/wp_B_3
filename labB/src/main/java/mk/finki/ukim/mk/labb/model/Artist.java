package mk.finki.ukim.mk.labb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Artist {
    @Id
    public Long id;
    public String firstName;
    public String lastName;
    public String bio;


    public Artist(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    public Artist() {

    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setBio(String bio) {
        this.bio = bio;
    }
}
