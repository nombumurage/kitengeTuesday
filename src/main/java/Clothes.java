import java.util.*;
import org.sql2o.*;


public class Clothes extends Kitenge{

	public static final String DATABASE_TYPE="clothes";

	public Clothes(String name, String description, int quantity,  String size, int price,int designerId,String imgUrl){
		this.name = name;
		this.description= description;
		this.designerId=designerId;
		this.price=price;
		this.quantity=quantity;
		this.size=size;
		this.imgUrl=imgUrl;
		type=DATABASE_TYPE;

	}


  public static Clothes find(int id){
  	try (Connection con = DB.sql2o.open()){
  		String sql = "select * from kitenge where id=:id";
  		Clothes clothes = con.createQuery(sql)
  		.addParameter("id",id)
  		.throwOnMappingFailure(false)
  		.executeAndFetchFirst(Clothes.class);
  		return clothes;
  	}
  }

public static List<Clothes> allClothes(){
	String sql ="select * from kitenge where type=type";
	try(Connection con = DB.sql2o.open()){
		return con.createQuery(sql)
		.executeAndFetch(Clothes.class);
	}
}
}
