package collectionClasses;

public class Coordinates {
    private Double x; //Максимальное значение поля: 432, Поле не может быть null
    private Long y; //Значение поля должно быть больше -429, Поле не может быть null
    public Coordinates(Double x, Long y){
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{x: " + this.x + "; y: " + this.y + "}";
    }
}