# spring-boot-crud-example-with-mysql
spring-boot-crud-example-with-mysql

See step by step complete example from scratch here (https://www.netsurfingzone.com/spring-boot/spring-boot-crud-example-with-mysql/).

===
Create a Student using:- POST – http://localhost:9091/student/create

Request and Response data to create Student.

{
"name":"dasu",
"rollNumber":"0126CS071"
}

----
{
    "id": 1,
    "name": "dasu",
    "rollNumber": "0126CS071"
}

==
Update Student using:- PUT– http://localhost:9091/student/update


Request and Response data for update Operation. Let’s update the name.

{
    "id": 1,
    "name": "dasu",
    "rollNumber": "0126CS071"
}

-----

{
    "id": 1,
    "name": "dasu",
    "rollNumber": "0126CS071"
}

===
Create multiple Students using:- POST – http://localhost:9091/student/bulkcreate

Request Data ofr bulk create.

[
    {
        "name": "rakesh",
        "rollNumber": "0126CS071"
    },
    {
        "name": "Rohit",
        "rollNumber": "0126CS072"
    },
    {
        "name": "Nayak",
        "rollNumber": "0126CS073"
    }
]
---
[
    {
        "id": 1,
        "name": "rakesh",
        "rollNumber": "0126CS071"
    },
    {
        "id": 2,
        "name": "Rohit",
        "rollNumber": "0126CS072"
    },
    {
        "id": 3,
        "name": "Nayak",
        "rollNumber": "0126CS073"
    }
]
===
Reference:
https://www.netsurfingzone.com/spring-boot/spring-boot-crud-example-with-mysql/

