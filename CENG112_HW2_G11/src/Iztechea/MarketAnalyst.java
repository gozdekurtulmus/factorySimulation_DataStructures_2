package Iztechea;

public class MarketAnalyst {

    private FactoryLine<Product> factoryLine;

    public MarketAnalyst(){
    	 this.factoryLine = new FactoryLine<>();
    }

    public void printManufactured(int choice){
        Product product = factoryLine.manufacture(choice);
        System.out.println("Marketing Analyst requesting "+ product.getName()+ ", SUCCESS, " + product.getName() + " manufactured.");
    }

    public void printNumberManufactured(){
        factoryLine.totalNumberManufactured();
    }

    public  QueueInterface<Product> getFactoryLine(){
 	   return factoryLine.getFactoryLine();
    }



}
