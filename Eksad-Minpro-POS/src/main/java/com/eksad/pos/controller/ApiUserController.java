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

import com.eksad.pos.model.MstUserModel;
import com.eksad.pos.service.MstUserService;

@Controller
public class ApiUserController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private MstUserService service;
	
	@RequestMapping(value="/api/mst-user/", method=RequestMethod.GET)
	public ResponseEntity<List<MstUserModel>> list(){
		ResponseEntity<List<MstUserModel>> result = null;
		try {
			List<MstUserModel> list = this.service.getList();
			result = new ResponseEntity<List<MstUserModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<MstUserModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/mst-user/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<MstUserModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<MstUserModel>> result = null;
		try {
			List<MstUserModel> list = this.service.search(cari);
			result = new ResponseEntity<List<MstUserModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<MstUserModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-user/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<MstUserModel> getById(@PathVariable("itemId") int vId){
		ResponseEntity<MstUserModel> result = null;
		try {
			MstUserModel cat = this.service.getById(vId);
			result = new ResponseEntity<MstUserModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstUserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-user/", method=RequestMethod.POST)
	public ResponseEntity<MstUserModel> postInsert(@RequestBody MstUserModel item){
		ResponseEntity<MstUserModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<MstUserModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstUserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-user/", method=RequestMethod.PUT)
	public ResponseEntity<MstUserModel> putUpdate(@RequestBody MstUserModel item){
		ResponseEntity<MstUserModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<MstUserModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstUserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-user/{itemId}", method=RequestMethod.DELETE)
	public ResponseEntity<MstUserModel> delApi(@PathVariable("itemId") Integer vid){
		ResponseEntity<MstUserModel> result = null;
		try {
			MstUserModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<MstUserModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<MstUserModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstUserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
