# cotacao-indicador-economico
How do I install it using maven:

Just add to your pom the following repository

```xml
<repositories>
        ...
        <repository>
		<id>cotacao-indicador-economico</id>
		<url>https://github.com/compels/cotacao-indicador-economico/raw/master/target/mvn-repo</url>
	</repository>
        ...
</repositories>
```

And then add your dependency

```xml
<dependencies>
        ...
        <dependency>
		<groupId>cotacao-indicador-economico</groupId>
		<artifactId>cotacao-indicador-economico</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</dependency>
        ...
</dependencies>
```

And that's it!