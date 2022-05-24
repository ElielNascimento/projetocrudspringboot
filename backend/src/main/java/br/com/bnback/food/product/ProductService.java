package br.com.bnback.food.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;

	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found " + id));
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	public Product updateProduct(Product newproduct, Long id) {
		Product product = productRepository.findById(id).get();
		product.setPrice(newproduct.getPrice());
		product.setDescription(newproduct.getDescription());
		return productRepository.save(product);

	}

}
