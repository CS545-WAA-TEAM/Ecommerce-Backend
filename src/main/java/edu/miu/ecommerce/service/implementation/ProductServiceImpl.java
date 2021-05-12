package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.repository.ProductDAO;
import edu.miu.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return StreamSupport.stream(productDAO.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(long id) {
        return productDAO.findById(id).orElseThrow();
    }
    @Override
    public void deleteProduct(long id) {
        productDAO.deleteById(id);
    }

    @Override
    public void updateProduct(Product product, long id) {

    }
}
