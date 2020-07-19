package api.restful.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import api.restful.model.views.Views;
import api.restful.model.catalog.Catalog;
import api.restful.model.catalog.Coordinate;
import api.restful.model.collection.Item;
import api.restful.model.geojson.Geojson;

import api.restful.services.CatalogServiceImpl;

@RestController
@RequestMapping(value = "catalog")
public class CatalogController {

	@Autowired
	CatalogServiceImpl service = new CatalogServiceImpl();

	public void setService(CatalogServiceImpl service) {
		this.service = service;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@JsonView(Views.Public.class)
	public ResponseEntity<Item> catalog_list() {
		try {
			return new ResponseEntity<Item> (this.service.listItems(), HttpStatus.OK);
		}  catch (Exception e) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
	   	}
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResponseEntity<Item> catalog_search(@RequestBody Geojson geojson) {
		try {
			return new ResponseEntity<Item> (this.service.search(geojson), HttpStatus.OK);
		}  catch (Exception e) {
			return new ResponseEntity<Item> (HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Catalog> add_catalog(@RequestBody Catalog catalog) {
		try {
			Catalog c = (Catalog) catalog;
			if (this.service.add(c)) {
				return new ResponseEntity<Catalog> (c, HttpStatus.OK);
			} else {
				return new ResponseEntity<Catalog> (new Catalog(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Catalog> (HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public ResponseEntity<Catalog> remove_catalog(@RequestParam String id) {
		try {
			Catalog c = (Catalog) this.service.findById(new Long(id));
			if (this.service.remove(c)) {
				c.setCoordinates(new ArrayList<Coordinate>());
				return new ResponseEntity<Catalog> (c, HttpStatus.OK);
			} else {
				return new ResponseEntity<Catalog> (new Catalog(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Catalog> (HttpStatus.NOT_FOUND);
		}
	}
}