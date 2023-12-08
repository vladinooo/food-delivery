import {FoodItem} from "../../shared/model/foodItem";
import {Restaurant} from "../../shared/model/restaurant";

export interface Order {

  foodItems?: FoodItem[];
  userId?: number;
  restaurant?: Restaurant;
}
