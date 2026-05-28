package in.arc.quizApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ElementCollection
    @CollectionTable(name = "question_tags",
        joinColumns = @JoinColumn(name = "question_id")
    )
    private List<String> tags;

    @OneToMany(mappedBy = "question",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Option> options;
}
