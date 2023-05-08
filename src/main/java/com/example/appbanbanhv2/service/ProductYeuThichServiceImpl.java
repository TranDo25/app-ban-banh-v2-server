package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.dto.ProductWithImageDTO;
import com.example.appbanbanhv2.entity.ProductYeuThich;
import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.repository.ProductYeuThichRepository;

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
public class ProductYeuThichServiceImpl implements ProductYeuThichService {
    @Autowired
    private ProductYeuThichRepository _yeuthichRepo;
    @Autowired
    private StorageRepository _storageRepo;
    @Autowired
    private ProductYeuThichRepository productyeuthichRepository;
    @Autowired
    private ProductsRepository _productRepo;

    @Override
    public Optional<ProductYeuThich> findByproduct_idAndUser_id(Integer productId, String userId) {
        return productyeuthichRepository.findProductYeuThichByIdProductAndUsersId(productId, userId);
    }

    @Override
    public ProductYeuThich save(ProductYeuThich productyeuthich) {
        return productyeuthichRepository.save(productyeuthich);
    }

    @Override
    public Optional<ProductYeuThich> find(Long id) {
        return productyeuthichRepository.findById(id);
    }

    @Override
    public List<ProductYeuThich> findAll() {
        return productyeuthichRepository.findAll();
    }

    @Override
    public List<ProductYeuThich> findAll(Sort sort) {
        return productyeuthichRepository.findAll(sort);
    }

    @Override
    public Page<ProductYeuThich> findAll(Pageable pageable) {
        return productyeuthichRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        productyeuthichRepository.deleteById(id);
    }

    @Override
    public void delete(ProductYeuThich productyeuthich) {
        productyeuthichRepository.delete(productyeuthich);
    }

    @Override
    public void deleteAll() {
        productyeuthichRepository.deleteAll();
    }

    @Override
    public int count() {
        return (int) productyeuthichRepository.count();
    }

    @Override
    public List<ProductWithImageDTO> getAllSpYeuThichByUserId(String userId) {
        List<Integer> listIdProductYeuThich = _yeuthichRepo.getAllIdProductYeuThichByUserId(userId);
        List<Products> listProduct = new ArrayList<>();
        for (Integer i : listIdProductYeuThich) {
            Products tmp = _productRepo.findById(i).get();
            listProduct.add(tmp);
        }
//        List<Products> listProduct = _yeuthichRepo.getAllSpYeuThichByUserId(userId);
        List<ProductWithImageDTO> res = new ArrayList<>();
        for (Products i : listProduct) {
            int idProduct = i.getId();
            ProductWithImageDTO tmp = new ProductWithImageDTO();
            BeanUtils.copyProperties(i, tmp);
            tmp.setImageName(_storageRepo.getImageNameByIdProduct(idProduct));
            res.add(tmp);

        }
        return res;
    }

    @Override
    public ProductYeuThich addNewProductYeuThich(String userId, int productId) {
        Products productTmp = _productRepo.findById(productId).get();
        productTmp.setSoVote(productTmp.getSoVote()+1);
        _productRepo.save(productTmp);
        int count = (int) _yeuthichRepo.count();
        ProductYeuThich tmp;
        if (count == 0) {
            tmp = new ProductYeuThich(1, productId, userId);
        } else {
            int theNewestId = _yeuthichRepo.getTheNewestId();
            tmp = new ProductYeuThich(theNewestId + 1, productId, userId);
        }
        ProductYeuThich res = _yeuthichRepo.save(tmp);

        return res;
    }

}