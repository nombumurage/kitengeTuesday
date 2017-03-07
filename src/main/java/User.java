import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class User {
  private String name;
  private String email;
  private String password;
  private String type;
  private int id;

  public static final String [] USER_TYPE = new String[] {"admin", "customer"};

  public User(String name, String email, String password, String type) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.type = type;
  }

  public String getName(){
    return name;
  }
  public String getEmail(){
    return email;
  }
  public String getPassword(){
    return password;
  }
  public String getType(){
    return type;
  }
  public int getId(){
    return id;
  }

  @Override
  public boolean equals(Object otherUser){
    if (!(otherUser instanceof User)) {
      return false;
    } else {
      User newUser = (User) otherUser;
      return this.getName().equals(newUser.getName()) &&
             this.getEmail().equals(newUser.getEmail()) &&
             this.getPassword().equals(newUser.getPassword()) &&
             this.getType().equals(newUser.getType());
    }
  }
  public static List<User> all() {
    String sql = "SELECT * FROM users";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(User.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO users (name, email, password, type) VALUES (:name, :email, :password, :type)";
      this.id = (int) con.createQuery(sql, true)
          .addParameter("name", this.name)
          .addParameter("email", this.email)
          .addParameter("password", this.password)
          .addParameter("type", this.type)
          .executeUpdate()
          .getKey();
    }
  }

  public static User find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users WHERE id=:id";
      User user = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(User.class);
        return user;
    }
  }
  public static User findLogin(String password) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users WHERE password=:password";
      User user = con.createQuery(sql)
        .addParameter("password", password)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(User.class);
        return user;
    }
  }

  public void update(String name, String email, String password) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET name = :name, email = :email, password = :password WHERE id = :id";
      con.createQuery(sql)
         .addParameter("name", name)
         .addParameter("email", email)
         .addParameter("password", password)

         .addParameter("id", id)
         .executeUpdate();
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM users WHERE id =:id; ";
    con.createQuery(sql)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  public List<Cart> getCart() {
    try(Connection con = DB.sql2o.open()) {
    String sql="SELECT * FROM cart where userid=:id";
    return con.createQuery(sql)
    .addParameter("id",id)
    .executeAndFetch(Cart.class);
    }
  }


}
