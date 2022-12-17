package com.esper.market.domain.service;

import com.esper.market.domain.Product;
import com.esper.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    // en este caso el metodo delete dentro del ProductRepository no retorna nada, pero desde el servicio se puede
    // retornar por ejemplo un boolean si se elimina y un false en caso contrario.
//    Metodo 1 del delete
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

//    Metodo 2 del delete
//    public boolean delete(int productId) {
//        if (getProduct(productId).isPresent()) {
//            productRepository.delete(productId);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
