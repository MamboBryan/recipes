package com.bizyback.play.recipe.datasources.remote

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 12:22 pm
 */

val RECIPE_SEARCH_VALID_RESPONSE = """
    {
	"from": 1,
	"to": 20,
	"count": 10000,
	"_links": {
		"next": {
			"href": "https://api.edamam.com/api/recipes/v2?q=banana&app_key=eae736ace3a235647a0ab93ed2bb26f2&name=banana&_cont=CHcVQBtNNQphDmgVQntAEX4BYVVtDAAARmJAA2QbYFB6BwQBUXlSVzNGMAYlDQsPSmJBAmpHMQRyAQJSRWxAAGQTMlJxUAoVLnlSVSBMPkd5BgNK&type=public&app_id=f4123019",
			"title": "Next page"
		}
	},
	"hits": [
    		{
			"recipe": {
				"uri": "http://www.edamam.com/ontologies/edamam.owl#recipe_daeccf98897118dba151e690360a72d9",
				"label": "3-Ingredient Banana Pudding",
				"image": "https://edamam-product-images.s3.amazonaws.com/web-img/d03/d0334a478f04973022f9ac4e530d2afe.jpeg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEHcaCXVzLWVhc3QtMSJGMEQCIFLH6M5K2TTFJ8LCwWkivooTsWeiaJUulgYN9fQkPRmRAiAz8%2BLRECytbihyHl7KLkxeHNl1%2FVHIoIG6GanDfIIrqCrCBQj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAAaDDE4NzAxNzE1MDk4NiIM5cN%2FCX89T0bvX%2B04KpYF8XsTBYiMKlfBOKyPeQrOHFuFK80iLHX7OBvJOUNlIYoVCNfueY3TJGUUE7KDerwTFzl1KQYJgQzosuwW17z9EPXEFw3c3MwZcKMMusmMJNsLHrdIR6oOysOyMGG%2F1Abj5QDRT%2Biifbj%2F4sWC1ojNdZoXMZDaTfsgA8w2Eji2zVxRxHpaZPfHq6na2HtKHItG7OnrF2QqPiho4O3%2FBIO2ry09rbo%2FV7BTJfgn2LTOFE8Iz%2B1uw8fs24o8v%2B%2BI6isrBH3CHNtSkirLJajfEys1NZB1yKMEceHTgX8BsO1bg8Ba%2FQ5mYWYbwTk9RLDVFoBRQ6oQcZtpDcVg43nTtNrNifgLqitC4VLousWbuNjP%2F9LkEy8%2F8o8MhmlYas3s54EJHIIyIA3JnS%2BRJIa8ijRrAI9NGRbYQGPVgj30GzkpcvXDsPgK7TSm0yPpKmlyBzaqTZDTJ6Jngi7Lb7lQ6FNEpIK4zeB%2BiUIGVsOsJf8mqyeD0lCltf0vs%2FBE0N3l24l%2B10LlkaG%2BoH4YLZwC%2BivVn3by1sD5GjU4Y2GZh5o8Iqk1tVRIcF9ZYx7jP7MAXGUnLotU6G5foHzD2jBfAjq9IzcdUErYqUgh19VcUIe0bbTtdCNfYjs3eOtV480yqLkkqd7Icl7GQzx%2FImnTwaVYuTZZY%2BEAHWgFDOEW1tHhiHMwwchB0rA%2BurvmgWHTcoYnzanhmPcZtSm%2B0lB4PuGf72qxxGOE16rn32cAQJFNZTmz%2B4y1ATYTnE0Q%2BAnLMqnPLtaJI5lJQGOjjvsf3ZA5t%2B20nZEl9HsXQ7fvhUtHU%2B%2BCbRoqvMFtqeMXnH89azQvbmw8JNPVHWaekRCVDohRBHDlPVY%2FUC87OfoMxvBKeKI5wRNa9HAwy4%2FErAY6sgGvzYYO0ukoftn%2FUCWYiTFCUSTDgAyIu3ybC8FSRe7OATx99snCObBl6E1fFf2k4rZsTy3QMiIi8nUUWZIzv7pIqpIRyqdYtRflTDSv81XfmfwXVU%2BYV6RGctR0O7HduDcXUIIWkxQ067jHIQwQrj3cR6IeuYQ4SzLhpIbgOZDBoOmUzNk4rfn4V3Cj7lv83GVuAoM%2FvLki5BagZbw8lFkoMxSSGIf%2Bg1oQavEqnDMlKEZG&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231231T065950Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFM3YQNNP7%2F20231231%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=ca67df20567e6d1498f854fd3f7ce6396f4de69f155460a97ae4f6df13fad461",
				"images": {
					"THUMBNAIL": {
						"url": "https://edamam-product-images.s3.amazonaws.com/web-img/d03/d0334a478f04973022f9ac4e530d2afe-s.jpeg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEHcaCXVzLWVhc3QtMSJGMEQCIFLH6M5K2TTFJ8LCwWkivooTsWeiaJUulgYN9fQkPRmRAiAz8%2BLRECytbihyHl7KLkxeHNl1%2FVHIoIG6GanDfIIrqCrCBQj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAAaDDE4NzAxNzE1MDk4NiIM5cN%2FCX89T0bvX%2B04KpYF8XsTBYiMKlfBOKyPeQrOHFuFK80iLHX7OBvJOUNlIYoVCNfueY3TJGUUE7KDerwTFzl1KQYJgQzosuwW17z9EPXEFw3c3MwZcKMMusmMJNsLHrdIR6oOysOyMGG%2F1Abj5QDRT%2Biifbj%2F4sWC1ojNdZoXMZDaTfsgA8w2Eji2zVxRxHpaZPfHq6na2HtKHItG7OnrF2QqPiho4O3%2FBIO2ry09rbo%2FV7BTJfgn2LTOFE8Iz%2B1uw8fs24o8v%2B%2BI6isrBH3CHNtSkirLJajfEys1NZB1yKMEceHTgX8BsO1bg8Ba%2FQ5mYWYbwTk9RLDVFoBRQ6oQcZtpDcVg43nTtNrNifgLqitC4VLousWbuNjP%2F9LkEy8%2F8o8MhmlYas3s54EJHIIyIA3JnS%2BRJIa8ijRrAI9NGRbYQGPVgj30GzkpcvXDsPgK7TSm0yPpKmlyBzaqTZDTJ6Jngi7Lb7lQ6FNEpIK4zeB%2BiUIGVsOsJf8mqyeD0lCltf0vs%2FBE0N3l24l%2B10LlkaG%2BoH4YLZwC%2BivVn3by1sD5GjU4Y2GZh5o8Iqk1tVRIcF9ZYx7jP7MAXGUnLotU6G5foHzD2jBfAjq9IzcdUErYqUgh19VcUIe0bbTtdCNfYjs3eOtV480yqLkkqd7Icl7GQzx%2FImnTwaVYuTZZY%2BEAHWgFDOEW1tHhiHMwwchB0rA%2BurvmgWHTcoYnzanhmPcZtSm%2B0lB4PuGf72qxxGOE16rn32cAQJFNZTmz%2B4y1ATYTnE0Q%2BAnLMqnPLtaJI5lJQGOjjvsf3ZA5t%2B20nZEl9HsXQ7fvhUtHU%2B%2BCbRoqvMFtqeMXnH89azQvbmw8JNPVHWaekRCVDohRBHDlPVY%2FUC87OfoMxvBKeKI5wRNa9HAwy4%2FErAY6sgGvzYYO0ukoftn%2FUCWYiTFCUSTDgAyIu3ybC8FSRe7OATx99snCObBl6E1fFf2k4rZsTy3QMiIi8nUUWZIzv7pIqpIRyqdYtRflTDSv81XfmfwXVU%2BYV6RGctR0O7HduDcXUIIWkxQ067jHIQwQrj3cR6IeuYQ4SzLhpIbgOZDBoOmUzNk4rfn4V3Cj7lv83GVuAoM%2FvLki5BagZbw8lFkoMxSSGIf%2Bg1oQavEqnDMlKEZG&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231231T065950Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFM3YQNNP7%2F20231231%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=eff3e3a736eacf87ace1719a7127ed005d62a526d4cf28ceff67e54e64f314b8",
						"width": 100,
						"height": 100
					},
					"SMALL": {
						"url": "https://edamam-product-images.s3.amazonaws.com/web-img/d03/d0334a478f04973022f9ac4e530d2afe-m.jpeg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEHcaCXVzLWVhc3QtMSJGMEQCIFLH6M5K2TTFJ8LCwWkivooTsWeiaJUulgYN9fQkPRmRAiAz8%2BLRECytbihyHl7KLkxeHNl1%2FVHIoIG6GanDfIIrqCrCBQj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAAaDDE4NzAxNzE1MDk4NiIM5cN%2FCX89T0bvX%2B04KpYF8XsTBYiMKlfBOKyPeQrOHFuFK80iLHX7OBvJOUNlIYoVCNfueY3TJGUUE7KDerwTFzl1KQYJgQzosuwW17z9EPXEFw3c3MwZcKMMusmMJNsLHrdIR6oOysOyMGG%2F1Abj5QDRT%2Biifbj%2F4sWC1ojNdZoXMZDaTfsgA8w2Eji2zVxRxHpaZPfHq6na2HtKHItG7OnrF2QqPiho4O3%2FBIO2ry09rbo%2FV7BTJfgn2LTOFE8Iz%2B1uw8fs24o8v%2B%2BI6isrBH3CHNtSkirLJajfEys1NZB1yKMEceHTgX8BsO1bg8Ba%2FQ5mYWYbwTk9RLDVFoBRQ6oQcZtpDcVg43nTtNrNifgLqitC4VLousWbuNjP%2F9LkEy8%2F8o8MhmlYas3s54EJHIIyIA3JnS%2BRJIa8ijRrAI9NGRbYQGPVgj30GzkpcvXDsPgK7TSm0yPpKmlyBzaqTZDTJ6Jngi7Lb7lQ6FNEpIK4zeB%2BiUIGVsOsJf8mqyeD0lCltf0vs%2FBE0N3l24l%2B10LlkaG%2BoH4YLZwC%2BivVn3by1sD5GjU4Y2GZh5o8Iqk1tVRIcF9ZYx7jP7MAXGUnLotU6G5foHzD2jBfAjq9IzcdUErYqUgh19VcUIe0bbTtdCNfYjs3eOtV480yqLkkqd7Icl7GQzx%2FImnTwaVYuTZZY%2BEAHWgFDOEW1tHhiHMwwchB0rA%2BurvmgWHTcoYnzanhmPcZtSm%2B0lB4PuGf72qxxGOE16rn32cAQJFNZTmz%2B4y1ATYTnE0Q%2BAnLMqnPLtaJI5lJQGOjjvsf3ZA5t%2B20nZEl9HsXQ7fvhUtHU%2B%2BCbRoqvMFtqeMXnH89azQvbmw8JNPVHWaekRCVDohRBHDlPVY%2FUC87OfoMxvBKeKI5wRNa9HAwy4%2FErAY6sgGvzYYO0ukoftn%2FUCWYiTFCUSTDgAyIu3ybC8FSRe7OATx99snCObBl6E1fFf2k4rZsTy3QMiIi8nUUWZIzv7pIqpIRyqdYtRflTDSv81XfmfwXVU%2BYV6RGctR0O7HduDcXUIIWkxQ067jHIQwQrj3cR6IeuYQ4SzLhpIbgOZDBoOmUzNk4rfn4V3Cj7lv83GVuAoM%2FvLki5BagZbw8lFkoMxSSGIf%2Bg1oQavEqnDMlKEZG&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231231T065950Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFM3YQNNP7%2F20231231%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=6a9a14d6d3e45bae93c528ca9efe627a79cf78016b7ea627509c53cc301aeda8",
						"width": 200,
						"height": 200
					},
					"REGULAR": {
						"url": "https://edamam-product-images.s3.amazonaws.com/web-img/d03/d0334a478f04973022f9ac4e530d2afe.jpeg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEHcaCXVzLWVhc3QtMSJGMEQCIFLH6M5K2TTFJ8LCwWkivooTsWeiaJUulgYN9fQkPRmRAiAz8%2BLRECytbihyHl7KLkxeHNl1%2FVHIoIG6GanDfIIrqCrCBQj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAAaDDE4NzAxNzE1MDk4NiIM5cN%2FCX89T0bvX%2B04KpYF8XsTBYiMKlfBOKyPeQrOHFuFK80iLHX7OBvJOUNlIYoVCNfueY3TJGUUE7KDerwTFzl1KQYJgQzosuwW17z9EPXEFw3c3MwZcKMMusmMJNsLHrdIR6oOysOyMGG%2F1Abj5QDRT%2Biifbj%2F4sWC1ojNdZoXMZDaTfsgA8w2Eji2zVxRxHpaZPfHq6na2HtKHItG7OnrF2QqPiho4O3%2FBIO2ry09rbo%2FV7BTJfgn2LTOFE8Iz%2B1uw8fs24o8v%2B%2BI6isrBH3CHNtSkirLJajfEys1NZB1yKMEceHTgX8BsO1bg8Ba%2FQ5mYWYbwTk9RLDVFoBRQ6oQcZtpDcVg43nTtNrNifgLqitC4VLousWbuNjP%2F9LkEy8%2F8o8MhmlYas3s54EJHIIyIA3JnS%2BRJIa8ijRrAI9NGRbYQGPVgj30GzkpcvXDsPgK7TSm0yPpKmlyBzaqTZDTJ6Jngi7Lb7lQ6FNEpIK4zeB%2BiUIGVsOsJf8mqyeD0lCltf0vs%2FBE0N3l24l%2B10LlkaG%2BoH4YLZwC%2BivVn3by1sD5GjU4Y2GZh5o8Iqk1tVRIcF9ZYx7jP7MAXGUnLotU6G5foHzD2jBfAjq9IzcdUErYqUgh19VcUIe0bbTtdCNfYjs3eOtV480yqLkkqd7Icl7GQzx%2FImnTwaVYuTZZY%2BEAHWgFDOEW1tHhiHMwwchB0rA%2BurvmgWHTcoYnzanhmPcZtSm%2B0lB4PuGf72qxxGOE16rn32cAQJFNZTmz%2B4y1ATYTnE0Q%2BAnLMqnPLtaJI5lJQGOjjvsf3ZA5t%2B20nZEl9HsXQ7fvhUtHU%2B%2BCbRoqvMFtqeMXnH89azQvbmw8JNPVHWaekRCVDohRBHDlPVY%2FUC87OfoMxvBKeKI5wRNa9HAwy4%2FErAY6sgGvzYYO0ukoftn%2FUCWYiTFCUSTDgAyIu3ybC8FSRe7OATx99snCObBl6E1fFf2k4rZsTy3QMiIi8nUUWZIzv7pIqpIRyqdYtRflTDSv81XfmfwXVU%2BYV6RGctR0O7HduDcXUIIWkxQ067jHIQwQrj3cR6IeuYQ4SzLhpIbgOZDBoOmUzNk4rfn4V3Cj7lv83GVuAoM%2FvLki5BagZbw8lFkoMxSSGIf%2Bg1oQavEqnDMlKEZG&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231231T065950Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFM3YQNNP7%2F20231231%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=ca67df20567e6d1498f854fd3f7ce6396f4de69f155460a97ae4f6df13fad461",
						"width": 300,
						"height": 300
					}
				},
				"source": "Food Network",
				"url": "https://www.foodnetwork.com/recipes/food-network-kitchen/3-ingredient-banana-pudding-3363475?soc=sharepin",
				"shareAs": "http://www.edamam.com/recipe/3-ingredient-banana-pudding-daeccf98897118dba151e690360a72d9/banana",
				"yield": 2.0,
				"dietLabels": [],
				"healthLabels": [
					"Vegetarian",
					"Pescatarian",
					"Dairy-Free",
					"Gluten-Free",
					"Wheat-Free",
					"Egg-Free",
					"Peanut-Free",
					"Tree-Nut-Free",
					"Soy-Free",
					"Fish-Free",
					"Shellfish-Free",
					"Pork-Free",
					"Red-Meat-Free",
					"Crustacean-Free",
					"Celery-Free",
					"Mustard-Free",
					"Sesame-Free",
					"Lupine-Free",
					"Mollusk-Free",
					"Alcohol-Free",
					"No oil added",
					"Sulfite-Free",
					"Kosher"
				],
				"cautions": [
					"Soy",
					"Sulfites"
				],
				"ingredientLines": [
					"1/2 cup chocolate almond milk",
					"4 bananas, plus banana slices, for topping",
					"2 tablespoons chia seeds"
				],
				"ingredients": [
					{
						"text": "1/2 cup chocolate almond milk",
						"quantity": 0.5,
						"measure": "cup",
						"food": "chocolate almond milk",
						"weight": 120.0,
						"foodCategory": "non-dairy beverages",
						"foodId": "food_bhqm9kabwyw66obm0c7ifa1n992f",
						"image": "https://www.edamam.com/food-img/ceb/cebccb760ad2a798e85c2295ff0884aa.jpg"
					},
					{
						"text": "4 bananas, plus banana slices, for topping",
						"quantity": 4.0,
						"measure": "<unit>",
						"food": "bananas",
						"weight": 462.8,
						"foodCategory": "fruit",
						"foodId": "food_bjsfxtcaidvmhaa3afrbna43q3hu",
						"image": "https://www.edamam.com/food-img/9f6/9f6181163a25c96022ee3fc66d9ebb11.jpg"
					},
					{
						"text": "4 bananas, plus banana slices, for topping",
						"quantity": 0.0,
						"measure": null,
						"food": "banana",
						"weight": 0.0,
						"foodCategory": "fruit",
						"foodId": "food_bjsfxtcaidvmhaa3afrbna43q3hu",
						"image": "https://www.edamam.com/food-img/9f6/9f6181163a25c96022ee3fc66d9ebb11.jpg"
					},
					{
						"text": "2 tablespoons chia seeds",
						"quantity": 2.0,
						"measure": "tablespoon",
						"food": "chia seeds",
						"weight": 24.0,
						"foodCategory": "plant-based protein",
						"foodId": "food_aifjb1oaozpl1nbw7g92oa54ists",
						"image": "https://www.edamam.com/food-img/bcc/bcc6e6bf3175772ad00b414636467257.jpg"
					}
				],
				"calories": 588.532,
				"totalCO2Emissions": 627.69769696,
				"co2EmissionsClass": "D",
				"totalWeight": 606.8,
				"totalTime": 245.0,
				"cuisineType": [
					"british"
				],
				"mealType": [
					"lunch/dinner"
				],
				"dishType": [
					"desserts"
				],
				"totalNutrients": {
					"ENERC_KCAL": {
						"label": "Energy",
						"quantity": 588.532,
						"unit": "kcal"
					},
					"FAT": {
						"label": "Fat",
						"quantity": 10.39524,
						"unit": "g"
					},
					"FASAT": {
						"label": "Saturated",
						"quantity": 1.317536,
						"unit": "g"
					},
					"FATRN": {
						"label": "Trans",
						"quantity": 0.033600000000000005,
						"unit": "g"
					},
					"FAMS": {
						"label": "Monounsaturated",
						"quantity": 1.452496,
						"unit": "g"
					},
					"FAPU": {
						"label": "Polyunsaturated",
						"quantity": 6.275443999999999,
						"unit": "g"
					},
					"CHOCDF": {
						"label": "Carbs",
						"quantity": 126.8784,
						"unit": "g"
					},
					"CHOCDF.net": {
						"label": "Carbohydrates (net)",
						"quantity": 106.1096,
						"unit": "g"
					},
					"FIBTG": {
						"label": "Fiber",
						"quantity": 20.7688,
						"unit": "g"
					},
					"SUGAR": {
						"label": "Sugars",
						"quantity": 66.9616,
						"unit": "g"
					},
					"SUGAR.added": {
						"label": "Sugars, added",
						"quantity": 10.5,
						"unit": "g"
					},
					"PROCNT": {
						"label": "Protein",
						"quantity": 9.76052,
						"unit": "g"
					},
					"CHOLE": {
						"label": "Cholesterol",
						"quantity": 0.0,
						"unit": "mg"
					},
					"NA": {
						"label": "Sodium",
						"quantity": 93.668,
						"unit": "mg"
					},
					"CA": {
						"label": "Calcium",
						"quantity": 400.18,
						"unit": "mg"
					},
					"MG": {
						"label": "Magnesium",
						"quantity": 219.75599999999997,
						"unit": "mg"
					},
					"K": {
						"label": "Potassium",
						"quantity": 1844.5040000000001,
						"unit": "mg"
					},
					"FE": {
						"label": "Iron",
						"quantity": 3.69208,
						"unit": "mg"
					},
					"ZN": {
						"label": "Zinc",
						"quantity": 2.5494000000000003,
						"unit": "mg"
					},
					"P": {
						"label": "Phosphorus",
						"quantity": 331.016,
						"unit": "mg"
					},
					"VITA_RAE": {
						"label": "Vitamin A",
						"quantity": 89.484,
						"unit": "µg"
					},
					"VITC": {
						"label": "Vitamin C",
						"quantity": 45.9276,
						"unit": "mg"
					},
					"THIA": {
						"label": "Thiamin (B1)",
						"quantity": 0.318668,
						"unit": "mg"
					},
					"RIBF": {
						"label": "Riboflavin (B2)",
						"quantity": 0.5910439999999999,
						"unit": "mg"
					},
					"NIA": {
						"label": "Niacin (B3)",
						"quantity": 5.32042,
						"unit": "mg"
					},
					"VITB6A": {
						"label": "Vitamin B6",
						"quantity": 1.7056760000000002,
						"unit": "mg"
					},
					"FOLDFE": {
						"label": "Folate equivalent (total)",
						"quantity": 93.76,
						"unit": "µg"
					},
					"FOLFD": {
						"label": "Folate (food)",
						"quantity": 105.52000000000001,
						"unit": "µg"
					},
					"FOLAC": {
						"label": "Folic acid",
						"quantity": 0.0,
						"unit": "µg"
					},
					"VITB12": {
						"label": "Vitamin B12",
						"quantity": 1.5,
						"unit": "µg"
					},
					"VITD": {
						"label": "Vitamin D",
						"quantity": 1.2,
						"unit": "µg"
					},
					"TOCPHA": {
						"label": "Vitamin E",
						"quantity": 3.9548,
						"unit": "mg"
					},
					"VITK1": {
						"label": "Vitamin K",
						"quantity": 2.314,
						"unit": "µg"
					},
					"WATER": {
						"label": "Water",
						"quantity": 454.1092,
						"unit": "g"
					}
				},
				"totalDaily": {
					"ENERC_KCAL": {
						"label": "Energy",
						"quantity": 29.4266,
						"unit": "%"
					},
					"FAT": {
						"label": "Fat",
						"quantity": 15.992676923076921,
						"unit": "%"
					},
					"FASAT": {
						"label": "Saturated",
						"quantity": 6.587680000000001,
						"unit": "%"
					},
					"CHOCDF": {
						"label": "Carbs",
						"quantity": 42.2928,
						"unit": "%"
					},
					"FIBTG": {
						"label": "Fiber",
						"quantity": 83.07520000000001,
						"unit": "%"
					},
					"PROCNT": {
						"label": "Protein",
						"quantity": 19.52104,
						"unit": "%"
					},
					"CHOLE": {
						"label": "Cholesterol",
						"quantity": 0.0,
						"unit": "%"
					},
					"NA": {
						"label": "Sodium",
						"quantity": 3.9028333333333336,
						"unit": "%"
					},
					"CA": {
						"label": "Calcium",
						"quantity": 40.018,
						"unit": "%"
					},
					"MG": {
						"label": "Magnesium",
						"quantity": 52.32285714285714,
						"unit": "%"
					},
					"K": {
						"label": "Potassium",
						"quantity": 39.244765957446816,
						"unit": "%"
					},
					"FE": {
						"label": "Iron",
						"quantity": 20.511555555555553,
						"unit": "%"
					},
					"ZN": {
						"label": "Zinc",
						"quantity": 23.17636363636364,
						"unit": "%"
					},
					"P": {
						"label": "Phosphorus",
						"quantity": 47.288,
						"unit": "%"
					},
					"VITA_RAE": {
						"label": "Vitamin A",
						"quantity": 9.942666666666666,
						"unit": "%"
					},
					"VITC": {
						"label": "Vitamin C",
						"quantity": 51.03066666666667,
						"unit": "%"
					},
					"THIA": {
						"label": "Thiamin (B1)",
						"quantity": 26.555666666666667,
						"unit": "%"
					},
					"RIBF": {
						"label": "Riboflavin (B2)",
						"quantity": 45.46492307692307,
						"unit": "%"
					},
					"NIA": {
						"label": "Niacin (B3)",
						"quantity": 33.252625,
						"unit": "%"
					},
					"VITB6A": {
						"label": "Vitamin B6",
						"quantity": 131.20584615384618,
						"unit": "%"
					},
					"FOLDFE": {
						"label": "Folate equivalent (total)",
						"quantity": 23.44,
						"unit": "%"
					},
					"VITB12": {
						"label": "Vitamin B12",
						"quantity": 62.5,
						"unit": "%"
					},
					"VITD": {
						"label": "Vitamin D",
						"quantity": 8.0,
						"unit": "%"
					},
					"TOCPHA": {
						"label": "Vitamin E",
						"quantity": 26.365333333333336,
						"unit": "%"
					},
					"VITK1": {
						"label": "Vitamin K",
						"quantity": 1.9283333333333335,
						"unit": "%"
					}
				},
				"digest": [
					{
						"label": "Fat",
						"tag": "FAT",
						"schemaOrgTag": "fatContent",
						"total": 10.39524,
						"hasRDI": true,
						"daily": 15.992676923076921,
						"unit": "g",
						"sub": [
							{
								"label": "Saturated",
								"tag": "FASAT",
								"schemaOrgTag": "saturatedFatContent",
								"total": 1.317536,
								"hasRDI": true,
								"daily": 6.587680000000001,
								"unit": "g"
							},
							{
								"label": "Trans",
								"tag": "FATRN",
								"schemaOrgTag": "transFatContent",
								"total": 0.033600000000000005,
								"hasRDI": false,
								"daily": 0.0,
								"unit": "g"
							},
							{
								"label": "Monounsaturated",
								"tag": "FAMS",
								"schemaOrgTag": null,
								"total": 1.452496,
								"hasRDI": false,
								"daily": 0.0,
								"unit": "g"
							},
							{
								"label": "Polyunsaturated",
								"tag": "FAPU",
								"schemaOrgTag": null,
								"total": 6.275443999999999,
								"hasRDI": false,
								"daily": 0.0,
								"unit": "g"
							}
						]
					},
					{
						"label": "Carbs",
						"tag": "CHOCDF",
						"schemaOrgTag": "carbohydrateContent",
						"total": 126.8784,
						"hasRDI": true,
						"daily": 42.2928,
						"unit": "g",
						"sub": [
							{
								"label": "Carbs (net)",
								"tag": "CHOCDF.net",
								"schemaOrgTag": null,
								"total": 106.1096,
								"hasRDI": false,
								"daily": 0.0,
								"unit": "g"
							},
							{
								"label": "Fiber",
								"tag": "FIBTG",
								"schemaOrgTag": "fiberContent",
								"total": 20.7688,
								"hasRDI": true,
								"daily": 83.07520000000001,
								"unit": "g"
							},
							{
								"label": "Sugars",
								"tag": "SUGAR",
								"schemaOrgTag": "sugarContent",
								"total": 66.9616,
								"hasRDI": false,
								"daily": 0.0,
								"unit": "g"
							},
							{
								"label": "Sugars, added",
								"tag": "SUGAR.added",
								"schemaOrgTag": null,
								"total": 10.5,
								"hasRDI": false,
								"daily": 0.0,
								"unit": "g"
							}
						]
					},
					{
						"label": "Protein",
						"tag": "PROCNT",
						"schemaOrgTag": "proteinContent",
						"total": 9.76052,
						"hasRDI": true,
						"daily": 19.52104,
						"unit": "g"
					},
					{
						"label": "Cholesterol",
						"tag": "CHOLE",
						"schemaOrgTag": "cholesterolContent",
						"total": 0.0,
						"hasRDI": true,
						"daily": 0.0,
						"unit": "mg"
					},
					{
						"label": "Sodium",
						"tag": "NA",
						"schemaOrgTag": "sodiumContent",
						"total": 93.668,
						"hasRDI": true,
						"daily": 3.9028333333333336,
						"unit": "mg"
					},
					{
						"label": "Calcium",
						"tag": "CA",
						"schemaOrgTag": null,
						"total": 400.18,
						"hasRDI": true,
						"daily": 40.018,
						"unit": "mg"
					},
					{
						"label": "Magnesium",
						"tag": "MG",
						"schemaOrgTag": null,
						"total": 219.75599999999997,
						"hasRDI": true,
						"daily": 52.32285714285714,
						"unit": "mg"
					},
					{
						"label": "Potassium",
						"tag": "K",
						"schemaOrgTag": null,
						"total": 1844.5040000000001,
						"hasRDI": true,
						"daily": 39.244765957446816,
						"unit": "mg"
					},
					{
						"label": "Iron",
						"tag": "FE",
						"schemaOrgTag": null,
						"total": 3.69208,
						"hasRDI": true,
						"daily": 20.511555555555553,
						"unit": "mg"
					},
					{
						"label": "Zinc",
						"tag": "ZN",
						"schemaOrgTag": null,
						"total": 2.5494000000000003,
						"hasRDI": true,
						"daily": 23.17636363636364,
						"unit": "mg"
					},
					{
						"label": "Phosphorus",
						"tag": "P",
						"schemaOrgTag": null,
						"total": 331.016,
						"hasRDI": true,
						"daily": 47.288,
						"unit": "mg"
					},
					{
						"label": "Vitamin A",
						"tag": "VITA_RAE",
						"schemaOrgTag": null,
						"total": 89.484,
						"hasRDI": true,
						"daily": 9.942666666666666,
						"unit": "µg"
					},
					{
						"label": "Vitamin C",
						"tag": "VITC",
						"schemaOrgTag": null,
						"total": 45.9276,
						"hasRDI": true,
						"daily": 51.03066666666667,
						"unit": "mg"
					},
					{
						"label": "Thiamin (B1)",
						"tag": "THIA",
						"schemaOrgTag": null,
						"total": 0.318668,
						"hasRDI": true,
						"daily": 26.555666666666667,
						"unit": "mg"
					},
					{
						"label": "Riboflavin (B2)",
						"tag": "RIBF",
						"schemaOrgTag": null,
						"total": 0.5910439999999999,
						"hasRDI": true,
						"daily": 45.46492307692307,
						"unit": "mg"
					},
					{
						"label": "Niacin (B3)",
						"tag": "NIA",
						"schemaOrgTag": null,
						"total": 5.32042,
						"hasRDI": true,
						"daily": 33.252625,
						"unit": "mg"
					},
					{
						"label": "Vitamin B6",
						"tag": "VITB6A",
						"schemaOrgTag": null,
						"total": 1.7056760000000002,
						"hasRDI": true,
						"daily": 131.20584615384618,
						"unit": "mg"
					},
					{
						"label": "Folate equivalent (total)",
						"tag": "FOLDFE",
						"schemaOrgTag": null,
						"total": 93.76,
						"hasRDI": true,
						"daily": 23.44,
						"unit": "µg"
					},
					{
						"label": "Folate (food)",
						"tag": "FOLFD",
						"schemaOrgTag": null,
						"total": 105.52000000000001,
						"hasRDI": false,
						"daily": 0.0,
						"unit": "µg"
					},
					{
						"label": "Folic acid",
						"tag": "FOLAC",
						"schemaOrgTag": null,
						"total": 0.0,
						"hasRDI": false,
						"daily": 0.0,
						"unit": "µg"
					},
					{
						"label": "Vitamin B12",
						"tag": "VITB12",
						"schemaOrgTag": null,
						"total": 1.5,
						"hasRDI": true,
						"daily": 62.5,
						"unit": "µg"
					},
					{
						"label": "Vitamin D",
						"tag": "VITD",
						"schemaOrgTag": null,
						"total": 1.2,
						"hasRDI": true,
						"daily": 8.0,
						"unit": "µg"
					},
					{
						"label": "Vitamin E",
						"tag": "TOCPHA",
						"schemaOrgTag": null,
						"total": 3.9548,
						"hasRDI": true,
						"daily": 26.365333333333336,
						"unit": "mg"
					},
					{
						"label": "Vitamin K",
						"tag": "VITK1",
						"schemaOrgTag": null,
						"total": 2.314,
						"hasRDI": true,
						"daily": 1.9283333333333335,
						"unit": "µg"
					},
					{
						"label": "Sugar alcohols",
						"tag": "Sugar.alcohol",
						"schemaOrgTag": null,
						"total": 0.0,
						"hasRDI": false,
						"daily": 0.0,
						"unit": "g"
					},
					{
						"label": "Water",
						"tag": "WATER",
						"schemaOrgTag": null,
						"total": 454.1092,
						"hasRDI": false,
						"daily": 0.0,
						"unit": "g"
					}
				],
				"tags": [
					"Healthy",
					"Banana",
					"Pudding"
				]
			},
			"_links": {
				"self": {
					"title": "Self",
					"href": "https://api.edamam.com/api/recipes/v2/daeccf98897118dba151e690360a72d9?type=public&app_id=f4123019&app_key=eae736ace3a235647a0ab93ed2bb26f2"
				}
			}
		}
	]
}
""".trimIndent()