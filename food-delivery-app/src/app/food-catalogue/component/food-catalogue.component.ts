import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FoodItemService} from "../service/food-item.service";
import {FoodItem} from "../../shared/model/foodItem";
import {FoodCatalogue} from "../../shared/model/foodCatalogue";

@Component({
  selector: 'app-food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrl: './food-catalogue.component.css'
})
export class FoodCatalogueComponent {

  restaurantId: number;
  foodItemResponse = {
    foodItems: [{
      id: 0,
      name: "",
      description: "",
      sVegetarian: false,
      price: 0,
      restaurantId: 0,
      quantity: 0
    }],
    restaurant: {
      id: 0,
      name: "",
      address: "",
      city: "",
      description: ""
    }
  };
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCatalogue;
  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.restaurantId = +params['id'];
    })
    this.getFoodItemsByRestaurant(this.restaurantId);
  }

  getFoodItemsByRestaurant(restaurantId: number) {
    this.foodItemService.getFoodItemsByRestaurant(restaurantId).subscribe(
      data => {
        this.foodItemResponse = data;
      }
    )
  }

  increment(food: any) {
    food.quantity++;
    const index = this.foodItemCart.findIndex(item => item.id === food.id);
    if (index === -1) {
      // If record does not exist, add it to the array
      this.foodItemCart.push(food);
    } else {
      // If record exists, update it in the array
      this.foodItemCart[index] = food;
    }
  }

  decrement(food: any) {
    if (food.quantity > 0) {
      food.quantity--;

      const index = this.foodItemCart.findIndex(item => item.id === food.id);
      if (this.foodItemCart[index].quantity == 0) {
        this.foodItemCart.splice(index, 1);
      } else {
        // If record exists, update it in the array
        this.foodItemCart[index] = food;
      }

    }
  }

  onCheckOut() {
    this.orderSummary = {
      foodItems: [],
      restaurant: null!,
    };
    this.orderSummary.foodItems = this.foodItemCart;
    this.orderSummary.restaurant = this.foodItemResponse.restaurant;
    this.router.navigate(['/order-summary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
  }
}
