package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final RecipeService recipeService;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	public DataLoader(RecipeService recipeService, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.recipeService = recipeService;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Recipe perfectGuacamole = new Recipe();
		
		perfectGuacamole.setDescription("Perfect Guacamole");
		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setDifficulty(Difficulty.EASY);
		perfectGuacamole.setServings(4);
		
		/*
		 * 
		    2 ripe avocados
		    1/4 teaspoon of salt, more to taste
		    1 tablespoon fresh lime juice or lemon juice
		    2 tablespoons to 1/4 cup of minced red onion or thinly sliced green onion
		    1-2 serrano chiles, stems and seeds removed, minced
		    2 tablespoons cilantro (leaves and tender stems), finely chopped
		    A dash of freshly grated black pepper
		    1/2 ripe tomato, seeds and pulp removed, chopped
		    Red radishes or jicama, to garnish
		    Tortilla chips, to serve

		 */
		Set<Ingredient> guacamoleIngredients = new HashSet<>();
		
		Ingredient avocado = new Ingredient();
		avocado.setAmount(BigDecimal.valueOf(2));
		avocado.setDescription("Avocado");
		avocado.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(avocado);
		
		Ingredient salt = new Ingredient();
		salt.setAmount(BigDecimal.valueOf(0.25));
		salt.setDescription("Salt");
		salt.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
		salt.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(salt);
		
		Ingredient freshLimeJuice = new Ingredient();
		freshLimeJuice.setAmount(BigDecimal.valueOf(1));
		freshLimeJuice.setDescription("Fresh lime juice");
		freshLimeJuice.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
		freshLimeJuice.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(freshLimeJuice);
		
		Ingredient mincedRedOnion = new Ingredient();
		mincedRedOnion.setAmount(BigDecimal.valueOf(0.25));
		mincedRedOnion.setDescription("Minced red onion");
		mincedRedOnion.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
		mincedRedOnion.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(mincedRedOnion);
		
		Ingredient serranoChiles = new Ingredient();
		serranoChiles.setAmount(BigDecimal.valueOf(2));
		serranoChiles.setDescription("Minced serrano chiles");
		serranoChiles.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(serranoChiles);
		
		Ingredient cilantro = new Ingredient();
		cilantro.setAmount(BigDecimal.valueOf(2));
		cilantro.setDescription("Finely chopped cilantro");
		cilantro.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
		cilantro.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(cilantro);
		
		Ingredient blackPepper = new Ingredient();
		blackPepper.setAmount(BigDecimal.valueOf(1));
		blackPepper.setDescription("Freshly grated black pepper");
		blackPepper.setUom(unitOfMeasureRepository.findByDescription("Dash").get());
		blackPepper.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(blackPepper);
		
		Ingredient tomato = new Ingredient();
		tomato.setAmount(BigDecimal.valueOf(0.5));
		tomato.setDescription("Chopped ripe tomato");
		tomato.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(tomato);
		
		Ingredient radishes = new Ingredient();
		radishes.setDescription("Radishes to garnish");
		radishes.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(radishes);
		
		Ingredient tortillaChips = new Ingredient();
		tortillaChips.setDescription("Tortilla chips to serve");
		tortillaChips.setRecipe(perfectGuacamole);
		guacamoleIngredients.add(tortillaChips);
		
		perfectGuacamole.setIngredients(guacamoleIngredients);
		
		recipeService.save(perfectGuacamole);
		
		Recipe spicyGrilledChickenTacos = new Recipe();
		
		spicyGrilledChickenTacos.setDescription("Spicy Grilled Chicken Tacos");
		spicyGrilledChickenTacos.setPrepTime(20);
		spicyGrilledChickenTacos.setCookTime(15);
		spicyGrilledChickenTacos.setDifficulty(Difficulty.MODERATE);
		spicyGrilledChickenTacos.setServings(6);
		
		/*
		 * For the chicken:

		    2 tablespoons ancho chili powder
		    1 teaspoon dried oregano
		    1 teaspoon dried cumin
		    1 teaspoon sugar
		    1/2 teaspoon salt
		    1 clove garlic, finely chopped
		    1 tablespoon finely grated orange zest
		    3 tablespoons fresh-squeezed orange juice
		    2 tablespoons olive oil
		    4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)
		
		To serve:
		
		    8 small corn tortillas
		    3 cups packed baby arugula (3 ounces)
		    2 medium ripe avocados, sliced
		    4 radishes, thinly sliced
		    1/2 pint cherry tomatoes, halved
		    1/4 red onion, thinly sliced
		    Roughly chopped cilantro
		    1/2 cup sour cream thinned with 1/4 cup milk
		    1 lime, cut into wedges

		 */
		Set<Ingredient> tacoIngredients = new HashSet<>();
		
		Ingredient anchoChiliPowder = new Ingredient();
		anchoChiliPowder.setAmount(BigDecimal.valueOf(2));
		anchoChiliPowder.setDescription("Ancho chili powder");
		anchoChiliPowder.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
		anchoChiliPowder.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(anchoChiliPowder);
		
		Ingredient driedOregano = new Ingredient();
		driedOregano.setAmount(BigDecimal.valueOf(1));
		driedOregano.setDescription("Dried oregano");
		driedOregano.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
		driedOregano.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(driedOregano);
		
		Ingredient driedCumin = new Ingredient();
		driedCumin.setAmount(BigDecimal.valueOf(1));
		driedCumin.setDescription("Dried cumin");
		driedCumin.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
		driedCumin.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(driedCumin);
		
		Ingredient sugar = new Ingredient();
		sugar.setAmount(BigDecimal.valueOf(1));
		sugar.setDescription("Sugar");
		sugar.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
		sugar.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(sugar);
		
		Ingredient saltForTacos = new Ingredient();
		saltForTacos.setAmount(BigDecimal.valueOf(0.5));
		saltForTacos.setDescription("Salt");
		saltForTacos.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
		saltForTacos.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(saltForTacos);
		
		Ingredient garlicClove = new Ingredient();
		garlicClove.setAmount(BigDecimal.valueOf(1));
		garlicClove.setDescription("Garlic clove finely chopped");
		garlicClove.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(garlicClove);
		
		Ingredient orangeZest = new Ingredient();
		orangeZest.setAmount(BigDecimal.valueOf(1));
		orangeZest.setDescription("Finely grated orange zest");
		orangeZest.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
		orangeZest.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(orangeZest);
		
		Ingredient orangeJuice = new Ingredient();
		orangeJuice.setAmount(BigDecimal.valueOf(3));
		orangeJuice.setDescription("Fresh-squeezed orange juice");
		orangeJuice.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
		orangeJuice.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(orangeJuice);
		
		Ingredient oliveOil = new Ingredient();
		oliveOil.setAmount(BigDecimal.valueOf(2));
		oliveOil.setDescription("Olive oil");
		oliveOil.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
		oliveOil.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(oliveOil);
		
		Ingredient chickenThighs = new Ingredient();
		chickenThighs.setAmount(BigDecimal.valueOf(1.25));
		chickenThighs.setDescription("Skinless, boneless chicken thighs");
		chickenThighs.setUom(unitOfMeasureRepository.findByDescription("Pound").get());
		chickenThighs.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(chickenThighs);
		
		Ingredient smallCornTortillas = new Ingredient();
		smallCornTortillas.setAmount(BigDecimal.valueOf(8));
		smallCornTortillas.setDescription("Small corn tortillas");
		smallCornTortillas.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(smallCornTortillas);
		
		Ingredient packedBabyArugula = new Ingredient();
		packedBabyArugula.setAmount(BigDecimal.valueOf(3));
		packedBabyArugula.setDescription("Packed baby arugula");
		packedBabyArugula.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
		packedBabyArugula.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(packedBabyArugula);
		
		Ingredient slicedAvocados = new Ingredient();
		slicedAvocados.setAmount(BigDecimal.valueOf(2));
		slicedAvocados.setDescription("Medium ripe avocados sliced");
		slicedAvocados.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(slicedAvocados);
		
		Ingredient thinlySlicedRadishes = new Ingredient();
		thinlySlicedRadishes.setAmount(BigDecimal.valueOf(4));
		thinlySlicedRadishes.setDescription("Thinly sliced radishes");
		thinlySlicedRadishes.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(thinlySlicedRadishes);
		
		Ingredient halvedCherryTomatoes = new Ingredient();
		halvedCherryTomatoes.setAmount(BigDecimal.valueOf(0.5));
		halvedCherryTomatoes.setDescription("Halved cherry tomatoes");
		halvedCherryTomatoes.setUom(unitOfMeasureRepository.findByDescription("Pint").get());
		halvedCherryTomatoes.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(halvedCherryTomatoes);
		
		Ingredient slicedRedOnion = new Ingredient();
		slicedRedOnion.setAmount(BigDecimal.valueOf(0.25));
		slicedRedOnion.setDescription("Thinly sliced red onion");
		slicedRedOnion.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(slicedRedOnion);
		
		Ingredient choppedCilantro = new Ingredient();
		choppedCilantro.setDescription("Roughly chopped cilantro");
		choppedCilantro.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(choppedCilantro);
		
		Ingredient sourCream = new Ingredient();
		sourCream.setAmount(BigDecimal.valueOf(0.5));
		sourCream.setDescription("Sour cream");
		sourCream.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
		sourCream.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(sourCream);
		
		Ingredient milk = new Ingredient();
		milk.setAmount(BigDecimal.valueOf(0.25));
		milk.setDescription("Milk");
		milk.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
		milk.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(milk);
		
		Ingredient limeWedges = new Ingredient();
		limeWedges.setAmount(BigDecimal.valueOf(1));
		limeWedges.setDescription("Lime cut into wedges");
		limeWedges.setRecipe(spicyGrilledChickenTacos);
		tacoIngredients.add(limeWedges);
		
		spicyGrilledChickenTacos.setIngredients(tacoIngredients);
		
		recipeService.save(spicyGrilledChickenTacos);
	}

}
