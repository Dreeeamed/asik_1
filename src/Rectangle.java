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

    public double area(double width, double height) {
        return width * height;
    }

    public double perimeter(double width, double height) {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return "id = " + id +
                "width = " + width +
                "height = " + height;
    }
}