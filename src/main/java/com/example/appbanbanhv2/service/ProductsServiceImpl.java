package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.dto.ProductWithImageDTO;
import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.repository.ProductsRepository;

import com.example.appbanbanhv2.repository.StorageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private StorageRepository storageRepository;

    @Override
    public Products save(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Optional<Products> find(Integer id) {
        return productsRepository.findById(id);
    }

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> findAll(Sort sort) {
        return productsRepository.findAll(sort);
    }

    @Override
    public Page<Products> findAll(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }

    @Override
    public void delete(Products products) {
        productsRepository.delete(products);
    }

    @Override
    public void deleteAll() {
        productsRepository.deleteAll();
    }

    @Override
    public long count() {
        return productsRepository.count();
    }

    //service này lấy ra 10 sản phẩm
    @Override
    public List<Products> find10product() {
        return productsRepository.find10product();
    }

    //service này lấy ra id của sản phẩm mới được thêm vào
    @Override
    public long getNewestProductId() {
        return productsRepository.getNewestProductId();
    }

    //service này lấy ra toàn bộ danh sách sản phẩm
    @Override
    public List<ProductWithImageDTO> findAllProductAndItsImage() {
        List<Products> listProduct = productsRepository.findAll();
        List<ProductWithImageDTO> res = new ArrayList<>();
        for (Products i : listProduct) {
            int idProduct = i.getId();
            ProductWithImageDTO tmp = new ProductWithImageDTO();
            BeanUtils.copyProperties(i, tmp);
            tmp.setImageName(storageRepository.getImageNameByIdProduct(idProduct));
            res.add(tmp);

        }
        return res;
    }

    //Service này lấy ra danh sách sản phẩm tìm kiếm theo tên
    public List<ProductWithImageDTO> searchProductByName(String searchString) {
        List<Products> listProduct = productsRepository.searchAllWithSearchString(searchString);
        List<ProductWithImageDTO> res = new ArrayList<>();
        for (Products i : listProduct) {
            int idProduct = i.getId();
            ProductWithImageDTO tmp = new ProductWithImageDTO();
            BeanUtils.copyProperties(i, tmp);
            tmp.setImageName(storageRepository.getImageNameByIdProduct(idProduct));
            res.add(tmp);

        }
        return res;

    }

    //service này lấy ra danh sách sản phẩm theo id danh mục
    @Override
    public List<ProductWithImageDTO> findAllProductByCategory(int id) {
        List<Products> listProduct = productsRepository.getAllProductByIdCategory(id);
        List<ProductWithImageDTO> res = new ArrayList<>();
        for (Products i : listProduct) {
            int idProduct = i.getId();
            ProductWithImageDTO tmp = new ProductWithImageDTO();
            BeanUtils.copyProperties(i, tmp);
            tmp.setImageName(storageRepository.getImageNameByIdProduct(idProduct));
            res.add(tmp);

        }
        return res;

    }

    //service này lấy ra product với ảnh theo id
    @Override
    public ProductWithImageDTO getProductWithImageById(int id) {
        Products tmp = productsRepository.findById(id).get();
        ProductWithImageDTO res = new ProductWithImageDTO();
        BeanUtils.copyProperties(tmp, res);
        res.setImageName(storageRepository.getImageNameByIdProduct(res.getId()));
        return res;
    }

    @Override
    public List<ProductWithImageDTO> getTenProductWithImageHasHighestVote() {
        List<Products> listTmp = productsRepository.find10product();
        List<ProductWithImageDTO> listRes = new ArrayList<>();
        for (Products i : listTmp) {
            ProductWithImageDTO tmp = new ProductWithImageDTO();
            BeanUtils.copyProperties(i, tmp);
            int idProduct = i.getId();
            tmp.setImageName(storageRepository.getImageNameByIdProduct(idProduct));
            listRes.add(tmp);

        }
        return listRes;
    }

}