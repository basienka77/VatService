package sanecznik.barbara.vat_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sanecznik.barbara.vat_service.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
