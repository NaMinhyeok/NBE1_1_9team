package gc.cafe.api.controller.product;

import gc.cafe.api.ApiResponse;
import gc.cafe.api.controller.product.request.ProductCreateRequest;
import gc.cafe.api.controller.product.request.ProductUpdateRequest;
import gc.cafe.api.service.product.ProductService;
import gc.cafe.api.service.product.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductCreateRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(productService.createProduct(request.toServiceRequest())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Long>> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(productService.deleteProduct(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductUpdateRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(productService.updateProduct(id, request.toServiceRequest())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(productService.getProduct(id)));
    }

}
