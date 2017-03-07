import org.junit.rules.ExternalResource;
import org.sql2o.*;
public class DatabaseRule extends ExternalResource{
    @Override
    protected  void before(){
     //DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/kitenge_test","pauline","pauline");
      // DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/kitenge_test","nombu","nombu");
      DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/kitenge_test","james","admin");
    }

    @Override
    protected  void after(){
      try(Connection con =DB.sql2o.open()){
        String deleteUserQuery = "DELETE FROM users *;";
        String sqlCart="delete from cart *";
        String sqlDesigner="delete from designer *";
      	String deleteClothesQuery="Delete from kitenge *;";

        con.createQuery(deleteClothesQuery).executeUpdate();
        con.createQuery(deleteUserQuery).executeUpdate();
        con.createQuery(sqlCart).executeUpdate();
        con.createQuery(sqlDesigner).executeUpdate();


}
    }



  }
