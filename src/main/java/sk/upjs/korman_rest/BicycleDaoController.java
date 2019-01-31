package sk.upjs.korman_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.duras.korman.DaoFactory;
import me.duras.korman.dao.AgentDao;
import me.duras.korman.dao.BicycleDao;
import me.duras.korman.models.Agent;
import me.duras.korman.models.Bicycle;

@CrossOrigin
@RestController
public class BicycleDaoController {

	private BicycleDao bicycleDao = DaoFactory.INSTANCE.getBicycleDao();

	@RequestMapping("/bicycles")
	public List<Bicycle> getAll() {
		return bicycleDao.getAll();
	}

	@RequestMapping("/bicycles/{id}")
	public Bicycle getById(@PathVariable int id) {
		return bicycleDao.getById(id);
	}
	
	@RequestMapping("/bicycles/ext/{extId}")
	public Bicycle getByExternalId(@PathVariable String extId) {
		return bicycleDao.getByExternalId(extId);
	}
	
	// CRUD - povaha projektu vyslovene zakazuje update(iba archivacia), create - vlozit bez id
	@RequestMapping(value = "/bicycles", method = RequestMethod.POST)
	public Bicycle addBicycle(@RequestBody Bicycle bicycle) {
		bicycleDao.save(bicycle);
		return bicycle;
	}
	
	@RequestMapping(value = "/bicycles/many", method = RequestMethod.POST)
	public void addManyBicycles(@RequestBody List<Bicycle> bicycles) {
		bicycleDao.saveMany(bicycles);
	}

	@RequestMapping(value="/bicycles", method = RequestMethod.DELETE)
	public int deleteBicycle(@RequestBody Bicycle bicycle) {
		return bicycleDao.delete(bicycle);
	} 
	
	@RequestMapping(value="/bicycles/many", method = RequestMethod.DELETE)
	public int deleteManyByExternalId(@RequestBody List<String> bicycles) {
		return bicycleDao.deleteManyByExternalId(bicycles);
	}
	
}