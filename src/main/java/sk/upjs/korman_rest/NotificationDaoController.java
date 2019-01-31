package sk.upjs.korman_rest;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.duras.korman.DaoFactory;
import me.duras.korman.dao.BicycleDao;
import me.duras.korman.dao.NotificationDao;
import me.duras.korman.models.Agent;
import me.duras.korman.models.Bicycle;
import me.duras.korman.models.Notification;

@CrossOrigin
@RestController
public class NotificationDaoController {
	
	private NotificationDao notificationDao = DaoFactory.INSTANCE.getNotificationDao();

	@RequestMapping("/notifications")
	public List<Notification> getAll() {
		return notificationDao.getAll();
	}

	@RequestMapping("/notifications/date")
	public List<Notification> getNew(@RequestBody Date dateFrom) {
		return notificationDao.getNew(dateFrom);
	}
	
	@RequestMapping("/notifications/{id}")
	public Notification getById(@PathVariable int id) {
		return notificationDao.getById(id);
	}
	
	// with id = update, without id = create
	@RequestMapping(value = "/notifications", method = RequestMethod.POST)
	public Notification addNotification(@RequestBody Notification notification) {
		notificationDao.save(notification);
		return notification;
	}
	
	@RequestMapping(value = "/notifications/many", method = RequestMethod.POST)
	public List<Notification> addManyNotifications(@RequestBody List<Notification> notifications) {
		return notificationDao.saveMany(notifications);
	}
	
	@RequestMapping(value="/notifications/{id}", method = RequestMethod.DELETE)
	public int deleteNotification(@PathVariable int id) {
		return notificationDao.delete(id);
	} 

	@RequestMapping(value="/notifications", method = RequestMethod.DELETE)
	public int deleteNotification(@RequestBody Notification notification) {
		return notificationDao.delete(notification);
	}
	
	@RequestMapping(value="/notifications/many", method = RequestMethod.DELETE)
	public int deleteManyByExternalId(@RequestBody List<Integer> notifications) {
		return notificationDao.deleteManyByBicycleId(notifications);
	}
	
}