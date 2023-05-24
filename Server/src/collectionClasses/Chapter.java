package collectionClasses;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
    private Long marinesCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000

    public Chapter(String name, String parentLegion, Long marinesCount){
        this.name = name;
        this.parentLegion = parentLegion;
        this.marinesCount = marinesCount;
    }

    public String getName() {
        return name;
    }

    public Long getMarinesCount() {
        return marinesCount;
    }

    public String getParentLegion() {
        return parentLegion;
    }

    @Override
    public String toString(){
        return "{name: " + this.name + "; parentLegion: " + this.parentLegion + "; marineCount: " + this.marinesCount + "}";
    }
}