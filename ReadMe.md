# CENG 112 - Data Structures

# Assignment 2:Furniture Manufacturing and OrderingSystem

In this homework,you are expected to implement a “Furniture Manufacturing and Ordering
System” application using Java. This homework will cover the topics given below;

1. Strings, Arrays, Generics
2. Queue ADT (Abstract Data Type)
3. Stack ADT (Abstract Data Type)

Assume that you are a Furniture Manufacturer called “ _IZTECHEA_ ”, that manufactures
different types of furniture.However,you immediatel ymanufacture furniture according to the
order that comes fromy our **_MarketingAnalyst_** and you store it in **one factory line** that is
based on a First-In-First-Out(FIFO) structure. **_MarketingAnalyst_** randomly generates what
to be produced and sends the request to the “ _IZTECHEA”_ .Your factory manufactures 6
different types of products, where all of them must implement the **IProduct interface** ;

1. Sofa
2. Bed
3. Chair
4. Dresser
5. Table
6. Bookcase

The methods for interface IProduct is given below:
```
public interface IProduct {
● public boolean isManufactured();
● public boolean isStored();
● public boolean isSold();
}
```
When you manufacture a product, it is temporarily stored in the factory (productionline) until
the **_StorageChief_** moves(i.e.,“stores”) it into a warehouse.Note that,a teach request,the
**_StorageChief_** _takes_ one product from the factoryline,i.e.queue, and stores each product
in its own warehouse. Thereby, you will have **six warehouses**. The warehouses are
designed to retrieve the first product that has bee nrecently added to your warehouse.In
other words, furniture is stored in Last-In-First-Out(LIFO) order.

Whena **_customer_** comes to buy any furniture,that furniture is decided randomly,and a
**_customer_** request is formed accordingly.Based on the requested furniture, you find the
corresponding warehouse and remove/pop it from the warehouse to sell it to the customer.If
you don’t have the requested product in the respective warehouse, you should return a _FAIL_
message. If you have it, yous hould return a _SUCCESS_ message. _FAIL_ and _SUCCESS_
messages work in the same way for the marketing analyst and storage.


Write a simulation that randomly receives requests from **_MarketingAnalyst_** , **_StorageChief_** ,
and **_Customer_** .There is only one object representing each role. **You should only ask the
user to enter a single input that is the number of requests for the simulation.** After all
the requests are completed, you should print a report that shows the number of products in
the factory, in the warehouse, and that is sold.

# The main structure of the program is given as a pseudocode:

r1 chooses among Marketing Analyst, Storage Chiefand Customer.

r2 chooses among Sofa, Bed, Chair, Dresser, Table,Bookcase.
```
Input number of requests
products[] {Sofa, Bed, Chair, Dresser, Table, Bookcase}
from 1 to number of requests
select a random number r1 in [0,2] # 3 roles (i.e.activities)
if r1 = 0
select a random number r2 in [0,5] # 6 typesof furniture
product = products[r2]
trigger Marketing Analyst for product
endif
if r1 = 1
trigger Storage Chief
endif
if r1 = 2
select a random number r2 between 0-5 # 6 types of furniture
product = products[r2]
trigger Customer for product
endif
product = null
end
```
## An example input/output is given below:

_Enter the number of random request cycles: 13_

_1._ **_Customer_** _buying Table,_ **_FAIL_** _, Table warehouse empty
2._ **_Marketing Analyst_** _requesting Bed,_ **_SUCCESS_** _, Bed manufactured
3._ **_Marketing Analyst_** _requesting Bed,_ **_SUCCESS_** _, Bed manufactured
4._ **_Customer_** _buying Bed,_ **_FAIL_** _, Bed warehouse empty
5._ **_Marketing Analyst_** _requesting Sofa,_ **_SUCCESS_** _, Sofa manufactured
6._ **_Storage Chief_** _storing Bed,_ **_SUCCESS_** _, Bed stored in Bed warehouse
7._ **_Storage Chief_** _storing Bed,_ **_SUCCESS_** _, Bed stored in Bed warehouse
8._ **_Customer_** _buying Bed,_ **_SUCCESS_** _, Customer bought Bed
9._ **_StorageChief_** _storing Sofa,_ **_SUCCESS_** _, Sofa stored in Sofa warehouse
10._ **_MarketingAnalyst_** _requesting Chair,_ **_SUCCESS_** _, Chair manufactured
11._ **_Storage Chief_** _storing Chair,_ **_SUCCESS_** _, Chair stored in Chair warehouse
12._ **_Customer_** _buying Chair,_ **_SUCCESS_** _, Customer bought Chair
13._ **_Marketing Analyst_** _requesting Sofa,_ **_SUCCESS_** _, Sofa manufactured_


_REPORT:_

_Amount of Bed in Factory Line: 0
Amount of Sofa in Factory Line: 1
Amount of Dresser in Factory Line: 0
Amount of Table in Factory Line: 0
Amount of Chair in Factory Line: 0
Amount of Bookcase in Factory Line: 0_

_Amount of Bed in Bed Warehouse: 1
Amount of Sofa in Sofa Warehouse: 1
Amount of Dresser in Dresser Warehouse: 0
Amount of Table in Table Warehouse: 0
Amount of Chair in Chair Warehouse: 0
Amount of Bookcase in Bookcase Warehouse: 0_

_Amount of Bed Sold: 1
Amount of Sofa Sold: 0
Amount of Dresser Sold: 0
Amount of Table Sold: 0
Amount of Chair Sold: 1
Amount of Bookcase Sold: 0_
