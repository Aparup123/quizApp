package in.arc.quizApp.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    private double point;

    @Column(name = "order_index")
    private int order;
}
