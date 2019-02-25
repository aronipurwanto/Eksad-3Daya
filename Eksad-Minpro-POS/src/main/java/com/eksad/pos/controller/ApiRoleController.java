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

import com.eksad.pos.model.MstRoleModel;
import com.eksad.pos.service.MstRoleService;

@Controller
public class ApiRoleController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private MstRoleService service;
	
	@RequestMapping(value="/api/mst-role/", method=RequestMethod.GET)
	public ResponseEntity<List<MstRoleModel>> list(){
		ResponseEntity<List<MstRoleModel>> result = null;
		try {
			List<MstRoleModel> list = this.service.getList();
			result = new ResponseEntity<List<MstRoleModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<MstRoleModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/mst-role/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<MstRoleModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<MstRoleModel>> result = null;
		try {
			List<MstRoleModel> list = this.service.search(cari);
			result = new ResponseEntity<List<MstRoleModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<MstRoleModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-role/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<MstRoleModel> getById(@PathVariable("itemId") int vId){
		ResponseEntity<MstRoleModel> result = null;
		try {
			MstRoleModel cat = this.service.getById(vId);
			result = new ResponseEntity<MstRoleModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstRoleModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-role/", method=RequestMethod.POST)
	public ResponseEntity<MstRoleModel> postInsert(@RequestBody MstRoleModel item){
		ResponseEntity<MstRoleModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<MstRoleModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstRoleModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-role/", method=RequestMethod.PUT)
	public ResponseEntity<MstRoleModel> putUpdate(@RequestBody MstRoleModel item){
		ResponseEntity<MstRoleModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<MstRoleModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstRoleModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-role/{itemId}", method=RequestMethod.DELETE)
	public ResponseEntity<MstRoleModel> delApi(@PathVariable("itemId") Integer vid){
		ResponseEntity<MstRoleModel> result = null;
		try {
			MstRoleModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<MstRoleModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<MstRoleModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstRoleModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
