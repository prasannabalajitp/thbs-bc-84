package com.th.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.th.model.Train;
import com.th.repository.TrainRepository;

@RestController
@RequestMapping("/trains")
public class TrainController {

	@Autowired
	TrainRepository tr;
	
//	@PostMapping("/train")
//	public ResponseEntity<Train> save(@RequestBody Train train){
//		Train t = tr.save(train);
//		return new ResponseEntity<Train>(t,HttpStatus.OK);
//	}
	@PostMapping("/train")
	public ResponseEntity<Train> save(@RequestBody Train t)
	{
		Train bk = tr.save(t);
		return new ResponseEntity<Train>(bk,HttpStatus.OK);
	}
	
	@GetMapping("/getAllTrains")
	public ResponseEntity<List<Train>> getAllTrains(){
		List<Train> tlist = tr.findAll();
		return new ResponseEntity<List<Train>>(tlist, HttpStatus.OK);
	}
	
	@GetMapping("/getTrainByNumber/{id}}")
	public ResponseEntity<Train> getTrainByNumber(@PathVariable int id){
		Optional<Train> tk = tr.findById(id);
		
		if(tk.isPresent())
		{
			Train t = tk.get();
			return new ResponseEntity<Train>(t, HttpStatus.OK);
		}
		return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteATrain/{id}")
	public ResponseEntity<Train> deleteTrainById(@PathVariable int id){
		if(tr.existsById(id))
		{
			tr.deleteById(id);
			return new ResponseEntity<Train>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
	}
}
