package Service;

import java.util.List;

import models.Product;


public interface IProductManagementService {

	public List<Product> listAllProductsForCategory(String category);
	public String getCategoryPath(String category);
}
