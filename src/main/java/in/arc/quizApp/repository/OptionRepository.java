package in.arc.quizApp.repository;

import in.arc.quizApp.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OptionRepository extends JpaRepository<Option, UUID> {
}
