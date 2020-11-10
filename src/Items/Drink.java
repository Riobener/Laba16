package Items;


public class Drink implements MenuItem {
    private int cost;
    private String name;
    private String description;
    private double alcoholVal;
    private int value;
    private DrinkTypeEnum type;
    public Drink(DrinkTypeEnum type, int value){
        switch (type){
            case BEER:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case WINE:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case VODKA:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case  BRANDY:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case CHAMPAGNE:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case WHISKEY:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case TEQUILA:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case RUM:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case VERMUTH:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case LIQUOR:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case JAGERMEISTER:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case JUICE:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case GREEN_TEA:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case BLACK_TEA:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case MILK:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case WATER:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case SODA:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;
            case COFFE:
                name = type.name();
                description = type.name()+" Chto to eshe";
                alcoholVal = 0.5;
                cost = 350;
                break;

        }
        this.value = value;
        this.alcoholVal = cost;
        this.type = type;
        this.name = type.name();
    }
    public DrinkTypeEnum getType(){
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
