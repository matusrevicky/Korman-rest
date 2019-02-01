package sk.upjs.korman_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.duras.korman.DaoFactory;

import me.duras.korman.dao.LogDao;

import me.duras.korman.models.Log;

@CrossOrigin
@RestController
public class LogDaoController {

	private LogDao logDao = DaoFactory.INSTANCE.getLogDao();

	@RequestMapping("/logs")
	public List<Log> getAll() {
		return logDao.getAll();
	}
	
	@RequestMapping(value="/logs", method = RequestMethod.DELETE)
	public int deleteLogs() {
		return logDao.clear();
	} 
}