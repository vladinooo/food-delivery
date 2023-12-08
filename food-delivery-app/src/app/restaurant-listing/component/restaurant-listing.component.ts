import { Component } from '@angular/core';
import {Restaurant} from "../../shared/model/restaurant";
import {Router} from "@angular/router";
import {RestaurantListingService} from "../service/restaurant-listing.service";

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrl: './restaurant-listing.component.css'
})
export class RestaurantListingComponent {

  public restaurants: Restaurant[];

  ngOnInit() {
    this.getAllRestaurants();
  }

  constructor(private router: Router, private restaurantListingService: RestaurantListingService) {
  }

  getAllRestaurants() {
    this.restaurantListingService.getAllRestaurants().subscribe(
      data => {
        this.restaurants = data;
      }
    )
  }

  onButtonClick(id: number) {
    this.router.navigate(['/food-catalogue', id]);
  }

}
