# SpringBootLearning

It contains different projects in spring boot which is example implementation created during learning concepts in spring boot.


[<h4>ORMAPP1</h4>](ORMAPP1)

<p>It contains implementation of <a href="https://spring.io/guides/gs/accessing-data-jpa/">Getting started with Accessing Data with JPA</a> (names for some files not exactly similar to doc) </p>

[<h4>TestApp1</h4>](TestApp1) 
<p>It contains implementation of <a href="https://spring.io/guides/gs/testing-web/">Getting started with Testing the web Layer</a> (names for some files not exactly similar to doc) </p>

[<h4>SecurityApp1</h4>](SecurityApp1)

<p>It contains implementation of <a href="https://spring.io/guides/gs/securing-web/">Getting started with Securing
 Web Application</a
> (names for some files not exactly similar to doc) 
<p><b>New Learning</b></p> 
<l>
<li><a href="http://zetcode.com/springboot/viewcontrollerregistry/">ViewControllerRegistry  </a> - It is used for
 creating simple routes.
</li>
<li><a href="https://stackoverflow.com/questions/8680843/httpservletrequest-getremoteuser-vs-httpservletrequest
-getuserprincipal-getn">HttpServletRequest#getRemoteUser()</a> - Returns the login of the user.</li>
</l>

[<h4>User Registration and Login</h4>](user_registration_and_login)

<p>It contains implementation of <a href="https://medium.com/@kamer.dev/spring-boot-user-registration-and-login-43a33ea19745">Spring Boot User Registration and login</a
> (names for some files not exactly similar to doc) 
<p><b>New Learning</b></p> 
<l>

<li>
    <p>
       <a href="https://projectlombok.org/features/EqualsAndHashCode">@EqualsAndHashCode  </a> - Any class definition may be annotated with @EqualsAndHashCode to        let lombok generate implementations of the equals(Object other) and hashCode() methods. 
   </p>
</li>

<li>
 <p>
 <a href="https://springframework.guru/spring-boot-with-lombok-part-1/#:~:text=You%20can%20use%20the%20%40NoArgsConstructor,and%20%40AllArgsConstructor%20annotations%20is%20this.">@NoArgsConstructor @AllArgsConstructor</a> - You can use the @NoArgsConstructor annotation to generate the default constructor that takes no arguments. To generate a constructor with arguments for all the field, use the @AllArgsConstructor annotation.
 </p>
 
</li>

<li>
  <p>
    <a href="https://www.baeldung.com/lombok-builder-default-value">@Builder.default </a> - 
    Create presence of default values after we build an object with a builder.
  </p>
</li>
<li><a href="http://zetcode.com/springboot/annotations/#:~:text=The%20%40Table%20annotation%20specifies%20the,the%20values%20of%20primary%20keys.
">@Entity @Id</a> - 

Each entity must have at least two annotations defined: @Entity and @Id. 

-> @Entity annotation specifies that the class is an entity and is mapped to a database table. 

-> @Table annotation specifies the name of the database table to be used for mapping. 

-> @Id annotation specifies the primary key of an entity.

-> @GeneratedValue provides for the specification of generation strategies for the values of primary keys.

</li>
</l>

