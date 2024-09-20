public class Card
{
    private String color;
    private String number;

    public Card(String color, String number)
    {
        this.color = color;
        this.number = number;
    }

    public String getColor()
    {
        return color;
    }

    public String getNumber()
    {
        return number;
    }

    @Override
    public String toString()
    {
        return color + number + "\u001B[0m";
    }
}
