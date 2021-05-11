package Iztechea;
/** 
	An interface that describes the operations of Products.
*/


public interface IProduct {

    /**
     * Sees whether the product is manufactured.
     * @return True if the product is manufactured, or false if not.
     */
    boolean isManufactured();

    /**
     * Sees whether the product is stored
     * @return True if the product is stored, or false if not.
     */
    boolean isStored();

    /**
     * Sees whether the product is sold.
     * @return True if the product is sold, or false if not.
     */
    boolean isSold();
}
