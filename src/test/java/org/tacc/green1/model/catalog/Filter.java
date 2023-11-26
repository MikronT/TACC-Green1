package org.tacc.green1.model.catalog;

@SuppressWarnings("unused")
public interface Filter {
    String NAME_CATEGORY = "category",
            NAME_STYLE = "style",
            NAME_SIZE = "size",
            NAME_PRICE = "price",
            NAME_COLOR = "color",
            NAME_MATERIAL = "material",
            NAME_ECO_COLLECTION = "eco collection",
            NAME_PERFORMANCE_FABRIC = "performance fabric",
            NAME_ERIN_RECOMMENDS = "erin recommends",
            NAME_NEW = "new",
            NAME_SALE = "sale",
            NAME_PATTERN = "pattern",
            NAME_CLIMATE = "climate",
            NAME_ACTIVITY = "activity",
            NAME_GENDER = "gender",
            NAME_FEATURES = "features",
            NAME_STRAP_HANDLE = "strap/handle";


    interface Color {
        String BLACK = "black",
                BLUE = "blue",
                BROWN = "brown",
                GRAY = "gray",
                GREEN = "green",
                LAVENDER = "lavender",
                ORANGE = "orange",
                PURPLE = "purple",
                RED = "red",
                WHITE = "white",
                YELLOW = "yellow";
    }


    interface Style {
        String INSULATED = "insulated",
                JACKET = "jacket",
                LIGHTWEIGHT = "lightweight",
                HOODED = "hooded",
                HEAVY_DUTY = "heavy duty",
                RAIN_COAT = "rain coat",
                HARD_SHELL = "hard shell",
                SOFT_SHELL = "soft shell",
                WINDBREAKER = "windbreaker",
                QUOTER_ZIP = "¼ zip",
                FULL_ZIP = "full zip",
                REVERSIBLE = "reversible",
                BRA = "bra",
                SWEATSHIRT = "sweatshirt",
                TANK = "tank",
                TEE = "tee",
                PULLOVER = "pullover",
                HOODIE = "hoodie",
                CAMISOLE = "camisole";
    }
}