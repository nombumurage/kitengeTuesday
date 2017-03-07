import org.sql2o.*;
import java.util.*;
public class Cart{
  private int userid;
  private int items;
  private int kitengeid;
  private int id;
  public Cart(int userid,int items,int kitengeid){
    this.userid=userid;
    this.items=items;
    this.kitengeid=kitengeid;
}
//override
  @Override
  public boolean equals(Object object){
    if(!(object instanceof Cart)){
      return false;
    }else{
      Cart newCart=(Cart) object;
      return this.getUserId()==newCart.getUserId() &&
       this.getItems()==this.getItems() &&
        this.getKitengeId()==newCart.getKitengeId();
    }
  }

  public int getUserId(){
    return userid;
  }
  public int getItems(){
    return  items;
  }
  public int getKitengeId(){
    return kitengeid;
  }
  public int getId(){
    return id;
  }
  //save methods
  public void save(){
    try(Connection con=DB.sql2o.open()){
      String sql="insert into cart (userid,items,kitengeid) values(:userid,:items,:kitengeid)";
    this.id= (int) con.createQuery(sql,true)
      .addParameter("userid",this.userid)
      .addParameter("items",this.items)
      .addParameter("kitengeid",this.kitengeid)
      .executeUpdate()
      .getKey();
    }
  }
  //all methods
  public static List<Cart> all(){
    try(Connection con=DB.sql2o.open()){
      String sql="select * from cart";
    return con.createQuery(sql)
    .executeAndFetch(Cart.class);
    }
  }
  //find methods
  public static Cart find(int id){
    try(Connection con=DB.sql2o.open()){
      String sql="select * from cart where id=:id";
    return con.createQuery(sql)
      .addParameter("id",id)
    .executeAndFetchFirst(Cart.class);
    }
  }
  //update
  public void update(int userid,int items,int kitengeid){
    try(Connection con=DB.sql2o.open()){
      String sql="update cart set userid=:userid,items=:items,kitengeid=:kitengeid where id=:id";
      con.createQuery(sql)
      .addParameter("userid",userid)
      .addParameter("items",items)
      .addParameter("kitengeid",kitengeid)
      .addParameter("id",this.id)
      .executeUpdate();
    }
  }
  public void delete(){
    try(Connection con=DB.sql2o.open()){
      String sql="delete from cart * where id=:id";
      con.createQuery(sql)
      .addParameter("id",this.id)
      .executeUpdate();
    }
  }

}
