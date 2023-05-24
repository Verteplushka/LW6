package collectionClasses;

import java.time.ZonedDateTime;

public class SpaceMarine implements Comparable<SpaceMarine> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int health; //Значение поля должно быть больше 0
    private AstartesCategory category; //Поле может быть null
    private Weapon weaponType; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле может быть null

    public SpaceMarine(String name, Coordinates coordinates, int health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = this.hashCode();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;

    }

    public SpaceMarine(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, int health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public String[] getList() {
        return new String[]{this.id.toString(), this.name, this.coordinates.getX().toString(), this.coordinates.getY().toString(), this.creationDate.toString(), Integer.toString(this.health), this.category.toString(), this.weaponType.toString(), this.meleeWeapon.toString(), this.chapter.getName(), this.chapter.getParentLegion(), this.chapter.getMarinesCount().toString()};
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    @Override
    public String toString() {
        return "{id: " + this.id + "; name: " + this.name + "; coordinates: " + this.coordinates + "; creationDate: " + this.creationDate + "; health: " + this.health + "; category: " + this.category + "; weaponType: " + this.weaponType + "; meleeWeapon: " + this.meleeWeapon + "; chapter:" + this.chapter + "}";
    }

    @Override
    public int compareTo(SpaceMarine o) {
        return this.getId() - o.getId();
    }
//
//    @Override
//    public int hashCode() {
//        System.out.println(this.id.hashCode());
//        System.out.println(this.name.hashCode());
//        System.out.println(this.coordinates.hashCode());
//        System.out.println(this.creationDate.hashCode());
//        System.out.println(this.category.hashCode());
//        System.out.println(this.weaponType.hashCode());
//        System.out.println(this.meleeWeapon.hashCode());
//        System.out.println(this.chapter.hashCode());
//        return this.id.hashCode() + this.name.hashCode() + this.coordinates.hashCode() + this.creationDate.hashCode() + this.category.hashCode() + this.weaponType.hashCode() + this.meleeWeapon.hashCode() + this.chapter.hashCode();
//    }
}