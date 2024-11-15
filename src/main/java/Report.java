

public class Report {

    private Position position;

    public Report(Position position) {
        this.position = position;
    }
 
    
    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + position.getDirection();
    }
}
