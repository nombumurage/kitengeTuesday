import org.junit.*;
import static org.junit.Assert.*;
public class CartTest{
  //rules
  @Rule
  public DatabaseRule database=new DatabaseRule();

  //new instance of the class
  Cart newCart= new Cart(1,1,1);

  @Test
  public void getinstance_returnsTrueIfInstanceOfClass(){
    assertTrue(newCart instanceof Cart);
  }
  @Test
  public void equals_returnsIfSameInstancesCanEquate(){
      Cart newCarts= new Cart(1,1,1);
    assertTrue(newCart.equals(newCarts));
  }
  // tesingthe getter methods
  @Test
  public void getUserId_returnsTheUserId(){
    assertEquals(1,newCart.getUserId());
  }
  @Test
  public void getId_returnsTheId(){
    newCart.save();
    assertTrue(newCart.getId()>0);
  }
  @Test
  public void getItems_returnsTheItems(){
    assertEquals(1,newCart.getItems());
  }
  @Test
  public void getKitengeId_returnsTheKitengeId(){
    assertEquals(1,newCart.getKitengeId());
  }
  //testing save methods
  @Test
  public void save_itemIsSavedIntoDatabase(){
    newCart.save();
    assertEquals(Cart.all().get(0),newCart);
  }
  //testing the all methods
  @Test
  public void all_checksIfAllInstancesAreReturned(){
    newCart.save();
      Cart newCarts= new Cart(3,4,1);
      newCarts.save();
      assertTrue(Cart.all().contains(newCart));
      assertTrue(Cart.all().contains(newCarts));

  }
  //testing the find methods
  @Test
  public void find_checksIfAllInstancesAreFound(){
    newCart.save();
  Cart foundCart=  Cart.find(newCart.getId());
    assertTrue(newCart.equals(foundCart));

  }
//update
@Test
public void update_checksIfAllInstancesAreUPdated(){
  newCart.save();
  newCart.update(3,4,1);
  Cart foundCart=  Cart.find(newCart.getId());
  assertEquals(foundCart.getUserId(),3);

}
//delete
@Test
public void delete_checksIfAllInstancesAredeleted(){
  newCart.save();
  newCart.delete();

  assertFalse(Cart.all().contains(newCart));

}

}
