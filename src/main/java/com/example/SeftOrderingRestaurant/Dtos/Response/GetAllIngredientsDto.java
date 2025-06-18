/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 10/06/2025
 * Time: 16:08
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Dtos.Response
 * Class: GetAllIngredientsDTO
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Dtos.Response;

import com.example.SeftOrderingRestaurant.Enums.IngredientStatus;
import lombok.Data;

@Data
public class GetAllIngredientsDto {
    private Integer ingredientID;
    private String name;
    private IngredientStatus status;
}