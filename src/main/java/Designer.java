import org.sql2o.*;
import java.util.*;
public class Designer{

  private String name;
  private int id;
  public Designer(String name){
    this.name=name;
}
//override
  @Override
  public boolean equals(Object object){
    if(!(object instanceof Designer)){
      return false;
    }else{
      Designer newDesigner=(Designer) object;
      return this.getName().equals(newDesigner.getName());

    }
  }
  public String getName(){
    return name;
  }
  public int getId(){
    return id;
  }
public void save(){
  try(Connection con=DB.sql2o.open()){
    String savesql="insert into  designer (name) values(:name);";
  this.id=(int)  con.createQuery(savesql,true)
    .addParameter("name",this.name)
    .executeUpdate()
    .getKey();
  }
}
  //all methods
  public static List<Designer> all(){
    try(Connection con=DB.sql2o.open()){
      String sql="select * from designer";
    return con.createQuery(sql)
    .executeAndFetch(Designer.class);
    }
  }
  //find methods
  public static Designer find(int id){
    try(Connection con=DB.sql2o.open()){
      String sql="select * from designer where id=:id";
    return con.createQuery(sql)
      .addParameter("id",id)
    .executeAndFetchFirst(Designer.class);
    }
  }
  //update
  public void update(String name){
    try(Connection con=DB.sql2o.open()){
      String sql="update designer set name=:name where id=:id";
      con.createQuery(sql)
      .addParameter("name",name)
      .addParameter("id",this.id)

      .executeUpdate();
    }
  }
  //delete
  public void delete(){
    try(Connection con=DB.sql2o.open()){
      String sql="delete from designer * where id=:id";
      con.createQuery(sql)

      .addParameter("id",this.id)

      .executeUpdate();
    }
  }
  //get vitenges
  public List<Clothes> getClothes(){
    try(Connection con=DB.sql2o.open()){
      String sql="select * from kitenge where designerid =:id";
      return con.createQuery(sql)
      .addParameter("id",this.id)
      .executeAndFetch(Clothes.class);
    }
  }


}
