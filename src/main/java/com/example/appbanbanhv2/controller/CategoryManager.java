package com.example.appbanbanhv2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.appbanbanhv2.entity.Category;
import com.example.appbanbanhv2.service.CategoryService;

@Controller
public class CategoryManager {
    
    @Autowired
    private CategoryService categoryService;
//quản lý danh mục
    @GetMapping("/admin/category")
    public String listCategory(Model model){
        List<Category> cateList = categoryService.findAll();
        model.addAttribute("categorys", cateList);
        return "category";
    }

    @GetMapping("/admin/category/addCategory")
    public String  newCategory(Model model)
    {
        Category category = new Category();
        model.addAttribute("category", category);
        return "create_category";
    }
    
    @PostMapping("/admin/category/addCategory")
    public String saveCategory(@ModelAttribute Category category)
    {
        
        categoryService.save(category);
        return "redirect:/admin/category";
    }
    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id)
    {
        categoryService.delete((long)id);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/edit/{id}")
    public String editCategory(@PathVariable Long id ,Model model)
    {
            model.addAttribute("category", categoryService.find(id).get());
            return "edit_category";

    }

    @PostMapping("/admin/category/{id}")
    public String saveCategory(@PathVariable Long id,@ModelAttribute("category") Category tmp ){
        Category category = categoryService.find(id).get();
        category.setTenCategory(tmp.getTenCategory());
        categoryService.save(category);
        return "redirect:/admin/category" ;

    }
}
