# JDK11 features

## Running .java File with Single Command (SingleCommandRun.java)
`java SingleCommandRun.java`

Previously we had to compile the .java class with `javac` to generate `.class` file. It is not required any more. The `.class` files is generated and use in memory.

This feature provides also 'shebang' support:
```shell script
#!/usr/bin/java --source 11
public class Hello {
    public static void main(String.. args) {
        System.out.println("Hello!");
    }
}
```
It is necessary to specify the `-source` version of Java to use.

Another thing is the file must not be named with `.java` extension. You can leave the extension or use for example the `.sh`.

## New Methods in String Class (NewStringMethods.java)
```java
print("".isBlank());                            // true
print("content".isBlank());                     // false

print("one\ntwo\nthree".lines().count());       // 3
print("one\ntwo\nthree".lines());               // Stream<String>

print(" \n \t text \t \n  ".strip());           // "text"
print(" \n \t text \t \n  ".stripLeading());    // "text \t \n"
print(" \n \t text \t \n  ".stripTrailing());   // " \n \t text"

print("x; ".repeat(3));                         // "x; x; x; "
```

## Writing and Reading string to/from files (StringToFromFile.java)
```java
Path filePath = Path.of(".", "data.txt");
filePath = Files.writeString(filePath, "Some important content");
String readContent = Files.readString(filePath);
```

## Local-Variable Syntax for Lambda Parameters
We can already define a lambda parameter without a type since JDK 8:
```java
Consumer<String> dataConsumer = (data) -> System.out.println(data);
```
But problem occurs when we want to annotate it. Then we would have to specify it's type:
```java
Consumer<String> dataConsumer = (@NotNull String data) -> System.out.println(data);
```
With JDK 11 we can do it with `var` as well:
```java
Consumer<String> dataConsumer = (@NotNull var data) -> System.out.println(data);
```

## Notable Additions to APIs (NotableApi.java)
### `.isEmpty()` method in Optional like classes:
```java
Optional<String> name = names.stream()...findANy();
if(name.isEmpty()) {
    ...
}
```

### `not()` method for Predicates
```java
nameStream.filter(name -> !name.startsWith"A");
nameStream.filter(Predicate.not(name -> name.startsWith("A")));
```
This can be nicely used with e.g. `isBlank()` method from `String`:
```java
nameStream.filter(not(String::isBlank));
```

### `convert()` in TImeUnits
Convert duration to number of given units:
```java
LocalDateTime start = LocalDateTime.now();
LocalDateTime stop = LocalDateTime.now().plusHours(12).plusMinutes(12);
long seconds = TimeUnit.SECONDS.convert(Duration.between(start, stop));
```

### nullStreams
In `InputStream`, `OutputStream`, `Reader` and `Writer` classes we now have null stream methods:
```java
var nullIs = InputStream.nullInputStream();
var nullOs = OutputStream.nullOutputStream();
var nullReader = Reader.nullReader();
var nullWriter = Writer.nullWriter();
```
You can think of them like `/dev/null` for throwing away an output you don’t need or providing an input that always returns zero bytes.