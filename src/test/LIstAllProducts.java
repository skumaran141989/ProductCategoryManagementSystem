package test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import Service.CategoryRepository;
import Service.IProductManagementService;
import Service.ProductManagementService;
import models.Category;
import models.Product;


class ListAllProductsTest {
	
	private CategoryRepository _repo;
	private IProductManagementService _productManagementService;
	
	public ListAllProductsTest()
	{
		_repo = new CategoryRepository();
		
		 Category elect = new Category("Electronics");
		 
		 Category tv = new Category("TV");
		 tv.setParent(elect);
		 tv.AddProducts(new Product("3D-TV", "3D Screen", tv, new BigDecimal(456.790)));
		 tv.AddProducts(new Product("SMART-TV", "SMART Features", tv, new BigDecimal(1001.790)));
		 tv.AddProducts(new Product("LED-TV", "LED Screen", tv, new BigDecimal(1001.790)));
		 
		 Category computer= new Category("Computer");
		 computer.setParent(elect);
		 computer.AddProducts(new Product("Desktop", "Assembled computer", computer, new BigDecimal(256.790)));
		 
		 Category laptop= new Category("Laptop");
		 laptop.setParent(computer);
		 laptop.AddProducts(new Product("Lenovo Laptop", "Lenovo brand Laptop", laptop, new BigDecimal(650.790)));
		 laptop.AddProducts(new Product("Dell Laptop", "Dell brand Laptop", laptop, new BigDecimal(750.790)));
		 
		 computer.AddSubCategory(laptop);
		 
		 Category books= new Category("Books");
		 
		 elect.AddSubCategory(tv);
		 elect.AddSubCategory(computer);
		
		_repo.add("Electronics", elect);
		_repo.add("Books", books);
		_repo.add("TV", tv);
		_repo.add("Laptop", laptop);
		_repo.add("Computer", computer);
		
		_productManagementService = new ProductManagementService(_repo);
	}

	@Test
	void Test_ListAllProductsWithCategory() {
		List<Product>  products = _productManagementService.listAllProductsForCategory("Electronics");
		
		Assertions.assertEquals(6, products.size());
	}
	
	@Test
	void Test_ListAllProductsWithNoSubCategoryCategory() {
		List<Product>  products = _productManagementService.listAllProductsForCategory("Laptop");
		
		Assertions.assertEquals(2, products.size());
	}
	
	@Test
	void Test_ListAllProductsForCategoryWithNoProducts() {
		List<Product>  products = _productManagementService.listAllProductsForCategory("Books");
		
		Assertions.assertEquals(0, products.size());
	}

}
