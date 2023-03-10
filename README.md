# pc-hi

**V1.0.0 - CRUD Example with JDBC**

    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.31</version>
    </dependency>

Need to use a singleton pattern to the database connection

**v2.0.0 - CRUD Example with JPA**

     <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.31</version>
      </dependency>

      <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.5.7.Final</version>
      </dependency>

src/main/resources/META-INF/persistence.xml

   <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
        http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
        <persistence-unit name="laptop_persist">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
            <properties>
            <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
            <property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/device_store"/>
            <property name="hibernate.connection.autocommit" value="false"/>
            <property name="hibernate.connection.username" value="root"/>
            <property name="hibernate.connection.password" value="19940306"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect"/>
            <property name="hibernate.connection.CharSet" value="utf8"/>
            <property name="hibernate.connection.characterEncoding" value="utf8"/>
            <property name="hibernate.connection.useUnicode" value="true"/>
            <property name="hibernate.show_sql" value="false"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>
  
EntityManager...

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laptop_persist");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(laptop);
    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
    
    
Need to use class name(Laptop) in the queries as follows.
    
    @Entity
    @Table(name = "laptop")
    @NamedQueries({
        @NamedQuery(name = "Laptop.getAllLaptopDetails", query = "SELECT lap FROM Laptop lap"),
        @NamedQuery(name = "Laptop.deleteGivenLaptop", query = "DELETE FROM Laptop lap WHERE lap.lapId= :id"),
        @NamedQuery(name = "Laptop.updateGivenLaptop", query = "UPDATE Laptop lap SET lap.brandName = :brand, lap.modelName = :model, lap.serialNumber =           :serial  WHERE lap.lapId= :id")
     })
     
cascade type can use to update the depenency objects    
    
     @ManyToOne(cascade = CascadeType.ALL)
     
To maintain the ManyToMany relationship, we can use jointable for it

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "laptop_printer", joinColumns = @JoinColumn(name = "lap_id"), inverseJoinColumns = @JoinColumn(name = "printer_id"))
    private Set<Printer> printers;  
    
    @ManyToMany(mappedBy = "printers")
    private Set<Laptop> laptops;
    
Mapped by will help to handover the ownership
     
