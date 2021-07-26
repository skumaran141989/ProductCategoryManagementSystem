package Service;
import java.util.HashMap;

import models.Category;


public class CategoryRepository {
      private HashMap<String, Category> _categories;
      
      public CategoryRepository()
      {
    	  _categories = new HashMap<String, Category>();
      }
      
      public void add(String catgeory, Category parent)
      {
    	  _categories.put(catgeory, parent);
      }
      
      public Category get(String category)
      {
    	  return _categories.get(category);
      }
}
