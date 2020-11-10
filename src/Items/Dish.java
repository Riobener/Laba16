package Items;

public class Dish implements MenuItem {
    private int cost;
    private String name;
    private String description;
    private double dishVal;
    private int value;
    private DishTypeEnum type;
    public Dish(DishTypeEnum type, int value){
        switch (type){
            case STEAK:
                name = type.name();
                description = type.name()+" Chto to eshe";
                dishVal = 240;
                cost = 321;
                break;
            case PIE:
                name = type.name();
                description = type.name()+" Chto to eshe";
                dishVal = 240;
                cost = 455;
                break;
            case FISH:
                name = type.name();
                description = type.name()+" Chto to eshe";
                dishVal = 240;
                cost = 222;
                break;
            case CHIPS:
                name = type.name();
                description = type.name()+" Chto to eshe";
                dishVal = 240;
                cost = 111;
                break;
            case POTATO:
                name = type.name();
                description = type.name()+" Chto to eshe";
                dishVal = 240;
                cost = 50;
                break;
        }
        this.value = value;
        this.dishVal = cost;
        this.type = type;
        this.name = type.name();
    }
    public DishTypeEnum getType(){
        return type;
    }
    public int getValue(){
        return value;
    }
    public int getCost() {
        return cost;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
