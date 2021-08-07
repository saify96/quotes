package quotes;

public class Quotes {
    String author;
    String text;

    public Quotes(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString(){
        return "Author : " + this.author +"\nThe Quote " + this.text;
    }
}

