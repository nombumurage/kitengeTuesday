
import org.junit.*;
import static org.junit.Assert.*;

public class ClothesTest {


@Rule 
public DatabaseRule database = new DatabaseRule();

@Test
public void instanceof_instantiatesTrue(){
	Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");
    assertEquals(true,newClothes instanceof Clothes);
}
@Test
public void getName_instantiatesWithName_String(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");  
  assertEquals("romper",newClothes.getName());
}


@Test
public void getDescription_instantiatesWithDescription_String(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");  
  assertEquals("short floral pants",newClothes.getDescription());
}
@Test
public void getImgUrl_instantiatesWithImage_String(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");  
  assertEquals("http://dhbdbhbdhb.com",newClothes.getImgUrl());
}

@Test
public void getQuantity_instantiatesWithQuantity_int(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");   
 assertEquals(10,newClothes.getQuantity());
}
@Test
public void getPrice_instantiatesWithSize_String(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com"); 
   assertEquals("medium",newClothes.getSize());
}
@Test
public void getPrice_instantiatesWithPrice_int(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");   
 assertEquals(3000,newClothes.getPrice());
}
@Test
public void getDesignerId_instantiatesWithDesignerId_int(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");   
 assertEquals(1,newClothes.getDesignerId());
}

@Test
public void save_savesIntoDatabase_true(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");
    newClothes.save();
    assertEquals(true,Clothes.allClothes().get(0).equals(newClothes));
}
@Test
public void find_findstheClotheatanId_String(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");
    newClothes.save();
    assertEquals(newClothes,Clothes.find(newClothes.getId()));
}

@Test
public void update_updatestheClothe(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");
    newClothes.save();
    newClothes.update("romper short","short floral",20,"small",4000);
    assertEquals("romper short",Clothes.find(newClothes.getId()).getName());
    assertEquals("short floral",Clothes.find(newClothes.getId()).getDescription());
    assertEquals(20,Clothes.find(newClothes.getId()).getQuantity());
    assertEquals("small",Clothes.find(newClothes.getId()).getSize());
    assertEquals(4000,Clothes.find(newClothes.getId()).getPrice());
}

@Test
public void delete_removedClothesFromDatabase_null(){
Clothes newClothes = new Clothes("romper","short floral pants",10,"medium",3000,1,"http://dhbdbhbdhb.com");
    newClothes.save();
    newClothes.delete();
    assertEquals(null,Clothes.find(newClothes.getId()));
}




}
