package guru.springframework.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		Set<Recipe> expectedRecipes = new HashSet<Recipe>() {{add(new Recipe());}};
		
		when(recipeRepository.findAll()).thenReturn(expectedRecipes);
		
		recipeService = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void testGetRecipes() {
		
		Set<Recipe> actualRecipes = recipeService.getRecipes();
		
		assertEquals(1, actualRecipes.size());
		verify(recipeRepository, times(1)).findAll();
	}
	
}
