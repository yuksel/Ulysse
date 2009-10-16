package org.qualipso.factory.eventqueue.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.qualipso.factory.FactoryResource;
import org.qualipso.factory.FactoryResourceIdentifier;
import org.qualipso.factory.notification.Event;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @date 11 june 2009
 */
@Entity
@XmlType(name = "EventQueue", namespace = "http://org.qualipso.factory.ws/resource/eventqueue", propOrder =  {"events"}
)
@SuppressWarnings("serial")
public class EventQueue extends FactoryResource {
	
	@Id
	private String name;
	private String path;
	
	private ArrayList<Event> events; 
	
	public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public EventQueue() {
	}
	
	@XmlAttribute(name = "name", required = true)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name = "path", required = true)
	@Transient
	@Override
	public String getResourcePath() {
		return path;
	}
	
	public void setResourcePath(String path) {
		this.path = path;
	}
	

	@Override
	@XmlTransient
	public FactoryResourceIdentifier getFactoryResourceIdentifier() {
		return new FactoryResourceIdentifier("EventQueueService", "EventQueue", getName());
	}

	@Override
	@XmlTransient
	public String getResourceName() {
		return name;
	}

}
