package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "user_class")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "user_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection
    private List<String> skills;

    @OneToOne(cascade ={CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id",referencedColumnName = "id" )
    private Pasport pasport;



    public User(String name, Gender gender, List<String> skills) {
        this.name = name;
        this.gender = gender;
        this.skills = skills;
    }

    public User(String name, Gender gender, List<String> skills, Pasport pasport) {
        this.name = name;
        this.gender = gender;
        this.skills = skills;
        this.pasport = pasport;
    }
}
