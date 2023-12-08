import {FoodItem} from "./foodItem";
import {Restaurant} from "./restaurant";

export interface FoodCatalogue {
  foodItems: FoodItem[];
  restaurant: Restaurant;
}
