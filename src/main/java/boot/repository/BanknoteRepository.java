package boot.repository;

import boot.entity.Banknote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanknoteRepository extends JpaRepository<Banknote, Long> {
}
