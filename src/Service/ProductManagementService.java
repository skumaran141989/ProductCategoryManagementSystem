package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import models.Category;
import models.Product;

public class ProductManagementService implements IProductManagementService {
	
	private CategoryRepository _repo;
	
	public ProductManagementService(CategoryRepository repo)
	{
		_repo = repo;
	}

	@Override
	public List<Product> listAllProductsForCategory(String categoryName) {
           
		Category category= _repo.get(categoryName);
		
		List<Product> products = new ArrayList<Product>();
		addAllProducts(category, products);
	
		return products;
	}
	
	
	private void addAllProducts(Category category, List<Product> products)
	{
		products.addAll(category.GetProducts());
		
		List<Category> childCategories = category.GetSubCategories();
		
	    for(Category childCategory: childCategories)
	    	addAllProducts(childCategory, products);
	}

	public String getCategoryPath(String categoryName) {
		
		Category category = _repo.get(categoryName);
		Stack<String> path = new Stack<String>();
		StringBuilder pathValue = new StringBuilder();
		
		do {
			path.push(category.getName());
			category = category.getParent();
		}while(category != null);
		
		while(!path.isEmpty());
	    {
	    	pathValue.append("/");
	    	pathValue.append(path.pop());
	    }
	    
	    return pathValue.toString();
	}
}
