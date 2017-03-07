import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class DesignerTest{
  //rules
  @Rule
  public DatabaseRule database=new DatabaseRule();

  //new instance of the class
  Designer newDesigner= new Designer("ken");

  @Test
  public void getinstance_returnsTrueIfInstanceOfClass(){
    assertTrue(newDesigner instanceof Designer);
  }
  @Test
  public void equals_returnsIfSameInstancesCanEquate(){
      Designer newDesigners= new Designer("ken");
    assertTrue(newDesigner.equals(newDesigners));
  }
  // tesingthe getter methods
  @Test
  public void getUserId_returnsTheUserId(){
    assertEquals("ken",newDesigner.getName());
  }
  @Test
  public void getId_returnsTheId(){
    newDesigner.save();
    assertTrue(newDesigner.getId()>0);
  }


  //testing save methods
  @Test
  public void save_itemIsSavedIntoDatabase(){
    newDesigner.save();
    assertEquals(Designer.all().get(0).getName(), newDesigner.getName());
  }
  //testing the all methods
  @Test
  public void all_checksIfAllInstancesAreReturned(){
    newDesigner.save();
      Designer newDesigners= new Designer("kim");
      newDesigners.save();
      List<Designer> allDesigners=Designer.all();
      assertTrue(allDesigners.contains(newDesigner));
      assertTrue(allDesigners.contains(newDesigners));

  }
  //testing the find methods
  @Test
  public void find_checksIfAllInstancesAreFound(){
    newDesigner.save();
  Designer foundDesigner= Designer.find(newDesigner.getId());
    assertTrue(newDesigner.equals(foundDesigner));

  }
//update
@Test
public void update_checksIfAllInstancesAreUPdated(){
  newDesigner.save();
  newDesigner.update("kim");
  Designer foundDesigner=  Designer.find(newDesigner.getId());
  assertEquals(foundDesigner.getName(),"kim");

}
@Test
public void delete_checksIfAllInstancesAredeleted(){
  newDesigner.save();
  newDesigner.delete();

  assertFalse(Designer.all().contains(newDesigner));

}
@Test
public void getClothes_checksIfAllClothesForTheDesigner(){
    newDesigner.save();
    Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,newDesigner.getId(),"http://dhbdbhbdhb.com");
    newClothes.save();
    Clothes newClotheez = new Clothes("Haskel","short floral pants",10,"medium",3000,newDesigner.getId(),"http://dhbdbhbdhb.com");
    newClotheez.save();
    List<Clothes> designerClothes=newDesigner.getClothes();
    assertTrue(newDesigner.getClothes().contains(newClothes));
    assertEquals(designerClothes.contains(newClotheez),true);
}


}
