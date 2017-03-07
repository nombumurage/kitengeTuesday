import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserTest {
  User testUser = new User("James", "james@gmail.com", "kitenge_test", "admin");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void user_instantiatesCorrectly_true(){
    User testUser = new User("James", "james@gmail.com", "kitenge_test", "admin");
    assertEquals(true, testUser instanceof User);
  }
  @Test
  public void user_testForGetterMethods_3(){
    assertThat(testUser.getName(), is(equalTo("James")));
    assertThat(testUser.getEmail(), is(equalTo("james@gmail.com")));
    assertThat(testUser.getPassword(), is(equalTo("kitenge_test")));
    assertThat(testUser.getType(), is(equalTo("admin")));
  }
  @Test
  public void equals_returnsTrueIfNameandPasswordAreSame_true(){
      User testUser = new User("James", "james@gmail.com", "kitenge_test", "admin");
      User anotherUser = new User("James", "james@gmail.com", "kitenge_test", "admin");
      assertTrue(testUser.equals(anotherUser));
  }
  @Test
  public void save_insertsObjectIntoDatabase_User(){
    testUser.save();
    assertEquals(true, User.all().get(0).equals(testUser));
  }
  @Test
  public void save_assignsIdToUser() {
    User testUser1 = new User("James", "james@gmail.com", "kitenge_test", "admin");
    testUser1.save();
    User savedUser = User.all().get(0);
    assertEquals(savedUser.getId(), testUser1.getId());
  }
  @Test
  public void all_returnsAllUsers_true(){
    User testUser1 = new User("James", "james@gmail.com", "kitenge_test", "admin");
    testUser1.save();
    User testUser2 = new User("Nombu", "nombu@gmail.com", "kitenge_test", "customer");
    testUser2.save();
    assertEquals(true, User.all().get(0).equals(testUser1));
    assertEquals(true, User.all().get(1).equals(testUser2));
  }
  @Test
  public void find_returnsUserWithSameId_secondUser(){
    User testUser1 = new User("James", "james@gmail.com", "kitenge_test", "admin");
    testUser1.save();
    User testUser2 = new User("Nombu", "nombu@gmail.com", "kitenge_test", "customer");
    testUser2.save();
    assertEquals(User.find(testUser2.getId()), testUser2);
  }
  @Test
  public void update_updateUserInformation_true() {
    User testUser = new User("James", "james@gmail.com", "kitenge_test");
    testUser.save();
    testUser.update("Nombu Murage", "nombu@gmail.com", "kitenge");
    assertEquals("Nombu Murage", User.find(testUser.getId()).getName());
    assertEquals("nombu@gmail.com", User.find(testUser.getId()).getEmail());
    assertEquals("kitenge", User.find(testUser.getId()).getPassword());
  
  }

  @Test
  public void delete_deletesUserFromDB_true() {
    testUser.save();
    testUser.delete();
    assertEquals(0, User.all().size());
  }

  @Test
  public void getCart_CheckIfTIRetrievesAllItems_true() {
    testUser.save();
    Cart newCart= new Cart(testUser.getId(),1,1);
    newCart.save();
    assertEquals(testUser.getCart().contains(newCart), true);
  }
}
