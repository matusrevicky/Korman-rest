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
import me.duras.korman.dao.SettingDao;
import me.duras.korman.models.Agent;
import me.duras.korman.models.Setting;

@CrossOrigin
@RestController
public class SettingsDaoController {

	private SettingDao settingDao = DaoFactory.INSTANCE.getSettingDao();

	@RequestMapping("/settings")
	public List<Setting> getAll() {
		return settingDao.getAll();
	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public Setting updateAgent(@RequestBody Setting setting) {
		settingDao.save(setting);
		return setting;
	}

}