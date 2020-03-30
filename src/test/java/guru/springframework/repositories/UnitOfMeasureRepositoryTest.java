package guru.springframework.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	@DirtiesContext
	public void testFindByDescription() {
		
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uom.get().getDescription());
	}
	
	@Test
	@DirtiesContext
	public void testFindByDescriptionCup() {
		
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Cup");
		
		assertEquals("Cup", uom.get().getDescription());
	}

}
