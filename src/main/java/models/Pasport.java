package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Pasport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "pasport")
    private User user;




    public Pasport(String series) {
        this.series = series;
    }
}
