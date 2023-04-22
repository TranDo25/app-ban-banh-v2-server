package com.example.appbanbanhv2.controller;

import com.example.appbanbanhv2.dto.ProductWithImageDTO;
import com.example.appbanbanhv2.dto.ProductsDTO;
import com.example.appbanbanhv2.entity.Category;
import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.service.CategoryService;
import com.example.appbanbanhv2.service.ProductsService;
import com.example.appbanbanhv2.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductManager {
	@Autowired
	private ProductsService productsService;
	@Autowired
	private StorageService service;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/admin/products")
	public String listProduct(Model model) {
//        model.addAttribute("products", productsService.findAll());
		List<ProductWithImageDTO> tmp = productsService.findAllProductAndItsImage();

//        for(ProductWithImageDTO i:tmp){
//            String pathUrl = "/api/admin/product/image/";
//            i.setImageName(pathUrl+ i.getImageName());
//        }
		model.addAttribute("products", tmp);
		return "products";
	}
//api này lấy toàn bộ product
	@GetMapping("/api/admin/products")
	public ResponseEntity<List<ProductWithImageDTO>> apiListProduct(Model model) {
//        model.addAttribute("products", productsService.findAll());
		List<ProductWithImageDTO> tmp = productsService.findAllProductAndItsImage();

		for (ProductWithImageDTO i : tmp) {
			String pathUrl = "localhost:8080/api/admin/product/image/";
			i.setImageName(pathUrl + i.getImageName());
		}
//                model.addAttribute("products", tmp);
		return ResponseEntity.ok(tmp);
	}
	//api này lấy ra tất cả danh sách sản phẩm theo id category
	@GetMapping("/api/admin/productsByCategory/{id}")
	public ResponseEntity<List<ProductWithImageDTO>> apiListProductByCategory(@PathVariable("id") int id) {
//        model.addAttribute("products", productsService.findAll());
		List<ProductWithImageDTO> tmp = productsService.findAllProductByCategory(id);

		for (ProductWithImageDTO i : tmp) {
			String pathUrl = "localhost:8080/api/admin/product/image/";
			i.setImageName(pathUrl + i.getImageName());
		}
//          model.addAttribute("products", tmp);
		return ResponseEntity.ok(tmp);
	}
	@GetMapping("/admin/products/addProduct")
	public String addProductForm(Model model) {
		ProductsDTO tmp = new ProductsDTO();
		model.addAttribute("product", tmp);
		List<Category> listCategory = categoryService.findAll();
		model.addAttribute("listCategory", listCategory);
		return "create_product";
	}
// api tìm kiếm sản phẩm theo chuỗi tìm kiếm
	@GetMapping("/api/admin/searchProductByName")
	public ResponseEntity<List<ProductWithImageDTO>> searchProductByName(
			@RequestParam("searchString") String searchString) {
		List<ProductWithImageDTO> tmp = productsService.searchProductByName(searchString);
		for (ProductWithImageDTO i : tmp) {
			String pathUrl = "localhost:8080/api/admin/product/image/";
			i.setImageName(pathUrl + i.getImageName());
		}
		return ResponseEntity.ok(tmp);
	}
//api get chi tiết sản phẩm theo id
	@GetMapping("/api/admin/getDetailProductById")
	public ResponseEntity<ProductWithImageDTO> getDetailProductById(@RequestParam("id") int id){
		ProductWithImageDTO tmp = productsService.getProductWithImageById(id);
		return  ResponseEntity.ok(tmp);
	}
	
	@PostMapping("/api/admin/product/uploadImage")
	public ResponseEntity<?> ApiUploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}
//api save image
	@PostMapping("/admin/product/uploadImage")
	public String createProduct(@ModelAttribute ProductsDTO product, Model model) throws IOException {
		Products tmp = new Products();
		BeanUtils.copyProperties(product, tmp);
		tmp.setId(0);
		try {
			productsService.save(tmp);
		} catch (Exception e) {
			System.out.println("error in save product");
		}
		long newestProductId;
		int count = (int) productsService.count();
		if(count == 0){
			newestProductId = 1;
		}
		else{
			newestProductId = productsService.getNewestProductId();
		}
		try {
			String uploadImage = service.uploadImage(product.getImage(), newestProductId);
			model.addAttribute("message", uploadImage);
			model.addAttribute("product", product);
		} catch (Exception e) {
			System.out.println("Error in update image");
		}
		return "create_product";
	}

	@GetMapping("/api/admin/product/image/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
		byte[] imageData = service.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);

	}

	@PostMapping("/api/admin/product/image//fileSystem")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadImage = service.uploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("/api/admin/product/image//fileSystem/{fileName}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
		byte[] imageData = service.downloadImageFromFileSystem(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);

	}
}
