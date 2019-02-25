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

import com.eksad.pos.model.MstCategoryModel;
import com.eksad.pos.service.MstCategoryService;

@Controller
public class ApiCategoryController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private MstCategoryService service;
	
	@RequestMapping(value="/api/mst-category/", method=RequestMethod.GET)
	public ResponseEntity<List<MstCategoryModel>> list(){
		ResponseEntity<List<MstCategoryModel>> result = null;
		try {
			List<MstCategoryModel> list = this.service.getList();
			result = new ResponseEntity<List<MstCategoryModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<MstCategoryModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/mst-category/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<MstCategoryModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<MstCategoryModel>> result = null;
		try {
			List<MstCategoryModel> list = this.service.search(cari);
			result = new ResponseEntity<List<MstCategoryModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<MstCategoryModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-category/check-name/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<Boolean> checkName(@PathVariable("katakunci") String cari){
		ResponseEntity<Boolean> result = null;
		try {
			Boolean list = this.service.checkName(cari);
			result = new ResponseEntity<Boolean>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-category/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<MstCategoryModel> getById(@PathVariable("itemId") int vId){
		ResponseEntity<MstCategoryModel> result = null;
		try {
			MstCategoryModel cat = this.service.getById(vId);
			result = new ResponseEntity<MstCategoryModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstCategoryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-category/", method=RequestMethod.POST)
	public ResponseEntity<MstCategoryModel> postInsert(@RequestBody MstCategoryModel item){
		ResponseEntity<MstCategoryModel> result = null;
		try {
			if(this.service.checkName(item.getName())==false){
				this.service.insert(item);
				result = new ResponseEntity<MstCategoryModel>(item, HttpStatus.CREATED);
			}else {
				result = new ResponseEntity<MstCategoryModel>(HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstCategoryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-category/", method=RequestMethod.PUT)
	public ResponseEntity<MstCategoryModel> putUpdate(@RequestBody MstCategoryModel item){
		ResponseEntity<MstCategoryModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<MstCategoryModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<MstCategoryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/mst-category/{itemId}", method=RequestMethod.DELETE)
	public ResponseEntity<MstCategoryModel> delApi(@PathVariable("itemId") Integer vid){
		ResponseEntity<MstCategoryModel> result = null;
		try {
			MstCategoryModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<MstCategoryModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<MstCategoryModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<MstCategoryModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
