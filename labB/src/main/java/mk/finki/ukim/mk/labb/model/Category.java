package mk.finki.ukim.mk.labb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Category {
    @Id
    public String name;

    public Category() {

    }
}
