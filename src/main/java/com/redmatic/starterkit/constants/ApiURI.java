package com.redmatic.starterkit.constants;

public class ApiURI {
    public static final String API_BASE_PATH = "/api";
    public static final String BASE_AUTH = "/api/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
    // Base Paths
    public static final String BASE_API_V1 = "/api/v1";
    public static final String ORG_SIGNUP = BASE_API_V1 + "/organizations/signup";
    public static final String POS_SALES = BASE_API_V1 + "/pos/sales";

    // Common HTTP Messages
    public static final String SUCCESS = "Success";
    public static final String FAILED = "Failed";

    // Inventory

    private static final String INVENTORY = "/inventory";
    private static final String INVENTORY_ID = "/{id}";
    private static final String INVENTORY_ITEM = INVENTORY + "/create";
    public static final String INVENTORY_ITEM_BASE = INVENTORY + "/items";
    public static final String INVENTORY_ITEM_GET_ALL = INVENTORY_ITEM;
    public static final String INVENTORY_ITEM_CREATE = INVENTORY_ITEM;
    public static final String INVENTORY_STOCK_TRANSFER = "/transfers";
    public static final String GET_INVENTORY_ITEMS = INVENTORY_ITEM_BASE;
    public static final String INVENTORY_ITEM_GET_BY_ID = INVENTORY + INVENTORY_ID;
    public static final String UPDATE_INVENTORY_ITEM_GET_BY_ID = INVENTORY + INVENTORY_ID + "/edit";
    public static final String DELETE_INVENTORY_ITEM_GET_BY_ID = INVENTORY + INVENTORY_ID + "/delete";


    // Supplier

    public static final String SUPPLIER = "/suppliers";
    private static final String SUPPLIER_ID = "/{id}";
    public static final String GET_ALL_SUPPLIER = SUPPLIER;
    public static final String CREATE_SUPPLIER = SUPPLIER + "/create";
    public static final String UPDATE_SUPPLIER_GET_BY_ID = SUPPLIER + SUPPLIER_ID + "/edit";
    public static final String DELETE_SUPPLIER_ITEM_GET_BY_ID = SUPPLIER + SUPPLIER_ID + "/delete";

    // Brand
    public static final String BRANDS = "/brands";
    private static final String BRANDS_ID = "/{id}";
    public static final String GET_ALL_BRANDS = BRANDS;
    public static final String CREATE_BRANDS = BRANDS + "/create";
    public static final String UPDATE_BRANDS_GET_BY_ID = BRANDS + BRANDS_ID + "/edit";
    public static final String DELETE_BRANDS_ITEM_GET_BY_ID = BRANDS + BRANDS_ID + "/delete";

    // Category
    public static final String CATEGORIES = "/categories";
    private static final String CATEGORIES_ID = "/{id}";
    public static final String GET_ALL_CATEGORIES = CATEGORIES;
    public static final String CREATE_CATEGORIES = CATEGORIES + "/create";
    public static final String UPDATE_CATEGORIES_GET_BY_ID = CATEGORIES + CATEGORIES_ID + "/edit";
    public static final String DELETE_CATEGORIES_ITEM_GET_BY_ID = CATEGORIES + CATEGORIES_ID + "/delete";

    //Branch
    public static final String BRANCHES = "/branches";
    private static final String BRANCHES_ID = "/{id}";
    public static final String GET_ALL_BRANCHES = BRANCHES;
    public static final String CREATE_BRANCHES = BRANCHES + "/create";
    public static final String GET_BRANCH_GET_BY_ID = BRANCHES + BRANCHES_ID;
    public static final String UPDATE_BRANCH_BY_ID = BRANCHES + BRANCHES_ID + "/edit";
    public static final String DELETE_BRANCH_BY_ID = BRANCHES + BRANCHES_ID + "/delete";

    private ApiURI() {
        // prevent instantiation
    }
}
