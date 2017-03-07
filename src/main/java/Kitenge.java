import java.util.*;
import org.sql2o.*;


public abstract class Kitenge {
	public String name;
	public String description;
	public String size;
	public int quantity;
	public int price;
	public int designerId;
    public String type;
    public int id;
    public String imgUrl;

    public int getId(){
    	return id;
    }

    public String getName(){
    	return name;
    }

    public String getDescription(){
    	return description;
    }	
 
    public String getSize(){
    	return size;
    }
   
   public int getPrice(){
   	   return price;
   }

   public int getDesignerId(){
   	  return designerId;
   }
    
   public int getQuantity(){
   	return quantity;
   }
   public String getImgUrl(){
   	return imgUrl;
   }

@Override
public boolean equals(Object otherKitenge){
	if(!(otherKitenge instanceof Kitenge)){
		return false;
	}
	else{
		Kitenge newKitenge = (Kitenge) otherKitenge;
		return this.getName().equals(newKitenge.getName())&&
		        this.getDescription().equals(newKitenge.getDescription())&&
		        this.getQuantity() == (newKitenge.getQuantity())&&
		        this.getPrice() == (newKitenge.getPrice())&&
		        this.getSize().equals(newKitenge.getSize())&&
		        this.getDesignerId() == newKitenge.getDesignerId()&&
		        this.getId() == newKitenge.getId();

	}
}

public void save(){
	try(Connection con = DB.sql2o.open()){
       String sql = "insert into kitenge (name,description,quantity,size,designerId,type,price,imgurl) values (:name,:description,:quantity,:size,:designerId,:type,:price,:imgurl)";
	   this.id = (int) con.createQuery(sql,true)
	   .addParameter("name",this.name)
	   .addParameter("description",this.description)
	   .addParameter("quantity",this.quantity)
	   .addParameter("size",this.size)
	   .addParameter("designerId",this.designerId)
	   .addParameter("type",this.type)
	   .addParameter("imgurl",this.imgUrl)
	   .addParameter("price",this.price)
	   .executeUpdate()
	   .getKey();

	  }
}

public static List<Object> all(){
	String sql ="select * from kitenge";
	try(Connection con = DB.sql2o.open()){
		return con.createQuery(sql)
		.executeAndFetch(Object.class);
	}
}

public void update(String name, String description, int quantity,String size, int price){
	try(Connection con = DB.sql2o.open()){
		String sql = "update kitenge  set name=:name,description=:description,quantity=:quantity,size=:size,type=:type,price=:price,imgurl=:imgurl where id=:id";
	    con.createQuery(sql)
	    .addParameter("name",name)
	    .addParameter("description",description)
	    .addParameter("quantity",quantity)
	    .addParameter("size",size)
	    .addParameter("type",this.type)
	    .addParameter("price",price)
	    .addParameter("imgurl",this.imgUrl)
	    .addParameter("id",this.id)
	    .executeUpdate();
}
}

public void delete(){
	try(Connection con =DB.sql2o.open()){
		String sql = "delete from kitenge where id=:id";
        con.createQuery(sql)
        .addParameter("id",this.id)
        .executeUpdate();
	}
}
}
