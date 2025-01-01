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
    "name": "Macbook",
    "category": "Laptop",
    "price": 1.1,
    "stock": 2
  }
]
~~~

### Update Product
~~~
http://localhost:9191/motadata/update-product/?id=1
~~~

~~~
{
  "name": "HP Pavilion",
  "category": "laptop",
  "price": 1.2,
  "stock": 3
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



