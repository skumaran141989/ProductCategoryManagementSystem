package models;
import java.math.BigDecimal;

public class Product {

	private String _name;
	private String _description;
	private BigDecimal _price;
	private Category _parent;
	
	public Product(String name, String description, Category parent, BigDecimal price)
	{
		_name= name;
		_description = description;
		_parent = parent;
		_price = price;
	}
	
	public void setName(String name)
	{
		_name= name;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setDescription(String description)
	{
		_description= description;
	}
	
	public String getDescription()
	{
		return _description;
	}
	
	
	public void setPrice(BigDecimal price)
	{
		_price= price;
	}
	
	public BigDecimal getPrice()
	{
		return _price;
	}
	
	public void setParent(Category parent)
	{
		_parent= parent;
	}
	
	public Category getParent()
	{
		return _parent;
	}
}
