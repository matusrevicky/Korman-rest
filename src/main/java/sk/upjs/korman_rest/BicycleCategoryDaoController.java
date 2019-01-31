package sk.upjs.korman_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.duras.korman.DaoFactory;
import me.duras.korman.dao.BicycleCategoryDao;
import me.duras.korman.models.BicycleCategory;


@CrossOrigin
@RestController
public class BicycleCategoryDaoController {

	private BicycleCategoryDao bicycleCategoryDao = DaoFactory.INSTANCE.getBicycleCategoryDao();

	@RequestMapping("/bicycleCategory")
	public List<BicycleCategory> getAll() {
		return bicycleCategoryDao.getAll();
	}
	
	@RequestMapping("/bicycleCategory/{id}")
	public BicycleCategory getById(@PathVariable int id) {
		return bicycleCategoryDao.getById(id);
	}


}