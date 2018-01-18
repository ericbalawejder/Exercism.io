class Triangle
{
    public static void main(String[] args) throws TriangleException
    {
        Triangle triangle = new Triangle(9, 40, 41);
        System.out.println(triangle.isEquilateral());
        System.out.println(triangle.isIsosceles());
        System.out.println(triangle.isScalene());
    }
    
    private double side1;
    private double side2;
    private double side3;
    
    Triangle(double side1, double side2, double side3) throws TriangleException
    {
        if (side1 == 0 && side2 == 0 && side3 == 0)
        {
            throw new TriangleException("Triangles with no size are illegal");
        }
        if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1)
        {
            throw new TriangleException("Fails triangle inequality: x + y >= z");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    boolean isEquilateral()
    {
        return side1 == side2 && side2 == side3;
    }

    boolean isIsosceles()
    {
        return side1 == side2 || side1 == side3 || side2 == side3;
    }

    boolean isScalene()
    {
        return side1 != side2 && side1 != side3 && side2 != side3;
    }
}
