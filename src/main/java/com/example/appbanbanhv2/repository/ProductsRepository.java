package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.dto.ProductWithImageDTO;
import com.example.appbanbanhv2.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Products, Integer> {

    @Query( value = "SELECT * FROM products ORDER BY so_vote DESC LIMIT 10", nativeQuery = true)
    List<Products> find10product();
    @Query(value = "SELECT id FROM products ORDER BY id DESC LIMIT 1", nativeQuery = true)
    long getNewestProductId();
    //lấy ra danh sách sản phẩm theo chuỗi tìm kiếm
    @Query(value="SELECT * FROM products WHERE products.ten_sp LIKE %:searchString%", nativeQuery = true)
	List<Products> searchAllWithSearchString(String searchString);
    //lấy ra danh sách sản phẩm theo id danh mục
    @Query(value="SELECT * FROM products WHERE products.category_id = ?1", nativeQuery = true)
	List<Products> getAllProductByIdCategory(int id);


}