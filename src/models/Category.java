package models;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String _name;
	private Category _parent;
	private List<Category> _childCategories;
	private List<Product> _products;
	
	
	public Category(String name)
	{
		_childCategories = new ArrayList<Category>();
		_products = new ArrayList<Product>();
		_name= name;
	}
	
	public void setName(String name)
	{
		_name= name;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setParent(Category parent)
	{
		_parent= parent;
	}
	
	public Category getParent()
	{
		return _parent;
	}
	
	public void AddProducts(Product product)
	{
		_products.add(product);
	}
	
	public List<Product> GetProducts()
	{
		return _products;
	}
	
	public void AddSubCategory(Category category)
	{
		_childCategories.add(category);
	}
	
	public List<Category> GetSubCategories()
	{
		return _childCategories;
	}
}
