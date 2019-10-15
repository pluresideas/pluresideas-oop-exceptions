Kapralov Sergey in his series of blog posts wrote his
[opinion](https://www.pragmaticobjects.com/chapters/001_checked_exceptions.html)
about handling checked exceptions which are not in our control.
He suggested to wrap them to unchecked exceptions.
His reasoning is that there are unchecked exceptions that we do not handle anyway. 

However, I think there is yet another solution, to wrap checked exception and return `Optional.empty()`.
I borrowed his code from the blog and modified with `Optional`:

```java
class FracFromFile implements Fraction {
    private final File file;

    public FracFromFile(File file) {
        this.file = file;
    }

    public final Optional<Integer> numerator() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return Optional.of(Integer.parseInt(
                    reader.readLine().split("/")[0]
            ));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public final Optional<Integer> denominator() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return Optional.of(Integer.parseInt(
                    reader.readLine().split("/")[1]
            ));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
``` 
