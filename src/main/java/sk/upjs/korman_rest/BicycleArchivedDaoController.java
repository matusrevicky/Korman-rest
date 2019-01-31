package sk.upjs.korman_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.duras.korman.DaoFactory;
import me.duras.korman.dao.ArchivedBicycleDao;
import me.duras.korman.models.ArchivedBicycle;


@CrossOrigin
@RestController
public class BicycleArchivedDaoController {

	private ArchivedBicycleDao bicycleDao = DaoFactory.INSTANCE.getArchivedBicycleDao();

	@RequestMapping("/bicyclesArchived")
	public List<ArchivedBicycle> getAll() {
		return bicycleDao.getAll();
	}
	
}