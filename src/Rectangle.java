public class Rectangle{
    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    public Rectangle(){
        this.height = 1;
        this.width = 1;
        this.id = idGen++;
    }

    public Rectangle(double width, double height){
        this();
        setHeight(height);
        setWidth(width);
    }

    public void setHeight(double height) {
        if(height < 0){
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public void setWidth(double width) {
        if(width < 0){
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public int getId() {
        return id;
    }

    public double area() {
        return this.width * this.height;
    }

    public double perimeter() {
        return 2 * this.width + 2 * this.height;
    }

    @Override
    public String toString() {
        return "rectangle, id: " + getId() + ";\n" +
                "width = " + getWidth() + "\n" +
                "height = " + getHeight();
    }
}