package guru.springframework.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;

public class IndexControllerTest {

	IndexController indexController;
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		Set<Recipe> expectedRecipes = new HashSet<Recipe>() {{add(new Recipe());}};
		
		when(recipeService.getRecipes()).thenReturn(expectedRecipes);
		
		indexController = new IndexController(recipeService);
	}

	@Test
	public void testMockMVC() throws Exception {
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}
	
	@Test
	public void testGetIndexPage() {
		
		String expectedIndexPage = "index";
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		assertEquals(expectedIndexPage, indexController.getIndexPage(model));
		
		verify(recipeService, times(1)).getRecipes();
		
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		
		assertEquals(1, argumentCaptor.getValue().size());
	}

}
