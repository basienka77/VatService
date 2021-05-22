package sanecznik.barbara.vat_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sanecznik.barbara.vat_service.domain.Category;
import sanecznik.barbara.vat_service.dto.CalculationRequest;
import sanecznik.barbara.vat_service.service.CategoryService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @PostMapping
    public BigDecimal calculateTaxAmount(@RequestBody List<CalculationRequest> calculationRequest){
        return categoryService.calculateTaxAmount(calculationRequest);
    }

}
