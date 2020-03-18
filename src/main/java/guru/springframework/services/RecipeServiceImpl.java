package guru.springframework.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> findAll() {
		
		final Set<Recipe> recipes = new HashSet<>();
		
		recipeRepository.findAll().forEach(recipes::add);
		
		return recipes;
	}

	@Override
	public Recipe save(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

}
