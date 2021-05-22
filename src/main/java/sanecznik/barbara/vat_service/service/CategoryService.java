package sanecznik.barbara.vat_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sanecznik.barbara.vat_service.domain.Category;
import sanecznik.barbara.vat_service.dto.CalculationRequest;
import sanecznik.barbara.vat_service.repository.CategoryRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public BigDecimal calculateTaxAmount(List<CalculationRequest> calculationRequests) {
        return calculationRequests.stream().map(this::calculateTaxAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    private BigDecimal calculateTaxAmount(CalculationRequest calculationRequest) {
        if (calculationRequest.getAmount() == null || calculationRequest.getId() == null) {
            return BigDecimal.ZERO;
        }
        Optional<Category> category = categoryRepository.findById(calculationRequest.getId());
        return category.map(value -> calculationRequest.getAmount().multiply(value.getTaxPercentage()).setScale(2, RoundingMode.HALF_UP)).orElse(BigDecimal.ZERO);
    }
}
