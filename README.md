# spring-boot

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



