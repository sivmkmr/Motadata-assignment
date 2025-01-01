# spring-boot

##	1.	Create a database named Product.
 
##	2.	Modify the application.properties file to configure the database:

      spring.datasource.url = jdbc:mysql://localhost:3306/Product
      spring.datasource.username = dataBaseUserName
      spring.datasource.password = dataBasePassword
 
## 	3.	Uncomment the following lines, then run the application. Once the app is running, comment these lines again:
  
    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void initDB() {
    List<Product> products = Stream.of(
            new Electronics("Dell XPS 13", 129999.99f, 30, "Electronics", "Dell", "XPS 13", 24),
            new Electronics("MacBook Pro 16", 249999.99f, 20, "Electronics", "Apple", "MacBook Pro 16", 36),
            new Electronics("HP Spectre x360", 119999.99f, 15, "Electronics", "HP", "Spectre x360", 12),
            new Electronics("Lenovo ThinkPad X1 Carbon", 134999.99f, 25, "Electronics", "Lenovo", "ThinkPad X1 Carbon", 36),
            new Electronics("Asus ROG Zephyrus G14", 149999.99f, 18, "Electronics", "Asus", "ROG Zephyrus G14", 24),
            new Electronics("Microsoft Surface Laptop 4", 159999.99f, 22, "Electronics", "Microsoft", "Surface Laptop 4", 24),
            new Electronics("Razer Blade 15", 189999.99f, 10, "Electronics", "Razer", "Blade 15", 36),
            new Electronics("Acer Predator Helios 300", 129999.99f, 16, "Electronics", "Acer", "Predator Helios 300", 12),
            new Electronics("Alienware m15 R6", 219999.99f, 12, "Electronics", "Dell", "Alienware m15 R6", 24)
    ).collect(Collectors.toList());
    repository.saveAll(products);
    }
    
##	4.	Hit the Swagger API to test CRUD operations as mentioned in the README.md file on GitHub:

~~~
http://localhost:9191/motadata/swagger-ui/index.html#/
~~~


### Create Product
~~~
http://localhost:9191/motadata/create-product
~~~

~~~
[
  {
    "name": "MacBook",
    "category": "Electronics",
    "price": 1.1,
    "stock": 2,
    "brand": "Apple",
    "modelName": "Macbook pro",
    "warrantyInMonths": 12
  }
]
~~~

### Update Product
~~~
http://localhost:9191/motadata/update-product/?id=1
~~~

~~~
  {
    "name": "MacBook",
    "category": "Electronics",
    "price": 1.1,
    "stock": 2,
    "brand": "Apple",
    "modelName": "Macbook pro",
    "warrantyInMonths": 12
  }
~~~

### Get Product By Id

~~~
http://localhost:9191/motadata/get-product-by-id?id=1
~~~

### Get All Product

~~~
http://localhost:9191/motadata/get-all-products
~~~

### Delete Product By Id

~~~
http://localhost:9191/motadata/delete-by-id?id=1
~~~



