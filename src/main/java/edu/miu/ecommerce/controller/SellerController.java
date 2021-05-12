package edu.miu.ecommerce.controller;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;
import edu.miu.ecommerce.model.NewProductRequest;
import edu.miu.ecommerce.service.ProductService;
import edu.miu.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    @GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/sellers/{id}")
    public Seller getSellerById(@PathVariable long id) {
        return sellerService.getSellerById(id);
    }

    @DeleteMapping("/sellers/{id}")
    public void deleteSeller(@PathVariable long id) {
        sellerService.deleteSeller(id);
    }
    @PostMapping("/sellers/{id}/product")
    public void addProduct(@PathVariable long id, @RequestBody NewProductRequest product){
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setOrders(null);
        newProduct.setReviews(null);
        sellerService.addProduct(newProduct,id);
    }
}
