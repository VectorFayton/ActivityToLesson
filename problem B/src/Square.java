public class Square extends Rectangle
{
    public Square()
    {

    }

    public Square(double side)
    {
        super(side, side);
    }

    public Square(double side, String color, boolean filled)
    {
        super(side, side, color, filled);
    }

    public double getSide()
    {
        return super.getLength();
    }

    public void setWidth(double wid)
    {
        super.setLength(wid);
    }

    public void setLength(double len)
    {
        super.setWidth(len);
    }

    public String toString()
    {
        return "Square[" + super.toString() + "]";
    }
}