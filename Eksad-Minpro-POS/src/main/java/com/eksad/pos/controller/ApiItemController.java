package com.eksad.pos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.pos.model.MstItemModel;
import com.eksad.pos.service.MstItemService;

@Controller
public class ApiItemController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private MstItemService service;
	
	@RequestMapping(value="/api/mst-item/", method=RequestMethod.GET)
	public ResponseEntity<List<MstItemModel>> list(){
		ResponseEntity<List<MstItemModel>> result = null;
		try {
			List<MstItemModel> list = this.service.getList();
			result = new ResponseEntity<List<MstItemModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<MstItemModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/mst-item/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<MstItemModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<MstItemModel>> result = null;
		try {
			List<MstItemModel> list = this.service.search(cari);
			result = new ResponseEntity<List<MstItemModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<MstItemModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-item/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<MstItemModel> getById(@PathVariable("itemId") int vId){
		ResponseEntity<MstItemModel> result = null;
		try {
			MstItemModel cat = this.service.getById(vId);
			result = new ResponseEntity<MstItemModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstItemModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-item/", method=RequestMethod.POST)
	public ResponseEntity<MstItemModel> postInsert(@RequestBody MstItemModel item){
		ResponseEntity<MstItemModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<MstItemModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstItemModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-item/", method=RequestMethod.PUT)
	public ResponseEntity<MstItemModel> putUpdate(@RequestBody MstItemModel item){
		ResponseEntity<MstItemModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<MstItemModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstItemModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-item/{itemId}", method=RequestMethod.DELETE)
	public ResponseEntity<MstItemModel> delApi(@PathVariable("itemId") Integer vid){
		ResponseEntity<MstItemModel> result = null;
		try {
			MstItemModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<MstItemModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<MstItemModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstItemModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
