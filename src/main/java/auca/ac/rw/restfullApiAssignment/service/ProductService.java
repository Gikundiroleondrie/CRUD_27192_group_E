package auca.ac.rw.restfullApiAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.restfullApiAssignment.modal.Product;
import auca.ac.rw.restfullApiAssignment.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepo; 

    // CREATE - Save a new product
    public String saveProduct(Product product){
        Optional<Product> checkProduct = productRepo.findById(product.getId());
        
        if(checkProduct.isPresent()){
            return "Product with id "+ product.getId() + " already exists.";
        }else{
            productRepo.save(product);
            return "Product saved successfully.";
        }
    }

    // READ - Get all products
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    // READ - Get product by ID
    public Optional<Product> getProductById(Long id){
        return productRepo.findById(id);
    }

    // UPDATE - Update an existing product
    public String updateProduct(Long id, Product productDetails){
        Optional<Product> existingProduct = productRepo.findById(id);
        
        if(existingProduct.isPresent()){
            Product product = existingProduct.get();
            
            if(productDetails.getName() != null){
                product.setName(productDetails.getName());
            }
            if(productDetails.getDescription() != null){
                product.setDescription(productDetails.getDescription());
            }
            if(productDetails.getPrice() > 0){
                product.setPrice(productDetails.getPrice());
            }
            if(productDetails.getCategory() != null){
                product.setCategory(productDetails.getCategory());
            }
            if(productDetails.getStockQuantity() > 0){
                product.setStockQuantity(productDetails.getStockQuantity());
            }
            
            productRepo.save(product);
            return "Product updated successfully.";
        }else{
            return "Product with id " + id + " not found.";
        }
    }

    // DELETE - Delete a product by ID
    public String deleteProduct(Long id){
        Optional<Product> existingProduct = productRepo.findById(id);
        
        if(existingProduct.isPresent()){
            productRepo.deleteById(id);
            return "Product deleted successfully.";
        }else{
            return "Product with id " + id + " not found.";
        }
    }
}
