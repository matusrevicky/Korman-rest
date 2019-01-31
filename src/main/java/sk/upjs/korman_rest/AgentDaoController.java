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
import me.duras.korman.models.Agent;

@CrossOrigin
@RestController
public class AgentDaoController {

	private AgentDao agentDao = DaoFactory.INSTANCE.getAgentDao();

	@RequestMapping("/agents")
	public List<Agent> getAll() {
		return agentDao.getAll();
	}
	
	@RequestMapping("/agents/{id}")
	public Agent getById(@PathVariable int id) {
		return agentDao.getById(id);
	}

	// CRUD - create and update, create - insert without id, update - insert with id
	@RequestMapping(value = "/agents", method = RequestMethod.POST)
	public Agent updateAgent(@RequestBody Agent agent) {
		agentDao.save(agent);
		return agent;
	}

	@RequestMapping(value="/agents/{id}", method = RequestMethod.DELETE)
	public int deleteAgent(@PathVariable int id) {
		return agentDao.delete(id);
	} 
	
	@RequestMapping(value="/agents", method = RequestMethod.DELETE)
	public int deleteAgent(@RequestBody Agent agent) {
		return agentDao.delete(agent);
	} 
}