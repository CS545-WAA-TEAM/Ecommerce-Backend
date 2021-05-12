package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Override
    public Iterable<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public void updateProduct(Product product, long id) {

    }
}
