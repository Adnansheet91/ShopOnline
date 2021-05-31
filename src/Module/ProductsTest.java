package Module;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {



    Products products=new Products ("Sofa","300","A");




    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals ("Sofa", products.getName ());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        products.setName ("Chair");
        assertEquals ("Chair", products.getName ());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals ("300", products.getPrice ());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        products.setPrice ("100");
        assertEquals ("100", products.getPrice ());
    }

    @org.junit.jupiter.api.Test
    void getQuality() {
        assertEquals ("A", products.getQuality ());
    }

    @org.junit.jupiter.api.Test
    void setQuality() {
        products.setQuality ("B");
        assertEquals ("B", products.getQuality ());

    }
}