package br.com.bnback.food.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/product")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	private Product createProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}

	@GetMapping
	private List<Product> findAll() {
		return productService.findAll();
	}

	@DeleteMapping("/{id}")
	private void deleteById(@PathVariable Long id) {
		productService.deleteById(id);
	}

	@GetMapping("/{id}")
	private Product findyById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@PutMapping("/{id}")
	private Product upadate(@RequestBody Product product, @PathVariable Long id) {
		return productService.updateProduct(product, id);
	}

}
