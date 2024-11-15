public class Floor {

    private final int width;
    private final int dept;

    public Floor(int width, int dept){
        if(width <= 0 || dept <= 0) {
            throw new IndexOutOfBoundsException("Floor needs to have a size bigger than zero");
        }
        this.width = width;
        this.dept = dept;
    }

    public int getWidth() {
        return width;
    }

    public int getDept() {
        return dept;
    }

    void checkBoundaries(int x, int y) {
        if(x < 0 || x > width || y < 0 || y > dept) {
            throw new IndexOutOfBoundsException("You are outside of your floor");
        }
    }
    
}