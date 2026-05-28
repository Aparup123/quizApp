package in.arc.quizApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Entity(name = "options")
@Data
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private int number;

    @ColumnDefault("false")
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Question question;


}
